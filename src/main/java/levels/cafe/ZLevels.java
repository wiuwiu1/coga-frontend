package levels.cafe;

public enum ZLevels {

    BACKGROUND(-0.1f),
    WALL_TILE(0.0f),
    WALL_DECAL_ADD(0.01f),
    BASE_GROUND_TILE(0.1f),
    GROUND_OFFSET_ADD(0.1f),
    FURNITURE_ADD(0.01f),
    ENTITIES_ADD(0.02f);

    private float level;

    ZLevels(float level) {
        this.level = level;
    }

    public float getLevel() {
        return level;
    }
}
