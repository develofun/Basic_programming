package test.blackjack.domain;

import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class CardDeck {
	private Stack<Card> cards;
	private String[] patterns = {"spade","clover","heart","diamond"};
	private String[] denominations = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
	
	public CardDeck() {
		this.cards = this.generateNewCards();
		Collections.shuffle(this.cards);
	}

	public Stack<Card> generateNewCards() {
		Stack<Card> newCards = new Stack<>();
		for(String pattern : patterns) {
			for(String denomination : denominations) {
				newCards.push(new Card(pattern, denomination));
			}
		}
		return newCards;
	}
	
	public Card drawACard() {
		Card card = cards.pop();
		return card;
	}
	
	public List<Card> getCards() {
		return cards;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		for(Card card : cards) {
			sb.append("["+card.getPattern()+"_"+card.getDenomination()+"]");
		}
		
		return sb.toString();
	}

}
