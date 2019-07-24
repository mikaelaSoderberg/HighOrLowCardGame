public class PlayingCard {

    private boolean isUp;
    private Suit suit;
    private Value value;

    protected enum Suit {
        DIAMONDS {
            public String toString() {
                return "♦";
            }
        },
        CLUBS {
            public String toString() {
                return "♣";
            }
        },
        HEARTS {
            public String toString() {
                return "♥";
            }
        },
        SPADES {
            public String toString() {
                return "♠";
            }
        }
    }

    protected enum Value {
        TWO {
            public String toString() {
                return "2";
            }
        },
        THREE {
            public String toString() {
                return "3";
            }
        },
        FOUR {
            public String toString() {
                return "4";
            }
        },
        FIVE {
            public String toString() {
                return "5";
            }
        },
        SIX {
            public String toString() {
                return "6";
            }
        },
        SEVEN {
            public String toString() {
                return "7";
            }
        },
        EIGHT {
            public String toString() {
                return "8";
            }
        },
        NINE {
            public String toString() {
                return "9";
            }
        },
        TEN {
            public String toString() {
                return "10";
            }
        },
        J,
        Q,
        K,
        A

    }

    public PlayingCard(Suit suit, Value value) {
        this.suit = suit;
        this.value = value;
    }

    public PlayingCard(boolean isUp) {
        this.isUp = isUp;
    }

    public boolean isUp() {
        return isUp;
    }

    public void setUp(boolean up) {
        isUp = up;
    }

    public Suit getSuit() {
        return suit;
    }

    public Value getValue() {
        return value;
    }

}
