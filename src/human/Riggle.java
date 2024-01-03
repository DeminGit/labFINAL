package human;

import actions.Beatable;
import actions.Mindable;
import world.Location;
import world.Mood;
import world.Movement;
import world.Sense;

import java.util.Objects;

public class Riggle extends Person implements Beatable, Mindable {

    private Sense sense;


    public Riggle(String name, String mood, String weapon, String movement, String location, String willing, Sense sense, int healthPoints) {
        super(name, mood, weapon, movement, location, willing,healthPoints);
        this.sense = sense;
    }

    @Override
    public void hit() {
        super.setMood(Mood.RAGE.getDescription());
        System.out.println(getWeapon());
        System.out.println(toString() + " взмахнул предметом - " + super.getWeapon());
    }

    public void getSureInObject(String obj) {
        super.setLocation(Location.STREET.getDescription());
        super.setMood(Mood.KAIF.getDescription());
        super.setMovement(Movement.NO_MOVEMENT.getDescription());
        System.out.println(toString() + " убедился в сохранности объекта - " + obj);

    }

    public void scream() {
        System.out.println(toString() + " закричал");
    }

    @Override
    public String getWeapon() {
        return "> " + toString() + " держит в руках предмет - " + super.getWeapon();
    }

    @Override
    public String toString() {
        return getName();
    }


    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) return false; // Сначала проверяем поля суперкласса
        if (this == obj) return true;
        if (!(obj instanceof Riggle)) return false; // Проверяем тип
        return true;

    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode()); // Используем hash из Objects для комбинирования хеш-кодов
    }

}
