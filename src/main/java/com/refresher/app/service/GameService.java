package com.refresher.app.service;

import java.util.Scanner;

import com.refresher.app.logic.Game;
import com.refresher.app.view.UI;

public class GameService {
    Game game;
    UI ui;

    public GameService(Game game) {
        this.game = game;
        this.ui = new UI(new Scanner(System.in));
    }

    public void start() {
        ui.printMessage("Welcome to Tic Tac Toe!");
        ui.printBoard(game.getBoard());
        while (!game.hasWon()) {
            int[] coords = ui.getUserInput();
            while (!game.makeMove(coords[0], coords[1])) {
                ui.printMessage("Invalid move. Try again.");
                coords = ui.getUserInput();
            }
            ui.printBoard(game.getBoard());
            if (!game.hasWon()) {
                game.changePlayer();
            }
        }
        ui.printMessage("Player " + game.getCurrentPlayer().getMarker() + " has won!");
    }

}
