package human;

import actions.Feelable;
import actions.GroundShiftable;
import actions.Movable;
import actions.Attackable;
import world.*;

import java.util.Random;
import java.util.Objects;


public class Policemen extends Person implements Movable, Attackable, Feelable {
    private Sense sense;

    public Policemen(String name, String mood, String weapon, String movement, String location, String willing, Sense sense, int healthPoints) {
        super(name, mood, weapon, movement, location, willing, healthPoints);
        this.sense = sense;
    }


    @Override
    public String getWeapon() {
        return "> " + this + " держит в руках предмет - " + super.getWeapon();
    }


    // Перегрузка метода для вывода просто оружия
    public String getWeapon(String context) {
        if ("comment".equals(context)) {
            return getWeapon(); // Использует переопределенный выше метод
        } else {
            return super.getWeapon(); // Возвращает оружие без описания
        }
    }

    @Override
    public String getMovement() {
        return "> " + this + " в данный момент - " + super.getMovement();
    }

    @Override
    public String getMood() {
        return "> " + "Настроение у персонажа " + this + " - " + super.getMood();
    }

    @Override
    public String getLocation() {
        return "> " + super.getLocation();
    }

    @Override
    public String getWilling() {
        return "> " + "Персонаж " + this + " - " + super.getWilling();
    }


    @Override
    public void shooting() {
        System.out.println(getMood());
        System.out.println(getWeapon());
        System.out.println(getMovement());
        System.out.println(this + " стрелял при помощи предмета - " + super.getWeapon());
    }

    @Override
    public void destroy() {
        setMood(Mood.RAGE.getDescription());
        System.out.println(this + " начал атаковать объект " + Devices.DEVICES.getDescription() + " " + getLocation());
        System.out.println(getMood());
    }


    @Override
    public void runForward() {
        super.setMovement(Movement.NO_MOVEMENT.getDescription());
        System.out.println(this + " побежал вперед");
        System.out.println(getMovement());
    }

    @Override
    public void runUp() {
        super.setMovement(Movement.MOVEMENT.getDescription());
        super.setLocation(Location.NEAR_ROCKET.getDescription());
        System.out.println(this + " сейчас " + getLocation());
        System.out.println(getMovement());
    }


    @Override
    public void toBreak() {

        System.out.println(this + " разбил предмет - " + Devices.BAROMETER.getDescription());

    }

    @Override
    public void fracture() {

        System.out.println(this + " разломал предмет - " + Devices.SEISMOGRAPH.getDescription());
    }


    @Override
    public void riddleWith() {

        System.out.println(this + " изрешетил пулями - " + Devices.RAIN_GAUGE.getDescription());
    }

    @Override
    public void climb() {
        super.setLocation(Location.TOWER.getDescription());
        super.setMovement(Movement.CLIMBING.getDescription());
        System.out.println(this + " залезают на объект " + Location.TOWER.getDescription());
        System.out.println(">" + " " + this + " находятся в локации - " + getLocation());
    }

    @Override
    public void finalAction() {
        super.setWilling(Willing.WILLING.getDescription());
        super.setMood(Mood.AWESOME.getDescription());
        System.out.println(getWilling() + " разбить объект - " + Devices.ANEMOMETER.getDescription());

    }

    public void feelGroundShift(GroundShiftable shifter) {
        shifter.shift();
    }

    @Override
    public String noExpect(String what) {
        return this + " не ожидал " + what;
    }

    @Override
    public void feel(String what) {
        System.out.println(this + " почувствовал уход почвы ");

        // локальный класс ReactionToAntiGravity
        // с вероятностью 20% полицейский роняет ружье

        class ReactionToAntiGravity {
            void react() {
                setMood(Mood.CONFUSED.getDescription());
                System.out.println("Теряет ориентацию из-за отсутствия тяжести.");
                Random random = new Random();
                int PossibilityOfLosingWeapon = 1 + random.nextInt(100);
                if (PossibilityOfLosingWeapon > 80) {
                    System.out.println(Policemen.this + " выронил из рук предмет - " + getWeapon("default") + " из-за неожиданной ситуации.");
                    setWeapon(Weapon.FISTS.getDescription());
                }

            }
        }
        ReactionToAntiGravity reaction = new ReactionToAntiGravity();
        reaction.react();
    }


    // вложенный non static class
    // попытка удержаться в воздухе делает смысл действия бессмысленным
    private class BalanceAttempt {
        void tryToBalance() {
            sense.setStability(Statable.NO_PRESENSE_OF_MEANING);
            setMood(Mood.RAGE.getDescription());
            System.out.println("Полицейский пытается удержаться в воздухе.");
            if (getWeapon("default") == Weapon.FISTS.getDescription()) {
                waveArms();
            }

        }
    }

    BalanceAttempt balanceAttempt = new BalanceAttempt();

    @Override
    public void misUnderstanding() {
        balanceAttempt.tryToBalance();
        System.out.println(this + " ничего не понимает");
    }

    @Override
    public void tumbleInAir() {
        super.setMood(Mood.RAGE.getDescription());
        super.setLocation(Location.AIR.getDescription());
        System.out.println(this + " кувыркается в воздухе");
        System.out.println(this + " находится в локации - " + getLocation());
    }

    @Override
    public void waveArms() {
        System.out.println(this + " размахивает руками");
    }

    @Override
    public void kickingLegs() {
        System.out.println(this + " брыкается ногами");
    }

    @Override
    public void bodyWobbling() {
        System.out.println(this + " вихляется всем телом");

    }


    @Override
    public void colide() {
        System.out.println(this + " столкнулся с другим полицейским");
    }

    @Override
    public void flyOff() {
        setMovement(Movement.FLY_OFF.getDescription());
        System.out.println(this + " отлетает");
    }

    @Override
    public void flyUp() {
        setMovement(Movement.FLY_UP.getDescription());
        System.out.println(this + " летит вверх");
    }

    @Override
    public void flyDown() {
        setMovement(Movement.FLY_DOWN.getDescription());
        System.out.println(this);
        System.out.println(this + " летит вниз");
    }


    // вложенный статик класс земля
    public static class Ground {
        public void colideWithPerson(String person) {
            System.out.println(this + " столкнулась с персонажем " + person);

        }

        @Override
        public String toString() {
            return "Земля";
        }
    }


    @Override
    public void pushGround() {
        setMood(Mood.AWESOME.getDescription());
        System.out.println(this + " оттолкнулся от земли");
    }


    @Override
    public String toString() {
        return getName();
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) return false; // Сначала проверяем поля суперкласса
        if (this == obj) return true;
        if (!(obj instanceof Policemen)) return false; // Проверяем тип
        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode()); // Используем hash из Objects для комбинирования хеш-кодов
    }

}
