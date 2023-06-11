package com.refresher.app.logic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.refresher.app.model.Board;
import com.refresher.app.model.Marker;

public class GameTests {
    Game game;

    @BeforeEach
    public void setup() {
        Board board = new Board();
        game = new Game(board);
    }

    @Test
    public void getCurrentPlayer_CurrentPlayerSet_ReturnsCurrentPlayer() {
        assert (game.getCurrentPlayer().getMarker() == Marker.X);
    }

    @Test
    public void changePlayer_PlayerChanged_ReturnsValidChangedPlayer() {
        assert (game.getCurrentPlayer().getMarker() == Marker.X);
        game.changePlayer();

        assert (game.getCurrentPlayer().getMarker() == Marker.O);

        game.changePlayer();

        assert (game.getCurrentPlayer().getMarker() == Marker.X);
    }

    @Test
    public void markField_MarksAvailableField_ReturnsTrue() {
        assert (game.makeMove(0, 0));
        assert (game.makeMove(1, 1));
    }

    @Test
    public void markField_MarksUnavailableField_ReturnsFalse() {
        assert (game.makeMove(0, 0));

        assert (!game.makeMove(0, 0));
    }

    @Test
    public void checkRows_WinConditionFulfilledInRows_ReturnsTrue() {
        game.makeMove(0, 0);
        game.makeMove(0, 1);
        game.makeMove(0, 2);
        game.makeMove(0, 3);
        game.makeMove(0, 4);

        assert (game.hasWon());
    }

    @Test
    public void checkRows_WinConditionNotFulfilledInRows_ReturnsFalse() {
        game.makeMove(0, 0);
        game.makeMove(0, 1);
        game.makeMove(0, 2);
        game.makeMove(0, 3);

        assert (!game.hasWon());
    }

    @Test
    public void checkColumns_WinConditionFulfilledInColumns_ReturnsTrue() {
        game.makeMove(0, 0);
        game.makeMove(1, 0);
        game.makeMove(2, 0);
        game.makeMove(3, 0);
        game.makeMove(4, 0);

        assert (game.hasWon());
    }

    @Test
    public void checkColumns_WinConditionNotFulfilledInColumns_ReturnsFalse() {
        game.makeMove(0, 0);
        game.makeMove(1, 0);
        game.makeMove(2, 0);
        game.makeMove(3, 0);

        assert (!game.hasWon());
    }

    @Test
    public void checkDiagonals_WinConditionFulfilledInDiagonalsFromLeftToRight_ReturnsTrue() {
        game.makeMove(0, 0);
        game.makeMove(1, 1);
        game.makeMove(2, 2);
        game.makeMove(3, 3);
        game.makeMove(4, 4);

        assert (game.hasWon());
    }

    @Test
    public void checkDiagonals_WinConditionFulfilledInDiagonalsFromRightToLeft_ReturnsTrue() {
        game.makeMove(0, 4);
        game.makeMove(1, 3);
        game.makeMove(2, 2);
        game.makeMove(3, 1);
        game.makeMove(4, 0);
        assert (game.hasWon());
    }

    @Test
    public void checkDiagonals_WinConditionFulfilledFromBottomToTop_ReturnsTrue() {
        game.makeMove(9, 0);
        game.makeMove(8, 1);
        game.makeMove(7, 2);
        game.makeMove(6, 3);
        game.makeMove(5, 4);
        assert (game.hasWon());
    }

    @Test
    public void checkDiagonals_WinConditionNotFulfilledInDiagonals_ReturnsFalse() {
        game.makeMove(0, 0);
        game.makeMove(1, 1);
        game.makeMove(2, 2);
        game.makeMove(3, 3);

        assert (!game.hasWon());
    }

}
