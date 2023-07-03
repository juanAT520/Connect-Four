
package github.ConnectFour.Various;

import static github.ConnectFour.ConnectFour.getRemainingSlots;
import static github.ConnectFour.ConnectFour.getTable;
import static github.ConnectFour.ConnectFour.setRemainingSlots;
import static github.ConnectFour.ConnectFour.setTable;

public class SetSlot {
    // Places the player's disc in the selected column.
    public static void placeDisc(int turn, int selection) {
        char[][] tableCopy = getTable();
        int[] remaining = getRemainingSlots();
        if (turn % 2 == 0) {
            tableCopy[remaining[selection - 1]][selection - 1] = 'R';
            remaining[selection - 1] -= 1;
        } else {
            tableCopy[remaining[selection - 1]][selection - 1] = 'b';
            remaining[selection - 1] -= 1;
        }
        setTable(tableCopy);
        setRemainingSlots(remaining);
    }
}
