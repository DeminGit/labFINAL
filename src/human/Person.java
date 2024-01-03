package human;

public abstract class Person {
    private String name;
    private String weapon;
    private String movement;
    private String mood;
    private String location;
    private String willing;
    private int healthPoints ;

    public Person(String name, String mood, String weapon, String movement, String location, String willing, int healthPoints) {
        this.name = name;
        this.weapon = weapon;
        this.movement = movement;
        this.mood = mood;
        this.location = location;
        this.willing = willing;
        this.healthPoints = healthPoints;

    }

    public String getName() {
        return name;
    }

    public String getWeapon() {
         return weapon;
    }

    public String getMovement() {
        return movement;
    }

    public String getMood() {
        return mood;
    }

    public String getWilling() {
        return willing;
    }

    public String getLocation() {
        return location;
    }
    public int getHealthPoints() {
        return healthPoints;
    }


    public void setWeapon(String whatInArm) {
        this.weapon = whatInArm;
    }

    public void setMovement(String movement) {
        this.movement = movement;
    }

    public void setMood(String mood) {
        this.mood = mood;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setWilling(String willing) {
        this.willing = willing;
    }
    public void setHealthPoints(int healthPoints) {this.healthPoints = healthPoints; }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;    //проверка на налл и не совпадение классов
        }

        Person person = (Person) obj;

        return name.equals(person.name);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result;
        return result;
    }


}
