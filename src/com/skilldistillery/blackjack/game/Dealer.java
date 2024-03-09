package com.skilldistillery.blackjack.game;

import java.util.Scanner;

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

	public void shuffleDeck() {
		this.deck.shuffle();
	}

	public void placeCardsFaceUp() {
		this.playerHand.placeCardsFaceUp();
	}

	public Card dealCard(boolean isFaceUp) {
		Card card = this.deck.dealCard(isFaceUp);
		if (isFaceUp) {
			// System.out.println("\nDealer deals " + card);
		} else {
			// System.out.println("\nDealer deals a card face down");
		}
		return card;
	}

	public void stackDeck(String fileName) {
		this.deck.stackTheDeck(fileName);
	}

	@Override
	public void playTurn(Dealer dealer, Scanner keyboard) {

		System.out.println("\n\nDealer's hand\n");
		this.showHand();

		while (this.playerHand.getHandValue() < 17) {

			System.out.println("\nThe Dealer Has " + this.playerHand.getHandValue() + " and must take a hit! ");

			this.addCardToHand(this.dealCard(true));

			System.out.println("\n\nDealer's hand: ");
			this.showHand();

		}

	}

}
