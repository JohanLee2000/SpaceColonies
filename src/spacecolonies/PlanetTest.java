// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Johan Lee (johanlee20)
package spacecolonies;

import student.TestCase;

/**
 * A test class for Planet and its methods
 * 
 * @author Johan Lee
 * @version 11.6.21
 */
public class PlanetTest extends TestCase {
    // ~Fields----------------------------------------------------------------
    private Planet planet;

    /**
     * Set up the test case.
     */
    public void setUp() {
        planet = new Planet("mars", 1, 2, 3, 5);

    }


    // ~Methods------------------------------------------------------------
    /**
     * Test the setName method
     */
    public void testSetName() {
        planet.setName("jupiter");
        assertEquals("jupiter", planet.getName());
    }


    /**
     * Test the getName method
     */
    public void testGetName() {
        assertEquals("mars", planet.getName());
    }


    /**
     * Test the getSkills method
     */
    public void testGetSkills() {
        assertEquals("A:1 M:2 T:3", planet.getSkills().toString());
    }


//    /**
//     * Test the getPopulation method
//     */
//    public void testGetPopulation() {
//        Person person = new Person("bob", 3, 4, 5, "mars");
//        planet.addPerson(person);
//        assertEquals(person.toString(), planet.getPopulation().toString());
//    }


    /**
     * Test the getPopulationSize method
     */
    public void testGetPopulationSize() {
        assertEquals(0, planet.getPopulationSize());
        Person person = new Person("bob", 3, 4, 5, "mars");
        planet.addPerson(person);
        assertEquals(1, planet.getPopulationSize());
    }


    /**
     * Test the getCapacity method
     */
    public void testGetCapacity() {
        assertEquals(5, planet.getCapacity());
    }


    /**
     * Test the getAvailability method
     */
    public void testGetAvailability() {
        assertEquals(5, planet.getAvailability());
        Person person = new Person("bob", 3, 4, 5, "mars");
        planet.addPerson(person);
        assertEquals(4, planet.getAvailability());
    }


    /**
     * Test the isFull method
     */
    public void testIsFull() {
        assertFalse(planet.isFull());
        Person person = new Person("bob", 3, 4, 5, "mars");
        Person person2 = new Person("bob", 3, 4, 5, "mars");
        Person person3 = new Person("bob", 3, 4, 5, "mars");
        Person person4 = new Person("bob", 3, 4, 5, "mars");
        Person person5 = new Person("bob", 3, 4, 5, "mars");
        planet.addPerson(person);
        planet.addPerson(person2);
        planet.addPerson(person3);
        planet.addPerson(person4);
        planet.addPerson(person5);
        assertTrue(planet.isFull());
    }


    /**
     * Test the addPerson method
     */
    public void testAddPerson() {
        Person person = new Person("bob", 3, 4, 5, "mars");
        Person person2 = new Person("bob", 3, 4, 5, "mars");
        Person person3 = new Person("bob", 3, 4, 5, "mars");
        Person person4 = new Person("bob", 3, 4, 5, "mars");
        Person person5 = new Person("bob", 1, 1, 1, "mars");
        Person person6 = new Person("bob", 3, 4, 5, "mars");
        Person person7 = new Person("bob", 3, 4, 5, "mars");
        planet.addPerson(person);
        planet.addPerson(person2);
        planet.addPerson(person3);
        planet.addPerson(person4);
        assertFalse(planet.addPerson(person5)); // unqualified
        assertTrue(planet.addPerson(person6));
        assertFalse(planet.addPerson(person7)); // full
    }


    /**
     * Test the isQualified method.
     */
    public void testIsQualified() {
        Person person = new Person("bob", 3, 4, 5, "mars");
        Person person2 = new Person("bob", 1, 2, 2, "mars");
        assertTrue(planet.isQualified(person));
        assertFalse(planet.isQualified(person2));
    }


    /**
     * Test the toString method
     */
    public void testToString() {
        assertEquals("mars, population 0 (cap: 5), Requires: A >= 1, M >= 2"
            + ", T >= 3", planet.toString());
    }


    /**
     * Test the compareTo method for capacity and availability
     */
    public void testCompareTo() {
        Exception exception = null;
        try {
            planet.compareTo(null);
            fail("compareTo() is not throwing an exception when it should");
        }
        catch (Exception e) {
            exception = e;
        }
        assertTrue(exception instanceof IllegalArgumentException);
        Planet planet2 = new Planet("mars", 1, 2, 3, 4);
        assertEquals(1, planet.compareTo(planet2));
        Planet planet3 = new Planet("mars", 1, 2, 3, 6);
        assertEquals(-1, planet.compareTo(planet3));
        // Test availability
        Planet planet4 = new Planet("mars", 1, 2, 3, 5);
        Person person = new Person("bob", 3, 4, 5, "mars");
        planet4.addPerson(person);
        assertEquals(1, planet.compareTo(planet4));
        planet.addPerson(person);
        planet.addPerson(person);
        assertEquals(-1, planet.compareTo(planet4));
    }


    /**
     * Test the compareTo method for skills and name
     */
    public void testCompareTo2() {
        Planet planet2 = new Planet("mars", 2, 2, 3, 5);
        Planet planet3 = new Planet("mars", 1, 1, 3, 5);
        assertEquals(-1, planet.compareTo(planet2));
        assertEquals(1, planet.compareTo(planet3));
        Planet planet4 = new Planet("bars", 1, 2, 3, 5);
        Planet planet5 = new Planet("sars", 1, 2, 3, 5);
        assertEquals(-1, planet.compareTo(planet4));
        assertEquals(1, planet.compareTo(planet5));
        Planet planet6 = new Planet("mars", 1, 2, 3, 5);
        assertEquals(0, planet.compareTo(planet6));
    }


    /**
     * Test the equals method
     */
    public void testEquals() {
        Object obj = new Object();
        assertFalse(planet.equals(null));
        assertFalse(planet.equals(obj));
        assertTrue(planet.equals(planet));
        Planet planet5 = new Planet("sars", 1, 2, 3, 5);
        // Planet planet6 = new Planet("mars", 1, 2, 3, 5);
        assertFalse(planet.equals(planet5));
        // assertTrue(planet.equals(planet6));

    }
}
