import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class HighLowMain {
    static Scanner scanner = new Scanner(System.in);
    static boolean loopGame = true;
    static boolean playGame = true;

    public static void main(String[] args) {

        PlayingCardDeck playingCardDeck = new PlayingCardDeck();
        CardPoint cardPoint = new CardPoint();
        List<PlayingCard> cardDeck = playingCardDeck.getCardDeck();

        do {
            //Nollställer poäng och antalet omgångar för varje gång som spelaren återvänder till menyn.
            int score = 0;
            int numberOfTurns = 0;

            welcomeScreen();
            menu();

            if (playGame) {

                Collections.shuffle(cardDeck);

                do {
                    if (cardDeck == null) {
                        System.out.println("\nThe deck is empty. You will now return to the main menu for more choices.\n");
                        break;
                    }

                    dealHand(playingCardDeck, cardDeck);

                    System.out.println("\nHigh or low?");
                    String input = scanner.next();
                    input = input.toLowerCase();

                    if (input.equals("high") || input.equals("low")) {
                        numberOfTurns++;

                        score = result(input, cardDeck, cardPoint, score);
                        printScore(score, numberOfTurns);

                        Collections.rotate(cardDeck, -1);

                        if (numberOfTurns % 51 == 0) {
                            System.out.println("\nYou have now used the entire card deck. Well done!");
                            System.out.println("Your total score is now " + score + " out of " + numberOfTurns + ".");
                            System.out.println("Do you wish to return to the menu (1) or shuffle a new deck (2)?");
                            input = scanner.next();
                            cardDeck = newShuffledCardDeckOrEndGame(input, cardDeck);

                        } else {
                            System.out.println("\nAnother hand (1) or return to the menu (2)?");
                            input = scanner.next();
                            newCardOrReturnToMenu(input);

                        }
                    } else {
                        System.out.println("\nThat was not a valid input. Please try again.");

                    }
                } while (playGame);
            }
        } while (loopGame);
    }

    static void welcomeScreen() {
        System.out.println("Welcome to Casino High and Low!");
        System.out.println("1. Play a game.");
        System.out.println("2. Show the rules.");
        System.out.println("3. End the game.");
        System.out.print("Choice: ");
    }

    static void menu() {
        String input = scanner.next();
        switch (input) {
            case "1":
                playGame = true;
                break;
            case "2":
                rules();
                welcomeScreen();
                menu();
                break;
            case "3":
                System.out.println("\nThank you for playing!\n\nQuiting. . . ");
                playGame = false;
                loopGame = false;
                break;
            default:
                System.out.println("\nThat is not a valid choice, please try again.\n");
                welcomeScreen();
                menu();
        }
    }

    static void rules() {
        System.out.println("\nGuess if the next card is higher or lower!");
        System.out.println("If the two cards have the same value, the suit will decide the score!");
        System.out.println("When you've played through the first deck of cards the game will ask you\nif you'd like to shuffle a new turn or return to the menu.\n");
    }

    static void dealHand(PlayingCardDeck playingCardDeck, List<PlayingCard> cardDeck) {
        System.out.println("\nYour card: " + playingCardDeck.dealTopCard(cardDeck).getSuit() + playingCardDeck.dealTopCard(cardDeck).getValue());
    }

    /* Metod för att få fram ett resultat. Hämtar värdet för det uppvända kortet (index[0]) och jämför med det nya kortet (index[1]).
        Jämför sedan om spelarens gissning stämmer överens med resultatet, dvs om det är högre eller lägre. Om lika skickas
        korten in i metoden ifDraw som jämför färgernas värde. Retunerar spelarens poäng.
     */
    static int result(String input, List<PlayingCard> cardDeck, CardPoint cardPoint, int score) {
        int firstCard = cardPoint.getCardPoint(cardDeck.get(0));
        int secondCard = cardPoint.getCardPoint(cardDeck.get(1));

        if (input.equals("high") && firstCard < secondCard || input.equals("low") && firstCard > secondCard) {
            System.out.println("\nCorrect!\nThe card was " + cardDeck.get(1).getSuit() + "" + cardDeck.get(1).getValue());
            score++;
        } else if (firstCard == secondCard) {
            score = ifDraw(cardDeck, cardPoint, score);
        } else {
            System.out.println("\nWrong!\nThe card was " + cardDeck.get(1).getSuit() + "" + cardDeck.get(1).getValue());
        }
        return score;
    }

    static int ifDraw(List<PlayingCard> cardDeck, CardPoint cardPoint, int score) {
        int current = cardPoint.ifDraw(cardDeck.get(0));
        int newCard = cardPoint.ifDraw(cardDeck.get(1));

        System.out.println("\nThe card was " + cardDeck.get(1).getSuit() + "" + cardDeck.get(1).getValue());

        if (current > newCard) {
            System.out.println("It's a draw! But lucky for you " + cardDeck.get(0).getSuit() + " is bigger than " + cardDeck.get(1).getSuit() + "\n");
            score++;
        } else
            System.out.println("It's a draw! And unlucky for you " + cardDeck.get(1).getSuit() + " is bigger than " + cardDeck.get(0).getSuit() + "\n");

        return score;
    }

    static void printScore(int score, int numberOfTurns) {
        System.out.println("Your score: " + score + "/" + numberOfTurns);
    }

    static void newCardOrReturnToMenu(String input) {
        if (input.equals("2")) {
            System.out.println();
            playGame = false;
        } else if (!input.equals("1")) {
            System.out.println("That was not a valid choice. Please try again: ");
            input = scanner.next();
            newCardOrReturnToMenu(input);
        }
    }

    static List<PlayingCard> newShuffledCardDeckOrEndGame(String input, List<PlayingCard> cardDeck) {
        if (input.equals("1")) {
            System.out.println();
            playGame = false;
        } else if (input.equals("2")) {
            Collections.shuffle(cardDeck);
        } else {
            System.out.println("That was not a valid input. Please try again.");
            input = scanner.next();
            newShuffledCardDeckOrEndGame(input, cardDeck);
        }
        return cardDeck;
    }
}
