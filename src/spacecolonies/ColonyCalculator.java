// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Johan Lee (johanlee20)
package spacecolonies;

import list.AList;

/**
 * This class handles the major calculations for the program
 * and puts them on planets
 * 
 * @author Johan Lee
 * @version 11.6.21
 */
public class ColonyCalculator {
    // ~Fields----------------------------------------------------------------
    /**
     * This field references the number of planets
     */
    public static final int NUM_PLANETS = 3;
    /**
     * This field references the minimal skill level required
     */
    public static final int MIN_SKILL_LEVEL = 1;
    /**
     * This field references the maximum skill level required
     */
    public static final int MAX_SKILL_LEVEL = 5;
    /**
     * This field references the queue of applicants
     */
    protected ArrayQueue<Person> applicantQueue;
    /**
     * This field references the list of rejected people.
     */
    protected AList<Person> rejectBus;
    /**
     * This field references the array of planets
     */
    protected Planet[] planets;

    // ~Constructor----------------------------------------------------------
    /**
     * The constructor for ColonyCalculator
     * 
     * @param people
     *            the arrayQueue of people
     * @param world
     *            the array of planets
     */
    public ColonyCalculator(ArrayQueue<Person> people, Planet[] world) {
        if (people == null) {
            throw new IllegalArgumentException();
        }
        rejectBus = new AList<Person>();
        applicantQueue = people;
        planets = world;
    }


    /**
     * This method gets the field value for the arrayQueue
     * 
     * @return the arrayQueue of people
     */
    public ArrayQueue<Person> getQueue() {
        return applicantQueue;
    }


    /**
     * This method gets the field value for the planets
     * 
     * @return the array of planets
     */
    public Planet[] getPlanets() {
        return planets;
    }

// /**
// * This method checks if the given person can get on the planet
// * @return true if qualified, false if otherwise.
// */
// private boolean canAccept(Planet planet, Person person)
// {
// return (planet.isQualified(person));
// }


    /**
     * This method attempts to find a planet for the person based
     * on their preference and if they meet the qualifications.
     * 
     * @param nextPerson
     *            the person that needs a planet
     * @return the planet that fits the person if any
     */
    public Planet getPlanetForPerson(Person nextPerson) {
        if (nextPerson == null) {
            return null;
        }
        String wantPlanet = nextPerson.getPlanetPreference();
        for (int i = 0; i < 3; i++) {
            if (planets[i].getName().equals(wantPlanet)) {
                if (!planets[i].isFull() && planets[i].isQualified(
                    nextPerson)) {
                    return planets[i];
                }
            }
            else {
                // Sort the planets according to capacity
                for (int j = 0; j < 2; j++) {
                    if (planets[j].compareTo(planets[j + 1]) == -1) {
                        Planet temp = planets[j];
                        planets[j] = planets[j + 1];
                        planets[j + 1] = temp;
                    }
                }
                // Search for eligible planet
                for (int k = 0; k < 3; k++) {
                    if (!planets[k].isFull() && planets[k].isQualified(
                        nextPerson)) {
                        return planets[k];
                    }
                }
            }
        }
        return null;
    }


    /**
     * This method will attempt to accept the next applicant
     * 
     * @return true if successful, false if not.
     */
    public boolean accept() {
        if (!applicantQueue.isEmpty()) {
            if (this.getPlanetForPerson(applicantQueue.getFront()) != null) {
                for (int i = 0; i < 3; i++) {
                    if (planets[i] == this.getPlanetForPerson(applicantQueue
                        .getFront())) {
                        planets[i].addPerson(applicantQueue.getFront());
                    }
                }
                applicantQueue.dequeue();
                return true;
            }
            return false;
        }
        return false;
    }


    /**
     * This method will reject the applicant and send them back
     */
    public void reject() {
        Person rejected = applicantQueue.dequeue();
        rejectBus.add(rejected);
    }


    /**
     * This method gets the index of the planet.
     * 
     * @param planet
     *            the name of the planet
     * @return the index of planet with the given name,
     *         -1 if not found
     */
    public int getPlanetIndex(String planet) {
        for (int i = 0; i < NUM_PLANETS; i++) {
            if (planets[i].getName().equals(planet)) {
                return i;
            }
        }
        return -1;
    }
}
