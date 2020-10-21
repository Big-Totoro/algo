package Algo.Sorting;

import java.util.Comparator;
import java.util.Random;

public class QuickSort<T extends Comparable<T>> implements SortingAlgo<T> {

    private Comparator<T> comparator = Comparator.naturalOrder();

    public void sort(T[] array) {
        sort(array, 0, array.length - 1);
    }

    public void sort(T[] array, Comparator<T> comparator) {
        this.comparator = comparator;
        sort(array, 0, array.length - 1);
    }

    private void sort(T[] array, int l, int r) {
        if (r - l < 1) {
            return;
        }

        int i = choosePivot(array, l, r);
        int j = partition(array, l, r, i);
        sort(array, l, j - 1);
        sort(array, j + 1, r);
    }

    private int choosePivot(T[] array, int l, int r) {
        return l + new Random().nextInt(r - l);
    }

    private int partition(T[] array, int l, int r, int pivot) {
        swap(array, l, pivot);

        int i = l + 1;
        T p = array[l];

        for (int j = l + 1; j <= r; ++j) {
            if (comparator.compare(array[j], p) < 0) {
                swap(array, i, j);
                i++;
            }
        }
        swap(array, i - 1, l);

        return i - 1;
    }

    private void swap(T[] array, int l, int r) {
        T temp = array[l];
        array[l] = array[r];
        array[r] = temp;
    }
}