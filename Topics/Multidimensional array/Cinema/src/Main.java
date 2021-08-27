import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] cinema = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                cinema[i][j] = scanner.nextInt();
            }
        }
        int k = scanner.nextInt();

        System.out.println(yourRow(cinema, k));
    }

    public static int yourRow(int[][] array, int necessarySeats) {
        int emptySeatsInARow;
        for (int i = 0; i < array.length; i++) {
            emptySeatsInARow = 0;
            for (int j = 0; j < array[0].length; j++) {
                if (array[i][j] == 0) {
                    emptySeatsInARow++;
                } else {
                    emptySeatsInARow = 0;
                }
                if (emptySeatsInARow == necessarySeats) {
                    return i + 1;
                }
            }
        }
        return 0;
    }
}