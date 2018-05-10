package cs.blackjack.game;

import java.util.ArrayList;

public class Dealer implements User{
	private ArrayList<Card> cards;
	private boolean turnStatus;
	private int points;
	
	@Override
	public String openCards() {
		StringBuffer cardString = new StringBuffer();
		for(int i = 0; i < cards.size() - 1; i++) {			
			cardString.append(cards.get(i).toString());
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

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}
	
}
