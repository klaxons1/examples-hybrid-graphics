package com.m3gworks.microcs;
import java.util.Vector;
import javax.microedition.m3g.Appearance;
import javax.microedition.m3g.Background;
import javax.microedition.m3g.CompositingMode;
import javax.microedition.m3g.Image2D;
import javax.microedition.m3g.Light;
import javax.microedition.m3g.Loader;
import javax.microedition.m3g.Mesh;
import javax.microedition.m3g.Object3D;
import javax.microedition.m3g.Sprite3D;
import javax.microedition.m3g.World;

public final class MapLoader {
    // Constants for spatial grid and map settings
    private static final float CELL_SIZE = 20.0f;
    private static final float MAP_BOUNDS_PADDING = 2.0f;
    private static final float DEFAULT_MAP_SIZE = 400.0f;
    private static final float MOON_HEIGHT = 50.0f;

    // Lighting constants
    private static final int LIGHT_MODE_AMBIENT = 128;
    private static final float LIGHT_INTENSITY = 3.0f;

    // Background constants
    private static final int BACKGROUND_IMAGE_MODE = 33;
    private static final int BACKGROUND_BORDER_MODE = 32;

    // Compositing mode constants
    private static final int BLENDING_MODE_ADDITIVE = 68;

    private static MapLoader instance;
    public Vector availableMaps = new Vector();
    public World currentWorld;
    public int currentMapIndex;
    public float[] mapBounds;
    public Vector[][] spatialGrid;
    private Vector environmentSprites = null;

    static {
        GameConfig.getInstance().initializeAllMaps();
    }

    private MapLoader() {
    }

    public static MapLoader getInstance() {
        if (instance == null) {
            instance = new MapLoader();
        }
        return instance;
    }

    public final World loadCurrentMap() {
        try {
            MapParameters currentMap = this.getCurrentMap();
            Object3D[] loadedObjects = Loader.load(currentMap.mapFilePath);

            // Find the World object in loaded scene
            for (int i = 0; i < loadedObjects.length; i++) {
                if (loadedObjects[i] instanceof World) {
                    this.currentWorld = (World) loadedObjects[i];
                    break;
                }
            }

            this.setupMapEnvironment(this.currentMapIndex);
            this.setupLighting();
            this.buildSpatialGrid();

        } catch (Exception e) {
            System.out.println("Load map error!");
            e.printStackTrace();
        }

        return this.currentWorld;
    }

    private void setupMapEnvironment(int mapIndex) {
        // Create moon for all maps except map 5
        if (mapIndex != 5) {
            this.createMoonSprite();
        }

        // Add trees only for specific maps
        if (mapIndex == 1) {
            this.createTrees();
        }
    }

    private void createMoonSprite() {
        try {
            Image2D moonTexture = ResourceLoader.loadImage2DFromFile("/res/map/moon.png");
            Appearance moonAppearance = new Appearance();

            CompositingMode blendingMode = new CompositingMode();
            blendingMode.setBlending(BLENDING_MODE_ADDITIVE);
            moonAppearance.setCompositingMode(blendingMode);

            Sprite3D moonSprite = new Sprite3D(false, moonTexture, moonAppearance);
            this.currentWorld.addChild(moonSprite);
            moonSprite.setTranslation(0.0f, MOON_HEIGHT, 0.0f);

        } catch (Exception e) {
            System.out.println("Failed to create moon sprite");
        }
    }

    private void createTrees() {
        this.environmentSprites = new Vector();

        try {
            Image2D treeTexture = ResourceLoader.createImage2D("/res/map/tree.png");

            // Create tree sprites at specific positions
            float[][] treePositions = {
                    {38.8f, 8.0f, 59.1f},
                    {31.9f, 8.0f, 90.2f},
                    {-57.9f, 8.0f, -51.7f}
            };

            for (int i = 0; i < treePositions.length; i++) {
                float[] position = treePositions[i];
                HudElementSprite treeSprite = new HudElementSprite(
                        treeTexture,
                        CameraManager.getInstance().getCamera("MAIN"),
                        position[0], position[1], position[2], 16.0f
                );

                this.environmentSprites.addElement(treeSprite);
                this.currentWorld.addChild(treeSprite.var_53);
            }

        } catch (Exception e) {
            System.out.println("Failed to create trees");
        }
    }

    public final void cleanupEnvironment() {
        if (this.environmentSprites != null) {
            for (int i = 0; i < this.environmentSprites.size(); i++) {
                HudElementSprite sprite = (HudElementSprite) this.environmentSprites.elementAt(i);
                sprite.sub_9e(); // Cleanup sprite
            }
        }
    }

    private void setupLighting() {
        Light ambientLight = new Light();
        ambientLight.setMode(LIGHT_MODE_AMBIENT);
        ambientLight.setIntensity(LIGHT_INTENSITY);
        this.currentWorld.addChild(ambientLight);
    }

    private void buildSpatialGrid() {
        int[] collisionObjectIds = this.getCurrentMap().objectIds;
        this.mapBounds = new float[4]; // [minX, minZ, maxX, maxZ]

        if (collisionObjectIds == null) {
            setupDefaultMapBounds();
        } else {
            buildCollisionGrid(collisionObjectIds);
        }
    }

    private void setupDefaultMapBounds() {
        this.mapBounds[0] = -DEFAULT_MAP_SIZE; // minX
        this.mapBounds[1] = -DEFAULT_MAP_SIZE; // minZ
        this.mapBounds[2] = DEFAULT_MAP_SIZE;  // maxX
        this.mapBounds[3] = DEFAULT_MAP_SIZE;  // maxZ

        int gridWidth = (int) Math.ceil((this.mapBounds[2] - this.mapBounds[0]) / CELL_SIZE);
        int gridHeight = (int) Math.ceil((this.mapBounds[3] - this.mapBounds[1]) / CELL_SIZE);

        this.spatialGrid = new Vector[gridHeight][gridWidth];
    }

    private void buildCollisionGrid(int[] collisionObjectIds) {
        // Initialize bounds to extreme values
        this.mapBounds[0] = Float.MAX_VALUE; // minX
        this.mapBounds[1] = Float.MAX_VALUE; // minZ
        this.mapBounds[2] = -Float.MAX_VALUE; // maxX
        this.mapBounds[3] = -Float.MAX_VALUE; // maxZ

        BoundingBox[] collisionBoxes = new BoundingBox[collisionObjectIds.length];

        // Calculate map bounds from all collision objects
        for (int i = 0; i < collisionObjectIds.length; i++) {
            Mesh collisionMesh = (Mesh) this.currentWorld.find(collisionObjectIds[i]);
            float[] transformedVertices = ResourceLoader.getTransformedVertices(collisionMesh, this.currentWorld);
            BoundingBox boundingBox = new BoundingBox(transformedVertices, collisionMesh);
            collisionBoxes[i] = boundingBox;

            updateMapBounds(boundingBox);
        }

        // Add padding to map bounds
        addBoundsPadding();

        // Create spatial grid
        createSpatialGridStructure(collisionBoxes);
    }

    private void updateMapBounds(BoundingBox boundingBox) {
        float[] minBounds = boundingBox.minBounds; // minX, minY, minZ
        float[] maxBounds = boundingBox.maxBounds; // maxX, maxY, maxZ

        if (minBounds[0] < this.mapBounds[0]) this.mapBounds[0] = minBounds[0];
        if (minBounds[2] < this.mapBounds[1]) this.mapBounds[1] = minBounds[2];
        if (maxBounds[0] > this.mapBounds[2]) this.mapBounds[2] = maxBounds[0];
        if (maxBounds[2] > this.mapBounds[3]) this.mapBounds[3] = maxBounds[2];
    }

    private void addBoundsPadding() {
        this.mapBounds[0] -= MAP_BOUNDS_PADDING;
        this.mapBounds[1] -= MAP_BOUNDS_PADDING;
        this.mapBounds[2] += MAP_BOUNDS_PADDING;
        this.mapBounds[3] += MAP_BOUNDS_PADDING;
    }

    private void createSpatialGridStructure(BoundingBox[] collisionBoxes) {
        float mapWidth = this.mapBounds[2] - this.mapBounds[0];
        float mapHeight = this.mapBounds[3] - this.mapBounds[1];

        int gridColumns = (int) Math.ceil(mapWidth / CELL_SIZE);
        int gridRows = (int) Math.ceil(mapHeight / CELL_SIZE);

        this.spatialGrid = new Vector[gridRows][gridColumns];

        // Place each bounding box in appropriate grid cells
        for (int i = 0; i < collisionBoxes.length; i++) {
            BoundingBox box = collisionBoxes[i];
            placeBoundingBoxInGrid(box, gridColumns, gridRows);
        }
    }

    private void placeBoundingBoxInGrid(BoundingBox box, int gridColumns, int gridRows) {
        float minX = box.minBounds[0];
        float minZ = box.minBounds[2];
        float maxX = box.maxBounds[0];
        float maxZ = box.maxBounds[2];

        // Calculate grid indices for bounding box
        int startCol = worldToGridCoord(minX - this.mapBounds[0]);
        int startRow = worldToGridCoord(minZ - this.mapBounds[1]);
        int endCol = worldToGridCoord(maxX - this.mapBounds[0]);
        int endRow = worldToGridCoord(maxZ - this.mapBounds[1]);

        // Clamp indices to grid boundaries
        startCol = Math.max(0, startCol);
        startRow = Math.max(0, startRow);
        endCol = Math.min(gridColumns - 1, endCol);
        endRow = Math.min(gridRows - 1, endRow);

        // Add box to all overlapping grid cells
        for (int row = startRow; row <= endRow; row++) {
            for (int col = startCol; col <= endCol; col++) {
                if (this.spatialGrid[row][col] == null) {
                    this.spatialGrid[row][col] = new Vector();
                }
                this.spatialGrid[row][col].addElement(box);
            }
        }
    }

    private int worldToGridCoord(float worldCoord) {
        float gridCoord = worldCoord / CELL_SIZE;
        return (gridCoord < 1.0f) ? 0 : (int) Math.floor(gridCoord);
    }

    public final void cleanupMap() {
        this.currentWorld = null;
        this.mapBounds = null;
        this.spatialGrid = null;
        this.environmentSprites = null;
    }

    public final void setupBackground(int screenWidth, int screenHeight) {
        Background background = this.currentWorld.getBackground();
        if (background != null) {
            background.setImageMode(BACKGROUND_IMAGE_MODE, BACKGROUND_BORDER_MODE);

            // Center the background image
            int backgroundHeight = background.getImage().getHeight();
            int verticalOffset = (backgroundHeight - screenHeight) / 2;
            background.setCrop(0, verticalOffset, screenWidth, screenHeight);
        }
    }

    public final void registerMap(MapParameters map) {
        this.availableMaps.addElement(map);
    }

    public final MapParameters getCurrentMap() {
        return (MapParameters) this.availableMaps.elementAt(this.currentMapIndex);
    }
}