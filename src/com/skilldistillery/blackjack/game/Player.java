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

	public void showHand() {
		System.out.println(ConsoleEffect.cyan + "\nYour hand:");
		this.playerHand.showHand();
	}

	public void playTurn(Dealer dealer, Scanner keyboard) {

		while (this.playerHand.getHandValue() < 21) {

			System.out.print("\nWould you like to [1][hit] or [2][stay] ? ");

			String choice = keyboard.nextLine();

			if (choice.equals("hit") || choice.equals("1")) {
				this.addCardToHand(dealer.dealCard(true));
			} else if (choice.equals("stay") || choice.equals("2")) {
				break;
			} else {
				System.out.println("\nPlease enter [1] or 'hit' or [2] or 'stay'.");
			}

			this.showHand();

			if (this.playerHand.getHandValue() > 21) {
				System.out.println("\nYou busted!\n");
				break;
			} else if (this.playerHand.getHandValue() == 21) {
				System.out.println("\nYou have 21!\n");
				break;
			}

		}

	}

}
