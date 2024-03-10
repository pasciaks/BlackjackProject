package com.skilldistillery.blackjack.game;

public interface ConsoleEffect {

//	Text Format:
	public static final String reset = "\u001B[0m";
	public static final String bold = "\u001B[1m";
	public static final String underline = "\u001B[4m";

//	Text Colors:
	public static final String black = "\u001B[30m";
	public static final String red = "\u001B[31m";
	public static final String green = "\u001B[32m";
	public static final String yellow = "\u001B[33m";
	public static final String blue = "\u001B[34m";
	public static final String magenta = " \u001B[35m";
	public static final String cyan = "\u001B[36m";
	public static final String white = "\u001B[37m";

//	Background colors
	public static final String blackBg = "\u001B[40m";
	public static final String redBg = "\u001B[41m";
	public static final String greenBg = "\u001B[42m";
	public static final String yellowBg = "\u001B[43m";
	public static final String blueBg = "\u001B[44m";
	public static final String magentaBg = "\u001B[45m";
	public static final String cyanBg = "\u001B[46m";
	public static final String whiteBg = "\u001B[47m";

}