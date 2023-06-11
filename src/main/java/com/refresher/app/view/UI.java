package com.refresher.app.view;

import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.refresher.app.model.Board;

public class UI {
    private static Map<String, Integer> rowMap = Stream.of(new Object[][] {
            { "A", 0 },
            { "B", 1 },
            { "C", 2 },
            { "D", 3 },
            { "E", 4 },
            { "F", 5 },
            { "G", 6 },
            { "H", 7 },
            { "I", 8 },
            { "J", 9 },
    }).collect(Collectors.toMap(data -> (String) data[0], data -> (Integer) data[1]));
    Scanner scanner;

    public UI(Scanner scanner) {
        this.scanner = scanner;
    }

    public void printBoard(Board board) {
        System.out.println("  0 1 2 3 4 5 6 7 8 9");
        for (int row = 0; row < 10; row++) {
            String COLS = "ABCDEFGHIJ";
            System.out.print(COLS.charAt(row) + " ");
            for (int column = 0; column < 10; column++) {
                String marker = board.getField(row, column).getMarker().toString() == "EMPTY" ? " "
                        : board.getField(row, column).getMarker().toString();
                System.out.print(marker + " ");
            }
            System.out.println();
        }
    }

    public int[] getUserInput() {
        int[] coords = new int[2];
        String input = this.readUserInput();
        while (!this.validateUserInput(input)) {
            this.printMessage("Invalid input. Try again.");
            input = this.readUserInput();
        }
        coords = this.parseUserInput(input);
        return coords;
    }

    public void printMessage(String message) {
        System.out.println(message);
    }

    public String readUserInput() {
        this.printMessage("Enter row: ");
        String row = scanner.nextLine();
        return row;
    }

    public boolean validateUserInput(String input) {
        String sanitizedInput = input.trim().toUpperCase();
        if (sanitizedInput.length() != 2
                || !validateUserInputFirstLetter(sanitizedInput)
                || !validateUserInputSecondLetter(sanitizedInput)) {
            return false;
        }
        return true;
    }

    private boolean validateUserInputFirstLetter(String input) {
        if (!rowMap.containsKey(input.substring(0, 1).toUpperCase())) {
            return false;
        }
        return true;
    }

    private boolean validateUserInputSecondLetter(String input) {
        if (!input.substring(1, 2).matches("[0-9]")) {
            return false;
        }
        return true;
    }

    public int[] parseUserInput(String input) {
        int[] coords = new int[2];
        coords[0] = rowMap.get(input.substring(0, 1).toUpperCase());
        coords[1] = Integer.parseInt(input.substring(1, 2));
        return coords;
    }
}
