package com.skilldistillery.blackjack.cards;

import java.util.ArrayList;
import java.util.List;

public abstract class Hand {

	protected List<Card> cardsInHand = new ArrayList<>();

	public Hand() {
		// default constructor
	}

	public void addCard(Card card) {
		cardsInHand.add(card);
	}

	public void clear() {
		cardsInHand.clear();
	}

	public abstract int getHandValue();

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Hand: ");
		for (Card card : cardsInHand) {
			builder.append(card + " ");
		}
		return builder.toString();
	}

}
