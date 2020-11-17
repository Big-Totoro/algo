package Algo;

import Algo.Sorting.MergeSort;
import Algo.Sorting.SortingAlgo;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MergeSortTest {

    @Before
    public void setup() {

    }

    @Test
    public void test1() {
        SortingAlgo<Integer> sortingAlgo = new MergeSort<>();
        Integer[] unsorted = {5, 2, 8, 4, 6, 7, 1, 3};
        sortingAlgo.sort(unsorted);

        assertThat(unsorted).isEqualTo(new Integer[] {1, 2, 3, 4, 5, 6, 7, 8});
    }

    @Test
    public void test2() {
        SortingAlgo<Integer> sortingAlgo = new MergeSort<>();
        Integer[] unsorted = {5, 2, 8, 9, 4, 6, 7, 1, 3};
        sortingAlgo.sort(unsorted);

        assertThat(unsorted).isEqualTo(new Integer[] {1, 2, 3, 4, 5, 6, 7, 8, 9});
    }
}
