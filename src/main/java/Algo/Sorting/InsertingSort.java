package Algo.Sorting;

import java.util.Arrays;

public class InsertingSort<T extends Comparable<T>> implements SortingAlgo<T> {

    @Override
    public void sort(T[] unsorted) {

        T key;
        int j;

        for (int i = 1; i < unsorted.length; ++i) {

            key = unsorted[i];

            j = i;
            while ((j > 0) && (unsorted[j - 1].compareTo(unsorted[j]) > 0) ) {

                unsorted[j] = unsorted[j - 1];
                unsorted[j - 1] = key;

                j = j - 1;
            }
        }
    }

    public static void main(String[] args) {

        SortingAlgo<Integer> sortingAlgo = new InsertingSort<>();
        Integer[] unsorted = {5, 2, 4, 6, 1, 3, 5, 1};

        sortingAlgo.sort(unsorted);

        System.out.println(String.format("The sorted array: %s", Arrays.toString(unsorted)));
    }
}
