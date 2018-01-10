package Exercises.Numbers;

import java.util.ArrayList;
import java.util.HashMap;

public class Numbers {

    /**
     * Find all combinations a, b, c, d that match to the a^3 + b^3 = c^3 + d^3
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

        for (int a = 1; a <= A; ++a) {

            for (int b = 1; b <= B; ++b) {

                for (int c = 1; c <= C; ++c) {

                    for (int d = 1; d <= D; ++d) {

                        ++operations;

                        if ((Math.pow(a, 3) + Math.pow(b, 3)) == (Math.pow(c, 3) + Math.pow(d, 3))) {

                            System.out.println(String.format("a^3 + b^3 = c^3 + d^3 -> %d %d %d %d", a, b, c, d));

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
     * Find all combinations a, b, c, d that match to the a^3 + b^3 = c^3 + d^3
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

        for (int a = 1; a <= A; ++a) {

            for (int b = 1; b <= B; ++b) {

                for (int c = 1; c <= C; ++c) {

                    ++operations;

                    int d = (int) Math.pow(Math.pow(a, 3) + Math.pow(b, 3) - Math.pow(c, 3), 1.0f / 3.0f);
                    if (((Math.pow(a, 3) + Math.pow(b, 3)) == (Math.pow(c, 3) + Math.pow(d, 3))) && (d <= 100)){

                        System.out.println(String.format("a^3 + b^3 = c^3 + d^3 -> %d %d %d %d", a, b, c, d));

                        ++combinations;
                    }
                }
            }
        }

        System.out.println(String.format("A number of iterations to find all combinations: %d", combinations));
        System.out.println(String.format("A number of operations to find all combinations: %d", operations));
    }

    /**
     * Find all combinations a, b, c, d that match to the a^3 + b^3 = c^3 + d^3
     *
     * Put c^3 + d^3 values to HashMap and then compare
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

        for (int c = 1; c <= C; ++c) {

            for (int d = 1; d <= D; ++d) {

                int sum = (int) (Math.pow(c, 3) + Math.pow(d, 3));
                ArrayList valuesCD = (ArrayList) map.get(Integer.valueOf(sum));

                if (valuesCD == null) {

                    valuesCD = new ArrayList();
                    map.put(Integer.valueOf(sum), valuesCD);
                }

                ++operations;

                valuesCD.add(new Pair<Integer>(c, d));
            }
        }

        for (int a = 1; a <= A; ++a) {

            for (int b = 1; b <= B; ++b) {

                ArrayList valuesCD = (ArrayList)map.get(Integer.valueOf( (int)(Math.pow(a, 3) + Math.pow(b, 3)) ));

                if (valuesCD != null) {

                    for (int i = 0; i < valuesCD.size(); ++i) {

                        System.out.println(String.format("a^3 + b^3 = c^3 + d^3 -> %d %d %d %d",
                                a,
                                b,
                                ((Pair)valuesCD.get(i)).getLeft(),
                                ((Pair)valuesCD.get(i)).getRight()));

                        ++operations;
                        ++combinations;
                    }
                }
            }
        }

        System.out.println(String.format("A number of iterations to find all combinations: %d", combinations));
        System.out.println(String.format("A number of operations to find all combinations: %d", operations));
    }

    /**
     * Find all combinations a, b, c, d that match to the a^3 + b^3 = c^3 + d^3
     *
     * Put c^3 + d^3 values to HashMap and then go through the keys and compare combinations on values
     */
    public static void a3b3_eq_c3d3_optimization3() {

        int A = 100, B = 100, C = 100, D = 100;
        /**
         * A number of combinations
         */
        int combinations = 0;

        /**
         * A number of operations;
         */
        int operations = 0;

        HashMap<Integer, ArrayList>map = new HashMap(C * D);

        /**
         * Calculate the sum for the C and D combinations
         */
        for (int c = 1; c <= C; ++c) {

            for (int d = 1; d <= D; ++d) {

                int sum = (int) (Math.pow(c, 3) + Math.pow(d, 3));
                ArrayList valuesCD = map.get(Integer.valueOf(sum));

                if (valuesCD == null) {

                    valuesCD = new ArrayList();
                    map.put(Integer.valueOf(sum), valuesCD);
                }

                ++operations;

                valuesCD.add(new Pair(c, d));
            }
        }

        for (Integer key : map.keySet()) {

            ArrayList<Pair> pairs = map.get(key);

            for (int i = 0; i < pairs.size(); ++i) {

                for (int j = 0; j < pairs.size(); ++j) {

                    System.out.println(String.format("a^3 + b^3 = c^3 + d^3 -> %d %d %d %d",
                            pairs.get(i).getLeft(),
                            pairs.get(i).getRight(),
                            pairs.get(j).getLeft(),
                            pairs.get(j).getRight()));

                    ++operations;
                    ++combinations;
                }
            }
        }

        System.out.println(String.format("A number of iterations to find all combinations: %d", combinations));
        System.out.println(String.format("A number of operations to find all combinations: %d", operations));
    }

    /**
     * Rotates square matrix
     * @param matrix to rotate
     * @return Rotated matrix
     */
    public static int[][] rotateMatrix(int[][] matrix) {

        assert (matrix.length > 0);
        assert (matrix.length == matrix[0].length);

        for (int k = 0; k < matrix.length / 2; ++k) {

            int top = k;
            int left = k;
            int size = matrix.length - (matrix.length * k / 2) - 1;

            for (int i = 0; i < size; ++i) {

                int temp = matrix[top][size - i];
                matrix[top][size - i] = matrix[i + k][left + k];
                matrix[i + k][left + k] = matrix[size + k][i + k];
                matrix[size + k][i + k] = matrix[size - i][size];
                matrix[size - i][size] = temp;
            }
        }

        return matrix;
    }

    public static void main(String[] args) {

//        a3b3_eq_c3d3_brute_force();
//        a3b3_eq_c3d3_optimization1();
//        a3b3_eq_c3d3_optimization2();
        a3b3_eq_c3d3_optimization3();

        int[][] matrix = {
                {11, 12, 13, 14},
                {21, 22, 23, 24},
                {31, 32, 33, 34},
                {41, 42, 43, 44}};

        matrix = rotateMatrix(matrix);

        for (int i = 0; i < matrix.length; ++i) {

            for (int j = 0; j < matrix.length; ++j) {

                System.out.print(String.format("%d ", matrix[i][j]));
            }

            System.out.println("");
        }
    }
}
