import org.testng.annotations.Test;

import static org.junit.Assert.assertArrayEquals;

public class matrixMultiplicationTestStrassen {

    @Test
    public void testCase1() {
        int[][] matrixA = {{1}};
        int[][] matrixB = {{1}};
        int[][] expected = {{1}};
        int[][] result = MatrixMultiplication.strassenMultiplication(matrixA, matrixB);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testCase2() {
        int[][] matrixA = {{5}};
        int[][] matrixB = {{9}};
        int[][] expected = {{45}};
        int[][] result = MatrixMultiplication.strassenMultiplication(matrixA, matrixB);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testCase3() {
        int[][] matrixA = {{-2}};
        int[][] matrixB = {{3}};
        int[][] expected = {{-6}};
        int[][] result = MatrixMultiplication.strassenMultiplication(matrixA, matrixB);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testCase4() {
        int[][] matrixA = {
                {1, 2},
                {3, 4}
        };
        int[][] matrixB = {
                {5, 6},
                {7, 8}
        };
        int[][] expected = {
                {19, 22},
                {43, 50}
        };
        int[][] result = MatrixMultiplication.strassenMultiplication(matrixA, matrixB);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testCase5() {
        int[][] matrixA = {
                {99, 99},
                {99, 99}
        };
        int[][] matrixB = {
                {99, 99},
                {99, 99}
        };
        int[][] expected = {
                {19_602, 19_602},
                {19_602, 19_602}
        };
        int[][] result = MatrixMultiplication.strassenMultiplication(matrixA, matrixB);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testCase6() {
        int[][] matrixA = {
                {3, 0, 3, 1},
                {5, 3, 1, 0},
                {3, 0, 3, 1},
                {1, 2, 2, 5}
        };
        int[][] matrixB = {
                {2, 4, 5, 2},
                {1, 3, 2, 1},
                {3, 0, 5, 0},
                {0, 4, 1, 4}
        };
        int[][] expected = {
                {15, 16, 31, 10},
                {16, 29, 36, 13},
                {15, 16, 31, 10},
                {10, 30, 24, 24}
        };
        int[][] result = MatrixMultiplication.strassenMultiplication(matrixA, matrixB);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testCase7() {
        int[][] matrixA = {
                {-165, -45, 454, 525},
                {454, 56, 659, 56},
                {2_649, 26, -88, 26},
                {1_659, -5, 0, 0}
        };
        int[][] matrixB = {
                {0, 0, 1, 20},
                {161, 1_674, 88, 59},
                {-65, 12, 123, 454},
                {98, -96, 12, 45}
        };
        int[][] expected = {
                {14_695, -120_282, 58_017, 223_786},
                {-28_331, 96_276, 87_111, 314_090},
                {12_454, 39_972, -5_575, 15_732},
                {-805, -8_370, 1_219, 32_885}
        };
        int[][] result = MatrixMultiplication.strassenMultiplication(matrixA, matrixB);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testCase8() {
        int[][] matrixA = {
                {1, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 1, 0},
                {0, 0, 0, 0, 0, 0, 0, 1}
        };
        int[][] matrixB = {
                {1, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 1, 0},
                {0, 0, 0, 0, 0, 0, 0, 1}
        };
        int[][] expected = {
                {1, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 1, 0},
                {0, 0, 0, 0, 0, 0, 0, 1}
        };
        int[][] result = MatrixMultiplication.strassenMultiplication(matrixA, matrixB);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testCase9() {
        int[][] matrixA = {
                {-165, -45, 454, 525, -165, -45, 454, 525},
                {454, 56, 659, 56, 454, 56, 659, 56},
                {2_649, 26, -88, 26, 2_649, 26, -88, 26},
                {1_659, -5, 0, 0, 1_659, -5, 0, 0},
                {-165, -45, 454, 525, -165, -45, 454, 525},
                {454, 56, 659, 56, 454, 56, 659, 56},
                {2_649, 26, -88, 26, 2_649, 26, -88, 26},
                {1_659, -5, 0, 0, 1_659, -5, 0, 0}
        };
        int[][] matrixB = {
                {1, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 1, 0},
                {0, 0, 0, 0, 0, 0, 0, 1}
        };
        int[][] expected = {
                {-165, -45, 454, 525, -165, -45, 454, 525},
                {454, 56, 659, 56, 454, 56, 659, 56},
                {2_649, 26, -88, 26, 2_649, 26, -88, 26},
                {1_659, -5, 0, 0, 1_659, -5, 0, 0},
                {-165, -45, 454, 525, -165, -45, 454, 525},
                {454, 56, 659, 56, 454, 56, 659, 56},
                {2_649, 26, -88, 26, 2_649, 26, -88, 26},
                {1_659, -5, 0, 0, 1_659, -5, 0, 0}
        };
        int[][] result = MatrixMultiplication.strassenMultiplication(matrixA, matrixB);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testCase10() {
        int[][] matrixA = {
                {5, 6},
                {7, 8}
        };
        int[][] matrixB = {
                {1, 2},
                {3, 4}
        };
        int[][] expected = {
                {23, 34},
                {31, 46}
        };
        int[][] result = MatrixMultiplication.strassenMultiplication(matrixA, matrixB);
        assertArrayEquals(expected, result);
    }
}
