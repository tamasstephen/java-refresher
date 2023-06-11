package com.refresher.app;

import com.refresher.app.logic.Game;
import com.refresher.app.model.Board;
import com.refresher.app.service.GameService;

public class RefresherApp {

    public static void main(String[] args) {
        Board board = new Board();
        Game game = new Game(board);
        GameService gameService = new GameService(game);
        gameService.start();
    }
}
