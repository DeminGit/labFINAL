package world;

public enum Location {
    STREET("улица"),
    NEAR_ROCKET("возле ракеты"),
    TOWER("вышка"),
    ROCKET("ракета"),
    AIR("воздух"),
    GROUND("земля");


    private String description;

    Location(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
