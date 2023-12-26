// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Johan Lee (johanlee20)
package spacecolonies;

import student.TestCase;

/**
 * A test class for ColonyCalculator and its methods
 * 
 * @author Johan Lee
 * @version 11.6.21
 */
public class ColonyCalculatorTest extends TestCase {
    // ~Fields--------------------------------------------------------------
    private ColonyCalculator colony;
    private ArrayQueue<Person> queue;
    private Planet planet1;
    private Planet planet2;

    /**
     * Sets up the test case for ColonyCalculator.
     */
    public void setUp() {
        queue = new ArrayQueue<Person>(3);
        planet1 = new Planet("mars", 2, 3, 4, 5);
        planet2 = new Planet("earth", 1, 2, 3, 4);
        Planet planet3 = new Planet("moon", 3, 4, 5, 6);
        Planet[] world = { planet1, planet2, planet3 };
        colony = new ColonyCalculator(queue, world);
    }


    // ~Methods------------------------------------------------------------
    /**
     * Test the getQueue method
     */
    public void testGetQueue() {
        assertEquals("[]", colony.getQueue().toString());
    }


//    /**
//     * Test the getPlanets method
//     */
//    public void testGetPlanets() {
//        Planet[] world2 = { planet1, planet2, planet3 };
//        assertEquals(world2, colony.getPlanets());
//    }


    /**
     * Test the getPlanetForPerson method
     */
    public void testGetPlanetForPerson() {
        assertNull(colony.getPlanetForPerson(null));
        Person person1 = new Person("bob", 2, 3, 4, "mars");
        Person person2 = new Person("sam", 1, 2, 3, "jupiter");
        Person person3 = new Person("jim", 1, 1, 1, "sun");
        assertEquals(planet1, colony.getPlanetForPerson(person1));
        assertEquals(planet2, colony.getPlanetForPerson(person2));
        assertNull(colony.getPlanetForPerson(person3));
    }


    /**
     * Test the accept method
     */
    public void testAccept() {
        assertFalse(colony.accept());
        Person person1 = new Person("bob", 2, 3, 4, "mars");
        queue.enqueue(person1);
        assertTrue(colony.accept());
        Person person2 = new Person("jim", 1, 1, 1, "sun");
        queue.enqueue(person2);
        assertFalse(colony.accept());
    }


    /**
     * Test the reject method
     */
    public void testReject() {
        Person person2 = new Person("jim", 1, 1, 1, "sun");
        queue.enqueue(person2);
        colony.reject();
        assertTrue(colony.rejectBus.contains(person2));
    }


    /**
     * Test the getPlanetIndex method
     */
    public void testGetPlanetIndex() {
        assertEquals(0, colony.getPlanetIndex("mars"));
        assertEquals(1, colony.getPlanetIndex("earth"));
        assertEquals(2, colony.getPlanetIndex("moon"));
        assertEquals(-1, colony.getPlanetIndex("sun"));
    }
}
