package strategies;

import models.Board;
import models.Cell;
import models.Move;
import models.Symbol;

import java.util.HashMap;

public class RowWinningStrategy implements WinningStrategy {
    private HashMap<Integer,HashMap<Character,Integer>> rowCounts=new HashMap<>();
   @Override
   public boolean checkWinner(Board board, Move move) {
       Cell cell=move.getCell();
       int row=cell.getRow();
       //check if the information about the row is present or not
       if(!rowCounts.containsKey(row)){
           rowCounts.put(row,new HashMap<>());
       }
       HashMap<Character,Integer> rowCount=rowCounts.get(row);

       // check if freq of symbol is present or not
       if(!rowCount.containsKey(cell.getSymbol())){

           rowCount.put(cell.getSymbol().getSymbol(),0);
       }
       // increase the frequency
       rowCount.put(cell.getSymbol().getSymbol(),rowCount.get(cell.getSymbol().getSymbol())+1);

       if(rowCount.get(cell.getSymbol().getSymbol())== board.getSize()){
           return true;
       }
        return false;

   }

    @Override
    public void handleUndo(Board board, Move move) {
        int row=move.getCell().getRow();
        Character ch=move.getPlayer().getSymbol().getSymbol();

        rowCounts.get(row).put(ch,rowCounts.get(row).get(ch)-1);
    }
}
//please try it out: o(1)
