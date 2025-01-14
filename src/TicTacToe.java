

//Цель: Создать программу на выбранном вами языке программирования для игры в "Крестики-нолики" с использованием статического массива, циклов и условных операторов (if),методов и т.д.
//Игра должна быть оформлена в консоли с красивым выводом игрового поля.
//
//Требования и условия:
//
//        1. Человек против человека
//Создайте игровое поле в виде статического двумерного массива размером 3x3 , либо оспользовать одномерный массив на 9 элементов.
//Каждый ход игрока:
//Выводите текущее состояние игрового поля.
//Запрашивайте у пользователя координаты для хода (номер строки и столбца) (в одномерном массиве номер квадратика).
//Проверьте корректность хода:
//Если ячейка занята, запросите ввод заново.
//Если координаты вне игрового поля, запросите ввод заново.
//Определите условия победы:
//Проверка наличия трех одинаковых символов (X или O) по строкам, столбцам или диагоналям.
//Если никто не победил, а поле заполнено, игра заканчивается ничьей.
//Оформите вывод в консоли так, чтобы игровое поле отображалось красиво.
//
//
import java.util.Scanner;

public class TicTacToe {
    private static char[][] board = {
            {' ', ' ', ' '},
            {' ', ' ', ' '},
            {' ', ' ', ' '}
    };

    private static char currentPlayer = 'X';

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean gameRunning = true;

        while (gameRunning) {
            printBoard();
            System.out.println("Игрок " + currentPlayer + ", введите строку и столбец (от 1 до 3 через пробел):");
            int row = scanner.nextInt() - 1;
            int col = scanner.nextInt() - 1;

            if (row < 0 || row > 2 || col < 0 || col > 2 || board[row][col] != ' ') {
                System.out.println("Неверный ход. Попробуйте снова.");
                continue;
            }

            board[row][col] = currentPlayer;

            if (checkWin()) {
                printBoard();
                System.out.println("Игрок " + currentPlayer + " победил!");
                gameRunning = false;
            } else if (isBoardFull()) {
                printBoard();
                System.out.println("Ничья!");
                gameRunning = false;
            } else {
                currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
            }
        }

        scanner.close();
    }

    private static void printBoard() {
        System.out.println("  1 2 3");
        for (int i = 0; i < 3; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j]);
                if (j < 2) System.out.print("|");
            }
            System.out.println();
            if (i < 2) System.out.println("  -----");
        }
    }

    private static boolean checkWin() {
        // Проверяем строки
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == currentPlayer && board[i][1] == currentPlayer && board[i][2] == currentPlayer) {
                return true;
            }
        }

        // Проверяем столбцы
        for (int i = 0; i < 3; i++) {
            if (board[0][i] == currentPlayer && board[1][i] == currentPlayer && board[2][i] == currentPlayer) {
                return true;
            }
        }

        // Проверяем диагонали
        if (board[0][0] == currentPlayer && board[1][1] == currentPlayer && board[2][2] == currentPlayer) {
            return true;
        }

        if (board[0][2] == currentPlayer && board[1][1] == currentPlayer && board[2][0] == currentPlayer) {
            return true;
        }

        return false;
    }

    private static boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }
}

//Игра крестики нолики
//2. Человек против компьютера
//Реализуйте логику игрового поля так же, как в первом варианте.
//Добавьте возможность игры против компьютера:
//Игрок делает ход первым (за X).
//После хода игрока компьютер выбирает случайную свободную клетку для своего хода (за O).
//После каждого хода:
//Проверяйте условия победы.
//Если поле заполнено, игра заканчивается ничьей.
//        Убедитесь, что компьютер не делает ход в занятую клетку.

