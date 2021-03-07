package s180009.Lab1;

import java.util.Comparator;

public class MageComparator implements Comparator<Mage> {

    @Override
    public int compare(Mage o1, Mage o2) {
        int result = o1.getName().compareTo(o2.getName());   //sortuje A->Z
        if (result == 0) {
            result = o2.getLevel() - o1.getLevel();          // kto ma wyzszy lewel
        }
        if (result == 0) {                          // kto ma wyzszy getPower()
            if (o2.getPower() - o1.getPower() < 0) {
                result = -1;
            } else if (o2.getPower() - o1.getPower() > 0) {
                result = 1;
            }
        }
        return -result;          // -result desc
    }
}
