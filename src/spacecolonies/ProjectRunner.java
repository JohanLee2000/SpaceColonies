// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Johan Lee (johanlee20)
package spacecolonies;

import java.io.FileNotFoundException;

/**
 * This class begins the program.
 * 
 * @author Johan Lee
 * @version 11.6.21
 */
public class ProjectRunner {
    /**
     * A constructor for ProjectRunner.
     */
    public ProjectRunner() {
        super();
    }


    /**
     * This method instantiates ColonyReader and provides
     * the text files.
     * 
     * @param args
     *            the array to input.
     * @throws SpaceColonyDataException
     * @throws FileNotFoundException
     */
    public static void main(String[] args)
        throws FileNotFoundException,
        SpaceColonyDataException {

        ColonyReader reader = new ColonyReader("input.txt", "planets.txt");
    }
}
