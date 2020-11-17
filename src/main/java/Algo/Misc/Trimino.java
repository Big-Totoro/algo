package Algo.Misc;

public class Trimino {
    public void triminos(String[][] array, int x, int y, int n, int p, int q) {
        if (n == 2) {
            if (y == q) {
                if (x == p) {
                    drawL1(array, x, y);
                } else {
                    drawL2(array, x, y);
                }
            } else {
                if (x == p) {
                    drawL3(array, x, y);
                } else {
                    drawL4(array, x, y);
                }
            }
        } else {
            int mid_x = x + n / 2;
            int mid_y = y + n / 2;

            if (q < mid_y) {
                if (p < mid_x) {
                    drawL1(array, mid_x - 1, mid_y - 1);
                    triminos(array, x, y, n / 2, p, q);
                    triminos(array, x, mid_y, n / 2, mid_x - 1, mid_y);
                    triminos(array, mid_x, y, n / 2, mid_x, mid_y - 1);
                    triminos(array, mid_x, mid_y, n / 2, mid_x, mid_y);
                } else {
                    drawL2(array, mid_x - 1, mid_y - 1);
                    triminos(array, x, y, n / 2, mid_x - 1, mid_y - 1);
                    triminos(array, x, mid_y, n / 2, mid_x - 1, mid_y);
                    triminos(array, mid_x, y, n / 2, p, q);
                    triminos(array, mid_x, mid_y, n / 2, mid_x, mid_y);
                }
            } else {
                if (p < mid_x) {
                    drawL3(array, mid_x - 1, mid_y - 1);
                    triminos(array, x, y, n / 2, mid_x - 1, mid_y - 1);
                    triminos(array, x, mid_y, n / 2, p, q);
                    triminos(array, mid_x, y, n / 2, mid_x, mid_y - 1);
                    triminos(array, mid_x, mid_y, n / 2, mid_x, mid_y);
                } else {
                    drawL4(array, mid_x - 1, mid_y - 1);
                    triminos(array, x, y, n / 2, mid_x - 1, mid_y - 1);
                    triminos(array, x, mid_y, n / 2, mid_x - 1, mid_y);
                    triminos(array, mid_x, y, n / 2, mid_x, mid_y - 1);
                    triminos(array, mid_x, mid_y, n / 2, p, q);
                }
            }
        }
    }

    private void drawL1(String[][] array, int x, int y) {
        array[x][y] = "\u2501";
        array[x + 1][y] = "\u2513";
        array[x][y + 1] = " ";
        array[x + 1][y + 1] = "\u2503";
    }

    private void drawL2(String[][] array, int x, int y) {
        array[x][y] = "\u250f";
        array[x + 1][y] = "\u250f";
        array[x][y + 1] = "\u2503";
        array[x + 1][y + 1] = " ";
    }

    private void drawL3(String[][] array, int x, int y) {
        array[x][y] = " ";
        array[x + 1][y] = "\u2503";
        array[x][y + 1] = "\u2501";
        array[x + 1][y + 1] = "\u251b";
    }

    private void drawL4(String[][] array, int x, int y) {
        array[x][y] = "\u2503";
        array[x + 1][y] = " ";
        array[x][y + 1] = "\u2517";
        array[x + 1][y + 1] = "\u2501";
    }
}
