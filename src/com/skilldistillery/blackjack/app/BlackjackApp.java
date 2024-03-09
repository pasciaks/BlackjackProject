package com.skilldistillery.blackjack.app;

import java.util.Scanner;

import com.skilldistillery.blackjack.game.Dealer;
import com.skilldistillery.blackjack.game.Player;

public class BlackjackApp {

	private Dealer dealer = new Dealer();
	private Player player = new Player();

	public static void main(String[] args) {

		BlackjackApp app = new BlackjackApp();
		app.startGame();
	}

	private void startGame() {

		Scanner keyboard = new Scanner(System.in);

		System.out.println("Welcome to Blackjack!");

		dealer.shuffleDeck();

		String wantsToContinuePlaying = "y";

		dealer.stackDeck("testDeck.txt"); // testing purposes

		do {

			player.clearHand();
			dealer.clearHand();

			// initial deal

			player.addCardToHand(dealer.dealCard(true)); // face up
			dealer.addCardToHand(dealer.dealCard(false)); // face down

			player.addCardToHand(dealer.dealCard(true)); // face up
			dealer.addCardToHand(dealer.dealCard(true)); // face up

			dealer.showHand();
			player.showHand();

			// check for player blackjack

			if (player.getHandValue() == 21) {

				System.out.println("Blackjack! You win!");

			} else {

				player.playTurn(dealer, keyboard);

				dealer.placeCardsFaceUp();

				// if player did not bust, dealer plays turn
				if (player.getHandValue() <= 21) {
					dealer.playTurn(dealer, keyboard);
				}
			}

			showGameResults();

			System.out.print("\nWould you like to play again? (y/N) ? ");

			wantsToContinuePlaying = keyboard.nextLine().trim();

		} while (wantsToContinuePlaying.equalsIgnoreCase("y"));

		System.out.println("\n\nGoodbye!\n\n");

		keyboard.close();

	}

	private void showGameResults() {

		System.out.println("\nGame Results\n");

		dealer.showHand();
		System.out.println("Dealer's hand value: " + dealer.getHandValue() + "\n");

		player.showHand();
		System.out.println("Player's hand value: " + player.getHandValue() + "\n");

		if (player.getHandValue() > 21) {
			System.out.println("\nYou busted!\n");
		} else if (dealer.getHandValue() > 21) {
			System.out.println("\nDealer busted!\n" + "\nYou win!");
		} else if (player.getHandValue() > dealer.getHandValue()) {
			System.out.println("\nPlayer wins!\n");
		} else if (player.getHandValue() < dealer.getHandValue()) {
			System.out.println("\nDealer wins!\n");
		} else {
			System.out.println("\nPush! No winner.\n");
		}
	}

}
