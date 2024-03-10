package com.skilldistillery.blackjack.testing;

import java.util.Scanner;

import com.skilldistillery.blackjack.game.Dealer;

public class TestingApp {

	public static void main(String[] args) {

		TestingApp testingApp = new TestingApp();
		testingApp.test();
	}

	private void test() {

		Scanner keyboard = new Scanner(System.in);

		System.out.println("\n\nTesting started.");

		waitForEnter(keyboard);
		showDeckCount();

		waitForEnter(keyboard);
		dealEntireDeck();

		waitForEnter(keyboard);
		dealStackedDeck();

		System.out.println("\n\nTesting complete.");

		keyboard.close();

	}

	private void waitForEnter(Scanner keyboard) {
		System.out.println("\nPress Enter to continue...\n");
		keyboard.nextLine();
		System.out.println();
		System.out.println();

	}

	private void showDeckCount() {

		Dealer dealer = new Dealer();

		dealer.setIDebugMode(true);

		System.out.println("-----------------------------------------------------------");
		System.out.println("Deck count");
		System.out.println("-----------------------------------------------------------");

		dealer.showDeck();

		System.out.println("-----------------------------------------------------------");
		System.out.println("-----------------------------------------------------------");

	}

	private void dealEntireDeck() {

		Dealer dealer = new Dealer();

		dealer.setIDebugMode(true);

		for (int i = 0; i < 52; i++) {
			dealer.addCardToHand(dealer.dealCard(true));
		}

	}

	private void dealStackedDeck() {

		Dealer dealer = new Dealer();

		dealer.setIDebugMode(true);

		System.out.println("Dealer stacks the deck.");

		dealer.stackDeck("testDeck.txt");

		dealer.clearHand();

		dealer.addCardToHand(dealer.dealCard(false));

		dealer.addCardToHand(dealer.dealCard(true));

		System.out.println("Show Dealer's hand:");

		dealer.showHand();

		System.out.println("Place Dealer's Cards Face Up and Show Dealer's Hand:");

		dealer.placeCardsFaceUp();

		dealer.showHand();
	}

}
