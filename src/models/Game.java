package models;

import strategies.WinningStrategy;

import java.util.List;

public class Game {

    private Board board;
    private List<Player> players;
    private Player winner;
    private int nextPlayerIndex;
    private List<Move> moves;
    private List<WinningStrategy> winningStrategies;
    private GameState gameState;
}
