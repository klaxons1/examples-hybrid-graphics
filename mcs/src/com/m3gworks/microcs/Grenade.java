package com.m3gworks.microcs;

import java.util.Enumeration;
import java.util.Hashtable;
import javax.microedition.m3g.Image2D;
import javax.microedition.m3g.RayIntersection;
import javax.microedition.m3g.World;

public final class Grenade {
    // Constants
    private static final float THROW_DISTANCE = 2.5f;
    private static final float GRAVITY = -0.2f;
    private static final float EXPLOSION_RADIUS = 6.0f;
    private static final float EXPLOSION_RADIUS_SQUARED = 36.0f;
    private static final float MIN_EXPLOSION_HEIGHT = 3.0f;
    private static final float GRENADE_SCALE = 0.3f;
    private static final int GRENADE_DAMAGE = 4;

    // Static resources
    private static Image2D grenadeImage;

    // Instance properties
    public GameEntity owner;
    private HudElementSprite grenadeSprite;
    private float[] startPosition;
    private float[] throwDirection;
    private int flightTime = 0;
    private boolean isExploded = true;

    public Grenade(GameEntity owner) {
        this.owner = owner;
    }

    /**
     * Load static resources for grenades
     */
    public static void loadResources() {
        grenadeImage = ResourceLoader.createImage2D("/res/image2d/grenade.png");
    }

    /**
     * Throw grenade from specified position with direction
     */
    public final void throwGrenade(World world, float[] position, float[] direction) {
        this.isExploded = false;
        this.startPosition = position;

        // Normalize and scale throw direction
        float[] normalizedDirection = MathUtils.normalizeVector(direction);
        this.throwDirection = new float[]{
                normalizedDirection[0] * THROW_DISTANCE,
                normalizedDirection[1] * THROW_DISTANCE,
                normalizedDirection[2] * THROW_DISTANCE
        };

        this.flightTime = 0;

        // Create sprite if it doesn't exist
        if (this.grenadeSprite == null) {
            this.grenadeSprite = new HudElementSprite(
                    grenadeImage,
                    world.getActiveCamera(),
                    position[0], position[1], position[2],
                    GRENADE_SCALE
            );
            world.addChild(this.grenadeSprite.var_53); // Используем оригинальное имя поля
            this.grenadeSprite.var_53.setPickingEnable(false);
        }

        // Position and show grenade
        this.grenadeSprite.var_53.setTranslation(position[0], position[1], position[2]);
        this.grenadeSprite.var_53.setRenderingEnable(true);
    }

    /**
     * Update grenade position and check for collisions
     */
    public final void updateGrenade(World world) {
        if (this.isExploded) {
            return;
        }

        // Calculate current position with parabolic trajectory
        float[] currentPosition = calculateGrenadePosition();
        this.grenadeSprite.var_53.setTranslation(currentPosition[0], currentPosition[1], currentPosition[2]);
        this.grenadeSprite.sub_9e(); // Используем оригинальное имя метода обновления спрайта

        this.flightTime++;

        // Calculate velocity for collision detection
        float[] velocity = calculateGrenadeVelocity();
        float[] normalizedVelocity = MathUtils.normalizeVector(velocity);

        // Check for collisions using ray casting
        RayIntersection intersection = new RayIntersection();
        boolean hasCollision = world.pick(
                -1,
                currentPosition[0], currentPosition[1], currentPosition[2],
                normalizedVelocity[0], normalizedVelocity[1], normalizedVelocity[2],
                intersection
        );

        float collisionDistance = intersection.getDistance();

        // Calculate next position to check if we've passed collision point
        float[] nextPosition = calculateGrenadePosition();
        float distanceTraveledSquared = calculateDistanceSquared(currentPosition, nextPosition);

        if (hasCollision && distanceTraveledSquared > collisionDistance * collisionDistance) {
            explodeGrenade(world, currentPosition);
        }
    }

    /**
     * Calculate current grenade position based on flight time
     */
    private float[] calculateGrenadePosition() {
        float time = (float) this.flightTime;
        return new float[]{
                startPosition[0] + throwDirection[0] * time,
                startPosition[1] + throwDirection[1] * time + 0.5f * GRAVITY * time * time,
                startPosition[2] + throwDirection[2] * time
        };
    }

    /**
     * Calculate grenade velocity for collision detection
     */
    private float[] calculateGrenadeVelocity() {
        float time = (float) this.flightTime;
        return new float[]{
                throwDirection[0],
                throwDirection[1] + GRAVITY * time,
                throwDirection[2]
        };
    }

    /**
     * Handle grenade explosion
     */
    private void explodeGrenade(World world, float[] explosionPosition) {
        // Hide grenade sprite
        this.grenadeSprite.var_53.setRenderingEnable(false);

        // Ensure minimum explosion height
        if (explosionPosition[1] < MIN_EXPLOSION_HEIGHT) {
            explosionPosition[1] = MIN_EXPLOSION_HEIGHT;
        }

        // Create visual explosion effect
        EffectManager.getInstance().createExplosionEffect(
                explosionPosition,
                world,
                CameraManager.getInstance().activeCamera
        );

        // Play explosion sound
        if (GameCanvas.getInstance().soundEnabled) {
            SoundManager.getInstance().sub_5e(4); // Используем оригинальные имена методов звука
        }

        // Apply damage to nearby entities
        applyExplosionDamage(explosionPosition);

        this.isExploded = true;
    }

    /**
     * Apply explosion damage to entities within radius
     */
    private void applyExplosionDamage(float[] explosionPosition) {
        GameEntityManager entityManager = GameEntityManager.getInstance();
        Hashtable entityTable = entityManager.entityTable;
        Enumeration entityKeys = entityTable.keys();

        while (entityKeys.hasMoreElements()) {
            Integer entityId = (Integer) entityKeys.nextElement();
            GameEntity entity = (GameEntity) entityTable.get(entityId);

            // Only damage player entities (type 2)
            if (entity.entityType == 2) {
                applyDamageToEntity(entity, explosionPosition);
            }
        }
    }

    /**
     * Apply damage to a specific entity if within explosion radius
     */
    private void applyDamageToEntity(GameEntity entity, float[] explosionPosition) {
        // Don't damage the thrower
        if (entity == this.owner) {
            return;
        }

        // Check if entity has health and is alive
        ChooseTeam targetPlayer = (ChooseTeam) entity;
        if (targetPlayer.getHealth() <= 0) {
            return;
        }

        // Check if entity is within explosion radius
        float[] entityPosition = entity.getPosition();
        float distanceSquared = calculateDistanceSquared(entityPosition, explosionPosition);

        if (distanceSquared < EXPLOSION_RADIUS_SQUARED) {
            targetPlayer.takeDamage(this.owner, GRENADE_DAMAGE, null, null);
        }
    }

    /**
     * Calculate squared distance between two points
     */
    private float calculateDistanceSquared(float[] point1, float[] point2) {
        float dx = point1[0] - point2[0];
        float dy = point1[1] - point2[1];
        float dz = point1[2] - point2[2];
        return dx * dx + dy * dy + dz * dz;
    }

    /**
     * Clean up grenade resources
     */
    public final void cleanup() {
        this.startPosition = null;
        this.throwDirection = null;
        this.grenadeSprite = null;
    }

    /**
     * Release static resources
     */
    public static void releaseResources() {
        grenadeImage = null;
    }

    /**
     * Check if grenade has exploded
     */
    public boolean isExploded() {
        return this.isExploded;
    }

    /**
     * Get current flight time
     */
    public int getFlightTime() {
        return this.flightTime;
    }
}