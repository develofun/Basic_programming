package test.blackjack.domain;

import java.util.List;

public interface Player {	
//	카드를 받는다
	public void recieveACard(Card card);
	
//	턴액션 : Hit or Stay
	public boolean isStay();
	
	public void changeTheTurnAction();
	
//	베팅
	public void bet(int coins);
	
	public String getName();
	
	public List<Card> getCards();
	
	public void checkPresentCards();
}
