package world;

public enum Movement {
    MOVEMENT("в движении"),
    NO_MOVEMENT("не в движении"),

    CLIMBING("поднимается вверх"),

    FLY_UP("летит вверх"),
    FLY_DOWN("летит вниз"),
    FLY_OFF("летит непонятно в каком направлении");


    private String description;
    Movement(String description){
        this.description = description;
    }
    public String getDescription(){
        return description;
    }
}
