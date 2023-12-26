// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Johan Lee (johanlee20)
package spacecolonies;

import queue.EmptyQueueException;
import student.TestCase;

/**
 * A test class for ArrayQueue and its methods.
 * 
 * @author Johan Lee
 * @version 11.6.21
 */
public class ArrayQueueTest extends TestCase {
    // ~Fields----------------------------------------------------------------
    private ArrayQueue<String> queue;

    /**
     * Set up the test case
     */
    public void setUp() {
        queue = new ArrayQueue<String>(20);
    }


    // ~Methods-------------------------------------------------------------
    /**
     * Test the getLengthOfUnderlyingArray method.
     */
    public void testGetLengthOfUnderlyingArray() {
        assertEquals(21, queue.getLengthOfUnderlyingArray());
    }


    /**
     * Test the getSize method.
     */
    public void testGetSize() {
        assertEquals(0, queue.getSize());
    }


    /**
     * Test the isEmpty method.
     */
    public void testIsEmpty() {
        assertTrue(queue.isEmpty());
        queue.enqueue("zero");
        assertFalse(queue.isEmpty());
    }


    /**
     * Test the enqueue method for adding entries correctly when
     * not at full capacity.
     */
    public void testEnqueueEntry() {
        queue.enqueue("zero");
        queue.enqueue("one");
        assertEquals(2, queue.getSize());
        assertEquals(21, queue.getLengthOfUnderlyingArray());

        assertEquals("zero", queue.dequeue());
    }


    /**
     * Test the enqueue method for when the capacity is full
     */
    public void testEnqueueFullCapacity() {
        for (int i = 0; i < 20; i++) {
            queue.enqueue("fill");
        }
        assertEquals(20, queue.getSize());
        queue.enqueue("fill2");
        assertEquals(41, queue.getLengthOfUnderlyingArray());

        assertEquals("fill", queue.dequeue());
        assertEquals("fill", queue.dequeue());
    }


    /**
     * Test the dequeue method
     */
    public void testDequeue() {
        Exception exception = null;
        try {
            queue.dequeue();
            fail("dequeue() is not throwing an exception when it should");
        }
        catch (Exception e) {
            exception = e;
        }
        assertTrue(exception instanceof EmptyQueueException);

        queue.enqueue("zero");
        queue.enqueue("one");
        assertEquals(2, queue.getSize());
        assertEquals("zero", queue.dequeue());
        assertEquals("one", queue.dequeue());
        assertEquals(0, queue.getSize());
    }


    /**
     * Test the getFront method
     */
    public void testGetFront() {
        Exception exception = null;
        try {
            queue.getFront();
            fail("getFront() is not throwing an exception when it should");
        }
        catch (Exception e) {
            exception = e;
        }
        assertTrue(exception instanceof EmptyQueueException);
        queue.enqueue("zero");
        queue.enqueue("one");
        assertEquals("zero", queue.getFront());
    }


    /**
     * Test the clear method
     */
    public void testClear() {
        queue.enqueue("fill");
        queue.enqueue("fill2");
        queue.clear();
        assertEquals(0, queue.getSize());
        assertEquals(21, queue.getLengthOfUnderlyingArray());
        Exception exception = null;
        try {
            queue.dequeue();
            fail("dequeue() is not throwing an exception when it should");
        }
        catch (Exception e) {
            exception = e;
        }
        assertTrue(exception instanceof EmptyQueueException);
    }


    /**
     * Test the toArray method
     */
    public void testToArray() {
        Exception exception = null;
        try {
            queue.toArray();
            fail("toArray() is not throwing an exception when it should");
        }
        catch (Exception e) {
            exception = e;
        }
        assertTrue(exception instanceof EmptyQueueException);

        queue.enqueue("zero");
        queue.enqueue("one");
        queue.enqueue("two");
        Object[] array = queue.toArray();
        assertEquals(3, array.length);

    }


    /**
     * Test the toString method
     */
    public void testToString() {
        assertEquals("[]", queue.toString());
        queue.enqueue("zero");
        queue.enqueue("one");
        assertEquals("[zero, one]", queue.toString());
    }


    /**
     * Test the equals method
     */
    public void testEquals() {
        Object obj = new Object();
        assertFalse(queue.equals(null));
        assertFalse(queue.equals(obj));
        assertTrue(queue.equals(queue));

    }
}
