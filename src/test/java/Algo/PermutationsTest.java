package Algo;

import Algo.Misc.Permutations;
import org.junit.Test;

import java.util.List;

public class PermutationsTest {
    @Test
    public void test11() {
        Permutations permutations = new Permutations();
        List<List<Integer>> list = permutations.getPermutations(new int[]{1, 2, 3});
        System.out.println(list.size());
        for (List<Integer> integers : list) {
            System.out.println(integers);
        }
    }
}
