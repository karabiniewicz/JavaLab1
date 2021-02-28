import java.util.HashSet;
import java.util.TreeSet;
import java.util.Set;

public class Main {
    private static final Mage[] mages = new Mage[11];
    private static final Set[] sets = new Set[11];
    private static final String NO_SORTING = "brak";
    private static final String NATURAL_SORTING = "naturalne";
    private static final String ALTERNATIVE_SORTING = "alternatywne";

    public static void main(String[] args) {
//        String sortingState = args[0];
        String sortingState = NATURAL_SORTING;

        creatTestData(sortingState);

        mages[0].write();
    }

    private static void creatTestData(String sortingState) {
        switch (sortingState) {
            case NATURAL_SORTING:
                for (int i = 0; i < sets.length; ++i) {
                    sets[i] = new TreeSet<>();
                }
                break;
            case ALTERNATIVE_SORTING:
                for (int i = 0; i < sets.length; ++i) {
                    sets[i] = new TreeSet<>(new MageComparator());
                }
                break;
            default:
                for (int i = 0; i < sets.length; ++i) {
                    sets[i] = new HashSet<>();
                }
        }

        mages[1] = new Mage("Clark", 3, 12.4, sets[0]);
        mages[2] = new Mage("Zizu", 3, 12.4, sets[1]);
        mages[4] = new Mage("Ten", 3, 12.4, sets[2]);
        mages[5] = new Mage("Zack", 3, 12.4, sets[3]);
        mages[7] = new Mage("Adam", 3, 12.4, sets[4]);
        mages[8] = new Mage("Michael", 3, 12.4, sets[5]);
        mages[9] = new Mage("Frank", 3, 12.4, sets[6]);
        mages[10] = new Mage("Antony", 3, 12.4, sets[7]);

        Set<Mage> mages9_11 = sets[8];
        mages9_11.add(mages[8]);
        mages9_11.add(mages[9]);
        mages9_11.add(mages[10]);
        mages[6] = new Mage("Steel", 3, 12.4, mages9_11);

        Set<Mage> mages5_8 = sets[9];
        mages5_8.add(mages[4]);
        mages5_8.add(mages[5]);
        mages5_8.add(mages[6]);
        mages5_8.add(mages[7]);
        mages[3] = new Mage("Ben", 3, 12.4, mages5_8);

        Set<Mage> mages2_4 = sets[10];
        mages2_4.add(mages[1]);
        mages2_4.add(mages[2]);
        mages2_4.add(mages[3]);
        mages[0] = new Mage("Mark", 3, 12.4, mages2_4);
    }
}
