package test.blackjack.domain;

import java.util.ArrayList;
import java.util.List;

public class Dealer implements Player{
	private List<Card> cards;
	private boolean turnAction;
	private String name = "딜러";
	
	public Dealer() {
		this.cards = new ArrayList<>();
	}
	
	@Override
	public void recieveACard(Card card) {
		cards.add(card);
	}

	@Override
	public boolean isStay() {
		return turnAction;
	}

	@Override
	public void bet(int coins) {}

	@Override
	public List<Card> getCards() {
		return cards;
	}

	@Override
	public void changeTheTurnAction() {
		turnAction = true;
	}

	@Override
	public String getName() {
		return name;
	}
}
