package test.blackjack.domain;

import java.util.ArrayList;
import java.util.List;

public class Gamer implements Player{
	private List<Card> cards;
	private int bettingCoins;
	private String name;
	private boolean turnAction;
	
	public Gamer() {}
	
	public Gamer(String name, int bettingcoins) {
		this.name = name;
		this.bettingCoins = bettingcoins;
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

	public List<Card> openCards() {
		return cards;
	}

	@Override
	public void bet(int coins) {
		this.bettingCoins -= coins;
	}
	
	public int getBettingCoins() {
		return bettingCoins;
	}
	
	public String getName() {
		return name;
	}

	@Override
	public List<Card> getCards() {
		return cards;
	}

	@Override
	public void changeTheTurnAction() {
		turnAction = true;
	}
  
}
