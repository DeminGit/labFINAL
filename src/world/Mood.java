package world;

public enum Mood {
    AMAZING("потрясающее"),
    RAGE("ярость"),
    COOL("всё круто"),
    SAD("грустное"),
    AWESOME("невероятное"),
    KAIF("кайфовое"),
    COMMON("обычное"),
    CONFUSED("растерянное");

    private String description;
    Mood(String description){
        this.description = description;
    }
    public String getDescription(){
        return description;
    }

}
