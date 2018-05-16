package euler;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Problem_096 {

    static int sudokuSum() {
        int sum = 0;
        int[][] board = new int[9][9];
        String line = "";
        
        try (BufferedReader reader = new BufferedReader(new FileReader(new File("p096_sudoku.txt")))) {
            int row = 0;
            while ((line = reader.readLine()) != null) {
                if (line.matches("Grid \\d+")) {
                    row = 0;
                    board = new int[9][9];
                } else {
                    for (int col = 0; col < line.length(); col++) {
                        board[row][col] = Integer.parseInt(line.substring(col, col+1));
                    }
                    row++;
                    if (row == 9) {
                        solveSudoku(board);
                        sum += (100*board[0][0]) + (10*board[0][1]) + board[0][2];
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return sum;
    }
    
    private static int[] findNextEmptySquare(int[][] board) {
        int[] pos = {-1, -1};
        
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == 0) {
                    pos[0] = i;
                    pos[1] = j;
                }
            }
        }
        
        return pos;
    }
    
    private static boolean solveSudoku(int[][] board) {
        int[] emptySpot = findNextEmptySquare(board);
        int i = emptySpot[0], j = emptySpot[1];
        if (i == -1) return true;
        
        if (board[i][j] == 0) {
            for (int k = 1; k < 10; k++) {
                if (isValid(board, i, j, k)) {
                    board[i][j] = k;
                    if (solveSudoku(board)) return true;
                    board[i][j] = 0;
                }
            }
        }
        return false;
    }
    
    private static boolean isValid(int[][] board, int squareRow, int squareCol, int val) {
        // unique digit in row
        for (int j = 0; j < 9; j++) {
            if (board[squareRow][j] == val)
                return false;
        }
        // unique digit in col
        for (int i = 0; i < 9; i++) {
            if (board[i][squareCol] == val)
                return false;
        }
        //unique digit in sector
        int secTopX = 3*(squareRow/3), secTopY = 3*(squareCol/3);
        for (int x = secTopX; x < secTopX+3; x++) {
            for (int y = secTopY; y < secTopY+3; y++) {
                if (board[x][y] == val)
                    return false;
            }
        }
        return true;
    }
  
}
