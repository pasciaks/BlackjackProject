package com.skilldistillery.blackjack.game;

import com.skilldistillery.blackjack.cards.Card;
import com.skilldistillery.blackjack.cards.Deck;

public class Dealer extends Player {

	// A dealer is a player who also has a hand of cards
	// The hand is inherited from the Player class

	private Deck deck;

	public Dealer() {
		this.deck = new Deck();
		this.shuffleDeck();
	}

	private void shuffleDeck() {
		this.deck.shuffle();
	}

	public Card dealCard() {
		return this.deck.dealCard();
	}

}
