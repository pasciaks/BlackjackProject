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
				acesUsedAsOnes++;
			}
		}
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

}
