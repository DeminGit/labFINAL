package human;

import Exceptions.IllegalGravityException;
import Exceptions.IllegalLanguageException;
import actions.Angryable;
import actions.Sayable;
import actions.Turnable;
import world.*;
import actions.StabilityChanger;
import java.util.Objects;
import java.util.Random;


public class Znayka extends Person implements Sayable, Angryable, Turnable {

    private Sense sense;
    private StabilityChanger stabilityChanger;

    public Znayka(String name, String mood, String weapon, String movement, String location, String willing, StabilityChanger stabilityChanger, Sense sense, int healthPoints) {
        super(name, mood, weapon, movement, location, willing, healthPoints);
        this.stabilityChanger = stabilityChanger;
        this.sense = sense;
    }

    @Override
    public void say(String word) throws IllegalLanguageException {
        if (!word.matches("^[а-яА-ЯёЁ\\s!,\\-]+$")) {
            throw new IllegalLanguageException("Текст должен быть на русском языке");
        }
        System.out.println(this + " говорит: " + word);
    }

    @Override
    public void becomeAngry() {
        super.setMood(Mood.RAGE.getDescription());
        System.out.println(this + " разозлился");
    }

    @Override
    public void turnOn() {
        Random random = new Random();
        int GravityChange = random.nextInt(100) + 1;
        if (GravityChange > 50) {
            throw new IllegalGravityException("Изменение гравитации слишком велико: " + GravityChange + " => мир почти уничтожен.");
        }
        stabilityChanger.changeStability(Statable.UNSTABLE);
        System.out.println(this + " успешно включил предмет - " + Devices.GRAVITY_CHANGER.getDescription());
        System.out.println("Изменение гравитации = " + GravityChange);
    }


    @Override
    public String toString() {
        return getName();
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) return false; // Сначала проверяем поля суперкласса
        if (this == obj) return true;
        if (!(obj instanceof Znayka)) return false; // Проверяем тип
        return true;

    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode()); // Используем hash из Objects для комбинирования хеш-кодов
    }
}
