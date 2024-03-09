package com.skilldistillery.blackjack.game;

import com.skilldistillery.blackjack.cards.Card;
import com.skilldistillery.blackjack.cards.Hand;

public class BlackjackHand extends Hand {

	@Override
	public int getHandValue() {
		int totalValue = 0;
		for (Card card : cardsInHand) {
			totalValue += card.getValue();
		}
		if (totalValue > 21) {
			int acesUsedAsOnes = 0;
			while (totalValue > 21 && acesUsedAsOnes < totalAces()) {
				totalValue -= 10;
			}
		}
		// System.out.println("\nTotal value of hand: " + totalValue);
		return totalValue;
	}

	private int totalAces() {
		int numberOfAces = 0;
		for (Card card : cardsInHand) {
			if (card.getRank().toString().equals("ACE")) {
				numberOfAces++;
			}
		}
		return numberOfAces;
	}

	public boolean isHard() {
		// A hand is hard if it has no aces, or if it has aces, they are all valued at 1
		return false;
	}

	public boolean isSoft() {
		// A hand is soft if it has aces, and at least one ace is valued at 11
		return false;
	}

}
