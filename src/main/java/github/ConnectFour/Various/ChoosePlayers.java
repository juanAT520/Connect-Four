
package github.ConnectFour.Various;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ChoosePlayers {
    // Asks the user to choose the number of players. (1 or 2)
    public static void nPlayers(Scanner sc) {
        while (true) {
            try {
                System.out.print("Choose between 1 or 2 players: ");
                if (sc.hasNextInt()) {
                    int players = sc.nextInt();
                    if (players < 1 || players > 2) {
                        throw new NumberFormatException(" [i] Only 1 or 2 players are accepted.");
                    }
                    github.ConnectFour.ConnectFour.setPlayers(players);
                    break;
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
