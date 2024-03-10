package com.skilldistillery.blackjack.game;

import java.util.Scanner;

import com.skilldistillery.blackjack.cards.Card;
import com.skilldistillery.blackjack.cards.Deck;

public class Dealer extends Player {

	// A dealer is a player who also has a hand of cards
	// The hand is inherited from the Player class

	private Deck deck;

	// If true, the deck counts will be shown
	private boolean isDebugMode = false;

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

	// If isDebugMode - Card counting for debug purposes + more!
	public void setIDebugMode(boolean isDebugMode) {
		this.isDebugMode = isDebugMode;
	}

	// If isDebugMode - Card counting for debug purposes + more!
	public void showDeck() {
		// Card counting for debug purposes + more!
		if (isDebugMode) {
			this.deck.showDeck();
		}
	}

	public Card dealCard(boolean isFaceUp) {
		Card card = this.deck.dealCard(isFaceUp);
		if (isDebugMode) {
			if (isFaceUp) {
				System.out.println(ConsoleEffect.black + "Dealer deals " + card);
			} else {
				System.out.println(ConsoleEffect.black + "Dealer deals a card face down");
			}
			System.out.println(ConsoleEffect.black + " " + this.deck.checkDeckSize() + " cards left in the deck."
					+ ConsoleEffect.reset);
		}

		return card;
	}

	public void stackDeck(String fileName) {
		this.deck.stackTheDeck(fileName);
	}

	@Override
	public void showHand() {
		System.out.println(ConsoleEffect.cyan + "Dealer hand:");
		this.playerHand.showHand();
	}

	@Override
	public int playTurn(Dealer dealer, Scanner keyboard) {

		this.showHand();
		dealer.showDeck(); // if dealer is in debug mode, will show deck count

		System.out.println("\nThe Dealer Has " + this.playerHand.getHandValue() + " ! ");

		while (this.playerHand.getHandValue() < 17) {

			System.out.println("\nThe Dealer Has " + this.playerHand.getHandValue() + " and must take a hit! ");

			this.addCardToHand(this.dealCard(true));

			this.showHand();
			dealer.showDeck(); // if dealer is in debug mode, will show deck count

			if (this.playerHand.getHandValue() > 21) {
				System.out.println("\nThe Dealer Has " + this.playerHand.getHandValue() + " and has busted! ");
				break;
			}

			System.out.println("\nThe Dealer Has " + this.playerHand.getHandValue() + " ! ");

		}

		return this.playerHand.getHandValue();

	}

}
