package world;

public enum Statable {
    STABLE("стабильное"),
    UNSTABLE("нестабильное"),
    PRESENSE_OF_MEANING("здравый смысл присутствует"),
    NO_PRESENSE_OF_MEANING("здравый смысл отсутствует");

    private String description;

    Statable(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
