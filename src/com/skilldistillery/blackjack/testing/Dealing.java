package com.skilldistillery.blackjack.testing;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.skilldistillery.blackjack.cards.Card;
import com.skilldistillery.blackjack.cards.Deck;

public class Dealing {

	public static void main(String[] args) {

		Dealing dealer = new Dealing();
		dealer.launch();
	}

	public void launch() {

		Deck deck = new Deck();

		showDeckSize(deck);

		deck.shuffle();

		showDeckSize(deck);

		Scanner keyboard = new Scanner(System.in);

		int howManyCards = 0;

		do {
			try {
				System.out.print("How many cards would you like to play with ? ");
				howManyCards = Integer.parseInt(keyboard.nextLine());
				if (howManyCards < 1 || howManyCards > 52) {
					throw new IllegalArgumentException();
				}
				break; // if no exceptions, exit loop with chosen value
			} catch (Exception e) {
				System.out.print("Invalid value, Please enter a number 1-52!\n");
			}
		} while (true);

		List<Card> yourHand = new ArrayList<>();

		for (int i = 0; i < howManyCards; i++) {
			yourHand.add(deck.dealCard());
		}

		int handValue = 0;

		for (Card card : yourHand) {
			handValue += card.getValue();
			System.out.println(card);
		}

		System.out.println("Your hand value is: " + handValue);

		showDeckSize(deck);

		keyboard.close();

	}

	private void showDeckSize(Deck deck) {
		System.out.println("Deck size is: " + deck.checkDeckSize());
	}

}
