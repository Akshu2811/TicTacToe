package controllers;

import models.Game;
import models.GameState;
import models.Player;
import strategies.WinningStrategy;

import java.util.List;

public class GameController {

    public Game startGame(
            int size,
            List<Player> players,
            List<WinningStrategy> winningStrategies

    ){
        return null;

    }
    public void makeMove(Game game){


    }

    public GameState getGameState(Game game){

        return null;
    }

    public void displayBoard(Game game){


    }

    public Player getWinner(Game game){
        return null;
    }

    public void undo(Game game){

    }



}
//use cases:
//1.startGame
//2. makeMove
//3.checkState
//4.getWinnner
//5.displayBoard
//6.undo