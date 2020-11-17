package Algo;

import Algo.Misc.Skyline;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

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

        List<Skyline.Pair> expected = new ArrayList<>();
        expected.add(Skyline.Pair.valueOf(1, 7));
        expected.add(Skyline.Pair.valueOf(3, 8));
        expected.add(Skyline.Pair.valueOf(8, 5));
        expected.add(Skyline.Pair.valueOf(9, 0));
        expected.add(Skyline.Pair.valueOf(11, 5));
        expected.add(Skyline.Pair.valueOf(13, 3));
        expected.add(Skyline.Pair.valueOf(15, 6));
        expected.add(Skyline.Pair.valueOf(18, 7));
        expected.add(Skyline.Pair.valueOf(20, 6));
        expected.add(Skyline.Pair.valueOf(21, 3));
        expected.add(Skyline.Pair.valueOf(24, 0));
        
        assertThat(skyline.computeSkyline(buildings)).isEqualTo(expected);
    }
}
