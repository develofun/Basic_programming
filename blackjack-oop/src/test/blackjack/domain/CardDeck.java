package test.blackjack.domain;

import java.util.ArrayList;
import java.util.List;

public class CardDeck {
	private List<Card> Cards;
	
	public CardDeck() {}

	

	public List<Card> generateCardDeck() {
		List<Card> makeNewCards = new ArrayList<Card>();
		Card card = new Card();
		for(String pattern : card.getPatterns()) {
			for(String denomination : card.getDenominations()) {
				makeNewCards.add(new Card(pattern, denomination));
			}
		}
		
		return makeNewCards;
	}
	
	public Card drawACard() {
		Card card = Cards.get(0);
		Cards.remove(0);
		return card;
	}
	
}
