package Algo;

import Algo.Misc.Trimino;
import org.junit.Test;

import java.util.Random;

public class TriminoTest {
    @Test
    public void test11() {
        Random random = new Random();
        Trimino trimino = new Trimino();
        int n = 16;
        int p = random.nextInt(n);
        int q = random.nextInt(n);
        String[][] triminos = new String[n][n];
        for (int i = 0; i < triminos.length; i++) {
            triminos[i] = new String[n];
        }
        trimino.triminos(triminos, 0, 0, n, p, q);
        for (int i = 0; i < triminos[0].length; i++) {
            for (int j = 0; j < triminos[i].length; j++) {
                String t = triminos[i][j];
                System.out.println(t);
            }
        }
    }
}
