package com.refresher.app.model;

public class Field {
    private Marker marker;

    public Field() {
        this.marker = Marker.EMPTY;
    }

    public Marker getMarker() {
        return marker;
    }

    public boolean setMarker(Marker marker) {
        if (this.marker != Marker.EMPTY) {
            return false;
        }
        this.marker = marker;
        return true;
    }
}
