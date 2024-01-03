package world;

public enum Willing {
    WILLING("имеет желание"),
    NoWLIING("не имеет желания"),
    HZWILLING("непонятно имеет ли желание");

    private String description;
    Willing(String description){
        this.description = description;
    }
    public String getDescription(){
        return description;
    }
}
