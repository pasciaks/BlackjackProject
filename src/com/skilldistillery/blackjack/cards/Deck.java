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

	// Stack the deck for testing with predetermined cards
	// Possible future plan to load an ordered deck from a file
	public void stackTheDeck(String fileName) {
		this.cards = new ArrayList<>();
		// Dealer gets black jack
		this.cards.add(new Card(Rank.ACE, Suit.SPADES));
		this.cards.add(new Card(Rank.KING, Suit.CLUBS));
		this.cards.add(new Card(Rank.NINE, Suit.DIAMONDS));
		this.cards.add(new Card(Rank.ACE, Suit.HEARTS));
		// You get black jack
		this.cards.add(new Card(Rank.ACE, Suit.SPADES));
		this.cards.add(new Card(Rank.ACE, Suit.HEARTS));
		this.cards.add(new Card(Rank.KING, Suit.CLUBS));
		this.cards.add(new Card(Rank.NINE, Suit.DIAMONDS));
		// You and the dealer get black jack
		this.cards.add(new Card(Rank.ACE, Suit.SPADES));
		this.cards.add(new Card(Rank.ACE, Suit.HEARTS));
		this.cards.add(new Card(Rank.KING, Suit.CLUBS));
		this.cards.add(new Card(Rank.JACK, Suit.DIAMONDS));
		// example game
		this.cards.add(new Card(Rank.SIX, Suit.CLUBS));
		this.cards.add(new Card(Rank.ACE, Suit.CLUBS));
		this.cards.add(new Card(Rank.FOUR, Suit.HEARTS));
		this.cards.add(new Card(Rank.THREE, Suit.CLUBS));
		this.cards.add(new Card(Rank.EIGHT, Suit.CLUBS));
		this.cards.add(new Card(Rank.KING, Suit.DIAMONDS));
		this.cards.add(new Card(Rank.TEN, Suit.DIAMONDS));
		this.cards.add(new Card(Rank.EIGHT, Suit.DIAMONDS));
		this.cards.add(new Card(Rank.JACK, Suit.CLUBS));
		this.cards.add(new Card(Rank.QUEEN, Suit.DIAMONDS));
		this.cards.add(new Card(Rank.FIVE, Suit.CLUBS));
		this.cards.add(new Card(Rank.ACE, Suit.CLUBS));
		this.cards.add(new Card(Rank.ACE, Suit.CLUBS));
		// example game
		this.cards.add(new Card(Rank.EIGHT, Suit.DIAMONDS));
		this.cards.add(new Card(Rank.JACK, Suit.CLUBS));
		this.cards.add(new Card(Rank.QUEEN, Suit.DIAMONDS));
		this.cards.add(new Card(Rank.FIVE, Suit.CLUBS));
		this.cards.add(new Card(Rank.ACE, Suit.CLUBS));
		this.cards.add(new Card(Rank.ACE, Suit.SPADES));
		this.cards.add(new Card(Rank.TEN, Suit.HEARTS));
	}

	// If deck is < DESIRED_CARDS_REMAINING, a new deck is added
	// This new deck is adding to the existing deck and entire deck is then shuffled
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
		// Deal a card by removing the first card from the deck
		Card card = this.cards.remove(0);
		// Set the card to be face up or face down as needed
		card.setFaceUp(isFaceUp);
		// Return the card
		return card;
	}

}
