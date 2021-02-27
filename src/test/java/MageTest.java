import org.junit.Test;

import java.util.TreeSet;
import java.util.Set;

import static org.junit.Assert.*;

public class MageTest {

    @Test
    public void shouldCheckIfEquals() {
        Mage mage2 = new Mage("Clark", 3, 12.4, new TreeSet<>());
        Mage mage3 = new Mage("Jan", 3, 12.4, new TreeSet<>());
        Set<Mage> mages2_4 = new TreeSet<>();
        mages2_4.add(mage2);
        mages2_4.add(mage3);
        Mage mage1 = new Mage("Mark", 3, 12.4, mages2_4);
        Mage mage10 = new Mage("Mark", 3, 12.4, mages2_4);

        assertEquals(mage1, mage10);
        assertNotEquals(mage1, mage2);
    }

    @Test
    public void shouldCheckHashCode() {
        Mage mage2 = new Mage("Clark", 3, 12.4, new TreeSet<>());
        Mage mage3 = new Mage("Jan", 3, 12.4, new TreeSet<>());

        assertNotEquals(mage2.hashCode(), mage3.hashCode());
        assertEquals(mage2.hashCode(), mage2.hashCode());

        Set<Mage> mages2_4 = new TreeSet<>();
        mages2_4.add(mage2);
        mages2_4.add(mage3);
        Mage mage1 = new Mage("Mark", 3, 12.4, mages2_4);
        Set<Mage> mages2_3 = new TreeSet<>();
        mages2_3.add(mage2);
        mages2_3.add(mage3);
        Mage mage10 = new Mage("Mark", 3, 12.4, mages2_3);

        assertEquals(mage1.hashCode(), mage10.hashCode());
    }
}
