package s180009.Lab1;

import java.util.*;

public class Mage implements Comparable<Mage> {
    private String name;
    private int level;
    private double power;
    private Set<Mage> apprentices;
    private int descendantsAmount = 0;

    static int deep = 1;

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    public int getDescendantsAmount() {
        return descendantsAmount;
    }

    public double getPower() {
        return power;
    }

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

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        Mage mage = (Mage) other;

        if (!name.equals(mage.name)) {
            return false;
        }
        if (level != mage.level) {
            return false;
        }
        if (Double.doubleToLongBits(power) != Double.doubleToLongBits(mage.power)) {
            return false;
        }
        if (apprentices.size() != mage.apprentices.size()) {
            return false;
        }
        for (Mage apperentice :
                apprentices) {
            if (!mage.apprentices.contains(apperentice)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(name, level, power);
        for (Mage apperentice :
                apprentices) {
            result += apperentice.hashCode();
        }
        return result;
    }

//    public void write(Map<Mage, Integer> map) {
//        for (int i = 0; i < deep; i++) {
//            System.out.print('-');
//        }
//        System.out.println(this.toString());
//
//        descendantsAmount = this.apprentices.size();
//
//        deep++;
//        for (Mage apprentice : this.apprentices) {
//            apprentice.write(map);
//            descendantsAmount += apprentice.getDescendantsAmount();
//        }
//        deep--;
//
//        map.put(this, descendantsAmount);
//    }

    public void writeAllMages() {
        for (int i = 0; i < deep; i++) {
            System.out.print('-');
        }
        System.out.println(this.toString());

        deep++;
        for (Mage apprentice : this.apprentices) {
            apprentice.writeAllMages();
        }
        deep--;
    }

    public Map<Mage, Integer> createDescendantsAmountStatistics(Map<Mage, Integer> map) {
        this.generateDescendantsAmountStatistics(map);

        return map;
    }

    private void generateDescendantsAmountStatistics(Map<Mage, Integer> map) {
        descendantsAmount = this.apprentices.size();

        for (Mage apprentice : this.apprentices) {
            apprentice.generateDescendantsAmountStatistics(map);
            descendantsAmount += apprentice.getDescendantsAmount();
        }

        map.put(this, descendantsAmount);
    }

    @Override
    public int compareTo(Mage o) {
        int result = this.name.compareTo(o.name);   //sortuje A->Z
        if (result == 0) {
            result = o.level - this.level;          // kto ma wyzszy lewel
        }
        if (result == 0) {                          // kto ma wyzszy power
            if (o.power - this.power < 0) {
                result = -1;
            } else if (o.power - this.power > 0) {
                result = 1;
            }
        }
        return result;          // -result desc
    }
}
