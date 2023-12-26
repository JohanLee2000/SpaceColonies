// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Johan Lee (johanlee20)
package spacecolonies;

import queue.QueueInterface;
import queue.EmptyQueueException;

/**
 * A class that implements the QueueInterface and tracks the person in
 * a queue
 * 
 * @author Johan Lee
 * @version 11.6.21
 * @param <T>
 *            The generic type for the ArrayQueue
 */
public class ArrayQueue<T> implements QueueInterface<T> {
    // ~Fields-----------------------------------------------------------------
    /**
     * This field references the queue that is created.
     */
    protected T[] queue;
    /**
     * This field references the default capacity of the ArrayQueue.
     */
    public static final int DEFAULT_CAPACITY = 20;
    /**
     * This field tracks the index for an enqueue operation, the back index.
     */
    protected int enqueueIndex;
    /**
     * This field tracks the index for a dequeue operation, the front index.
     */
    protected int dequeueIndex;
    /**
     * This field references the number of items stored in the ArrayQueue.
     */
    protected int size;

    // ~Constructor-----------------------------------------------------------
    /**
     * Constructor for ArrayQueue. If more objects need to be added to
     * a queue that has reached its capacity, then the size can be expanded
     * 
     * @param capacity
     *            designates the capacity of the ArrayQueue.
     */
    @SuppressWarnings("unchecked")
    public ArrayQueue(int capacity) {
        queue = (T[])new Object[capacity + 1];
        enqueueIndex = queue.length - 1;
        dequeueIndex = 0;
        size = 0;
    }


    // ~Methods--------------------------------------------------------------
    /**
     * This method returns the length of the underlying array
     * 
     * @return length of array
     */
    public int getLengthOfUnderlyingArray() {
        return queue.length;

    }


    /**
     * This method returns the number of items stored in the queue.
     * 
     * @return the size of the queue
     */
    public int getSize() {
        return size;
    }


    /**
     * This method checks if the arrayQueue is empty
     * 
     * @return true if empty, false otherwise.
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }


    /**
     * This method checks if the arrayQueue is full.
     * 
     * @return true if the queue is full, false if otherwise.
     */
    private boolean isFull() {
        return size == getLengthOfUnderlyingArray() - 1;
    }


    /**
     * This method enqueues the next element and adds
     * it to the arrayQueue.
     */
    @Override
    public void enqueue(T newEntry) {
        ensureCapacity();
        enqueueIndex = (enqueueIndex + 1) % queue.length;
        queue[enqueueIndex] = newEntry;
        size++;
    }


    /**
     * This helper method can double the length of the underlying array
     * when the queue is full.
     */
    @SuppressWarnings("unchecked")
    private void ensureCapacity() {
        if (isFull()) {
            T[] oldContents = queue;
            int oldSize = oldContents.length - 1;
            int newSize = 2 * oldSize;
            queue = (T[])new Object[newSize + 1];
            // Copy queue contents to new queue
            int j = dequeueIndex;
            for (int i = 0; i < oldSize; i++) {
                queue[i] = oldContents[j];
                j = (j + 1) % oldSize;
            }

            dequeueIndex = 0;
            enqueueIndex = oldSize - 1;
        }

    }


    /**
     * This method dequeues the entry at the front of the queue.
     * 
     * @return the entry that was removed from the queue.
     */
    @Override
    public T dequeue() {
        if (isEmpty()) {
            throw new EmptyQueueException();
        }
        T front = getFront();
        queue[dequeueIndex] = null;
        dequeueIndex = incrementIndex(dequeueIndex);
        size--;
        return front;
    }


    /**
     * This method gets the entry at the front of the queue.
     * 
     * @return the entry at the front of the queue.
     */
    @Override
    public T getFront() {
        if (isEmpty()) {
            throw new EmptyQueueException();
        }
        return queue[dequeueIndex];
    }


    /**
     * This method resets the ArrayQueue to its original state
     * with a default capacity.
     */
    @SuppressWarnings("unchecked")
    @Override
    public void clear() {
        queue = (T[])new Object[DEFAULT_CAPACITY + 1];
        enqueueIndex = queue.length - 1;
        dequeueIndex = 0;
        size = 0;
    }


    /**
     * This helper method increments an index in the array
     * 
     * @return the index of the incremented index.
     */
    private int incrementIndex(int index) {
        return ((index + 1) % queue.length);
    }


    /**
     * This method returns array with its entries starting at index 0
     * but does not affect the original queue.
     * 
     * @return an array of the same size without no extra empty slots
     */
    public Object[] toArray() {
        if (isEmpty()) {
            throw new EmptyQueueException();
        }
        Object[] array = new Object[this.getSize()];
        int j = dequeueIndex;
        for (int i = 0; i < this.getSize(); i++) {
            array[i] = queue[j];
            j++;
        }
        return array;
    }


    /**
     * This method will iterate through the contents of the queue
     * and concatenate them together, separated by a comma and space
     * 
     * @return a string representation of the array.
     */
    public String toString() {
        StringBuilder s = new StringBuilder();
        if (isEmpty()) {
            s.append("[]");
        }
        else {
            s.append("[");
            int j = dequeueIndex;
            for (int i = 0; i < this.getSize(); i++) {
                s.append(queue[j]);
                if (i + 1 != this.getSize()) {
                    s.append(", ");
                }
                j++;
            }
            s.append("]");
        }
        return s.toString();
    }


    /**
     * This method tests if ArrayQueues are equal if
     * they contain the same elements in same order
     * 
     * @param obj
     *            the Object to be compared to
     * @return true if ArrayQueues are equal, false otherwise.
     */
    public boolean equals(Object obj) {
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        if (obj == this) {
            return true;
        }

        Object[] queue2 = (Object[])obj;
        if (this.getSize() != queue2.length) {
            return false;
        }
        for (int i = 0; i < this.getSize(); i++) {
            T myElement = queue[(dequeueIndex + i) % queue.length];
            @SuppressWarnings("unchecked")
            T otherElement = (T)queue2[i];

            if (!myElement.equals(otherElement)) {
                return false;
            }

        }
        return true;
    }

}
