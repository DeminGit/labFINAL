package world;

public enum Weapon {
    DUBINKA("дубинка"),
    GUN("ружье"),
    AK47("ак-47"),
    M4A1S("эмка"),
    FISTS("кулаки");

    private String description;
    Weapon(String description){
        this.description = description;
    }
    public String getDescription(){
        return description;
    }
}
