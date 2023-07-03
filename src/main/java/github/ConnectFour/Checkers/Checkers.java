
package github.ConnectFour.Checkers;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Checkers {
    // Checks if the selected column is valid.
    public static boolean columns(int selection, int[] remainingSlots) {
        if (selection > 0 & selection < 8) {
            if (remainingSlots[selection - 1] >= 0) {
                return true;
            }
            System.out.println("This column is full.");
        } else {
            System.out.println("This number is out of range.");
            return false;
        }
        return false;
    }
    
    // Checks for a horizontal winning combination.
    public static boolean horizontal(char[][] matrix) {
        for (int row = 0; row < 6; row++) {
            for (int col = 0; col < 7 - 3; col++) {
                if (matrix[row][col] != ' ' &
                        (matrix[row][col] == matrix[row][col + 1] &
                        matrix[row][col] == matrix[row][col + 2] &
                        matrix[row][col] == matrix[row][col + 3])) {
                    github.ConnectFour.Various.Print.printTable(matrix);
                    winner(matrix, col, row);
                    return true;
                }
            }
        }
        return false;
    }
    
    // Checks for a vertical winning combination.
    public static boolean vertical(char[][] matrix) {
        for (int row = 0; row < 6 - 3; row++) {
            for (int col = 0; col < 7; col++) {
                if (matrix[row][col] != ' '
                        & (matrix[row][col] == matrix[row + 1][col]
                        & matrix[row][col] == matrix[row + 2][col]
                        & matrix[row][col] == matrix[row + 3][col])) {
                    github.ConnectFour.Various.Print.printTable(matrix);
                    winner(matrix, col, row);
                    return true;
                }
            }
        }
        return false;
    }
    
    // Checks for a diagonal winning combination.  (left to right)
    public static boolean diagonal1(char[][] matrix) {
        for (int row = 0; row < 6 - 3; row++) {
            for (int col = 0; col < 7 - 3; col++) {
                if (matrix[row][col] != ' '
                        & (matrix[row][col] == matrix[row + 1][col + 1]
                        & matrix[row][col] == matrix[row + 2][col + 2]
                        & matrix[row][col] == matrix[row + 3][col + 3])) {
                    github.ConnectFour.Various.Print.printTable(matrix);
                    winner(matrix, col, row);
                    return true;
                }
            }
        }
        return false;
    }
    
    // Checks for a diagonal winning combination. (right to left)
    public static boolean diagonal2(char[][] matrix) {
        for (int row = 0; row < 6 - 3; row++) {
            for (int col = 3; col < 7; col++) {
                if (matrix[row][col] != ' '
                        & (matrix[row][col] == matrix[row + 1][col - 1]
                        & matrix[row][col] == matrix[row + 2][col - 2]
                        & matrix[row][col] == matrix[row + 3][col - 3])) {
                    github.ConnectFour.Various.Print.printTable(matrix);
                    winner(matrix, col, row);
                    return true;
                }
            }
        }
        return false;
    }
    
    // Prints the winner message based on the player's color.
    public static void winner(char[][] matrix, int col, int row) {
        if (matrix[row][col] == 'R') { System.out.println("Red player wins!!!");
        } else { System.out.println("Blue player wins!!!"); }
    }
    
    // Checks if the game should continue.
    public static boolean checkContinue(char[][] matriz) {
        if (horizontal(matriz) ||
                vertical(matriz) ||
                diagonal1(matriz) ||
                diagonal2(matriz)) {
            return true;
        } 
        return false; 
    }
    
    // Handles the selection of a column by the player.
    public static int selection(Scanner sc, int selection, int turn) {
        while (true) {
            try {
                if (turn % 2 == 0) { System.out.print(" [Player 1] Place a red disc indicating a column between 1 and 7: "); 
                } else { System.out.print(" [Player 2] Place a blue disc indicating a column between 1 and 7: "); }
                if (sc.hasNextInt()) {
                    selection = sc.nextInt();
                    if (!(selection > 0 && selection < 8)) {
                        throw new NumberFormatException(" [i] You can only play in columns 1 to 7.");
                    }
                    return selection;
                } else {
                    throw new InputMismatchException(" [i] You must introduce only numbers.");
                }
            } catch (InputMismatchException ex) {
                System.out.println(ex.getMessage());
                sc.nextLine();
            } catch (NumberFormatException ex) {
                System.out.println(ex.getMessage());
                sc.nextLine();
            }
        }
    }
}
