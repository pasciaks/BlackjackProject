package com.skilldistillery.blackjack.game;

public class GameTable {

	// This code was worked on during this 4th week.
	// It was completed before the HW was assigned.

	// Suits = "♠ ♦ ♣ ❤"

	// ┌───┐
	// │░░░│
	// │░░░│
	// │░░░│
	// └───┘

	// ┌───┐
	// │02 │
	// │ ♣ │
	// │ 02│
	// └───┘

	private int sleepTime = 250;
	private int columns = 120;
	private int rows = 7;

	private String screenBgColor = ConsoleEffect.blackBg;
	private String screenTextColor = ConsoleEffect.white;
	private String reset = ConsoleEffect.reset;

	String[][] screenXY = new String[rows][columns];

	public void clearScreen() {
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				setScreen(i, j, screenBgColor + screenTextColor + " " + reset);
			}
		}
		sleepFor(sleepTime);
	}

	public String[][] drawCardToScreen(String[][] card, int row, int column, String bgColor, String textColor,
			String value, String suitColor, String suit, int type) {
		card = buildCardWithColor(bgColor, textColor, type);
		if (type == 1) {
			clearInsideOfCard(card, textColor, bgColor);
			drawValueToCard(card, value, textColor, bgColor);
			drawSuitToCard(card, suit, suitColor, bgColor);
		}
		placeBoxOnScreen(row, column, card);
		return card;
	}

	public void drawScreen() {
		for (int i = 0; i < rows; i++) {
			String line = "";
			for (int j = 0; j < columns; j++) {
				line += screenXY[i][j];
			}
			System.out.println(line);
		}
		System.out.println(ConsoleEffect.reset);
		sleepFor(sleepTime);
	}

	private void drawSuitToCard(String[][] card, String suit, String textColor, String backColor) {
		switch (suit) {
		case "♠":
			card[2][2] = backColor + textColor + "♠";
			break;
		case "♦":
			card[2][2] = backColor + textColor + "♦";
			break;
		case "♣":
			card[2][2] = backColor + textColor + "♣";
			break;
		case "❤":
			card[2][2] = backColor + textColor + "❤";
			break;
		}
	}

	private void clearInsideOfCard(String[][] card, String textColor, String backColor) {
		for (int i = 1; i < 4; i++) {
			for (int j = 1; j < 4; j++) {
				card[i][j] = backColor + textColor + " ";
			}
		}
	}

	private void drawValueToCard(String[][] card, String value, String textColor, String backColor) {
		String valueAsTwoCharString = String.format("%2s", value);
		clearInsideOfCard(card, textColor, backColor);
		if (valueAsTwoCharString.substring(0, 1).equals(" ")) {
			card[1][1] = backColor + textColor + valueAsTwoCharString.substring(1, 2);
		} else {
			card[1][1] = backColor + textColor + valueAsTwoCharString.substring(0, 1);
			card[1][2] = backColor + textColor + valueAsTwoCharString.substring(1, 2);
		}
		card[3][2] = backColor + textColor + valueAsTwoCharString.substring(0, 1);
		card[3][3] = backColor + textColor + valueAsTwoCharString.substring(1, 2);
	}

	private String[][] buildCardWithColor(String bgColor, String textColor, int style) {
		String cardFrame;

		switch (style) {
		case 1:
			cardFrame = "┌───┐│   ││   ││   │└───┘";
			break;
		default:
			cardFrame = "┌───┐│░░░││░░░││░░░│└───┘";
			break;
		}

		int index = 0;
		String[][] card = new String[5][5];
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				card[i][j] = "" + bgColor + textColor + cardFrame.charAt(index);
				index++;
			}
		}
		return card;
	}

	private void placeBoxOnScreen(int row, int column, String[][] box) {
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				setScreen(row + i, column + j, box[i][j]);
			}
		}
	}

	private void setScreen(int row, int column, String value) {
		screenXY[row][column] = value;
	}

	private void sleepFor(int milliseconds) {
		try {
			Thread.sleep(milliseconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
