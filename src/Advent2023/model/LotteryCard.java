package Advent2023.model;

public class LotteryCard {

    private int gameNum;
    private int originalWins;
    private int numOfCards;


    public LotteryCard(int gameNum, int originalWins) {
        this.gameNum = gameNum;
        this.originalWins = originalWins;
    }


    public int getGameNum() {
        return gameNum;
    }

    public void setGameNum(int gameNum) {
        this.gameNum = gameNum;
    }

    public int getOriginalWins() {
        return originalWins;
    }

    public void setOriginalWins(int originalWins) {
        this.originalWins = originalWins;
    }

    public int getNumOfCards() {
        return numOfCards;
    }

    public void setNumOfCards(int numOfCards) {
        this.numOfCards = numOfCards;
    }


    @Override
    public String toString() {
        return "LotteryCard{" +
                "gameNum=" + gameNum +
                ", originalWins=" + originalWins +
                ", numOfCards=" + numOfCards +
                '}';
    }
}
