package cs.blackjack.game;

import java.util.Collections;
import java.util.Stack;

public class CardDeck {
	private Stack<Card> cards;

	public CardDeck() {
		this.cards = generateCardDeck();
		Collections.shuffle(this.cards);
	}
	
	private Stack<Card> generateCardDeck() {
		Stack<Card> newCards = new Stack<>();
		
		return newCards;
	}
}
