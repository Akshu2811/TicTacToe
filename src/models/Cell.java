package models;

public class Cell {

    private int row;
    private int col;
    private Symbol symbol;
    private Player player;
    private CellState cellState;


    public Cell(int row, int col) {
        this.row = row;
        this.col = col;
        this.symbol = null;
        this.cellState = CellState.EMPTY;

    }


    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public Symbol getSymbol() {
        return symbol;
    }

    public void setSymbol(Symbol symbol) {
        this.symbol = symbol;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public CellState getCellState() {
        return cellState;
    }

    public void setCellState(CellState cellState) {
        this.cellState = cellState;
    }

    //here we wre checking if the cell is empty or filled - if it is empty printing it blank and if it is filled with a
    //symbol printing that symbol using symbol getter
    public void display(){
        if(cellState==CellState.EMPTY){
            System.out.print("| - |");
        }
        else if(cellState==CellState.FILLED){
            System.out.print("| "+symbol.getSymbol()+" |");
        }
    }
}
