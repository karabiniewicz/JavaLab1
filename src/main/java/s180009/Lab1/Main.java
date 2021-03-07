package s180009.Lab1;

import java.util.*;

public class Main {
    private static final Mage[] mages = new Mage[11];
    private static final Set[] sets = new Set[11];
    private static final String NO_SORTING = "brak";
    private static final String NATURAL_SORTING = "naturalne";
    private static final String ALTERNATIVE_SORTING = "alternatywne";

    public static void main(String[] args) {
        String sortingState = args[0];
        Map<Mage, Integer> map;

        switch (sortingState) {
            case NATURAL_SORTING:
                map = new TreeMap<>();
                for (int i = 0; i < sets.length; ++i) {
                    sets[i] = new TreeSet<>();
                }
                break;
            case ALTERNATIVE_SORTING:
                map = new TreeMap<>(new MageComparator());
                for (int i = 0; i < sets.length; ++i) {
                    sets[i] = new TreeSet<>(new MageComparator());
                }
                break;
            case NO_SORTING:
            default:
                map = new HashMap<>();
                for (int i = 0; i < sets.length; ++i) {
                    sets[i] = new HashSet<>();
                }
        }

        creatTestData();

        //mages[0].write(map);
        mages[0].writeAllMages();
        map = mages[0].createDescendantsAmountStatistics(map);

        System.out.println("--------------------");

        for (Object k : map.keySet()) {
            System.out.println(k + " " + map.get(k));
        }
    }

    private static void creatTestData() {
        mages[1] = new Mage("Clark", 3, 152.4, sets[0]);
        mages[2] = new Mage("Zizu", 5, 1.24, sets[1]);
        mages[4] = new Mage("Ten", 2, 12.64, sets[2]);
        mages[5] = new Mage("Zack", 67, 112.4, sets[3]);
        mages[7] = new Mage("Adam", 7, 61.4, sets[4]);
        mages[8] = new Mage("Michael", 9, 11.0, sets[5]);
        mages[9] = new Mage("Frank", 4, 15.4, sets[6]);
        mages[10] = new Mage("Antony", 4, 13.4, sets[7]);

        Set<Mage> mages9_11 = sets[8];
        mages9_11.add(mages[8]);
        mages9_11.add(mages[9]);
        mages9_11.add(mages[10]);
        mages[6] = new Mage("Steel", 5, 1.4, mages9_11);

        Set<Mage> mages5_8 = sets[9];
        mages5_8.add(mages[4]);
        mages5_8.add(mages[5]);
        mages5_8.add(mages[6]);
        mages5_8.add(mages[7]);
        mages[3] = new Mage("Ben", 31, 12.4, mages5_8);

        Set<Mage> mages2_4 = sets[10];
        mages2_4.add(mages[1]);
        mages2_4.add(mages[2]);
        mages2_4.add(mages[3]);
        mages[0] = new Mage("Mark", 99, 99.99, mages2_4);
    }
}
