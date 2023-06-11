package com.refresher.app.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

public class BoardTests {
    Board board;

    @BeforeEach
    public void setUp() {
        board = new Board();
    }

    @Test
    public void markField_FieldWasMarked_ReturnsTrue() {
        Board board = new Board();
        assert (board.markField(0, 0, Marker.X));
    }

    @Test
    public void markField_FielWasOccupied_returnsFalse() {
        assert (board.markField(0, 0, Marker.X));

        assert (!board.markField(0, 0, Marker.O));
    }

    @Test
    public void isFieldEmpty_TheFieldIsEmpty_ReturnsTrue() {
        assert (board.isFieldEmpty(0, 0));
    }

    @Test
    public void isFieldEmpty_TheFieldIsOccupied_ReturnsFalse() {
        assert (board.markField(0, 0, Marker.X));

        assert (!board.isFieldEmpty(0, 0));
    }

}
