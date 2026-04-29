// UC7: Computer Makes a Random Move (Easy Level)
// Goal: Allow the computer to make a random valid move.

#include <iostream>
#include <cstdlib>
#include <ctime>
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

// Function to check valid move
bool isValidMove(char board[3][3], int row, int col)
{
    return (row >= 0 && row < 3 &&
            col >= 0 && col < 3 &&
            board[row][col] == ' ');
}

// Function for computer random move
void computerMove(char board[3][3], char symbol)
{
    int slot, row, col;

    do
    {
        slot = rand() % 9 + 1;   // Generate 1 to 9
        row = (slot - 1) / 3;
        col = (slot - 1) % 3;

    } while (!isValidMove(board, row, col));

    board[row][col] = symbol;

    cout << "\nComputer selected slot: " << slot << endl;
}

int main()
{
    char board[3][3] =
    {
        {'X', ' ', 'O'},
        {' ', ' ', ' '},
        {'O', 'X', ' '}
    };

    srand(time(0)); // Seed random number

    displayBoard(board);

    computerMove(board, 'O');

    cout << "\nBoard After Computer Move:\n";
    displayBoard(board);

    return 0;
}
