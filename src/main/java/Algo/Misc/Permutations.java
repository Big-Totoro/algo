package Algo.Misc;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    public List<List<Integer>> getPermutations(int[] array) {
        List<List<Integer>> permutations = new ArrayList<>();
        getPermutations(array, 0, permutations);

        return permutations;
    }

    private void getPermutations(int[] array, int start, List<List<Integer>> result) {
        if (start == array.length) {
            List<Integer> temp = new ArrayList<>();
            for(int i = 0; i < array.length; ++i) {
                temp.add(array[i]);
            }
            result.add(temp);
            return;
        }

        for (int k = start; k < array.length; ++k) {
            swap(array, k, start);
            getPermutations(array, start + 1, result);
            swap(array, k, start);
        }
    }

    private void swap(int[] array, int l, int r) {
        int temp = array[l];
        array[l] = array[r];
        array[r] = temp;
    }
}
