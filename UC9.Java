// UC9: Check Winning Condition
// Goal: Detect if a player has won the game.

#include <iostream>
using namespace std;

// Function to display board
void displayBoard(char board[3][3])
{
    cout << "\nBoard:\n";

    for (int i = 0; i < 3; i++)
    {
        for (int j = 0; j < 3; j++)
        {
            cout << board[i][j];

            if (j < 2)
                cout << " | ";
        }

        cout << endl;

        if (i < 2)
            cout << "--|---|--\n";
    }
}

// Function to check winning condition
bool checkWinner(char board[3][3], char symbol)
{
    // Check rows
    for (int i = 0; i < 3; i++)
    {
        if (board[i][0] == symbol &&
            board[i][1] == symbol &&
            board[i][2] == symbol)
            return true;
    }

    // Check columns
    for (int j = 0; j < 3; j++)
    {
        if (board[0][j] == symbol &&
            board[1][j] == symbol &&
            board[2][j] == symbol)
            return true;
    }

    // Check main diagonal
    if (board[0][0] == symbol &&
        board[1][1] == symbol &&
        board[2][2] == symbol)
        return true;

    // Check opposite diagonal
    if (board[0][2] == symbol &&
        board[1][1] == symbol &&
        board[2][0] == symbol)
        return true;

    return false;
}

int main()
{
    char board[3][3] =
    {
        {'X', 'X', 'X'},
        {'O', ' ', 'O'},
        {' ', ' ', ' '}
    };

    char player = 'X';

    displayBoard(board);

    if (checkWinner(board, player))
        cout << "\nPlayer " << player << " Wins!\n";
    else
        cout << "\nNo Winner Yet.\n";

    return 0;
}
