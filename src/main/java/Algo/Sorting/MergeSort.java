package Algo.Sorting;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;

public class MergeSort <T extends Comparable<T>> implements SortingAlgo<T> {

    private Comparator<T> comparator = Comparator.naturalOrder();

    @Override
    public void sort(T[] unsorted) {
        Objects.requireNonNull(unsorted);
        if (unsorted.length < 2) {
            return;
        }

        int mid = unsorted.length / 2;
        T[] left = Arrays.copyOfRange(unsorted, 0, mid);
        T[] right = Arrays.copyOfRange(unsorted, mid, unsorted.length);
        sort(left);
        sort(right);
        merge(unsorted, left, right);
    }

    @Override
    public void sort(T[] unsorted, Comparator<T> comparator) {
        Objects.requireNonNull(comparator);
        this.comparator = comparator;
        sort(unsorted);
    }

    private void merge(T[] result, T[] left, T[] right) {
        Objects.requireNonNull(left);
        Objects.requireNonNull(right);

        int i = 0;
        int j = 0;
        int k = 0;

        while (i < left.length && j < right.length) {
            if (left[i].compareTo(right[j]) < 0) {
                result[k++] = left[i++];
            } else {
                result[k++] = right[j++];
            }
        }

        while (i < left.length) {
            result[k++] = left[i++];
        }

        while (j < right.length) {
            result[k++] = right[j++];
        }
    }
}
