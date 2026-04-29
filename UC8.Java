// UC8: Continuous Turn-Based Game Loop
// Goal: Continue gameplay until win or draw is detected.

#include <iostream>
using namespace std;

// Display board
void displayBoard(char board[3][3])
{
    cout << "\n";
    for (int i = 0; i < 3; i++)
    {
        for (int j = 0; j < 3; j++)
        {
            cout << board[i][j];
            if (j < 2) cout << " | ";
        }
        cout << endl;
        if (i < 2) cout << "--|---|--\n";
    }
}

// Check winner
bool checkWin(char board[3][3], char symbol)
{
    for (int i = 0; i < 3; i++)
    {
        if (board[i][0] == symbol &&
            board[i][1] == symbol &&
            board[i][2] == symbol)
            return true;

        if (board[0][i] == symbol &&
            board[1][i] == symbol &&
            board[2][i] == symbol)
            return true;
    }

    if (board[0][0] == symbol &&
        board[1][1] == symbol &&
        board[2][2] == symbol)
        return true;

    if (board[0][2] == symbol &&
        board[1][1] == symbol &&
        board[2][0] == symbol)
        return true;

    return false;
}

// Check draw
bool checkDraw(char board[3][3])
{
    for (int i = 0; i < 3; i++)
    {
        for (int j = 0; j < 3; j++)
        {
            if (board[i][j] == ' ')
                return false;
        }
    }
    return true;
}

int main()
{
    char board[3][3] =
    {
        {' ', ' ', ' '},
        {' ', ' ', ' '},
        {' ', ' ', ' '}
    };

    char currentPlayer = 'X';
    bool gameOver = false;
    int row, col;

    while (!gameOver)
    {
        displayBoard(board);

        cout << "\nPlayer " << currentPlayer << " Turn\n";
        cout << "Enter row (0-2): ";
        cin >> row;
        cout << "Enter column (0-2): ";
        cin >> col;

        // Check valid move
        if (row >= 0 && row < 3 &&
            col >= 0 && col < 3 &&
            board[row][col] == ' ')
        {
            board[row][col] = currentPlayer;

            // Check win
            if (checkWin(board, currentPlayer))
            {
                displayBoard(board);
                cout << "\nPlayer " << currentPlayer << " Wins!\n";
                gameOver = true;
            }
            // Check draw
            else if (checkDraw(board))
            {
                displayBoard(board);
                cout << "\nGame Draw!\n";
                gameOver = true;
            }
            else
            {
                // Switch turn
                currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
            }
        }
        else
        {
            cout << "\nInvalid Move! Try Again.\n";
        }
    }

    return 0;
}
