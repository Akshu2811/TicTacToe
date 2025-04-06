package strategies;

import models.Board;
import models.Cell;
import models.Move;
import models.Symbol;

import java.util.HashMap;

public class RowWinningStrategy implements WinningStrategy {
    private HashMap<Integer,HashMap<Symbol,Integer>> rowCounts;
   @Override
   public boolean checkWinner(Board board, Move move) {
       Cell cell=move.getCell();
       int row=cell.getRow();
       //check if the information about the row is present or not
       if(!rowCounts.containsKey(row)){
           rowCounts.put(row,new HashMap<>());
       }
       HashMap<Symbol,Integer> rowCount=rowCounts.get(row);

       // check if freq of symbol is present or not
       if(!rowCount.containsKey(cell.getSymbol())){

           rowCount.put(cell.getSymbol(),0);
       }
       // increase the frequency
       rowCount.put(cell.getSymbol(),rowCount.get(cell.getSymbol())+1);

       if(rowCount.get(cell.getSymbol())== board.getSize()){}
        return true;

   }
}
//please try it out: o(1)
