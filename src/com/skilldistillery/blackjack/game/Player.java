package com.skilldistillery.blackjack.game;

import com.skilldistillery.blackjack.cards.Card;
import com.skilldistillery.blackjack.cards.Hand;

public class Player {

	protected Hand playerHand = new BlackjackHand();

	// add card to player's hand
	public void addCardToHand(Card card) {
		playerHand.addCard(card);
	}

}
