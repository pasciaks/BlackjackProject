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
		// dealer.stackDeck("testDeck.txt"); // testing purposes
		// -------------------------------------------------------

		do {

			player.clearHand();
			dealer.clearHand();

			dealer.showDeck(); // if dealer is in debug mode, will show deck count

			// Initial deal

			player.addCardToHand(dealer.dealCard(true)); // face up
			dealer.addCardToHand(dealer.dealCard(false)); // face down

			player.addCardToHand(dealer.dealCard(true)); // face up
			dealer.addCardToHand(dealer.dealCard(true)); // face up

			dealer.showHand();
			player.showHand();

			boolean skipPlay = false;
			boolean doesPlayerHaveBJ = false;
			boolean doesDealerHaveBJ = false;
			boolean doesPlayerHaveInsurance = false;

			// ---------------------------------------------------------------
			// IF DEALER HAS ACE SHOWING, OFFER INSURANCE
			// ---------------------------------------------------------------
			if (dealer.isAceShowing()) {
				System.out.println(ConsoleEffect.red + "Dealer has an Ace showing.\n" + ConsoleEffect.reset);
				String wantsInsurance = askYesOrNo(
						ConsoleEffect.yellow + "Would you like to buy insurance ? (y/n) ? " + ConsoleEffect.reset,
						keyboard);
				if (wantsInsurance.equalsIgnoreCase("y")) {
					doesPlayerHaveInsurance = true;
					System.out.println(ConsoleEffect.green + "Insurance purchased." + ConsoleEffect.reset);
				} else {
					System.out.println(ConsoleEffect.red + "No insurance purchased." + ConsoleEffect.reset);
				}
			}

			// ---------------------------------------------------------------
			// IF PLAYER HAS BLACKJACK, SKIP PLAYER'S TURN
			// ---------------------------------------------------------------

			if (dealer.getHandValue() == 21) {
				doesDealerHaveBJ = true;
			}

			if (player.getHandValue() == 21) {
				System.out.println(ConsoleEffect.green + "\nYou have Blackjack!" + ConsoleEffect.reset);
				skipPlay = true;
				doesPlayerHaveBJ = true;

				if (doesDealerHaveBJ) {
					System.out.println(ConsoleEffect.red + "\nDealer also has blackjack." + ConsoleEffect.reset);
					skipPlay = true;
				}
			}

			if (!skipPlay) {

				int playerTotal = 0;

				// Player's turn
				playerTotal = player.playTurn(dealer, keyboard);

				if (playerTotal <= 21) {
					// Dealer's turn
					dealer.placeCardsFaceUp();
					dealer.playTurn(dealer, keyboard);
				}
			}

			dealer.placeCardsFaceUp();

			showGameResults(doesPlayerHaveBJ, doesDealerHaveBJ, doesPlayerHaveInsurance);

			System.out.println(ConsoleEffect.reset);

			wantsToContinuePlaying = askYesOrNo("Would you like to play again ? (y/n) ? ", keyboard);

		} while (wantsToContinuePlaying.equalsIgnoreCase("y"));

		System.out.println("\n\nGoodbye!\n\n");

		keyboard.close();

	}

	private String askYesOrNo(String question, Scanner keyboard) {
		String choice = "";
		do {
			System.out.println(question);
			choice = keyboard.nextLine().trim();
			if (choice.equalsIgnoreCase("y") || choice.equalsIgnoreCase("n")) {
				break;
			}
		} while (true);
		return choice;
	}

	private void showGameResults(boolean doesPlayerHaveBJ, boolean doesDealerHaveBJ, boolean doesPlayerHaveInsurance) {

		System.out.println("\nGame Results\n");

		dealer.showHand();
		System.out.println("Dealer's hand value: " + dealer.getHandValue() + "\n");

		player.showHand();
		System.out.println("Player's hand value: " + player.getHandValue() + "\n");

		// The following logic was left verbose for clarity

		if (doesPlayerHaveBJ && doesDealerHaveBJ) {
			System.out.println(ConsoleEffect.yellow + "\nDouble Black Jack!\n");
			return;
		}

		if (doesPlayerHaveBJ) {
			System.out.println(ConsoleEffect.green + "\nPlayer has Black Jack!\n");
			return;
		}

		if (doesDealerHaveBJ) {
			System.out.println(ConsoleEffect.red + "\nDealer has Black Jack!\n");
			if (doesPlayerHaveInsurance) {
				System.out.println(ConsoleEffect.green + "Good thing you had insurance!\n");
			} else {
				System.out.println(ConsoleEffect.red + "Too bad you didn't buy insurance!\n");
			}
			return;
		}

		if (player.getHandValue() > 21) {
			System.out.println(ConsoleEffect.red + "\nPlayer busted! Dealer Wins.\n" + ConsoleEffect.reset);
		} else if (dealer.getHandValue() > 21) {
			System.out.println(ConsoleEffect.green + "\nDealer busted! Player Wins.\n" + ConsoleEffect.reset);
		} else if (player.getHandValue() > dealer.getHandValue()) {
			System.out.println(ConsoleEffect.green + "\nPlayer wins!\n");
		} else if (player.getHandValue() < dealer.getHandValue()) {
			System.out.println(ConsoleEffect.red + "\nDealer wins!\n");
		} else {
			System.out.println(ConsoleEffect.yellow + "\nPush! No winner.\n");
		}

		return;
	}

}
