// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Johan Lee (johanlee20)
package spacecolonies;

/**
 * This class extends from Exception
 * 
 * @author Johan Lee
 * @version 11.6.21
 */
@SuppressWarnings("serial")
public class SpaceColonyDataException extends Exception {
    /**
     * The constructor for a SpaceColonyDataException
     * 
     * @param string
     *            the message for the exception
     */
    public SpaceColonyDataException(String string) {
        super(string);
    }
}
