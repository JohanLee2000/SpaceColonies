// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Johan Lee (johanlee20)
package spacecolonies;

/**
 * This class provides information on the planet
 * 
 * @author Johan Lee
 * @version 11.6.21
 */
public class Planet implements Comparable<Planet> {

    // ~Fields-----------------------------------------------------------
    /**
     * This field references the planet's name.
     */
    protected String name;
    /**
     * This field references the minimum skill level in 3 areas.
     */
    protected Skillset minSkills;
    /**
     * This field references the people on the planet.
     */
    protected Person[] population;
    /**
     * This field references references the number of people on the planet.
     */
    protected int populationSize;
    /**
     * This field references the capacity size of the planet.
     */
    protected final int capacity;

    // ~Constructor---------------------------------------------------------
    /**
     * @param planetName name of planet
     * @param planetAgri agriculture score
     * @param planetMedi medicine score
     * @param planetTech technology score
     * @param planetCap capacity of planet
     * 
     */
    public Planet(
        String planetName,
        int planetAgri,
        int planetMedi,
        int planetTech,
        int planetCap) {
        name = planetName;
        minSkills = new Skillset(planetAgri, planetMedi, planetTech);
        populationSize = 0;
        capacity = planetCap;
        population = new Person[planetCap];
    }


    // ~Methods-----------------------------------------------------------
    /**
     * This method sets the name of the planet
     * 
     * @param newName
     *            the new name of the planet
     */
    public void setName(String newName) {
        name = newName;
    }


    /**
     * This method gets the name of the planet
     * 
     * @return the name of the planet.
     */
    public String getName() {
        return name;
    }


    /**
     * This method returns the Skillset
     * 
     * @return the minimal Skillset required on the planet
     */
    public Skillset getSkills() {
        return minSkills;
    }


    /**
     * This method gets the person array that represent the population
     * 
     * @return the array of people
     */
    public Person[] getPopulation() {
        return population;
    }


    /**
     * This method gets the size of the population
     * 
     * @return the population size on the planet
     */
    public int getPopulationSize() {
        return populationSize;
    }


    /**
     * This method gets the capacity of the planet
     * 
     * @return the number of people allowed on the planet
     */
    public int getCapacity() {
        return capacity;
    }


    /**
     * This method calculates the space left on the planet
     * 
     * @return the number of available spaces left
     */
    public int getAvailability() {
        return capacity - populationSize;
    }


    /**
     * This method checks if the planet population is at full capacity.
     * 
     * @return true if full, false otherwise.
     */
    public boolean isFull() {
        return populationSize == capacity;
    }


    /**
     * This method will attempt to add a person to the planet
     * by checking if there is available space and if the person
     * if qualified.
     * 
     * @param newbie
     *            The new person to add
     * @return is successfully added, false if not.
     */
    public boolean addPerson(Person newbie) {
        if (!isFull() && isQualified(newbie)) {
            population[populationSize] = newbie;
            populationSize++;
            return true;
        }
        return false;
    }


    /**
     * This method checks if a person is qualified to live on the planet
     * based on their skill sets.
     * 
     * @param applicant
     *            The person to check for qualification
     * @return true if person is qualified, false if otherwise.
     */
    public boolean isQualified(Person applicant) {
        return (applicant.getSkills().getAgriculture() >= minSkills
            .getAgriculture() && applicant.getSkills()
                .getMedicine() >= minSkills.getMedicine() && applicant
                    .getSkills().getTechnology() >= minSkills.getTechnology());
    }


    /**
     * This method uses a StringBuilder to represent the planet
     * 
     * @return a string representation of the planet.
     */
    public String toString() {
        StringBuilder s = new StringBuilder();

        s.append(this.getName() + ", ");
        s.append("population " + this.getPopulationSize() + " ");
        s.append("(cap: " + this.getCapacity() + "), ");
        s.append("Requires: A >= " + this.minSkills.getAgriculture());
        s.append(", M >= " + this.minSkills.getMedicine());
        s.append(", T >= " + this.minSkills.getTechnology());
        return s.toString();
    }


    /**
     * This method compares two planets based on capacity(greater wins),
     * then availability(greater wins), then minimal skillSet(greater wins)
     * , then on name (alphabetical)
     * 
     * @param other
     *            the Planet to be compared to.
     * @return 1 if this planet is greater than the other,
     *         -1 if this planet should be ordered after,
     *         0 is everything is the same.
     */
    @Override
    public int compareTo(Planet other) {
        if (other == null) {
            throw new IllegalArgumentException();
        }
        if (this.getCapacity() > other.getCapacity()) {
            return 1;
        }
        else if (this.getCapacity() < other.getCapacity()) {
            return -1;
        }
        else // Same capacity
        {
            if (this.getAvailability() > other.getAvailability()) {
                return 1;
            }
            else if (this.getAvailability() < other.getAvailability()) {
                return -1;
            }
            else // Same availability
            {
                if (this.getSkills().compareTo(other.getSkills()) == 1) {
                    return 1;
                }
                else if (this.getSkills().compareTo(other.getSkills()) == -1) {
                    return -1;
                }
                else // Same skillset values
                {
                    if (this.getName().compareTo(other.getName()) < 0) {
                        return 1;
                    }
                    else if (this.getName().compareTo(other.getName()) > 0) {
                        return -1;
                    }
                    else // Same name
                    {
                        return 0;
                    }
                }
            }
        }
    }


    /**
     * This method checks if two planets are equal based on their
     * input fields and if they have the same population
     * 
     * @param obj
     *            the Object to check if equal.
     * @return true if fields are equal and population equal,
     *         false if otherwise.
     */
    public boolean equals(Object obj) {
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        Planet other = (Planet)obj;

        return (this.getName().equals(other.getName()) && this
            .getSkills() == other.getSkills()  && 
            this.getPopulationSize() == other.getPopulationSize() && this
                .getCapacity() == other.getCapacity());
    }

}
