package com.skilldistillery.blackjack.cards;

import java.util.Objects;

public class Card {

	private Rank rank;
	private Suit suit;

	private boolean isFaceUp = false;

	public Card(Rank rank, Suit suit) {
		this.rank = rank;
		this.suit = suit;
	}

	public Rank getRank() {
		return rank;
	}

	public Suit getSuit() {
		return suit;
	}

	public int getValue() {
		return this.rank.getValue();
	}

	public boolean isFaceUp() {
		return isFaceUp;
	}

	public void setFaceUp(boolean isFaceUp) {
		this.isFaceUp = isFaceUp;
	}

	@Override
	public String toString() {
		return this.rank + " of " + this.suit;
	}

	public String showCard() {
		if (isFaceUp) {
			return rank + " of " + suit;
		} else {
			return "Face Down";
		}
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
