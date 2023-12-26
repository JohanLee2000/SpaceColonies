// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Johan Lee (johanlee20)
package spacecolonies;

import student.TestCase;

/**
 * A test class for Person
 * 
 * @author Johan Lee
 * @version 11.6.21
 */
public class PersonTest extends TestCase {
// ~Fields-------------------------------------------------------------------
    private Person person;

    /**
     * Set up the test case for Person
     */
    public void setUp() {
        person = new Person("bob", 3, 4, 5, "mars");
    }


    // ~Methods-------------------------------------------------------------
    /**
     * Test the getName method
     */
    public void testGetName() {
        assertEquals("bob", person.getName());
    }


    /**
     * Test the getSkills method
     */
    public void testGetSkills() {
        assertEquals("A:3 M:4 T:5", person.getSkills().toString());
    }


    /**
     * Test the getPlanetPreference method
     */
    public void testPlanetPreference() {
        assertEquals("mars", person.getPlanetPreference());
    }


    /**
     * Test the toString method for a person with planet preference
     * and without a preference.
     */
    public void testToString() {
        assertEquals("bob A:3 M:4 T:5 Wants: mars", person.toString());
        Person person2 = new Person("sam", 3, 4, 5, "");
        assertEquals("No-Planet sam A:3 M:4 T:5", person2.toString());
    }


    /**
     * Test the equals method for two persons.
     */
    public void testEquals() {
        Object obj = new Object();
        assertFalse(person.equals(null));
        assertFalse(person.equals(obj));
        assertTrue(person.equals(person));
        Person person2 = new Person("bob", 3, 4, 5, "jupiter");
        Person person3 = new Person("sam", 3, 4, 5, "mars");
        Person person4 = new Person("bob", 4, 4, 5, "mars");
        Person person5 = new Person("bob", 3, 4, 5, "mars");
        assertFalse(person.equals(person2));
        assertFalse(person.equals(person3));
        assertFalse(person.equals(person4));
        assertTrue(person.equals(person5));
    }
}
