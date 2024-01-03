package world;

public enum Devices {
    DEVICES("приборы"),
    BAROMETER("барометр"),
    SEISMOGRAPH("сейсмограф"),
    RAIN_GAUGE("дождемер"),
    ANEMOMETER("анемометр"),
    GRAVITY_CHANGER("прибор невесомости");


    private String description;

    Devices(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
