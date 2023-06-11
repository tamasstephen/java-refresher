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

}
