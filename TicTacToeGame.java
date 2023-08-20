import java.util.Scanner;
public class TicTacToeGame {
    private static char[][] board = new char[3][3];
    private static char currentPlayer = 'X';

    public static void main(String[] args) {
        initializeBoard();
        displayBoard();

        while (!isGameOver()) {
            playTurn();
            displayBoard();
            switchPlayer();
        }

        char winner = checkWinner();
        if (winner == 'X') {
            System.out.println("Player X wins!");
        } else if (winner == 'O') {
            System.out.println("Player O wins!");
        } else {
            System.out.println("It's a draw!");
        }
    }

    private static void initializeBoard() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                board[row][col] = '-';
            }
        }
    }

    private static void displayBoard() {
        System.out.println("Current board:");
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                System.out.print(board[row][col] + " ");
            }
            System.out.println();
        }
    }

    private static void playTurn() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Player " + currentPlayer + ", enter row (0-2): ");
        int row = scanner.nextInt();
        System.out.println("Player " + currentPlayer + ", enter column (0-2): ");
        int col = scanner.nextInt();

        if (row < 0 || row > 2 || col < 0 || col > 2 || board[row][col] != '-') {
            System.out.println("Invalid move. Try again.");
            playTurn();
        } else {
            board[row][col] = currentPlayer;
        }
    }

    private static void switchPlayer() {
        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
    }

    private static boolean isGameOver() {
        return checkWinner() != '-' || isBoardFull();
    }

    private static boolean isBoardFull() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (board[row][col] == '-') {
                    return false;
                }
            }
        }
        return true;
    }

    private static char checkWinner() {
        // Check rows, columns, and diagonals for a win
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == board[i][1] && board[i][1] == board[i][2] && board[i][0] != '-') {
                return board[i][0];
            }
            if (board[0][i] == board[1][i] && board[1][i] == board[2][i] && board[0][i] != '-') {
                return board[0][i];
            }
        }
        if (board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] != '-') {
            return board[0][0];
        }
        if (board[0][2] == board[1][1] && board[1][1] == board[2][0] && board[0][2] != '-') {
            return board[0][2];
        }
        return '-';
    }
}
