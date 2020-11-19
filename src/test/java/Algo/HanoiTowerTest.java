package Algo;

import Algo.Misc.HanoiTower;
import org.junit.Test;

public class HanoiTowerTest {
    @Test
    public void test11() {
        HanoiTower hanoiTower = new HanoiTower();
        hanoiTower.moveTower(3, 1, 2, 3);
    }

    @Test
    public void test12() {
        HanoiTower hanoiTower = new HanoiTower();
        hanoiTower.moveTower(4, 1, 2, 3);
    }
}
