package Advent2023.model;

public class CamelCard implements Comparable<CamelCard> {

    private String card;

    private String sortedCard;

    private int bid;

    public CamelCard(String card, int bid) {
        this.card = card;
        this.bid = bid;
    }


    public String getCard() {
        return card;
    }

    public void setCard(String card) {
        this.card = card;
    }

    public String getSortedCard() {
        return sortedCard;
    }

    public void setSortedCard(String sortedCard) {
        this.sortedCard = sortedCard;
    }

    public int getBid() {
        return bid;
    }

    public void setBid(int bid) {
        this.bid = bid;
    }


    @Override
    public String toString() {
        return "CamelCard{" +
                "card='" + card + '\'' +
                ", sortedCard='" + sortedCard + '\'' +
                ", bid=" + bid +
                '}';
    }


    // overridden method from comparable
    @Override
    public int compareTo(CamelCard o) {

        String card1 = this.getSortedCard();
        int[] card1Counts = new int[13];

        String card2 = o.getSortedCard();
        int[] card2Counts = new int[13];

        char[] cards = {'A', 'K', 'Q', 'J', 'T', '9', '8', '7', '6', '5', '4', '3', '2'};

        int[] cardOneTypes = new int[6];  // 0 - 5, 1 - 4, 2 - fh, 3 - three of a kind, 4 - 2 2 of a kind, 5 - 1p
        int[] cardTwoTypes = new int[6];

        for (int i = 0; i < 13; i++) {
            card1Counts[i] = countCards(card1, cards[i]);
            card2Counts[i] = countCards(card2, cards[i]);
        }

        for (int i = 0; i < 13; i++) {
            if (card1Counts[i] == 5) {
                cardOneTypes[0]++;
            }
            if (card1Counts[i] == 4) {
                cardOneTypes[1]++;
            }
            if (card1Counts[i] == 3) {
                cardOneTypes[3]++;
            }
            if (card1Counts[i] == 2) {
                cardOneTypes[5]++;
            }


            if (card2Counts[i] == 5) {
                cardTwoTypes[0]++;
            }
            if (card2Counts[i] == 4) {
                cardTwoTypes[1]++;
            }
            if (card2Counts[i] == 3) {
                cardTwoTypes[3]++;
            }
            if (card2Counts[i] == 2) {
                cardTwoTypes[5]++;
            }

        }

        // full house
        if (cardOneTypes[3] == 1 && cardOneTypes[5] == 1) {
            cardOneTypes[2] = 1;
            cardOneTypes[3] = 0;
            cardOneTypes[5] = 0;
        }
        if (cardTwoTypes[3] == 1 && cardTwoTypes[5] == 1) {
            cardTwoTypes[2] = 1;
            cardTwoTypes[3] = 0;
            cardTwoTypes[5] = 0;
        }

        // two pair
        if (cardOneTypes[5] == 2) {
            cardOneTypes[4] = 1;
            cardOneTypes[5] = 0;
        }

        if (cardTwoTypes[5] == 2) {
            cardTwoTypes[4] = 1;
            cardTwoTypes[5] = 0;
        }

        for (int i = 0; i < 6; i++) {

            if (cardOneTypes[i] > cardTwoTypes[i]) {
                return 1;
            }
            if (cardTwoTypes[i] > cardOneTypes[i]) {
                return -1;
            }

            if (cardOneTypes[i] == cardTwoTypes[i] && cardOneTypes[i] != 0) {
                String firstCard = this.getCard();
                String secondCard = o.getCard();


                return compareChars(firstCard, secondCard, cards);

            }


        }





        return 0;
    }


    private int compareChars(String firstCard, String secondCard, char[] cards) {

        for (int i = 0; i < firstCard.length(); i++) {

            for (int j = 0; j < cards.length; j++) {

                if (firstCard.charAt(i) == cards[j] && secondCard.charAt(i) != cards[j]) {
                    return 1;
                }
                if (secondCard.charAt(i) == cards[j] && firstCard.charAt(i) != cards[j]) {
                    return -1;
                }

            }


        }
        return 0;
    }


    private int countCards(String card, char charToSearchFor) {


        return (int) card.chars().filter(ch -> ch == charToSearchFor).count();



    }



}
