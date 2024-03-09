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

		dealer.stackDeck("testDeck.txt"); // testing purposes

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

		keyboard.close();

	}

	private void showGameResults() {

		System.out.println("\n\nGame Results\n");

		System.out.println("Dealer's hand: ");

		dealer.showHand();
		System.out.println("Dealer's hand value: " + dealer.getHandValue() + "\n");

		System.out.println("Player's hand: ");

		player.showHand();
		System.out.println("Player's hand value: " + player.getHandValue() + "\n");

		if (player.getHandValue() > 21) {
			System.out.println("You busted!");
		} else if (dealer.getHandValue() > 21) {
			System.out.println("Dealer busted!" + "\nYou win!");
		} else if (player.getHandValue() > dealer.getHandValue()) {
			System.out.println("Player wins!");
		} else if (player.getHandValue() < dealer.getHandValue()) {
			System.out.println("Dealer wins!");
		} else {
			System.out.println("Push!");
		}
	}

}
