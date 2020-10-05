package Algo.Sorting;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Objects;

public class MergeSort <T extends Comparable<T>> implements SortingAlgo<T> {

    @Override
    public void sort(T[] unsorted) {
        Objects.requireNonNull(unsorted);
        if (unsorted.length < 2) {
            return;
        }

        Integer mid = unsorted.length / 2;
        T[] left = Arrays.copyOfRange(unsorted, 0, mid);
        T[] right = Arrays.copyOfRange(unsorted, mid, unsorted.length);
        sort(left);
        sort(right);
        merge(unsorted, left, right);
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
