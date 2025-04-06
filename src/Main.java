import controllers.GameController;
import models.*;
import strategies.RowWinningStrategy;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        GameController gameController = new GameController();

        List<Player> players = new ArrayList<>();

        players.add(new Human());
        players.add(new Bot());

        Game game = gameController.startGame(3,players,List.of(new RowWinningStrategy()));

        while(gameController.getGameState(game).equals(GameState.IN_PROGRESS)){
            gameController.displayBoard(game);
            gameController.makeMove(game);
        }

        if(gameController.getGameState(game).equals(GameState.SUCCESS)){
            System.out.println("We have a winner: "+gameController.getWinner(game));
        }
        else{
            System.out.println("We have a DRAW");
        }

    }
}