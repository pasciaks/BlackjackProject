package com.skilldistillery.blackjack.app;

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

	}

}
