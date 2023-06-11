package com.refresher.app.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class FieldTests {
    private Field field;

    @BeforeEach
    public void setUp() {
        field = new Field();
    }

    @Test
    public void testFieldCreation() {
        assert (field.getMarker() == Marker.EMPTY);
    }

    @Test
    public void setMarker_MarkerWasSetCorrectly_ReturnsTrue() {
        field.setMarker(Marker.X);
    }

    @Test
    @DisplayName("Test if field can not be marked twice")
    public void setMarker_MarkerWasAlreadySet_ReturnsFalse() {
        field.setMarker(Marker.X);

        assert (!field.setMarker(Marker.O));
    }

    @Test
    public void getMarker_MarkerWasSetCorrectly_ReturnsValidMarker() {
        field.setMarker(Marker.X);
        assert (field.getMarker() == Marker.X);
    }

    public void getMarker_MarkerWasSetTwice_ReturnsValidMarker() {
        field.setMarker(Marker.X);
        field.setMarker(Marker.O);

        assert (field.getMarker() == Marker.X);
    }
}
