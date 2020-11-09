package Algo.Sorting;

import java.util.Comparator;
import java.util.Objects;

public class SelectorSort<T extends Comparable<T>> implements SortingAlgo<T> {

    private Comparator<T> comparator = Comparator.naturalOrder();

    @Override
    public void sort(T[] unsorted) {
        sort(unsorted, 0, unsorted.length - 1);
    }

    public void sort(T[] unsorted, Comparator<T> comparator) {
        Objects.requireNonNull(comparator);
        this.comparator = comparator;
        sort(unsorted, 0, unsorted.length - 1);
    }

    private void sort(T[] unsorted, int l, int r) {
        if (l >= r) {
            return;
        }

        int minIndex = l;
        for (int i = l; i <= r; ++i) {
            if (comparator.compare(unsorted[i], unsorted[l]) < 0) {
                minIndex = i;
            }
        }
        swap(unsorted, l, minIndex);

        sort(unsorted, l + 1, r);
    }

    private void swap(T[] array, int l, int r) {
        T temp = array[l];
        array[l] = array[r];
        array[r] = temp;
    }
}
