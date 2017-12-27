package Exercises.Numbers;

import java.util.ArrayList;
import java.util.HashMap;

public class Numbers {

    /**
     * Find all combinations that match to the a^3 + b^3 = c^3 + d^3
     *
     * Brute force algorithms through all values O(n^4)
     */
    public static void a3b3_eq_c3d3_brute_force() {

        int A = 100, B = 100, C = 100, D = 100;
        /**
         * A number of combinations
         */
        int combinations = 0;

        /**
         * A number of operations;
         */
        int operations = 0;

        for (int a = 0; a < A; ++a) {

            for (int b = 0; b < B; ++b) {

                for (int c = 0; c < C; ++c) {

                    for (int d = 0; d < D; ++d) {

                        ++operations;

                        if ((Math.pow(a, 3) + Math.pow(b, 3)) == (Math.pow(c, 3) + Math.pow(d, 3))) {

                            System.out.println(String.format("a^3 + b^3 = c^3 + d^3 -> %d, %d, %d, %d", a, b, c, d));

                            ++combinations;

                            break;
                        }
                    }
                }
            }
        }

        System.out.println(String.format("A number of iterations to find all combinations: %d", combinations));
        System.out.println(String.format("A number of operations to find all combinations: %d", operations));
    }

    /**
     * Find all combinations that match to the a^3 + b^3 = c^3 + d^3
     *
     * Brute force algorithms through all values O(n^3) and we calculate d = Pow(a^3 + b^3 - c^3, 1/3)
     */
    public static void a3b3_eq_c3d3_optimization1() {

        int A = 100, B = 100, C = 100, D = 100;
        /**
         * A number of combinations
         */
        int combinations = 0;

        /**
         * A number of operations;
         */
        int operations = 0;

        for (int a = 0; a < A; ++a) {

            for (int b = 0; b < B; ++b) {

                for (int c = 0; c < C; ++c) {

                    ++operations;

                    int d = (int) Math.pow(Math.pow(a, 3) + Math.pow(b, 3) - Math.pow(c, 3), 1.0f / 3.0f);
                    if ((Math.pow(a, 3) + Math.pow(b, 3)) == (Math.pow(c, 3) + Math.pow(d, 3))) {

                        System.out.println(String.format("a^3 + b^3 = c^3 + d^3 -> %d, %d, %d, %d", a, b, c, d));

                        ++combinations;
                    }
                }
            }
        }

        System.out.println(String.format("A number of iterations to find all combinations: %d", combinations));
        System.out.println(String.format("A number of operations to find all combinations: %d", operations));
    }

    /**
     * Find all combinations that match to the a^3 + b^3 = c^3 + d^3
     *
     * Brute force algorithms through all values O(n^3) and we calculate d = Pow(a^3 + b^3 - c^3, 1/3)
     */
    public static void a3b3_eq_c3d3_optimization2() {

        int A = 100, B = 100, C = 100, D = 100;
        /**
         * A number of combinations
         */
        int combinations = 0;

        /**
         * A number of operations;
         */
        int operations = 0;

        HashMap map = new HashMap(C * D);

        for (int c = 0; c < C; ++c) {

            for (int d = 0; d < D; ++d) {

                int sum = (int) (Math.pow(c, 3) + Math.pow(d, 3));
                ArrayList valuesCD = (ArrayList) map.get(Integer.valueOf(sum));

                if (valuesCD == null) {

                    valuesCD = new ArrayList();
                    map.put(Integer.valueOf(sum), valuesCD);
                }

                valuesCD.add(c);
                valuesCD.add(d);
            }
        }

        for (int a = 0; a < A; ++a) {

            for (int b = 0; b < B; ++b) {

                ++operations;

                ArrayList valuesCD = (ArrayList)map.get(Integer.valueOf( (int)(Math.pow(a, 3) + Math.pow(b, 3)) ));

                if (valuesCD != null) {

                    for (int i = 0; i <= valuesCD.size() / 2; i += 2) {

                        System.out.println(String.format("a^3 + b^3 = c^3 + d^3 -> %d, %d, %d, %d", a, b, valuesCD.get(i), valuesCD.get(i + 1)));

                        ++combinations;
                    }
                }
            }
        }

        System.out.println(String.format("A number of iterations to find all combinations: %d", combinations));
        System.out.println(String.format("A number of operations to find all combinations: %d", operations));
    }

    public static void main(String[] args) {

//        a3b3_eq_c3d3_brute_force();
//        a3b3_eq_c3d3_optimization1();
        a3b3_eq_c3d3_optimization2();
    }
}
