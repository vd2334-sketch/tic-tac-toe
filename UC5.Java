// UC5: Validate User Move
// Goal: Ensure the move is within bounds and the cell is empty.

#include <iostream>
using namespace std;

// Function to validate move
bool validateUserMove(char board[3][3], int row, int col)
{
    // Boundary checking
    if (row < 0 || row > 2 || col < 0 || col > 2)
    {
        cout << "Invalid Move: Row and Column must be between 0 and 2.\n";
        return false;
    }

    // Check if cell is empty
    if (board[row][col] != ' ')
    {
        cout << "Invalid Move: Cell already occupied.\n";
        return false;
    }

    // Move accepted
    return true;
}

int main()
{
    char board[3][3] =
    {
        {'X', ' ', 'O'},
        {' ', 'X', ' '},
        {'O', ' ', ' '}
    };

    int row, col;

    cout << "Enter row (0-2): ";
    cin >> row;

    cout << "Enter column (0-2): ";
    cin >> col;

    if (validateUserMove(board, row, col))
    {
        cout << "Move Accepted.\n";
    }
    else
    {
        cout << "Move Rejected.\n";
    }

    return 0;
}
