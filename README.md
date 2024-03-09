# BlackjackProject

#### Description

- This is the 4th week homework assignment for Skill Distillery, Full Stack Development.


- Use classes to create a working command line blackjack game.

#### Technologies Used
	- JAVA
	- Eclipse
	- Git/GitHub
	- Sublime Text Editor
	- Zsh

#### Learning Objectives
- Building classes in an Object-Oriented manner: APIE.
- Building classes whose fields are Objects (has-a).
- Writing methods.
- Using collections to organize and manage data.
- Using conditionals to create game logic.
- Considering common data and behaviors, and refactoring into parent / child classes.
	
#### Lessons Learned
    - Attention to detail, read and re-read requirements.
	- Commit early, commit often, and push!
	- Start with what you know.
	
#### Notes

 Additional time could be put in to re factor some code to make it more DRY.
 
 Appropriate comments have been added to source code so if time allows these additional modifications can be implemented.
 
 Future potential to add the ability to save and load a specific deck, implement betting, etc. Saving a game deck would be a way to revisit the previous played sessions.  This would provide the chance to compete with previous players and their scores for that specific deck.
 
#### Display enhancement for user experience.

- Rather than just displaying text versions of cards, I implemented a very involved console window (System.out) class that can be used to generate text in row,column positions that will show text with background and foreground colors. This enabled a nice display of the cards for a surprising console application user experience.


- The following screen shot example demonstrations the initial deal.  Note that the cards are delt to the Player, then the Dealer, then the Player, and finally to the dealer.  The dealer's first card is dealt face-down.

![Example Play](game1.png)

- The following screen shot example demonstrates the smart Ace counting implementation.  An Ace is valued at either an 11 or a 1 depending on the current total as appropriate use for the Ace value in the hand.

![Example Play](game2.png)

#### Sleeper thread for user Interaction and Simulation experience.

-Implementing a sleeper thread to simulate gameplay was beneficial to actually simulate gameplay.

	
```JAVA

	private void sleepFor(int milliseconds) {
		try {
			Thread.sleep(milliseconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
```
	
# Partial starting UML that helps demonstrate the start of the project

![Black Jack UML](partial-uml.png)
	
	