package world;

import actions.StabilityChanger;

import java.util.Objects;

public class Gravity implements StabilityChanger {
    Statable stability;
    private String name;

    public Gravity(Statable stability, String name) {
        this.name = name;
        this.stability = stability;
    }


    public Statable getStability() {
        return stability;
    }


    public void setStability(Statable stability) {
        this.stability = stability;
    }


    public String getName() {
        return name;
    }

    @Override
    public void changeStability(Statable newStability) {
        setStability(newStability);
    }

    @Override
    public String toString() {
        return getName();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Gravity gravity = (Gravity) o;
        return stability == gravity.stability &&
                Objects.equals(name, gravity.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(stability, name);
    }
}
