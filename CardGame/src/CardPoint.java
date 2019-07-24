public class CardPoint {
    private int point;
    private PlayingCard playingCard;

    public int getCardPoint(PlayingCard playingCard) {
        if (playingCard.getValue() == PlayingCard.Value.TWO) {
            return 2;
        } else if (playingCard.getValue() == PlayingCard.Value.THREE) {
            return 3;
        } else if (playingCard.getValue() == PlayingCard.Value.FOUR) {
            return 4;
        } else if (playingCard.getValue() == PlayingCard.Value.FIVE) {
            return 5;
        } else if (playingCard.getValue() == PlayingCard.Value.SIX) {
            return 6;
        } else if (playingCard.getValue() == PlayingCard.Value.SEVEN) {
            return 7;
        } else if (playingCard.getValue() == PlayingCard.Value.EIGHT) {
            return 8;
        } else if (playingCard.getValue() == PlayingCard.Value.NINE) {
            return 9;
        } else if (playingCard.getValue() == PlayingCard.Value.TEN) {
            return 10;
        } else if (playingCard.getValue() == PlayingCard.Value.J) {
            return 11;
        } else if (playingCard.getValue() == PlayingCard.Value.Q) {
            return 12;
        } else if (playingCard.getValue() == PlayingCard.Value.K) {
            return 13;
        } else
            return 14;
    }

    public int ifDraw(PlayingCard playingCard) {
        if (playingCard.getSuit() == PlayingCard.Suit.CLUBS) {
            point = 1;
        } else if (playingCard.getSuit() == PlayingCard.Suit.DIAMONDS) {
            point = 2;
        } else if (playingCard.getSuit() == PlayingCard.Suit.HEARTS) {
            point = 3;
        } else if (playingCard.getSuit() == PlayingCard.Suit.SPADES) {
            point = 4;
        }
        return point;
    }
}
