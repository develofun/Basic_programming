package cs.blackjack.game;

import java.util.ArrayList;

public interface User {
	// 카드 오픈
	ArrayList<Card> openCards();
	// 카드 hit/stay
	boolean isStay();
	// 카드 소유
	void receiveCard(Card card);		
}
