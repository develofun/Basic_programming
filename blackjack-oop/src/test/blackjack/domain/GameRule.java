package test.blackjack.domain;

import java.util.List;

public class GameRule {
	private int bettingCoins;
	
//  베팅 코인
	public void collect(int bettingCoins) {
		this.bettingCoins = bettingCoins;
	}
	
	public void initializeBettingCoins() {
		this.bettingCoins = 0;
	}
	
//	승자 결정
	public Player finalWinner(List<Player> players) {
		return null;
	}
	
//	점수 합계 계산
	private int playerPoint(Player player) {
		int point = 0;
		for(Card card : player.getCards()) {
			point += card.getDenominationPoint();
		}
		return point;
	}
}
