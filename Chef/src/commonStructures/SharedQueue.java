package commonStructures;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Miguel "NS" Fradinho Alves
 */
public class SharedQueue<T> extends Queue<T> {

    // Our locks for
    private Condition emptyLock, fullLock;
    // Lock that guarantees mutual exclusion
    private Lock mutex;

    public SharedQueue(int size) {
        super(size);
        mutex = new ReentrantLock();
        emptyLock = mutex.newCondition();
        fullLock = mutex.newCondition();
    }

    /**
     * Concurrent-safe <p> {@inheritDoc} </p>
     */
    @Override
    public void enqueue(T element) {
        // entering monitor
        mutex.lock();
        try {
            // While it's full, we get blocked
            while (this.current_size == this.values.length) {
                try {
                    fullLock.await();
                } catch (InterruptedException e) { }
            }
            // Accessing critical region
            this.current_size++;
            this.values[this.in_element] = element;
            this.in_element = (this.in_element + 1) % this.values.length;
            // Leaving critical region
            // Giving a heads up that's not empty anymore
            emptyLock.signal();
        } finally {
            // Exiting monitor
            mutex.unlock();
        }
    }


    /**
     * Concurrent-safe <p> {@inheritDoc} </p>
     */
    @Override
    public T dequeue() {
        // entering monitor
        mutex.lock();
        try {
            // If it's empty, we get blocked
            while (current_size == 0) {
                try {
                    emptyLock.await();
                } catch (InterruptedException e) {
                }
            }
            // Accessing critical region
            this.current_size--;
            T element = this.values[out_element];
            this.values[out_element] = null;
            this.out_element = (this.out_element + 1) % this.values.length;
            // leaving critical region
            // Warning that's not full anymore
            fullLock.signal();
            return element;
        } finally {
            // Exiting monitor
            mutex.unlock();
        }
    }
}
