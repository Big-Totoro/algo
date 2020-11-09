package Algo.Sorting;

import java.util.Comparator;

public interface SortingAlgo<T extends Comparable<T>> {

    void sort(T[] unsorted);
    void sort(T[] unsorted, Comparator<T> comparator);
}
