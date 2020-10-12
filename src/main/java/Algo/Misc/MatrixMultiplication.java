package Algo.Misc;

public class MatrixMultiplication {

    public int[][] multiply(int[][] A, int[][] B) {
        if (A.length != B[0].length) {
            return new int[][] {};
        }

        int n = A.length;
        int mid = n / 2;
        int[][] C = new int[n][n];

        if (n == 1) {
            C[0][0] = A[0][0] * B[0][0];

            return C;
        }

        int[][] A11 = new int[mid][mid];
        int[][] A12 = new int[mid][mid];
        int[][] A21 = new int[mid][mid];
        int[][] A22 = new int[mid][mid];

        int[][] B11 = new int[mid][mid];
        int[][] B12 = new int[mid][mid];
        int[][] B21 = new int[mid][mid];
        int[][] B22 = new int[mid][mid];

        split(A, A11, 0, 0);
        split(A, A12, 0, mid);
        split(A, A21, mid, 0);
        split(A, A22, mid, mid);

        split(B, B11, 0, 0);
        split(B, B12, 0, mid);
        split(B, B21, mid, 0);
        split(B, B22, mid, mid);

        // C11
        add(C, multiply(A11, B11), multiply(A12, B21));
        // C12
        add(C, multiply(A11, B12), multiply(A12, B22));
        // C21
        add(C, multiply(A21, B11), multiply(A22, B21));
        // C22
        add(C, multiply(A21, B12), multiply(A22, B22));

        return C;
    }

    private void split(int[][] A, int[][] C, int fromRow, int fromCol) {
        for (int row = 0; row < C.length; row++) {
            for (int col = 0; col < C.length; col++) {
                C[row][col] = A[fromRow + row][fromCol + col];
            }
        }
    }

    private void add(int[][] C, int[][] A, int[][] B) {

    }
}
