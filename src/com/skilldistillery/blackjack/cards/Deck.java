package com.skilldistillery.blackjack.cards;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {

	private static final int DESIRED_CARDS_REMAINING = 1;

	List<Card> cards;

	public Deck() {
		this.cards = createDeck();
	}

	private List<Card> createDeck() {
		List<Card> deck = new ArrayList<>();
		for (Suit suit : Suit.values()) {
			for (Rank rank : Rank.values()) {
				deck.add(new Card(rank, suit));
			}
		}
		return deck;
	}

	public int checkDeckSize() {
		return this.cards.size();
	}

	public void shuffle() {
		Collections.shuffle(this.cards);
	}

	// Future plan to load an ordered deck for testing
	public void stackTheDeck(String fileName) {
		this.cards = new ArrayList<>();

		this.cards.add(new Card(Rank.TEN, Suit.CLUBS));
		this.cards.add(new Card(Rank.ACE, Suit.CLUBS));
		this.cards.add(new Card(Rank.TEN, Suit.CLUBS));
		this.cards.add(new Card(Rank.ACE, Suit.CLUBS));
		this.cards.add(new Card(Rank.ACE, Suit.CLUBS));

		// for (Suit suit : Suit.values()) {
		// for (Rank rank : Rank.values()) {
		// this.cards.add(new Card(rank, suit));
		// }
		// }

		// this.cards = createDeck();
		// this.shuffle();
	}

	// If deck is < DESIRED_CARDS_REMAINING, a new deck is added and shuffled
	public Card dealCard(boolean isFaceUp) {
		if (checkDeckSize() < DESIRED_CARDS_REMAINING) {
			System.out.println("Adding cards to deck and reshuffling.");
			for (Suit suit : Suit.values()) {
				for (Rank rank : Rank.values()) {
					this.cards.add(new Card(rank, suit));
				}
			}
			this.shuffle();
		}
		Card card = this.cards.remove(0);
		card.setFaceUp(isFaceUp);
		return card;
	}

}
