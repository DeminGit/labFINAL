package world;

import java.util.Objects;

public class Sense {
    Statable stability;
    private String name;

    public Sense(Statable stability, String name) {
        this.stability = stability;
        this.name = name;
    }

    public Statable getStability() {
        return getStability();
    }

    public void setStability(Statable stability) {
        this.stability = stability;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sense sense = (Sense) o;
        return Objects.equals(stability, sense.stability) &&
                Objects.equals(name, sense.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(stability, name);
    }
}
