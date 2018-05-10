package cs.blackjack.game;

import java.util.Collections;
import java.util.Stack;

public class CardDeck {
	private Stack<Card> cards;
	private int cardCount = 13;
	private String[] patterns = {"SPADE", "HEART", "CLOVER", "DIAMOND"};
	enum Denominations{
		TWO("2");
		
		private String denomination;
		
		private Denominations(String denomination) {
			this.denomination = denomination;
		}
		
		public String getDenomination() {
			return denomination;
		}
	}

	public CardDeck() {
		this.cards = generateCardDeck();
		Collections.shuffle(this.cards);
	}
	
//	카드덱 생성
	private Stack<Card> generateCardDeck() {
		Stack<Card> newCards = new Stack<>();
		for(String pattern : patterns) {
			for(int i = 1; i <= cardCount; i++) {
				String denomination;
				if(i == 1) {
					denomination = "A";
				} else if(i == 11) {
					denomination = "J";
				} else if(i == 12) {
					denomination = "Q";
				} else if(i == 13) {
					denomination = "K";
				} else {
					denomination = String.valueOf(i);
				}
				
				newCards.push(new Card(pattern, denomination));
			}
		}
		return newCards;
	}
	
//	카드 한 장씩 뽑기
	public Card drawCard() {
		return cards.pop();
	}
}
