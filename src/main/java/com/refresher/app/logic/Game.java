package com.refresher.app.logic;

import java.util.ArrayList;

import com.refresher.app.model.Board;
import com.refresher.app.model.Field;
import com.refresher.app.model.Marker;
import com.refresher.app.model.Player;

public class Game {
    private Board board;
    private Player player1;
    private Player player2;
    private Player currentPlayer;

    public Game(Board board) {
        this.board = board;
        this.player1 = new Player(Marker.X);
        this.player2 = new Player(Marker.O);
        this.currentPlayer = player1;
    }

    public Board getBoard() {
        return (Board) board.getBoard();
    }

    public void changePlayer() {
        if (currentPlayer == player1) {
            currentPlayer = player2;
        } else {
            currentPlayer = player1;
        }
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public boolean makeMove(int row, int column) {
        return board.markField(row, column, currentPlayer.getMarker());
    }

    public boolean hasWon() {
        return checkRows() || checkColumns() || checkDiagonals();
    }

    public boolean checkRows() {
        for (int row = 0; row < 10; row++) {
            int hits = 0;
            for (int column = 0; column < 10; column++) {
                if (board.getField(row, column).getMarker() == currentPlayer.getMarker()) {
                    hits++;
                } else {
                    hits = 0;
                }
                if (hits >= 5) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean checkColumns() {
        for (int column = 0; column < 10; column++) {
            int hits = 0;
            for (int row = 0; row < 10; row++) {
                if (board.getField(row, column).getMarker() == currentPlayer.getMarker()) {
                    hits++;
                } else {
                    hits = 0;
                }
                if (hits >= 5) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean checkDiagonals() {
        for (int row = 0; row < 10; row++) {
            for (int column = 0; column < 10; column++) {
                int hits = 0;
                for (int i = 0; i < 5; i++) {
                    if (row + i < 10 && column + i < 10) {
                        if (board.getField(row + i, column + i).getMarker() == currentPlayer.getMarker()) {
                            hits++;
                        } else {
                            hits = 0;
                        }
                        if (hits >= 5) {
                            return true;
                        }
                    }
                }
                hits = 0;
                for (int i = 0; i < 5; i++) {
                    if (row + i < 10 && column - i >= 0) {
                        if (board.getField(row + i, column - i).getMarker() == currentPlayer.getMarker()) {
                            hits++;
                        } else {
                            hits = 0;
                        }
                        if (hits >= 5) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
}
