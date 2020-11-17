package Algo;

import Algo.Sorting.SelectorSort;
import Algo.Sorting.SortingAlgo;
import org.junit.Test;

import java.util.Comparator;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class SelectionSortTest {

    @Test
    public void test11() {
        Integer[] array = {5, 4, 3, 2, 1};
        SortingAlgo<Integer> sortingAlgo = new SelectorSort<>();

        sortingAlgo.sort(array);
        assertThat(array).isEqualTo(new Integer[] {1, 2, 3, 4, 5});
    }

    @Test
    public void test12() {
        Integer[] array = {1, 2, 3, 4, 5};
        SortingAlgo<Integer> sortingAlgo = new SelectorSort<>();

        sortingAlgo.sort(array, Comparator.reverseOrder());
        assertThat(array).isEqualTo(new Integer[] {5, 4, 3, 2, 1});
    }
}
