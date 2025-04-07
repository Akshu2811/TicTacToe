import controllers.GameController;
import models.*;
import strategies.RowWinningStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static Scanner sc=new Scanner(System.in);
    public static void main(String[] args) {


        GameController gameController = new GameController();

        List<Player> players = new ArrayList<>();

        players.add(new Human("Akshitha",new Symbol('X'),PlayerType.HUMAN,1));
        players.add(new Bot("Shiva",new Symbol('O'),PlayerType.BOT,BotDifficultyLevel.EASY));

        Game game = gameController.startGame(3,players,List.of(new RowWinningStrategy()));

        while(gameController.getGameState(game).equals(GameState.IN_PROGRESS)){
            gameController.displayBoard(game);
            gameController.makeMove(game);
            System.out.println("Do you want to undo? (Y/N)");
            String userInput = sc.nextLine();
            if(userInput.equals("Y")){
                gameController.undo(game);
            }
        }

        if(gameController.getGameState(game).equals(GameState.SUCCESS)){
            System.out.println("We have a winner: "+gameController.getWinner(game).getName());
        }
        else if(gameController.getGameState(game).equals(GameState.DRAW)){
            System.out.println("We have a DRAW");
        }

    }
}