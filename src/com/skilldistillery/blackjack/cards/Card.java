package com.skilldistillery.blackjack.cards;

import java.util.Objects;

import com.skilldistillery.blackjack.game.ConsoleEffect;
import com.skilldistillery.blackjack.game.GameTable;

public class Card {

	private String bgColor = ConsoleEffect.whiteBg;
	private String textColor = ConsoleEffect.blue;

	private Rank rank;
	private Suit suit;

	private String[][] cardSpace = new String[5][5];

	private boolean isFaceUp = false;

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

	private String translateSuitToColor(String oldSuit) {
		String newColor = "" + ConsoleEffect.blue;
		switch (oldSuit) {
		case "Spades":
		case "Clubs":
			newColor = ConsoleEffect.black;
			break;
		case "Diamonds":
		case "Hearts":
			newColor = ConsoleEffect.red;
			break;
		default:
			break;
		}
		return newColor;
	}

	private String translateSuit(String oldSuit) {
		String newSuit = "" + oldSuit;
		switch (oldSuit) {
		case "Spades":
			newSuit = "♠";
			break;
		case "Diamonds":
			newSuit = "♦";
			break;
		case "Clubs":
			newSuit = "♣";
			break;
		case "Hearts":
			newSuit = "❤";
			break;
		default:
			break;
		}
		return newSuit;
	}

	private int translateIsFaceUp(boolean isFaceUp) {
		return isFaceUp ? 1 : 0;
	}

	// This is verbose and could be re factored in new iteration
	private String translateRank(String oldRank) {

		// TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6), SEVEN(7), EIGHT(8), NINE(9),
		// TEN(10), JACK(10), QUEEN(10), KING(10), ACE(11);
		String newRank = "" + oldRank;
		switch (oldRank) {
		case "TWO":
			newRank = "2";
			break;
		case "THREE":
			newRank = "3";
			break;
		case "FOUR":
			newRank = "4";
			break;
		case "FIVE":
			newRank = "5";
			break;
		case "SIX":
			newRank = "6";
			break;
		case "SEVEN":
			newRank = "7";
			break;
		case "EIGHT":
			newRank = "8";
			break;
		case "NINE":
			newRank = "9";
			break;
		case "TEN":
			newRank = "10";
			break;
		case "JACK":
			newRank = "J";
			break;
		case "QUEEN":
			newRank = "Q";
			break;
		case "KING":
			newRank = "K";
			break;
		case "ACE":
			newRank = "A";
			break;
		default:
			break;
		}

		return newRank;
	}

	public void showCard(int index, GameTable gameTable) {
		System.out.println(this.toString() + " ");
		gameTable.drawCardToScreen(cardSpace, 1, 1 + index * 6, bgColor, textColor,
				this.translateRank(this.rank.toString()), this.translateSuitToColor(this.suit.toString()),
				this.translateSuit(this.suit.toString()), this.translateIsFaceUp(this.isFaceUp));
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
