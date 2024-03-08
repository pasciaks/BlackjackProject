package com.skilldistillery.blackjack.cards;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {

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
		System.out.println(this.cards.size());
		return this.cards.size();
	}

	public void shuffle() {
		Collections.shuffle(this.cards);
	}

	public Card dealCard() {
		return this.cards.remove(0);
	}

	// Uses new to create and store new reference
	public void addAsNewCard(Rank rank, Suit suit) {
		this.cards.add(new Card(rank, suit));
	}

	// Calls the addAsNewCard method to create and store new reference
	public void addAsNewCard(Card card) {
		this.addAsNewCard(card.getRank(), card.getSuit());
	}

	// Calls the addAsNewCard method to create and store new reference
	public void addDeckOfCardsAsNewCards(Deck deck) {
		for (Card card : deck.cards) {
			this.addAsNewCard(card);
		}
	}

}
