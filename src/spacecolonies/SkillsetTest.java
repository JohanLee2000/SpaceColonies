// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Johan Lee (johanlee20)
package spacecolonies;

import student.TestCase;

/**
 * A test class for Skillset
 * 
 * @author Johan Lee
 * @version 11.6.21
 */
public class SkillsetTest extends TestCase {
    // ~Fields----------------------------------------------------------------
    private Skillset skillset;

    /**
     * Set up the test case for Skillset
     */
    public void setUp() {
        skillset = new Skillset(3, 4, 5);
    }


    // ~Methods---------------------------------------------------------------
    /**
     * Test the getAgriculture method to return the correct score
     */
    public void testGetAgriculture() {
        assertEquals(3, skillset.getAgriculture());
    }


    /**
     * Test the getMedicine method to return the correct score
     */
    public void testGetMedicine() {
        assertEquals(4, skillset.getMedicine());
    }


    /**
     * Test the getTechnology method to return the correct score
     */
    public void testGetTechnology() {
        assertEquals(5, skillset.getTechnology());
    }


    /**
     * Test the isLessThanOrEqualTo method with another skillset object
     */
    public void testIsLessThanOrEqualTo() {
        Skillset skillset2 = new Skillset(2, 3, 4);
        Skillset skillset3 = new Skillset(3, 4, 5);
        Skillset skillset4 = new Skillset(4, 4, 6);

        assertFalse(skillset.isLessThanOrEqualTo(skillset2));
        assertTrue(skillset.isLessThanOrEqualTo(skillset3));
        assertTrue(skillset.isLessThanOrEqualTo(skillset4));
    }


    /**
     * Test the toString method
     */
    public void testToString() {
        assertEquals("A:3 M:4 T:5", skillset.toString());
    }


    /**
     * Test the equals method
     */
    public void testEquals() {
        Object obj = new Object();
        assertFalse(skillset.equals(null));
        assertFalse(skillset.equals(obj));
        assertTrue(skillset.equals(skillset));
        Skillset skillset2 = new Skillset(3, 4, 5);
        Skillset skillset3 = new Skillset(3, 4, 6);
        assertTrue(skillset.equals(skillset2));
        assertFalse(skillset.equals(skillset3));
    }


    /**
     * Test the compareTo method
     */
    public void testCompareTo() {
        Exception exception = null;
        try {
            skillset.compareTo(null);
            fail("push() is not throwing an exception when it should");
        }
        catch (Exception e) {
            exception = e;
        }
        assertTrue(exception instanceof IllegalArgumentException);
        Skillset skillset2 = new Skillset(2, 3, 4);
        Skillset skillset3 = new Skillset(4, 5, 6);
        Skillset skillset4 = new Skillset(5, 4, 3);
        assertEquals(1, skillset.compareTo(skillset2));
        assertEquals(-1, skillset.compareTo(skillset3));
        assertEquals(0, skillset.compareTo(skillset4));
    }
}
