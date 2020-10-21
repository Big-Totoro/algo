package Algo.Misc;

import java.util.Random;

public class RSelect {
    private Random random = new Random();

    public int select(int[] array, int i) {
        if (array.length == 1) {
            return array[0];
        }

        int idx = select(array, 0, array.length - 1, i);
        return array[idx];
    }

    private int select(int[] array, int l, int r, int i) {
        int p = choosePivot(array, l, r);
        int j = partition(array, l, r, p);
        if (j == i) {
            return j;
        }
        if (j < i) {
            return select(array, j + 1, r, i);
        }

        return select(array, l, j - 1, i);
    }

    private int choosePivot(int[] array, int l, int r) {
        return l + (r - l) / 2;
    }

    private int partition(int[] array, int l, int r, int pivot) {
        swap(array, l, pivot);

        int i = l + 1;
        int p = array[l];

        for (int j = l + 1; j <= r; ++j) {
            if (array[j] < p) {
                swap(array, i, j);
                i++;
            }
        }
        swap(array, l, i - 1);

        return i - 1;
    }

    private void swap(int[] array, int l, int r) {
        int temp = array[l];
        array[l] = array[r];
        array[r] = temp;
    }
}
