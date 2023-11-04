import java.util.Random;

public class MatrixMultiplication {
    public static void main(String[] args) {
        int[][] ma = generateRandomMatrix(1, 50, 1024);
        int[][] mb = generateRandomMatrix(1, 50, 1024);

        int[][] mcc = classicMultiplication(ma, mb);
        int[][] mcd = divideAndConquerMultiplication(ma, mb);
        int[][] mcs = strassenMultiplication(ma, mb);

        // Print matrices
        printMatrix("Original Matrix A (MA)  ", ma);
        printMatrix("Original Matrix B (MB  ", mb);
        // Print the result matrices after multiplication
        printMatrix("Matrix C (MCC) - Classic Multiplication Result ", mcc);
        printMatrix("Matrix D (MCD) - Divide and Conquer Multiplication Result ", mcd);
        printMatrix("Matrix S (MCS) - Strassen's Multiplication Result ", mcs);
        // Call the recordAndPrintRuntimes method to record and print runtimes
        recordAndPrintRuntimes(ma, mb);

    }

    // VECTOR OPERATIONS--------------------------------------------------------
    public static int vectorMultiplication(int[] vectorA, int[] vectorB) {
        int product = 0;
        for (int i = 0; i < vectorA.length; i++) {
            product += vectorA[i] * vectorB[i];
        }
        return product;
    }

    public static int[] vectorAddition(int[] vectorA, int[] vectorB) {
        int[] vectorC = new int[vectorA.length];
        for (int i = 0; i < vectorA.length; i++) {
            vectorC[i] = vectorA[i] + vectorB[i];
        }
        return vectorC;
    }

    public static int[] vectorNegation(int[] vector) {
        int[] negVector = new int[vector.length];
        for (int i = 0; i < vector.length; i++) {
            negVector[i] = -vector[i];
        }
        return negVector;
    }

    // MATRIX OPERATIONS--------------------------------------------------------
    public static int[][] matrixAddition(int[][] matrixA, int[][] matrixB) {
        int[][] matrixC = new int[matrixA.length][matrixA[0].length];
        for (int i = 0; i < matrixA.length; i++) {
            for (int j = 0; j < matrixA[0].length; j++) {
                matrixC[i][j] = matrixA[i][j] + matrixB[i][j];
            }
        }
        return matrixC;
    }

    public static int[][] matrixNegation(int[][] matrix) {
        int[][] negMatrix = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                negMatrix[i][j] = -matrix[i][j];
            }
        }
        return negMatrix;
    }

    // MATRIX HELPERS--------------------------------------------------------------
    public static int getWidth(int[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }
        return matrix[0].length;
    }

    public static boolean canMultiply(int[][] matrixA, int[][] matrixB) {
        return getWidth(matrixA) == matrixB.length;
    }

    public static int[][][] splitMatrix(int[][] matrix) {
        int matrixLen = matrix.length;
        int matrixWidth = getWidth(matrix);
        int rowMid = matrixLen / 2;
        int colMid = matrixWidth / 2;

        int[][] m11 = new int[rowMid][colMid];
        int[][] m12 = new int[rowMid][colMid];
        int[][] m21 = new int[rowMid][colMid];
        int[][] m22 = new int[rowMid][colMid];

        for (int i = 0; i < matrixLen; i++) {
            for (int j = 0; j < matrixWidth; j++) {
                if (i < rowMid) {
                    if (j < colMid) {
                        m11[i][j] = matrix[i][j];
                    } else {
                        m12[i][j - colMid] = matrix[i][j];
                    }
                } else {
                    if (j < colMid) {
                        m21[i - rowMid][j] = matrix[i][j];
                    } else {
                        m22[i - rowMid][j - colMid] = matrix[i][j];
                    }
                }
            }
        }
        return new int[][][] { m11, m12, m21, m22 };
    }

    public static int[][] combineMatrix(int[][] m11, int[][] m12, int[][] m21, int[][] m22) {
        int offset = m11.length;
        int numRows = offset + m21.length;
        int numCols = m11[0].length + m12[0].length;
        int[][] matrix = new int[numRows][numCols];

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                if (i < offset) {
                    matrix[i][j] = (j < m11[0].length) ? m11[i][j] : m12[i][j - m11[0].length];
                } else {
                    matrix[i][j] = (j < m11[0].length) ? m21[i - offset][j] : m22[i - offset][j - m11[0].length];
                }
            }
        }
        return matrix;
    }

    public static int[][] generateRandomMatrix(int minN, int maxN, int dim) {
        int[][] matrix = new int[dim][dim];
        Random random = new Random();
        for (int i = 0; i < dim; i++) {
            for (int j = 0; j < dim; j++) {
                matrix[i][j] = random.nextInt(maxN - minN + 1) + minN;
            }
        }
        return matrix;
    }

    public static int[][] initializeMatrix(int nRows, int nCols) {
        int[][] matrix = new int[nRows][nCols];
        return matrix;
    }

    public static void printMatrix(String label, int[][] matrix) {
        System.out.println(label);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(" " + matrix[i][j]);
            }
            System.out.println();
        }
    }
    // Record and print the runtime for matrices -----------------------------------------------
    public static void recordAndPrintRuntimes(int[][] matrixA, int[][] matrixB) {
        long startTime, endTime;

        // Record and print the runtime for classic multiplication
        startTime = System.nanoTime();
        int[][] mcc = classicMultiplication(matrixA, matrixB);
        endTime = System.nanoTime();
        long classicRuntime = endTime - startTime;
        System.out.println("Classic Multiplication Runtime: " + classicRuntime + " nanoseconds");

        // Record and print the runtime for divide and conquer multiplication
        startTime = System.nanoTime();
        int[][] mcd = divideAndConquerMultiplication(matrixA, matrixB);
        endTime = System.nanoTime();
        long divideAndConquerRuntime = endTime - startTime;
        System.out.println("Divide and Conquer Multiplication Runtime: " + divideAndConquerRuntime + " nanoseconds");

        // Record and print the runtime for Strassen's multiplication
        startTime = System.nanoTime();
        int[][] mcs = strassenMultiplication(matrixA, matrixB);
        endTime = System.nanoTime();
        long strassenRuntime = endTime - startTime;
        System.out.println("Strassen's Multiplication Runtime: " + strassenRuntime + " nanoseconds");
    }

    // MATRIX MULTIPLIERS-------------------------------------------------------------------
    public static int[][] classicMultiplication(int[][] matrixA, int[][] matrixB) {
        int matrixBWidth = matrixB[0].length;
        int[][] matrixC = initializeMatrix(matrixA.length, matrixBWidth);

        for (int i = 0; i < matrixA.length; i++) {
            for (int j = 0; j < matrixBWidth; j++) {
                int[] vectorA = matrixA[i];
                int[] vectorB = new int[matrixB.length];

                for (int n = 0; n < matrixB.length; n++) {
                    vectorB[n] = matrixB[n][j];
                }

                int dotProduct = vectorMultiplication(vectorA, vectorB);
                matrixC[i][j] = dotProduct;
            }
        }
        return matrixC;
    }

    public static int[][] divideAndConquerMultiplication(int[][] matrixA, int[][] matrixB) {
        if (matrixA.length == getWidth(matrixA) && matrixB.length == getWidth(matrixB) && matrixA.length <= 2) {
            return classicMultiplication(matrixA, matrixB);
        }

        int[][][] matrices = splitMatrix(matrixA);
        int[][] a11 = matrices[0];
        int[][] a12 = matrices[1];
        int[][] a21 = matrices[2];
        int[][] a22 = matrices[3];

        matrices = splitMatrix(matrixB);
        int[][] b11 = matrices[0];
        int[][] b12 = matrices[1];
        int[][] b21 = matrices[2];
        int[][] b22 = matrices[3];

        int[][] c11 = matrixAddition(
                divideAndConquerMultiplication(a11, b11),
                divideAndConquerMultiplication(a12, b21)
        );
        int[][] c12 = matrixAddition(
                divideAndConquerMultiplication(a11, b12),
                divideAndConquerMultiplication(a12, b22)
        );
        int[][] c21 = matrixAddition(
                divideAndConquerMultiplication(a21, b11),
                divideAndConquerMultiplication(a22, b21)
        );
        int[][] c22 = matrixAddition(
                divideAndConquerMultiplication(a21, b12),
                divideAndConquerMultiplication(a22, b22)
        );

        return combineMatrix(c11, c12, c21, c22);
    }

    public static int[][] strassenMultiplication(int[][] matrixA, int[][] matrixB) {
        if (matrixA.length == getWidth(matrixA) && matrixB.length == getWidth(matrixB) && matrixA.length == 1) {
            int[][] result = new int[1][1];
            result[0][0] = matrixA[0][0] * matrixB[0][0];
            return result;
        }

        if (matrixA.length == getWidth(matrixA) && matrixB.length == getWidth(matrixB) && matrixA.length == 2) {
            return classicMultiplication(matrixA, matrixB);
        }

        int[][][] matrices = splitMatrix(matrixA);
        int[][] a11 = matrices[0];
        int[][] a12 = matrices[1];
        int[][] a21 = matrices[2];
        int[][] a22 = matrices[3];

        matrices = splitMatrix(matrixB);
        int[][] b11 = matrices[0];
        int[][] b12 = matrices[1];
        int[][] b21 = matrices[2];
        int[][] b22 = matrices[3];

        int[][] p = strassenMultiplication(
                matrixAddition(a11, a22),
                matrixAddition(b11, b22)
        );
        int[][] q = strassenMultiplication(
                matrixAddition(a21, a22),
                b11
        );
        int[][] r = strassenMultiplication(
                a11,
                matrixAddition(b12, matrixNegation(b22))
        );
        int[][] s = strassenMultiplication(
                a22,
                matrixAddition(b21, matrixNegation(b11))
        );
        int[][] t = strassenMultiplication(
                matrixAddition(a11, a12),
                b22
        );
        int[][] u = strassenMultiplication(
                matrixAddition(a21, matrixNegation(a11)),
                matrixAddition(b11, b12)
        );
        int[][] v = strassenMultiplication(
                matrixAddition(a12, matrixNegation(a22)),
                matrixAddition(b21, b22)
        );

        int[][] c11 = matrixAddition(
                matrixAddition(
                        matrixAddition(p, s),
                        matrixNegation(t)
                ),
                v
        );
        int[][] c12 = matrixAddition(r, t);
        int[][] c21 = matrixAddition(q, s);
        int[][] c22 = matrixAddition(
                matrixAddition(
                        matrixAddition(p, r),
                        matrixNegation(q)
                ),
                u
        );

        return combineMatrix(c11, c12, c21, c22);
    }


}

