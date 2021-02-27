import java.util.Set;

public class Mage {
    private String name;
    private int level;
    private double power;
    private Set<Mage> apprentices;

    static int deep = 1;

    public Mage(String name, int level, double power, Set<Mage> apprentices) {
        this.name = name;
        this.level = level;
        this.power = power;
        this.apprentices = apprentices;
    }

    @Override
    public String toString() {
        return "Mage{" +
                "name='" + name + '\'' +
                ", level=" + level +
                ", power=" + power +
                '}';
    }

    public void write() {
        for (int i = 0; i < deep; i++) {
            System.out.print('-');
        }
        System.out.println(this.toString());

        deep++;
        for (Mage apprentice : this.apprentices) {
            apprentice.write();
        }
        deep--;

    }
}
