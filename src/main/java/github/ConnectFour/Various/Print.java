

package github.ConnectFour.Various;


public class Print {
    // Prints the game matrix.
    public static void printTable(char[][] matrix) {
        for (int f = 0; f < 6; f++) {
            System.out.print("|");
            for (int c = 0; c < 7; c++) {
                System.out.printf("%2c |", matrix[f][c]);
                if (c == 6) {
                    System.out.println("");
                }
            }
        }
        System.out.println("");
    }
}
