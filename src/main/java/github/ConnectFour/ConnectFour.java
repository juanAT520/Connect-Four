
package github.ConnectFour;

import java.util.Scanner;
import static github.ConnectFour.Checkers.Checkers.checkContinue;
import static github.ConnectFour.Checkers.Checkers.selection;

public class ConnectFour {
    private static Scanner sc = new Scanner(System.in);
    private static char[][] table = matrix();
    private static int[] remainingSlots = {5, 5, 5, 5, 5, 5, 5};
    private static int turn = 0;
    private static int selection = 0;
    private static int nPlayers = 0;
    
    // Getter methods.
    public static char[][] getTable() { return table; }
    public static int[] getRemainingSlots() { return remainingSlots; }
    public static int getNumPlayers() { return nPlayers; }
    
    // Setter methods.
    public static void setTable(char[][] tableCopy) { table = tableCopy; }
    public static void setRemainingSlots(int[] remaining) { remainingSlots = remaining; }
    public static void setPlayers(int players) { nPlayers = players; }
    public static void setSelection(int userSelect) { selection = userSelect; }
    
    // Creates the initial game matrix.
    public static char[][] matrix() {
        char[][] matrix = new char[6][7];
        for (int row = 0; row < 6; row++) {
            for (int col = 0; col < 7; col++) {
                if (row == 0) { matrix[row][col] = (char) ((col + 49));
                } else { matrix[row][col] = ' '; }
            }
        }
        return matrix; 
    }
    
    // Generates a random move for the bot player.
    public static int botMove() {
        return ((int) (Math.random() * 7) + 1);
    }
    
    public static void main(String[] args) {
        github.ConnectFour.Various.ChoosePlayers.nPlayers(sc);
        while (!checkContinue(table)) {
            github.ConnectFour.Various.Print.printTable(table);
            do {
                if (nPlayers == 2 || (turn % 2 == 0 && nPlayers == 1)) {
                    setSelection(selection(sc, selection, turn));
                } else if (nPlayers == 1) {
                    selection = botMove();
                    System.out.println(" [Bot] Blue player places a disc in the column: " + selection);
                }
            } while (!github.ConnectFour.Checkers.Checkers.columns(selection, remainingSlots));
            github.ConnectFour.Various.SetSlot.placeDisc(turn, selection);
            turn += 1;
        }
    }
}
