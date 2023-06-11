package com.refresher.app.model;

import java.util.ArrayList;

public class Board {
    private ArrayList<ArrayList<Field>> board;

    public Board() {
        this.board = new ArrayList<ArrayList<Field>>();
        for (int i = 0; i < 10; i++) {
            ArrayList<Field> row = new ArrayList<Field>();
            for (int j = 0; j < 10; j++) {
                row.add(new Field());
            }
            this.board.add(row);
        }
    }

    public Board getBoard() {
        return this;
    }

    public boolean markField(int row, int column, Marker marker) {
        return this.board.get(row).get(column).setMarker(marker);
    }

    public Field getField(int row, int column) {
        return this.board.get(row).get(column);
    }

    public boolean isFieldEmpty(int row, int column) {
        if (this.board.get(row).get(column).getMarker() == Marker.EMPTY) {
            return true;
        } else {
            return false;
        }
    }
}
