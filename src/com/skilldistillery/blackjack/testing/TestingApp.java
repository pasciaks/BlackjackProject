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
		dealStackedBlackJackDeck();

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

		dealer.setInDebugMode(true);

		System.out.println("-----------------------------------------------------------");
		System.out.println("Deck count");
		System.out.println("-----------------------------------------------------------");

		dealer.showDeck();

		System.out.println("-----------------------------------------------------------");
		System.out.println("-----------------------------------------------------------");

	}

	private void dealEntireDeck() {

		Dealer dealer = new Dealer();

		dealer.setInDebugMode(true);

		for (int i = 0; i < 52; i++) {
			dealer.addCardToHand(dealer.dealCard(true));
		}

	}

	private void dealStackedBlackJackDeck() {

		Dealer dealer = new Dealer();

		dealer.setInDebugMode(true);

		System.out.println("Dealer stacks the deck.");

		dealer.stackDeck("testDeck.txt");

		int originalDeckSize = dealer.checkDeckSize();

		System.out.println("Original deck size: " + originalDeckSize);

		int numberOfCardsToDeal = 2;

		int currentHandIndex = 0;

		for (int i = 0; i < Math.floor(0 + (originalDeckSize / numberOfCardsToDeal)); i++) {
			dealer.clearHand();

			for (int j = 0; j < numberOfCardsToDeal; j++) {
				dealer.addCardToHand(dealer.dealCard(j == 0 ? false : true));
			}

			System.out.println("Show Dealer's hand: " + ++currentHandIndex);

			dealer.showHand();

			System.out.println("Place Dealer's Cards Face Up and Show Dealer's Hand:");

			dealer.placeCardsFaceUp();

			dealer.showHand();
		}
	}

	private void dealStackedDeck() {

		Dealer dealer = new Dealer();

		dealer.setInDebugMode(true);

		int originalDeckSize = dealer.checkDeckSize();

		System.out.println("Original deck size: " + originalDeckSize);

		boolean isFaceUp = true;
		int numberOfCardsToDeal = (int) (2 + Math.floor(Math.random() * 5));
		int currentHandIndex = 0;

		for (int i = 0; i < Math.floor(0 + (originalDeckSize / numberOfCardsToDeal)); i++) {
			dealer.clearHand();

			for (int j = 0; j < numberOfCardsToDeal; j++) {
				if (Math.random() < 0.5) {
					isFaceUp = !isFaceUp;
				}
				dealer.addCardToHand(dealer.dealCard(isFaceUp));
			}

			System.out.println("Show Dealer's hand: " + ++currentHandIndex);

			dealer.showHand();

			System.out.println("Place Dealer's Cards Face Up and Show Dealer's Hand:");

			dealer.placeCardsFaceUp();

			dealer.showHand();
		}
	}

}
