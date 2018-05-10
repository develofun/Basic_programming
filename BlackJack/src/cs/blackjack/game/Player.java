package cs.blackjack.game;

import java.util.ArrayList;

public class Player implements User{
	private ArrayList<Card> cards;
	private boolean turnStatus;
	
	@Override
	public String openCards() {
		StringBuffer cardString = new StringBuffer();
		for(Card card : cards) {
			cardString.append(card.toString());
		}		
		return cardString.toString();
	}

	@Override
	public boolean isStay() {
		return turnStatus;
	}

	@Override
	public void receiveCard(Card card) {
		cards.add(card);
	}

	@Override
	public void changeTurnStatus() {
		turnStatus = true;		
	}
	
}
