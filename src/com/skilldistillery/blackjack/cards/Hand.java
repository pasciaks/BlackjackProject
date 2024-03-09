package com.skilldistillery.blackjack.cards;

import java.util.ArrayList;
import java.util.List;

import com.skilldistillery.blackjack.game.GameTable;

public abstract class Hand {

	protected List<Card> cardsInHand = new ArrayList<>();

	private GameTable gameTable = new GameTable();

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
		this.gameTable.clearScreen();
		int index = 0;
		for (Card card : cardsInHand) {
			card.showCard(index++, gameTable);
		}
		this.gameTable.drawScreen();
	}

	public boolean isAceShowing() {
		for (Card card : cardsInHand) {
			if (card.getRank().toString().equals("ACE") && card.isFaceUp()) {
				return true;
			}
		}
		return false;
	}

	public int countOfCardsInHand() {
		return cardsInHand.size();
	}

}
