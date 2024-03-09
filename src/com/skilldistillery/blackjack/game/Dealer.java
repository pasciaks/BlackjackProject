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
			System.out.println(ConsoleEffect.black + "Dealer deals " + card);
		} else {
			System.out.println(ConsoleEffect.black + "Dealer deals a card face down");
		}
		return card;
	}

	public void stackDeck(String fileName) {
		this.deck.stackTheDeck(fileName);
	}

	public boolean isAceShowing() {
		return this.playerHand.isAceShowing();
	}

	@Override
	public void showHand() {
		System.out.println(ConsoleEffect.cyan + "\nDealer hand:");
		this.playerHand.showHand();
	}

	@Override
	public void playTurn(Dealer dealer, Scanner keyboard) {

		this.showHand();

		System.out.println("\nThe Dealer Has " + this.playerHand.getHandValue() + " ! ");

		while (this.playerHand.getHandValue() < 17) {

			System.out.println("\nThe Dealer Has " + this.playerHand.getHandValue() + " and must take a hit! ");

			this.addCardToHand(this.dealCard(true));

			this.showHand();

			if (this.playerHand.getHandValue() > 21) {
				System.out.println("\nThe Dealer Has " + this.playerHand.getHandValue() + " and has busted! ");
				break;
			}

			System.out.println("\nThe Dealer Has " + this.playerHand.getHandValue() + " ! ");

		}

	}

}
