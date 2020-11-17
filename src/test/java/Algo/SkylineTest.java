package Algo;

import Algo.Misc.Skyline;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SkylineTest {
    @Test
    public void test11() {
        Skyline skyline = new Skyline();
        Skyline.Building[] buildings = new Skyline.Building[] {
                Skyline.Building.valueOf(1, 7, 7),
                Skyline.Building.valueOf(18, 20, 7),
                Skyline.Building.valueOf(2, 9, 5),
                Skyline.Building.valueOf(17, 19, 2),
                Skyline.Building.valueOf(12, 24, 3),
                Skyline.Building.valueOf(3, 8, 8),
                Skyline.Building.valueOf(11, 13, 5),
                Skyline.Building.valueOf(15, 21, 6)
        };
        assertThat(skyline.computeSkyline(buildings))
        .isEqualTo(new Skyline.Pair[] {
                Skyline.Pair.valueOf(1, 7),
                Skyline.Pair.valueOf(3, 8),
                Skyline.Pair.valueOf(8, 5),
                Skyline.Pair.valueOf(9, 0),
                Skyline.Pair.valueOf(11, 5),
                Skyline.Pair.valueOf(13, 3),
                Skyline.Pair.valueOf(15, 6),
                Skyline.Pair.valueOf(18, 7),
                Skyline.Pair.valueOf(20, 6),
                Skyline.Pair.valueOf(21, 3),
                Skyline.Pair.valueOf(24, 0),
        });
    }
}
