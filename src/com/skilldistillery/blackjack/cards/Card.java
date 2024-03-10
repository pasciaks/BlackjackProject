package com.skilldistillery.blackjack.cards;

import java.util.Objects;

import com.skilldistillery.blackjack.game.ConsoleEffect;
import com.skilldistillery.blackjack.game.GameTable;

public class Card {

	private Rank rank;
	private Suit suit;
	private boolean isFaceUp = false;

	// The following are for enhanced display of cards
	private String[][] cardSpace = new String[5][5];
	private String bgColor = ConsoleEffect.whiteBg;
	private String textColor = ConsoleEffect.blue;

	public Card(Rank rank, Suit suit) {
		this.rank = rank;
		this.suit = suit;
	}

	public Rank getRank() {
		return this.rank;
	}

	public Suit getSuit() {
		return this.suit;
	}

	public int getValue() {
		return this.rank.getValue();
	}

	public boolean isFaceUp() {
		return this.isFaceUp;
	}

	public void setFaceUp(boolean isFaceUp) {
		this.isFaceUp = isFaceUp;
	}

	@Override
	public String toString() {
		if (this.isFaceUp) {
			return "[" + this.rank + " of " + this.suit + "]";
		} else {
			return "[***]";
		}

	}

	private String translateSuitToColor(String oldSuitAsString) {
		String translatedSuitStringAsColorString = "" + ConsoleEffect.blue;
		switch (oldSuitAsString) {
		case "Spades":
		case "Clubs":
			translatedSuitStringAsColorString = ConsoleEffect.black;
			break;
		case "Diamonds":
		case "Hearts":
			translatedSuitStringAsColorString = ConsoleEffect.red;
			break;
		default:
			break;
		}
		return translatedSuitStringAsColorString;
	}

	private String translateSuitToSymbol(String oldSuitAsString) {
		String translatedSuitString = "" + oldSuitAsString;
		switch (oldSuitAsString) {
		case "Hearts":
			translatedSuitString = "❤";
			break;
		case "Spades":
			translatedSuitString = "♠";
			break;
		case "Clubs":
			translatedSuitString = "♣";
			break;
		case "Diamonds":
			translatedSuitString = "♦";
			break;
		default:
			break;
		}
		return translatedSuitString;
	}

	private int translateIsFaceUpToCardType(boolean isFaceUp) {
		return isFaceUp ? 1 : 0;
	}

	private String translateRank(String oldRankAsString) {

		// TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6), SEVEN(7), EIGHT(8), NINE(9),
		// TEN(10), JACK(10), QUEEN(10), KING(10), ACE(11);
		String translatedRankToShortString = "" + oldRankAsString;
		switch (oldRankAsString) {
		case "TWO":
			translatedRankToShortString = "2";
			break;
		case "THREE":
			translatedRankToShortString = "3";
			break;
		case "FOUR":
			translatedRankToShortString = "4";
			break;
		case "FIVE":
			translatedRankToShortString = "5";
			break;
		case "SIX":
			translatedRankToShortString = "6";
			break;
		case "SEVEN":
			translatedRankToShortString = "7";
			break;
		case "EIGHT":
			translatedRankToShortString = "8";
			break;
		case "NINE":
			translatedRankToShortString = "9";
			break;
		case "TEN":
			translatedRankToShortString = "10";
			break;
		case "JACK":
			translatedRankToShortString = "J";
			break;
		case "QUEEN":
			translatedRankToShortString = "Q";
			break;
		case "KING":
			translatedRankToShortString = "K";
			break;
		case "ACE":
			translatedRankToShortString = "A";
			break;
		default:
			break;
		}

		return translatedRankToShortString;
	}

	public void showCard(int index, GameTable gameTable) {

		gameTable.drawCardToScreen(cardSpace, 1, 1 + index * 6, bgColor, textColor,
				this.translateRank(this.rank.toString()), this.translateSuitToColor(this.suit.toString()),
				this.translateSuitToSymbol(this.suit.toString()), this.translateIsFaceUpToCardType(this.isFaceUp));

		// System.out.println(this.toString() + " ");

	}

	@Override
	public int hashCode() {
		return Objects.hash(rank, suit);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Card other = (Card) obj;
		return rank == other.rank && suit == other.suit;
	}

}
