package models;

import strategies.WinningStrategy;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private Board board;
    private List<Player> players;
    private Player winner;
    private int nextPlayerIndex;
    private List<Move> moves;
    private List<WinningStrategy> winningStrategies;
    private GameState gameState;

    public Game(int size, List<Player> players,List<WinningStrategy> winningStrategies) {
        //using size create the board
         board=new Board(size);
         setPlayers(players);
         this.winningStrategies=winningStrategies;
         nextPlayerIndex=0;
         moves=new ArrayList<>();
         this.winner=null;
         gameState=GameState.IN_PROGRESS;

    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public void displayBoard() {
        board.display();
    }
    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
        for (Player player : players) {
            player.setGame(this);
        }
    }

    public Player getWinner() {
        return winner;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }

    public int getNextPlayerIndex() {
        return nextPlayerIndex;
    }

    public void setNextPlayerIndex(int nextPlayerIndex) {
        this.nextPlayerIndex = nextPlayerIndex;
    }

    public List<Move> getMoves() {
        return moves;
    }

    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }
    public boolean validateMove(Move move) {
        int row=move.getCell().getRow();
        int col=move.getCell().getCol();
        //checking if the rows and columns are in the given boundary
        if(row<0 || col<0 || row>=board.getSize() || col>=board.getSize()){
            return false;
        }
        //seeing if it is returning an empty cell or not
        return board.getBoard().get(row).get(col).getCellState().equals(CellState.EMPTY);
    }
    public void updateGameSateAfterMove(Move move) {
        int row=move.getCell().getRow();
        int col=move.getCell().getCol();

        Cell cellToChange = board.getBoard().get(row).get(col);
        cellToChange.setCellState(CellState.FILLED);
        cellToChange.setSymbol(move.getPlayer().getSymbol());

        move.setCell(cellToChange);

        moves.add(move);

        nextPlayerIndex++;
        nextPlayerIndex%=board.getSize()-1;

    }
    public boolean checkWinner(Move move) {
        for(WinningStrategy winningStrategy : winningStrategies){
            if(winningStrategy.checkWinner(board, move)){
                return true;
            }
        }
        return false;
    }

    public boolean checkDraw() {
        return moves.size()==board.getSize()*board.getSize();
    }

    public void undo(){
        if(moves.isEmpty()){
            System.out.println("No moves to undo!");
        }
        Move lastMove=moves.get(moves.size()-1);
        moves.remove(moves.size()-1);

        lastMove.getCell().setCellState(CellState.EMPTY);
        lastMove.getCell().setSymbol(null);

        nextPlayerIndex--;
        nextPlayerIndex=(nextPlayerIndex+players.size())%players.size();

        for(WinningStrategy winningStrategy : winningStrategies){
            winningStrategy.handleUndo(board, lastMove);
        }
        setGameState(GameState.IN_PROGRESS);
        setWinner(null);


    }
    public void makeMove() {
        Player currentPlayer=players.get(nextPlayerIndex);
        System.out.println("It's "+currentPlayer.getName()+"'s turn. Please be ready with your move");
        Move move=currentPlayer.makeMove();

        if(!validateMove(move)){
            System.out.println("Invalid move. Please try again!");
            return;
        }

        updateGameSateAfterMove(move);

        //check if there is a winner after the move
        if(checkWinner(move)){
            winner=move.getPlayer();
            gameState=GameState.SUCCESS;
        }
        else if(checkDraw()){
            gameState=GameState.DRAW;
        }

    }

    public List<WinningStrategy> getWinningStrategies() {
        return winningStrategies;
    }

    public void setWinningStrategies(List<WinningStrategy> winningStrategies) {
        this.winningStrategies = winningStrategies;
    }

    public GameState getGameState() {
        return gameState;
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }
}
