package models;

import java.util.Scanner;

public class Human extends Player {

    private int level;
    private int coins;

    private Scanner scanner = new Scanner(System.in);
    public Human(String name,Symbol symbol,PlayerType playerType, int level) {
        super(name,symbol,playerType);
        this.level = level;

    }
    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getCoins() {
        return coins;
    }

    public void setCoins(int coins) {
        this.coins = coins;
    }

    @Override
    public Move makeMove() {
        System.out.println("Please enter the row in which you would like to make a move");
        int row = scanner.nextInt();
        System.out.println("Please enter the column in which you want to make a move");
        int column = scanner.nextInt();

        return new Move(new Cell(row,column),this);


    }
}
