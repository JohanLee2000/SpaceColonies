// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Johan Lee (johanlee20)
package spacecolonies;

/**
 * A class that contains the data of the applicant info
 * 
 * @author Johan Lee
 * @version 11.6.21
 */
public class Person {
    // ~Fields----------------------------------------------------------------
    /**
     * This field references the person's name.
     */
    protected String name;
    /**
     * This field references the skillset of the person.
     */
    protected Skillset skills;
    /**
     * This field references the planet the person prefers.
     */
    protected String planetPreference;

    // ~Constructor------------------------------------------------------------
    /**
     * Constructor for Person with 5 parameters
     * 
     * @param name
     *            Name of the person
     * @param agri
     *            score for agriculture
     * @param medi
     *            score for medicine
     * @param tech
     *            score for technology
     * @param planet
     *            Planet preferred by the person
     */
    public Person(String name, int agri, int medi, int tech, String planet) {
        this.name = name;
        skills = new Skillset(agri, medi, tech);
        planetPreference = planet;
    }


    /**
     * This method returns the name of the person
     * 
     * @return the name of the person in a string.
     */
    public String getName() {
        return name;
    }


    /**
     * This method returns the Skillset of the person
     * 
     * @return the skills of the person in a skillset
     */
    public Skillset getSkills() {
        return skills;
    }


    /**
     * This method returns the planet preference of the person
     * 
     * @return the planet preferred by the person in a string
     */
    public String getPlanetPreference() {
        return planetPreference;
    }


    /**
     * This method uses a StringBuilder to represent the person's values.
     * 
     * @return the person's name, skillset and preference as a string.
     */
    public String toString() {
        StringBuilder s = new StringBuilder();
        if (planetPreference.length() == 0) {
            s.append("No-Planet ");
        }
        s.append(name + " ");
        s.append(skills.toString());
        if (planetPreference.length() > 0) {
            s.append(" Wants: ");
            s.append(planetPreference);
        }
        return s.toString();
    }


    /**
     * This method checks if two person objects are equal
     * 
     * @param obj
     *            the Object to be compared to
     * @return true if their name, skillset and planetPreference
     *         values are the same, false if otherwise.
     */
    public boolean equals(Object obj) {
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        return (this.getName().equals(((Person)obj).getName()) && this
            .getSkills().toString().equals(((Person)obj).getSkills().toString())
            && this.getPlanetPreference().equals(((Person)obj)
                .getPlanetPreference()));
    }

}
