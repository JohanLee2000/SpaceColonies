// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Johan Lee (johanlee20)
package spacecolonies;

/**
 * A class that provides information on the skill sets
 * of the people
 * 
 * @author Johan Lee
 * @version 11.6.21
 */
public class Skillset implements Comparable<Skillset> {
    // ~Fields-----------------------------------------------------------------
    /**
     * This field references the agriculture score.
     */
    protected int agriculture;
    /**
     * This field references the medicine score.
     */
    protected int medicine;
    /**
     * This field references the technology score.
     */
    protected int technology;

    // ~Constructor-----------------------------------------------------------
    /**
     * Constructor for Skillset with 3 parameters
     * 
     * @param ag
     *            The agriculture score
     * @param med
     *            The medicine score
     * @param tech
     *            The technology score
     */
    public Skillset(int ag, int med, int tech) {
        agriculture = ag;
        medicine = med;
        technology = tech;
    }


    // ~Methods-----------------------------------------------------------------
    /**
     * This method returns the agriculture score
     * 
     * @return the agriculture field
     */
    public int getAgriculture() {
        return agriculture;
    }


    /**
     * This method returns the medicine score
     * 
     * @return the medicine field
     */
    public int getMedicine() {
        return medicine;
    }


    /**
     * This method returns the technology score
     * 
     * @return the technology field
     */
    public int getTechnology() {
        return technology;
    }


    /**
     * This method compares this skillset object to another.
     * 
     * @param other
     *            is another skillset object
     * @return true if the agriculture, medicine and technology fields are
     *         all less than or equal to the other skillset fields, false if
     *         otherwise.
     */
    public boolean isLessThanOrEqualTo(Skillset other) {
        return (this.agriculture <= other.agriculture
            && this.medicine <= other.medicine
            && this.technology <= other.technology);
    }


    /**
     * This method converts the data of the skillset into a string.
     * 
     * @return the string representation of the skillset
     */
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("A:");
        s.append(this.getAgriculture() + " ");
        s.append("M:");
        s.append(this.getMedicine() + " ");
        s.append("T:");
        s.append(this.getTechnology());
        return s.toString();
    }


    /**
     * This method checks if two skillset objects are equal.
     * 
     * @param obj
     *            the Object to be compared to
     * @return true if all three fields, agriculture, technology and
     *         medicine are equal, false if otherwise.
     */
    public boolean equals(Object obj) {
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        return (this.getAgriculture() == ((Skillset)obj).getAgriculture()
            && this.getMedicine() == ((Skillset)obj).getMedicine() && this
                .getTechnology() == ((Skillset)obj).getTechnology());
    }


    /**
     * This method implements Comparable to compare the sum of the
     * skills of the current object to the parameter object.
     * 
     * @return -1 if sum is less than skills of current object
     *         0 if sum is equal to skills of current object
     *         1 if sum is greater than skills of current object
     */
    @Override
    public int compareTo(Skillset skills) {
        if (skills == null) {
            throw new IllegalArgumentException();
        }
        int thisSum = this.getAgriculture() + this.getMedicine() + this
            .getTechnology();
        int otherSum = skills.getAgriculture() + skills.getMedicine() + skills
            .getTechnology();

        if (thisSum > otherSum) {
            return 1;
        }
        else if (thisSum < otherSum) {
            return -1;
        }
        else {
            return 0;
        }

    }

}
