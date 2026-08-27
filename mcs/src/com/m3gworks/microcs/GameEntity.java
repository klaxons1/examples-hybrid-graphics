package com.m3gworks.microcs;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;
import javax.microedition.m3g.World;

public abstract class GameEntity {
    // Constants
    public static final float COLLISION_THRESHOLD = 0.5f;
    public static final float MAX_MOVE_DISTANCE = 8.0f;
    public static final float FIELD_OF_VIEW_ANGLE = 40.0f;
    public static final float GRID_CELL_SIZE = 20.0f;

    // Entity properties
    public int entityId;
    public String entityName;
    public int entityType;
    public int stateCounter = 0;
    public boolean isActive = true;

    // 3D components
    public Model3D model3D;
    public BoundingSphere boundingSphere = new BoundingSphere();
    private BoundingSphere tempBoundingSphere = new BoundingSphere(new float[3], 0.0f);

    // Orientation
    public float pitchAngle = 0.0f;
    public float yawAngle = 0.0f;

    // Direction constants
    public static final int DIRECTION_FORWARD = 1;
    public static final int DIRECTION_BACKWARD = 2;
    public static final int DIRECTION_LEFT = 3;
    public static final int DIRECTION_RIGHT = 4;

    public GameEntity(int entityId, String entityName, int entityType) {
        this.entityId = entityId;
        this.entityName = entityName;
        this.entityType = entityType;
    }

    // Abstract methods that must be implemented by subclasses
    public abstract void initialize(World world);
    public abstract float getCollisionRadius();
    public abstract float moveForward(float distance);
    public abstract float strafe(float distance);
    public abstract float turnRight(float angle);
    public abstract float turnLeft(float angle);
    public abstract void updateBot();

    /**
     * Clean up resources when entity is destroyed
     */
    public void reset() {
        if (this.model3D != null) {
            this.model3D.cleanUp();
            this.model3D = null;
        }
        this.boundingSphere = null;
        this.tempBoundingSphere = null;
    }

    /**
     * Respawn entity at its spawn point
     */
    public void respawn() {
        this.pitchAngle = 0.0f;
        this.yawAngle = 0.0f;

        float[] spawnPoints = MapLoader.getInstance().getCurrentMap().spawnPoints;
        int spawnIndex = (this.entityId - 1) * 3;

        this.model3D.rootNode.setTranslation(
                spawnPoints[spawnIndex],
                spawnPoints[spawnIndex + 1],
                spawnPoints[spawnIndex + 2]
        );

        this.updateBoundingSphere();
    }

    /**
     * Update bounding sphere position based on spawn point
     */
    public final void updateBoundingSphere() {
        float[] spawnPoints = MapLoader.getInstance().getCurrentMap().spawnPoints;
        int spawnIndex = (this.entityId - 1) * 3;

        this.boundingSphere.radius = this.getCollisionRadius();
        this.boundingSphere.setCenter(spawnPoints[spawnIndex], 0.0f, spawnPoints[spawnIndex + 2]);
    }

    /**
     * Move bounding sphere by specified vector
     */
    public final void moveBoundingSphere(float[] movementVector) {
        float[] center = this.boundingSphere.center;
        center[0] += movementVector[0];
        center[1] += movementVector[1];
        center[2] += movementVector[2];
    }

    /**
     * Get bounding sphere at future position after movement
     */
    public final BoundingSphere getFutureBoundingSphere(float[] movementVector) {
        float[] currentCenter = this.boundingSphere.center;

        this.tempBoundingSphere.center[0] = currentCenter[0] + movementVector[0];
        this.tempBoundingSphere.center[1] = currentCenter[1] + movementVector[1];
        this.tempBoundingSphere.center[2] = currentCenter[2] + movementVector[2];
        this.tempBoundingSphere.radius = this.boundingSphere.radius;

        return this.tempBoundingSphere;
    }

    /**
     * Find other entities within specified bounding sphere
     */
    public GameEntity findEntityInRadius(BoundingSphere searchSphere) {
        Hashtable entityTable = GameEntityManager.getInstance().entityTable;
        Enumeration keys = entityTable.keys();

        while (keys.hasMoreElements()) {
            Integer entityKey = (Integer) keys.nextElement();
            GameEntity otherEntity = (GameEntity) entityTable.get(entityKey);

            if (otherEntity != this && otherEntity.boundingSphere.intersects(searchSphere)) {
                return otherEntity;
            }
        }

        return null;
    }

    /**
     * Check if there's line of sight to another entity (no obstacles in between)
     */
    public final boolean hasLineOfSight(GameEntity targetEntity) {
        if (targetEntity == null) return false;

        float[] targetPosition = targetEntity.getPosition();
        float[] myPosition = this.getPosition();

        if (targetPosition == null || myPosition == null) return false;

        // Calculate direction vector to target (ignoring Y-axis for simplicity)
        float[] directionToTarget = new float[]{
                targetPosition[0] - myPosition[0],
                0.0f,
                targetPosition[2] - myPosition[2]
        };

        MapLoader mapLoader = MapLoader.getInstance();
        float[] mapBounds = mapLoader.mapBounds;

        if (mapBounds == null || mapBounds.length < 2) return false;

        // Convert positions to grid coordinates
        int targetGridX = worldToGridCoordinate(targetPosition[0], mapBounds[0]);
        int targetGridZ = worldToGridCoordinate(targetPosition[2], mapBounds[1]);
        int myGridX = worldToGridCoordinate(myPosition[0], mapBounds[0]);
        int myGridZ = worldToGridCoordinate(myPosition[2], mapBounds[1]);

        // Calculate grid direction and step size
        float[] gridDirection = new float[]{
                (float)(targetGridX - myGridX),
                0.0f,
                (float)(targetGridZ - myGridZ)
        };

        float[] normalizedDirection = MathUtils.normalizeVector(gridDirection);
        float[] gridStep = new float[]{
                normalizedDirection[0] * GRID_CELL_SIZE / 2.0f,
                0.0f,
                normalizedDirection[2] * GRID_CELL_SIZE / 2.0f
        };

        Vector[][] spatialGrid = mapLoader.spatialGrid;
        if (spatialGrid == null) return false;

        int lastGridX = -1;
        int lastGridZ = -1;
        int stepCount = 0;

        while (true) {
            int currentGridX, currentGridZ;

            if (stepCount == 0) {
                // Start from current position
                currentGridX = myGridX;
                currentGridZ = myGridZ;
            } else {
                // Move along the ray
                float testX = myPosition[0] + (float)stepCount * gridStep[0];
                float testZ = myPosition[2] + (float)stepCount * gridStep[2];

                // Check if we've passed the target
                if ((directionToTarget[0] >= 0.0f && testX > targetPosition[0]) ||
                        (directionToTarget[0] < 0.0f && testX < targetPosition[0]) ||
                        (directionToTarget[2] >= 0.0f && testZ > targetPosition[2]) ||
                        (directionToTarget[2] < 0.0f && testZ < targetPosition[2])) {
                    break;
                }

                currentGridZ = worldToGridCoordinate(testZ, mapBounds[1]);
                currentGridX = worldToGridCoordinate(testX, mapBounds[0]);
            }

            stepCount++;

            // Check if we moved to a new grid cell
            if (currentGridX != lastGridX || currentGridZ != lastGridZ) {
                // Validate grid indices
                if (currentGridZ < 0 || currentGridZ >= spatialGrid.length ||
                        currentGridX < 0 || currentGridX >= spatialGrid[currentGridZ].length) {
                    continue;
                }

                // Check for collisions in this grid cell
                Vector gridCell = spatialGrid[currentGridZ][currentGridX];
                if (gridCell != null) {
                    for (int i = 0; i < gridCell.size(); ++i) {
                        Object element = gridCell.elementAt(i);
                        if (element instanceof BoundingBox) {
                            if (((BoundingBox) element).intersectsRay(myPosition, directionToTarget)) {
                                return true; // Found an obstacle blocking line of sight
                            }
                        }
                    }
                }

                // Stop if direction is zero (same cell)
                if (gridDirection[0] == 0.0f && gridDirection[2] == 0.0f) {
                    break;
                }

                lastGridX = currentGridX;
                lastGridZ = currentGridZ;
            }
        }

        return false; // No obstacles found
    }

    /**
     * Check if another entity is within field of view
     */
    public final boolean isEntityInView(GameEntity entity) {
        float[] entityPosition = entity.getPosition();
        return this.isPointInView(entityPosition[0], entityPosition[2]);
    }

    /**
     * Check if a point is within field of view
     */
    public final boolean isPointInView(float pointX, float pointZ) {
        float[] myPosition = this.getPosition();
        float[] directionToPoint = new float[]{
                pointX - myPosition[0],
                0.0f,
                pointZ - myPosition[2]
        };

        float[] forwardVector = this.getForwardVector(DIRECTION_FORWARD, 1.0f);

        // Calculate angle between forward vector and direction to point
        float dotProduct = MathUtils.dotProduct(forwardVector, directionToPoint);
        float forwardMagnitude = (float)Math.sqrt(forwardVector[0] * forwardVector[0] +
                forwardVector[1] * forwardVector[1] +
                forwardVector[2] * forwardVector[2]);
        float directionMagnitude = (float)Math.sqrt(directionToPoint[0] * directionToPoint[0] +
                directionToPoint[1] * directionToPoint[1] +
                directionToPoint[2] * directionToPoint[2]);

        float angleRadians = (float) MathUtilsArcSin.asin(dotProduct / (forwardMagnitude * directionMagnitude));
        float angleDegrees = (float) Math.toDegrees(angleRadians);

        return Math.abs(angleDegrees) <= FIELD_OF_VIEW_ANGLE;
    }

    /**
     * Get forward vector based on direction and magnitude
     */
    public final float[] getForwardVector(int direction, float magnitude) {
        float angle = 0.0f;

        switch (direction) {
            case DIRECTION_FORWARD:
                angle = this.yawAngle + 180.0f;
                break;
            case DIRECTION_BACKWARD:
                angle = this.yawAngle;
                break;
            case DIRECTION_LEFT:
                angle = this.yawAngle - 90.0f;
                break;
            case DIRECTION_RIGHT:
                angle = this.yawAngle + 90.0f;
                break;
        }

        float[] vector = new float[3];
        double sinAngle = Math.sin(Math.toRadians(angle));
        double cosAngle = Math.cos(Math.toRadians(angle));

        if (Math.abs(cosAngle) == 1.0) {
            // Moving primarily along Z-axis
            vector[0] = 0.0f;
            vector[2] = (float)(magnitude * cosAngle);
            vector[1] = 0.0f;
        } else if (Math.abs(sinAngle) == 1.0) {
            // Moving primarily along X-axis
            vector[2] = 0.0f;
            vector[0] = (float)(magnitude * sinAngle);
            vector[1] = 0.0f;
        } else {
            // Moving diagonally
            vector[0] = (float)(magnitude * sinAngle);
            vector[2] = (float)(magnitude * cosAngle);
            vector[1] = 0.0f;
        }

        return vector;
    }

    /**
     * Check for collisions at future position
     */
    public final BoundingBox checkCollision(float[] movementVector) {
        if (movementVector == null) return null;

        MapLoader mapLoader = MapLoader.getInstance();
        if (mapLoader == null) return null;

        BoundingSphere futureSphere = this.getFutureBoundingSphere(movementVector);
        if (futureSphere == null) return null;

        // Use enlarged sphere for collision detection
        BoundingSphere searchSphere = new BoundingSphere(futureSphere.center, futureSphere.radius * 2.0f);
        float[] currentCenter = this.boundingSphere.center;

        if (currentCenter == null) return null;

        // Calculate search area bounds
        float searchRadius = searchSphere.radius;
        float minX = currentCenter[0] - searchRadius;
        float minZ = currentCenter[2] - searchRadius;
        float maxX = currentCenter[0] + searchRadius;
        float maxZ = currentCenter[2] + searchRadius;

        float[] mapBounds = mapLoader.mapBounds;
        if (mapBounds == null || mapBounds.length < 2) return null;

        // Convert bounds to grid coordinates
        int startGridZ = worldToGridCoordinate(minZ, mapBounds[1]);
        int startGridX = worldToGridCoordinate(minX, mapBounds[0]);
        int endGridZ = worldToGridCoordinate(maxZ, mapBounds[1]);
        int endGridX = worldToGridCoordinate(maxX, mapBounds[0]);

        Vector[][] spatialGrid = mapLoader.spatialGrid;
        if (spatialGrid == null) return null;

        // Check all grid cells in the search area
        for (int gridZ = startGridZ; gridZ <= endGridZ; ++gridZ) {
            for (int gridX = startGridX; gridX <= endGridX; ++gridX) {
                // Validate grid indices
                if (gridZ < 0 || gridZ >= spatialGrid.length ||
                        gridX < 0 || gridX >= spatialGrid[gridZ].length) {
                    continue;
                }

                Vector gridCell = spatialGrid[gridZ][gridX];
                if (gridCell != null) {
                    for (int i = 0; i < gridCell.size(); ++i) {
                        Object element = gridCell.elementAt(i);
                        if (element instanceof BoundingBox) {
                            BoundingBox boundingBox = (BoundingBox) element;
                            if (boundingBox.intersects(searchSphere)) {
                                return boundingBox;
                            }
                        }
                    }
                }
            }
        }

        return null;
    }

    /**
     * Get current entity position from 3D model
     */
    public final float[] getPosition() {
        float[] position = new float[3];
        this.model3D.rootNode.getTranslation(position);
        return position;
    }

    /**
     * Convert world coordinate to grid coordinate
     */
    private int worldToGridCoordinate(float worldCoord, float mapBound) {
        float gridCoord = (worldCoord - mapBound) / GRID_CELL_SIZE;
        return gridCoord < 1.0f ? 0 : (int) Math.floor(gridCoord);
    }
}