
import java.util.ArrayList;

import java.util.List;

public class PlayingCardDeck {

    private List<PlayingCard> cardDeck = new ArrayList<>();
    private PlayingCard topCard;

    public List<PlayingCard> getCardDeck() {
        for (PlayingCard.Suit s : PlayingCard.Suit.values()) {
            for (PlayingCard.Value v : PlayingCard.Value.values()) {
                this.cardDeck.add(new PlayingCard(s, v));
            }
        }
        return cardDeck;
    }

    public PlayingCard dealTopCard(List<PlayingCard> cardDeck){
            topCard = cardDeck.get(0);
            return topCard;
    }

//    Metod för att lägga det använda kortet längst bak i högen enligt instruktionerna.
//    Använder dock Collections.rotate i main-klassen.

//    public List<PlayingCard> placeBottomCard(List<PlayingCard> cardDeck){
//            cardDeck.remove(0);
//            cardDeck.add(topCard);
//            return cardDeck;
//    }
}
