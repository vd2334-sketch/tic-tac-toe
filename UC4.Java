public class TicTacToe {

    public static void main(String[] args) {

        int slot = 5; // example

        int row = getRowFromSlot(slot);
        int col = getColFromSlot(slot);

        System.out.println("Row: " + row);
        System.out.println("Column: " + col);
    }

    // Get row index
    static int getRowFromSlot(int slot) {
        return (slot - 1) / 3;
    }

    // Get column index
    static int getColFromSlot(int slot) {
        return (slot - 1) % 3;
    }
}
