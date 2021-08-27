package processor;

import javax.annotation.processing.SupportedSourceVersion;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m1 = scanner.nextInt();
        int n1 = scanner.nextInt();
        int[][] matrix1 = new int[m1][n1];
        for (int i = 0; i < m1; i++) {
            for (int j = 0; j < n1; j++) {
                matrix1[i][j] = scanner.nextInt();
            }
        }

        int m2 = scanner.nextInt();
        int n2 = scanner.nextInt();
        int[][] matrix2 = new int[m2][n2];
        for (int i = 0; i < m2; i++) {
            for (int j = 0; j < n2; j++) {
                matrix2[i][j] = scanner.nextInt();
            }
        }

        try {
            int[][] sum = add(matrix1, matrix2);
            for (int i = 0; i < m1; i++) {
                for (int j = 0; j < n1; j++) {
                    System.out.printf("%d ", sum[i][j]);
                }
                System.out.println();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static int[][] add(int[][] m1, int[][] m2) throws Exception {
        if (m1.length != m2.length || m1[0].length != m2[0].length) {
            throw new Exception("ERROR");
        }

        int[][] result = new int[m1.length][m1[0].length];
        for (int i = 0; i < m1.length; i++) {
            for (int j = 0; j < m1[0].length; j++) {
                result[i][j] = m1[i][j] + m2[i][j];
            }
        }

        return result;
    }
}
