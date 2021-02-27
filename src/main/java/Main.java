import java.util.TreeSet;
import java.util.TreeSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        Mage mage2 = new Mage("Clark", 3, 12.4, new TreeSet<>());
        Mage mage3 = new Mage("Jan", 3, 12.4, new TreeSet<>());
        Mage mage5 = new Mage("Ten", 3, 12.4, new TreeSet<>());
        Mage mage6 = new Mage("John", 3, 12.4, new TreeSet<>());
        Mage mage8 = new Mage("Adam", 3, 12.4, new TreeSet<>());
        Mage mage9 = new Mage("Michael", 3, 12.4, new TreeSet<>());
        Mage mage10 = new Mage("Frank", 3, 12.4, new TreeSet<>());
        Mage mage11 = new Mage("Tom", 3, 12.4, new TreeSet<>());
        Set<Mage> mages9_11 = new TreeSet<>();
        mages9_11.add(mage9);
        mages9_11.add(mage10);
        mages9_11.add(mage11);
        Mage mage7 = new Mage("Steel", 3, 12.4, mages9_11);

        Set<Mage> mages5_8 = new TreeSet<>();
        mages5_8.add(mage5);
        mages5_8.add(mage6);
        mages5_8.add(mage7);
        mages5_8.add(mage8);
        Mage mage4 = new Mage("Ben", 3, 12.4, mages5_8);

        Set<Mage> mages2_4 = new TreeSet<>();
        mages2_4.add(mage4);
        mages2_4.add(mage2);
        mages2_4.add(mage3);

        Mage mage1 = new Mage("Mark", 3, 12.4, mages2_4);

        //System.out.println(mage1.equals(mage15));
        mage1.write();


    }
}
