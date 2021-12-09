package com.faraz.bhinder;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        char[][] board = {
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}};

        char[][] board2 = {
                {'.','4','.','.','9','3','.','.','.'},
                {'.','.','.','.','.','.','.','3','.'},
                {'.','.','.','.','.','.','.','.','.'},
                {'.','.','4','.','.','.','.','.','6'},
                {'2','.','3','.','.','.','.','6','.'},
                {'.','.','.','.','.','.','.','.','.'},
                {'.','.','.','.','.','.','4','.','.'},
                {'.','.','.','1','.','.','.','.','.'},
                {'.','.','.','4','7','.','.','.','.'}};
        Solution s = new Solution();
        System.out.println(s.isValidSudoku(board));
        System.out.println(s.isValidSudoku(board2));
    }
}

class Solution {
    Set<Character> rowSet = new HashSet<>();
    Set<Character> colSet = new HashSet<>();
    Set<Character> innerSet = new HashSet<>();

    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (rowSet.contains(board[i][j])) {
                    return false;
                }
                if (board[i][j] != '.') {
                    rowSet.add(board[i][j]);
                }
            }
            rowSet.clear();
        }


        for (int i = 0; i < board[0].length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (colSet.contains(board[j][i])) {
                    return false;
                }
                if (board[j][i] != '.') {
                    colSet.add(board[j][i]);
                }
            }
            colSet.clear();
        }
        boolean innerBoxesValid = innerBoxValid(board, 0, 0)
                && innerBoxValid(board, 0, 3)
                && innerBoxValid(board, 0, 6)
                && innerBoxValid(board, 3, 0)
                && innerBoxValid(board, 3, 3)
                && innerBoxValid(board, 3, 6)
                && innerBoxValid(board, 6, 0)
                && innerBoxValid(board, 6, 3)
                && innerBoxValid(board, 6, 6);
        return innerBoxesValid;
    }

    private boolean innerBoxValid(char[][] board, int r, int c) {
        for (int i = r; i < r + 3 ; i++) {
            for (int j = c; j < c + 3; j++) {
                if (innerSet.contains(board[i][j])) {
                    return false;
                }
                if (board[i][j] != '.') {
                    innerSet.add(board[i][j]);
                }
            }
        }
        innerSet.clear();
        return true;
    }
}