package Algo.Misc;

import java.lang.reflect.Array;
import java.util.Objects;

public class PriorityHeap<T extends Comparable<T>> {

    private static final int INITIAL_CAPACITY = 10;

    private T[] pq;
    private int size = 0;
    private int N = 0;

    public PriorityHeap(Class<T> clazz) {
        this(clazz, INITIAL_CAPACITY);
    }

    public PriorityHeap(Class<T> clazz, int capacity) {
        if (capacity < 1) {
            throw new IllegalArgumentException();
        }
        pq = (T[])Array.newInstance(clazz, capacity);
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public T peek() {
        return pq[1];
    }

    public T pop() {
        if (N < 1) {
            return null;
        }

        T result = pq[1];
        swap(1, N);
        pq[N--] = null;
        --size;
        bubbleDown(1);
        return result;
    }

    public boolean offer(T element) {
        Objects.requireNonNull(element);

        pq[++N] = element;
        bubbleUp(N);
        ++size;

        return true;
    }

    private void bubbleUp(int index) {
        if (index / 2 == 0) {
            return;
        }
        while (index > 0 && index / 2 > 0 && pq[index / 2].compareTo(pq[index]) > 0) {
            swap(index / 2, index);
            index /= 2;
        }
    }

    private void bubbleDown(int index) {
        while (2 * index < N) {
            int j = 2 * index;
            if (j < N && pq[j].compareTo(pq[j + 1]) > 0) {
                j++;
            }
            if (j > 0 && pq[j].compareTo(pq[j + 1]) > 0) {
                break;
            }

            swap(index, j);
            index = j;
        }
    }

    private void swap(int left, int right) {
        T temp = pq[left];
        pq[left] = pq[right];
        pq[right] = temp;
    }
}
