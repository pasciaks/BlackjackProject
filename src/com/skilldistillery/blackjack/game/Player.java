package com.skilldistillery.blackjack.game;

import java.util.Scanner;

import com.skilldistillery.blackjack.cards.Card;
import com.skilldistillery.blackjack.cards.Hand;

public class Player {

	protected Hand playerHand = new BlackjackHand();

	// add card to player's hand
	public void addCardToHand(Card card) {
		this.playerHand.addCard(card);
	}

	// clear player's hand
	public void clearHand() {
		this.playerHand.clear();
	}

	public int getHandValue() {
		return this.playerHand.getHandValue();
	}

	public boolean isAceShowing() {
		return this.playerHand.isAceShowing();
	}

	public void showHand() {
		System.out.println(ConsoleEffect.cyan + "Player hand:");
		this.playerHand.showHand();
	}

	public int playTurn(Dealer dealer, Scanner keyboard) {

		while (this.playerHand.getHandValue() < 21) {

			dealer.showDeck(); // if dealer is in debug mode, will show deck count

			System.out.println("\nWould you like to [1][hit] or [2][stand] ? ");

			String choice = keyboard.nextLine().trim();

			if (choice.equalsIgnoreCase("hit") || choice.equals("1")) {
				System.out.println(ConsoleEffect.yellow + "\nYou chose to hit.\n" + ConsoleEffect.reset);
				this.addCardToHand(dealer.dealCard(true));
			} else if (choice.equalsIgnoreCase("stand") || choice.equals("2")) {
				System.out.println(ConsoleEffect.yellow + "\nYou chose to stand.\n" + ConsoleEffect.reset);
				break;
			} else {
				System.out.println("\nPlease enter [1] or 'hit' or [2] or 'stand'.");
			}

			dealer.showHand();

			this.showHand();

			if (this.playerHand.getHandValue() > 21) {
				System.out.println("\nYou busted!\n");
				break;
			} else if (this.playerHand.getHandValue() == 21) {
				System.out.println("\nYou have 21!\n");
				break;
			}

		}

		return this.playerHand.getHandValue();

	}

}
