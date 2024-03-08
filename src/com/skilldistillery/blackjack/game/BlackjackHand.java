package com.skilldistillery.blackjack.game;

import com.skilldistillery.blackjack.cards.Hand;

public class BlackjackHand extends Hand {

	@Override
	public int getHandValue() {
		return 0;
	}

	// Opening blackjack hand only 1st two cards equal 21

	public boolean isHard() {
		// A hand is hard if it has no aces, or if it has aces, they are all valued at 1
		return false;
	}

	public boolean isSoft() {
		// A hand is soft if it has aces, and at least one ace is valued at 11
		return false;
	}

}
