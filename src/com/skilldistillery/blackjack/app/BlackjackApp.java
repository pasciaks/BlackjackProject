package com.skilldistillery.blackjack.app;

import java.util.Scanner;

import com.skilldistillery.blackjack.game.ConsoleEffect;
import com.skilldistillery.blackjack.game.Dealer;
import com.skilldistillery.blackjack.game.Player;

public class BlackjackApp {

	private Dealer dealer = new Dealer();
	private Player player = new Player();

	public static void main(String[] args) {

		System.out.println("Welcome to Blackjack!");

		System.out.println("----------------------------------------------------------------------------");
		System.out.println("- TODO - carefully check play logic, blackjacks and assignment instructions-");
		System.out.println("- TODO - carefully check play logic, blackjacks and assignment instructions-");
		System.out.println("- TODO - carefully check play logic, blackjacks and assignment instructions-");
		System.out.println("- TODO - carefully check play logic, blackjacks and assignment instructions-");
		System.out.println("----------------------------------------------------------------------------");

		BlackjackApp app = new BlackjackApp();

		app.startGame();
	}

	private void startGame() {

		Scanner keyboard = new Scanner(System.in);

		dealer.shuffleDeck();

		String wantsToContinuePlaying = "y";

		// -------------------------------------------------------
		// Possible plan to load/save a deck for testing/competing
		// -------------------------------------------------------
		dealer.stackDeck("testDeck.txt"); // testing purposes
		// -------------------------------------------------------

		do {

			player.clearHand();
			dealer.clearHand();

			// Initial deal

			player.addCardToHand(dealer.dealCard(true)); // face up
			dealer.addCardToHand(dealer.dealCard(false)); // face down

			player.addCardToHand(dealer.dealCard(true)); // face up
			dealer.addCardToHand(dealer.dealCard(true)); // face up

			dealer.showHand();
			player.showHand();

			boolean hasInsurance = false;
			boolean skipPlay = false;

			// -------------------------------------------------------
			// IF DEALER HAS ACE SHOWING, OFFER INSURANCE
			// -------------------------------------------------------
			if (dealer.isAceShowing()) {
				System.out.print("\nWould you like to buy insurance? (y/N) ? ");
				String wantsInsurance = keyboard.nextLine().trim();
				if (wantsInsurance.equalsIgnoreCase("y")) {
					System.out.println(ConsoleEffect.red + "\nInsurance purchased." + ConsoleEffect.reset);
					hasInsurance = true;
					if (dealer.getHandValue() == 21) {
						System.out.println(ConsoleEffect.red + "\nDealer has blackjack." + ConsoleEffect.reset);
						skipPlay = true;
					}
				} else {
					if (dealer.getHandValue() == 21) {
						System.out.println(ConsoleEffect.red + "\nDealer has blackjack." + ConsoleEffect.reset);
						skipPlay = true;
					}
				}
			}
			// ------------------------------------------------------------
			// NOT CERTAIN OF GAME INSURANCE RULES SO LEFT IT VERBOSE ABOVE
			// ------------------------------------------------------------

			if (!skipPlay) {

				if (player.getHandValue() == 21) {

					System.out.println(ConsoleEffect.red + "\nBlackjack! You win!" + ConsoleEffect.reset);

					if (dealer.getHandValue() == 21) {
						System.out.println(
								ConsoleEffect.red + "\nDealer also has blackjack. Push!" + ConsoleEffect.reset);
					}

				} else {

					player.playTurn(dealer, keyboard);

					dealer.placeCardsFaceUp();

					if (player.getHandValue() <= 21) {
						dealer.playTurn(dealer, keyboard);
					}
				}

			}

			dealer.placeCardsFaceUp();

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
