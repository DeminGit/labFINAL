import Exceptions.IllegalGravityException;
import actions.GroundShiftable;
import human.*;
import world.*;

public class Main {
    public static void main(String[] args) {

        Sense sense = new Sense(Statable.PRESENSE_OF_MEANING, "здравый смысл");

        Riggle riggle = new Riggle("Риггль", Mood.AWESOME.getDescription(),
                Weapon.DUBINKA.getDescription(),
                Movement.NO_MOVEMENT.getDescription(), Location.STREET.getDescription(),
                Willing.HZWILLING.getDescription(), sense,100);

        Policemen[] policemen = new Policemen[2];

        policemen[0] = new Policemen("Man1", Mood.COMMON.getDescription(),
                Weapon.GUN.getDescription(),
                Movement.NO_MOVEMENT.getDescription(), Location.STREET.getDescription(),
                Willing.HZWILLING.getDescription(), sense,100);


        policemen[1] = new Policemen("Man2", Mood.COMMON.getDescription(),
                Weapon.GUN.getDescription(),
                Movement.NO_MOVEMENT.getDescription(), Location.STREET.getDescription(),
                Willing.HZWILLING.getDescription(), sense,100);

        Gravity gravity = new Gravity(Statable.STABLE, "гравитация");

        Znayka znayka = new Znayka("Знайка", Mood.COMMON.getDescription(),
                Weapon.FISTS.getDescription(),
                Movement.NO_MOVEMENT.getDescription(), Location.NEAR_ROCKET.getDescription(),
                Willing.HZWILLING.getDescription(), gravity, sense,100);


        riggle.getSureInObject("ракета");
        riggle.hit();
        riggle.scream();


        for (Policemen policeman : policemen) {
            policeman.shooting();
            policeman.runForward();
            policeman.runUp();
            policeman.destroy();
            policeman.toBreak();
            policeman.fracture();
            policeman.riddleWith();
            policeman.climb();
            policeman.finalAction();

        }

        try {
            znayka.say("Это что же за варварство такое!");
        } catch (IllegalArgumentException e) {
            System.out.println("Упс! Знайка не знает этот язык." + e.getMessage());
        }

        znayka.BecomeAngry();

        try {
            znayka.say("Ну ,подождите-ка ,я покажу вам!");
        } catch (IllegalArgumentException e) {
            System.out.println("Упс! Знайка не знает этот язык." + e.getMessage());
        }


        while (true) {
            try {
                znayka.TurnOn();
                break; // Если исключения не было, выходим из цикла
            } catch (IllegalGravityException e) {
                System.out.println("Произошла ошибка: " + e.getMessage() + " Доктор Стрэндж перемещает Знайку во времени в момент включения прибора невесомости! Знайка заново включает прибор невесомости!");

            }
        }


        System.out.println(policemen[0].noExpect("подвоха"));
        System.out.println(policemen[1].noExpect("подвоха"));


        policemen[0].feel(policemen[0].noExpect("почва ушла из под ног"));
        policemen[1].feel(policemen[1].noExpect("почва ушла из под ног"));

        policemen[0].feelGroundShift(new GroundShiftable() {
            @Override
            public void shift() {
                System.out.println("Почва ушла из-под ног у персонажа - " + policemen[0].toString());
                policemen[0].setMood(Mood.RAGE.getDescription());

            }
        });

        policemen[1].feelGroundShift(new GroundShiftable() {
            @Override
            public void shift() {
                System.out.println("Почва ушла из-под ног у персонажа - " + policemen[1].toString());
                policemen[0].setMood(Mood.RAGE.getDescription());
            }
        });

        for (Policemen policeman : policemen) {
            policeman.misUnderstanding();
            policeman.tumbleInAir();
            policeman.waveArms();
            policeman.kickingLegs();
            policeman.bodyWobbling();
        }

        for (Policemen policeman : policemen) {
            policeman.colide();
            policeman.flyOff();
            policeman.flyUp();
            policeman.flyDown();
            policeman.pushGround();
            policeman.flyUp();
        }

        Policemen.Ground ground = new Policemen.Ground();
        for (Policemen policeman : policemen) {
            ground.colideWithPerson(policeman.getName());
        }
    }
}