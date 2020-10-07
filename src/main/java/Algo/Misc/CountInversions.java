package Algo.Misc;

import java.util.Arrays;
import java.util.Objects;

/**
 * Find a couple of elements that are in inverse order.
 * For example, [1, 3, 5, 2, 4, 6]. Here are (5, 2), (3, 2), (5, 4) couples in the inverse mode.
 */
public class CountInversions {
    public int countInversions(Integer[] array) {
        Objects.requireNonNull(array);
        if (array.length < 2) {
            return 0;
        }

        int mid = array.length / 2;
        Integer[] left = Arrays.copyOfRange(array, 0, mid);
        Integer[] right = Arrays.copyOfRange(array, mid, array.length);

        Integer r1 = countInversions(left);
        Integer r2 = countInversions(right);
        Integer r3 = mergeAndCountSplitInversions(array, left, right);

        return r1 + r2 + r3;
    }

    private int mergeAndCountSplitInversions(Integer[] array, Integer[] left, Integer[] right) {
        int i = 0;
        int j = 0;
        int k = 0;
        int inversionsCounter = 0;

        while (i < left.length && j < right.length) {
            if (left[i] < right[j]) {
                array[k++] = left[i++];
            } else {
                array[k++] = right[j++];
                inversionsCounter += left.length - i;
            }
        }

        while (i < left.length) {
            array[k++] = left[i++];
        }

        while (j < right.length) {
            array[k++] = right[j++];
        }

        return inversionsCounter;
    }
}
