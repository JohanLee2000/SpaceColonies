// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Johan Lee (johanlee20)
package spacecolonies;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * A class to read the input and process them
 * 
 * @author Johan Lee
 * @version 11.6.21
 */
public class ColonyReader {
    // ~Fields----------------------------------------------------------------
    /**
     * This field references the list of planets
     */
    protected Planet[] planets;
    /**
     * This field references the queue of people
     */
    protected ArrayQueue<Person> queue;

    // ~Constructor----------------------------------------------------------
    /**
     * A constructor for ColonyReader
     * 
     * @param applicantFileName
     *            name of applicant
     * @param planetFileName
     *            name of planet
     * @throws SpaceColonyDataException
     * @throws FileNotFoundException
     */
    public ColonyReader(String applicantFileName, String planetFileName)
        throws FileNotFoundException,
        SpaceColonyDataException {
        planets = readPlanetFile(planetFileName);
        queue = readQueueFile(applicantFileName);
    }


    // ~Methods-------------------------------------------------------------
    /**
     * This method will declare a local array of planets to be
     * stored in sequential order.
     * 
     * @param fileName
     *            the name of the file
     * @return an array of the planets
     * @throws FileNotFoundException
     * @throws SpaceColonyDataException
     */
    private Planet[] readPlanetFile(String fileName)
        throws FileNotFoundException,
        SpaceColonyDataException {
        Planet[] planetFile = new Planet[3];
        Scanner file = new Scanner(new File(fileName));
        int counter = 0;
        while (file.hasNextLine() && counter < 3) {
            while (file.hasNext()) {
                String string = file.next();
                string.split(", *");
                if (Integer.valueOf(string) > 5 || Integer.valueOf(
                    string) < 1) {
                    throw new SpaceColonyDataException("invalid skill");
                }
            }
            // planetFile[counter] = file.nextLine();
            counter++;
        }
        if (counter < 3) {
            throw new SpaceColonyDataException("Less than 3 planets");
        }
        file.close();
        return planets;
    }


    /**
     * This method will declare an local array of person to be stored
     * in the input file
     * 
     * @throws FileNotFoundException
     * @throws SpaceColonyDataException
     */
    private ArrayQueue<Person> readQueueFile(String fileName)
        throws FileNotFoundException,
        SpaceColonyDataException {
        ArrayQueue<Person> array = new ArrayQueue<Person>(1);
        Scanner file = new Scanner(new File(fileName));
        while (file.hasNextLine()) {
            while (file.hasNext()) {
                String string = file.next();
                string.split(", *");
                if (Integer.valueOf(string) > 5 || Integer.valueOf(
                    string) < 1) {
                    throw new SpaceColonyDataException("invalid skill");
                }
            }
        }
        file.close();
        return array;
    }
}
