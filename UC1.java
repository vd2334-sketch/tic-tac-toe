import java.util.Random;
import java.util.Scanner;

public class TicTacToe
{
    // Function to display the board
    static void displayBoard(char[][] board)
    {
        System.out.println();

        for(int i = 0; i < 3; i++)
        {
            for(int j = 0; j < 3; j++)
            {
                System.out.print(" " + board[i][j]);

                if(j < 2)
                    System.out.print(" |");
            }

            System.out.println();

            if(i < 2)
                System.out.println("---|---|---");
        }

        System.out.println();
    }

    // Function to check winner
    static boolean checkWinner(char[][] board, char player)
    {
        // Rows
        for(int i = 0; i < 3; i++)
        {
            if(board[i][0] == player &&
               board[i][1] == player &&
               board[i][2] == player)
                return true;
        }

        // Columns
        for(int i = 0; i < 3; i++)
        {
            if(board[0][i] == player &&
               board[1][i] == player &&
               board[2][i] == player)
                return true;
        }

        // Diagonals
        if(board[0][0] == player &&
           board[1][1] == player &&
           board[2][2] == player)
            return true;

        if(board[0][2] == player &&
           board[1][1] == player &&
           board[2][0] == player)
            return true;

        return false;
    }

    // Function to check draw
    static boolean checkDraw(char[][] board)
    {
        for(int i = 0; i < 3; i++)
        {
            for(int j = 0; j < 3; j++)
            {
                if(board[i][j] != 'X' && board[i][j] != 'O')
                    return false;
            }
        }

        return true;
    }

    // Function for player move
    static void playerMove(char[][] board, Scanner sc)
    {
        int row, col;

        while(true)
        {
            System.out.print("Enter row (1-3): ");
            row = sc.nextInt();

            System.out.print("Enter column (1-3): ");
            col = sc.nextInt();

            row--;
            col--;

            if(row >= 0 && row < 3 &&
               col >= 0 && col < 3 &&
               board[row][col] != 'X' &&
               board[row][col] != 'O')
            {
                board[row][col] = 'X';
                break;
            }
            else
            {
                System.out.println("Invalid move! Try again.");
            }
        }
    }

    // Function for computer move
    static void computerMove(char[][] board)
    {
        Random random = new Random();

        int row, col;

        while(true)
        {
            row = random.nextInt(3);
            col = random.nextInt(3);

            if(board[row][col] != 'X' &&
               board[row][col] != 'O')
            {
                board[row][col] = 'O';
                break;
            }
        }

        System.out.println("Computer placed O at position: "
                           + (row + 1) + "," + (col + 1));
    }

    // Main function
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        char[][] board =
        {
            {'1', '2', '3'},
            {'4', '5', '6'},
            {'7', '8', '9'}
        };

        System.out.println("===== TIC TAC TOE =====");
        System.out.println("Player = X");
        System.out.println("Computer = O");

        while(true)
        {
            displayBoard(board);

            // Player turn
            playerMove(board, sc);

            if(checkWinner(board, 'X'))
            {
                displayBoard(board);
                System.out.println("Congratulations! You win!");
                break;
            }

            if(checkDraw(board))
            {
                displayBoard(board);
                System.out.println("Game Draw!");
                break;
            }

            // Computer turn
            computerMove(board);

            if(checkWinner(board, 'O'))
            {
                displayBoard(board);
                System.out.println("Computer wins!");
                break;
            }

            if(checkDraw(board))
            {
                displayBoard(board);
                System.out.println("Game Draw!");
                break;
            }
        }

        sc.close();
    }
}
