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
		this.playerHand.showHand();
	}

	public void playTurn(Dealer dealer, Scanner keyboard) {

		while (this.playerHand.getHandValue() < 21) {

			System.out.print("\nWould you like to [hit] or [stay] ? ");

			String choice = keyboard.nextLine();

			if (choice.equals("hit")) {
				this.addCardToHand(dealer.dealCard(true));
			} else if (choice.equals("stay")) {
				break;
			} else {
				System.out.println("\nPlease enter 'hit' or 'stay'.");
			}

			System.out.println("\nYour hand\n");
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
