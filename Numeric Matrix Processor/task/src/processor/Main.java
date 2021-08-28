package processor;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    final static Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

    public static void main(String[] args) {
        int currentCommand = 0;
        double[][] result;
        do {
            try {
                currentCommand = displayMenu();
                switch (currentCommand) {
                    case 1:
                        result = add();
                        displayResult(result);
                        break;
                    case 2:
                        result = multiplyByNumber();
                        displayResult(result);
                        break;
                    case 3:
                        result = multiplyMatrices();
                        displayResult(result);
                        break;
                    case 4:
                        displayResult(transpose());
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } while (currentCommand != 0);
    }

    public static int displayMenu() throws IllegalArgumentException {
        System.out.print("1. Add matrices\n" +
                "2. Multiply matrix by a constant\n" +
                "3. Multiply matrices\n" +
                "4. Transpose matrix\n" +
                "0. Exit\n");
        System.out.print("Your choice: ");
        int command = scanner.nextInt();
        if (command <0 || command > 4) {
            throw new IllegalArgumentException("Error: no such command");
        }
        return command;
    }

    public static double[][] add() throws IllegalArgumentException {
        System.out.print("Enter size of first matrix: ");
        int m1 = scanner.nextInt();
        int n1 = scanner.nextInt();
        double[][] matrix1 = new double[m1][n1];
        System.out.print("Enter first matrix:\n");
        for (int i = 0; i < m1; i++) {
            for (int j = 0; j < n1; j++) {
                matrix1[i][j] = scanner.nextDouble();
            }
        }

        System.out.print("Enter size of second matrix: ");
        int m2 = scanner.nextInt();
        int n2 = scanner.nextInt();
        double[][] matrix2 = new double[m2][n2];
        System.out.print("Enter second matrix:\n");
        for (int i = 0; i < m2; i++) {
            for (int j = 0; j < n2; j++) {
                matrix2[i][j] = scanner.nextDouble();
            }
        }

        if (matrix1.length != matrix2.length || matrix1[0].length != matrix2[0].length) {
            throw new IllegalArgumentException("Error: Wrong dimensions.");
        }

        double[][] result = new double[matrix1.length][matrix1[0].length];
        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix1[0].length; j++) {
                result[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }

        return result;
    }

    public static double[][] multiplyByNumber() {
        System.out.print("Enter size of matrix: ");
        int m1 = scanner.nextInt();
        int n1 = scanner.nextInt();
        double[][] matrix = new double[m1][n1];
        System.out.print("Enter matrix:\n");
        for (int i = 0; i < m1; i++) {
            for (int j = 0; j < n1; j++) {
                matrix[i][j] = scanner.nextDouble();
            }
        }
        System.out.print("Enter constant: ");
        double multiplier = scanner.nextDouble();

        double[][] result = new double[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                result[i][j] = matrix[i][j] * multiplier;
            }
        }

        return result;
    }

    public static double[][] multiplyMatrices() throws IllegalArgumentException {
        System.out.print("Enter size of first matrix: ");
        System.out.print("Enter size of first matrix: ");
        int m1 = scanner.nextInt();
        int n1 = scanner.nextInt();
        double[][] matrix1 = new double[m1][n1];
        System.out.print("Enter first matrix:\n");
        for (int i = 0; i < m1; i++) {
            for (int j = 0; j < n1; j++) {
                matrix1[i][j] = scanner.nextDouble();
            }
        }

        System.out.print("Enter size of second matrix: ");
        int m2 = scanner.nextInt();
        int n2 = scanner.nextInt();
        double[][] matrix2 = new double[m2][n2];
        System.out.print("Enter second matrix:\n");
        for (int i = 0; i < m2; i++) {
            for (int j = 0; j < n2; j++) {
                matrix2[i][j] = scanner.nextDouble();
            }
        }

        if (matrix1[0].length != matrix2.length) {
            throw new IllegalArgumentException("Error: wrong matrix sizes");
        }

        double[][] result = new double[matrix1.length][matrix2[0].length];
        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix2[0].length; j++) {
                result[i][j] = 0;
            }
        }

        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix2[0].length; j++) {
                for (int k = 0; k < matrix1[0].length; k++) {
                    result[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }

        return result;
    }

    public static double[][] transpose() {
        System.out.print("1. Main diagonal\n" +
                "2. Side diagonal\n" +
                "3. Vertical line\n" +
                "4. Horizontal line\n");
        System.out.print("Your choice: ");
        int command = scanner.nextInt();
        if (command < 0 || command > 4) {
            throw new IllegalArgumentException("Error: no such command");
        }

        System.out.print("Enter matrix size: ");
        int m = scanner.nextInt();
        int n= scanner.nextInt();

        double[][] matrix = new double[m][n];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = scanner.nextDouble();
            }
        }

        double[][] result = new double[0][];
        switch (command) {
            case 1:
                result = transposeByMainDiagonal(matrix);
                break;
            case 2:
                result = transposeBySideDiagonal(matrix);
                break;
            case 3:
                result = transposeByVerticalLine(matrix);
                break;
            case 4:
                result = transposeByHorizontalLine(matrix);
        }

        return result;
    }

    public static double[][] transposeByMainDiagonal(double[][] matrix) {
        double[][] result = new double[matrix[0].length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                result[i][j] = matrix[j][i];
            }
        }

        return result;
    }

    public static double[][] transposeBySideDiagonal(double[][] matrix) {
        double[][] result = new double[matrix[0].length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                result[i][j] = matrix[matrix.length - j - 1][matrix[i].length - i - 1];
            }
        }

        return result;
    }

    public static double[][] transposeByVerticalLine(double[][] matrix) {
        double temp;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length / 2; j++) {
                temp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix[0].length - j - 1];
                matrix[i][matrix[0].length - j - 1] = temp;
            }
        }

        return matrix;
    }

    public static double[][] transposeByHorizontalLine(double[][] matrix) {
        double temp;
        for (int i = 0; i < matrix.length / 2; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                temp = matrix[i][j];
                matrix[i][j] = matrix[matrix[0].length - i - 1][j];
                matrix[matrix[0].length - i - 1][j] = temp;
            }
        }

        return matrix;
    }

    public static void displayResult(double[][] matrix) {
        System.out.print("The result is:\n");
        for (double[] doubles : matrix) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.printf("%f ", doubles[j]);
            }
            System.out.println();
        }
    }
}
