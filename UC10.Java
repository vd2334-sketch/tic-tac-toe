// UC10: Detect Draw Condition
// Goal: Detect when no moves remain and no winner exists.

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

// Function to check draw condition
bool checkDraw(char board[3][3])
{
    for (int i = 0; i < 3; i++)
    {
        for (int j = 0; j < 3; j++)
        {
            // If empty cell found, game not draw
            if (board[i][j] == ' ')
                return false;
        }
    }

    // No empty cells found
    return true;
}

int main()
{
    char board[3][3] =
    {
        {'X', 'O', 'X'},
        {'X', 'O', 'O'},
        {'O', 'X', 'X'}
    };

    displayBoard(board);

    if (checkDraw(board))
        cout << "\nGame is Draw!\n";
    else
        cout << "\nMoves Still Available.\n";

    return 0;
}
