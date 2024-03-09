package com.skilldistillery.blackjack.cards;

import java.util.ArrayList;
import java.util.List;

public abstract class Hand {

	protected List<Card> cardsInHand = new ArrayList<>();

	public void addCard(Card card) {
		cardsInHand.add(card);
	}

	public void clear() {
		cardsInHand.clear();
	}

	public abstract int getHandValue();

	public void placeCardsFaceUp() {
		for (Card card : cardsInHand) {
			card.setFaceUp(true);
		}
	}

	public void showHand() {
		for (Card card : cardsInHand) {
			card.showCard();
		}
		System.out.println();
	}

}
