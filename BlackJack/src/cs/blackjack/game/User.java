package cs.blackjack.game;

import java.util.ArrayList;

public interface User {
	// 카드 오픈
	String openCards();
	// 카드 hit/stay
	boolean isStay();
	// 카드 소유
	void receiveCard(Card card);
	// 턴 상태 변경
	void changeTurnStatus();
}
