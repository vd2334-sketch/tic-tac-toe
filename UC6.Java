public class TicTacToe {

    static char[][] board = new char[3][3];

    public static void main(String[] args) {

        // Initialize board
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '-';
            }
        }

        // Place a sample move
        placeMove(0, 0, 'X');

        // Print result
        System.out.println(board[0][0]);
    }

    // Place symbol on board
    static void placeMove(int row, int col, char symbol) {
        board[row][col] = symbol;
    }
}
