package commonStructures;

/**
 * @author Miguel "NS" Fradinho Alves
 */
public class Queue<T> {
    // Circular Queue
    /**
     * Our values
     */
    protected T[]     values;
    /**
     * Variable for know when the Queue is empty
     */
    protected boolean empty;
    /**
     * The current size of the queue
     */
    protected int     current_size;
    /**
     * Index of the next element to be removed
     */
    protected int     out_element;
    /**
     * Index of the next available position
     */
    protected int     in_element;

    @SuppressWarnings("unchecked")
    public Queue(int size) {
        empty = true;
        current_size = 0;
        out_element = 0;
        in_element = 0;
        if (size > 0) {
            this.values = (T[]) new Object[size];
        } else {
            this.values = (T[]) new Object[10];
        }

    }

    /**
     * Returns the current number of elements in the Queue
     *
     * @return the current number of elements in the Queue
     */
    public int getSize() {
        return this.current_size;
    }

    /**
     * Inserts the element to the Queue
     *
     * @param element to insert into the Queue
     */
    public void enqueue(T element) {
        // when full
        if ((this.in_element == this.out_element) && !empty) {
            System.out.println("ERROR: QUEUE IS FULL");
            return;
        }
        // Not full
        else {
            empty = false;
            this.current_size++;
            this.values[this.in_element] = element;
            this.in_element = (this.in_element + 1) % this.values.length;
        }
    }

    /**
     * Removes and returns the oldest element in Queue, if the Queue has any elements. Otherwise, returns null.
     *
     * @return the oldest element in the Queue or null.
     */
    public T dequeue() {
        if (!empty) {
            this.current_size--;
            T element = this.values[out_element];
            this.values[out_element] = null;
            this.out_element = (this.out_element + 1) % this.values.length;
            // Which means we removed last element
            if (this.out_element == this.in_element) {
                empty = true;
            }
            return element;
        }

        return null;
    }
}
