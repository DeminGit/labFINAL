package actions;

public interface Movable {
    void runForward();
    void climb();
    void runUp();
    void tumbleInAir(); //кувыркаться в воздухе
    void waveArms();
    void kickingLegs(); //брыкаясь ногами
    void bodyWobbling(); //вихляясь телом
    void colide(); //столкнуться
    void flyOff(); //отлететь
    void flyUp(); //полететь вверх
    void flyDown(); //полететь вниз
    void pushGround(); //оттолкнуться от земли

}