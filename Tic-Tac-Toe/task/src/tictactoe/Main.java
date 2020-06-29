package tictactoe;

import java.util.Scanner;

enum GameState {
    PLAY, DRAW, XWIN, OWIN
}

public class Main {
    public static void main(String[] args) {
        int countOf_ = 9;
        GameState game = GameState.PLAY;
        boolean askNextTurn = true;
        char[][] matrix = new char[3][3];
        Scanner scanner = new Scanner(System.in);
        char nextTurn = 'X';

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                matrix[i][j] = ' ';
            }
       }

        printGameField(matrix);

        while (game == GameState.PLAY ) {
            while (askNextTurn) {
                System.out.print("Enter the coordinates: ");
                String[] coordinates = scanner.nextLine().split(" ");
                askNextTurn = makeNextTurn(matrix, coordinates, nextTurn);
            }
            countOf_--;

            game = checkGameState(matrix, countOf_);
            printGameField(matrix);

            if (nextTurn == 'X') {
                nextTurn = 'O';
            } else {
                nextTurn = 'X';
            }

            askNextTurn = true;
        }

        switch (game) {
            case XWIN:
                System.out.println("X wins");
                break;
            case OWIN:
                System.out.println("O wins");
                break;
            case DRAW:
                System.out.println("Draw");
                break;
        }
    }

    public static void printGameField(char[][] matrix) {
        System.out.println("---------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.print("|");
            System.out.println();
        }
        System.out.println("---------");
    }

    public static GameState checkGameState(char[][] matrix, int countOf_) {
        boolean isXWin = false;
        boolean isOWin = false;

        for (int i = 0; i < 3; i++) {
            if (matrix[i][0] == matrix[i][1] && matrix[i][0] == matrix[i][2]) {
                if (matrix[i][0] == 'X') {
                    isXWin = true;
                }
                if (matrix[i][0] == 'O') {
                    isOWin = true;
                }
            }
        }

        for (int j = 0; j < 3; j++) {
            if (matrix[0][j] == matrix[1][j] && matrix[0][j] == matrix[2][j]) {
                if (matrix[0][j] == 'X') {
                    isXWin = true;
                }
                if (matrix[0][j] == 'O') {
                    isOWin = true;
                }
            }
        }

        if (matrix[0][0] == matrix[1][1] && matrix[0][0] == matrix[2][2]) {
            if (matrix[0][0] == 'X') {
                isXWin = true;
            }
            if (matrix[0][0] == 'O') {
                isOWin = true;
            }
        }

        if (matrix[2][0] == matrix[1][1] && matrix[2][0] == matrix[0][2]) {
            if (matrix[2][0] == 'X') {
                isXWin = true;
            }
            if (matrix[2][0] == 'O') {
                isOWin = true;
            }
        }

        if (isXWin) {
            return GameState.XWIN;
        } else if (isOWin) {
            return GameState.OWIN;
        } else if (!isXWin && !isOWin && countOf_ == 0) {
            return GameState.DRAW;
        }
        return GameState.PLAY;
    }

    public static boolean makeNextTurn(char[][] matrix, String[] coordinates, char nextTurn) {
        int i = 0;
        int j = 0;

        try {
            int coordX = Integer.parseInt(coordinates[0]);
            int coordY = Integer.parseInt(coordinates[1]);

            switch (coordX) {
                case 1:
                    j = 0;
                    break;
                case 2:
                    j = 1;
                    break;
                case 3:
                    j = 2;
                    break;
                default:
                    System.out.println("Coordinates should be from 1 to 3!");
                    return true;
            }

            switch (coordY) {
                case 1:
                    i = 2;
                    break;
                case 2:
                    i = 1;
                    break;
                case 3:
                    i = 0;
                    break;
                default:
                    System.out.println("Coordinates should be from 1 to 3!");
                    return true;
            }

            if (matrix[i][j] != ' ') {
                System.out.println("This cell is occupied! Choose another one!");
                return true;
            }

            matrix[i][j] = nextTurn;
        } catch (NumberFormatException nfe) {
            System.out.println("You should enter numbers!");
            return true;
        } catch (IndexOutOfBoundsException iobe) {
            System.out.println("You should enter TWO numbers!");
        }
        return false;
    }
}