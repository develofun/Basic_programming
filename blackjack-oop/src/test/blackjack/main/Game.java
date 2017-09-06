package test.blackjack.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import test.blackjack.domain.Card;
import test.blackjack.domain.CardDeck;
import test.blackjack.domain.Contstants;
import test.blackjack.domain.Dealer;
import test.blackjack.domain.GameRule;
import test.blackjack.domain.Gamer;
import test.blackjack.domain.Player;

//플레이어 참여 인원은 2명
//플레이어의 각 이름을 정한다.
//게임 카드덱을 섞는다.(생성한다)

//<Loop>
//베팅을 한다
//if(딜러 > 16) 딜러 카드 배분 제외
//if(라운드 == 1) 카드 2장 씩 배분 / else 카드 1장씩 배분
//bust 플레이어 제외
//hit/stay 행동 선택

public class Game {
//	플레이어 참여 인원은 2명
	
  public void playtheBlackjack() {
//  플레이어를 설정한다.
  	List<Player> players = new ArrayList<>();
  	players.add(new Gamer("user_1", 1000));
  	players.add(new Dealer());
	
//  게임 카드덱을 섞는다.(생성한다)
  	Scanner scan = new Scanner(System.in);
  	CardDeck cardDeck = new CardDeck();
  	GameRule gameRule = new GameRule();
  	
//		if(라운드 == 1) 카드 2장 씩 배분 / else 카드 1장씩 배분
  	List<Player> firstTurnPlayers = initPhase(players, cardDeck);
  	
//	<Loop>
//		베팅을 한다
//		if(딜러 > 16) 딜러 카드 배분 제외
//		bust 플레이어 제외
//		hit/stay 행동 선택
  	List<Player> finishGamePlayers = gamePhase(firstTurnPlayers, cardDeck, scan); 
		
  	Player player = gameRule.finalWinner(finishGamePlayers);
		
  	System.out.println("승자는 [" + player.getName() + "] 입니다.");
	}
  
  private List<Player> initPhase(List<Player> players, CardDeck cardDeck) {
  	for(int i = 0 ; i < 2 ; i ++) {
	  	for(Player player : players) {
	  		Card card = cardDeck.drawACard();
	  		player.recieveACard(card);
	  	}
  	}
  	return players;
  }
  
  private List<Player> gamePhase(List<Player> players, CardDeck cardDeck, Scanner scan) {
  	List<Player> stayPlayers = new ArrayList<>();
  	while(isAllPlayerStay(players)) {
  		for(Player player : players) {
//		베팅을 한다
  			bettingTurn(player);
//		if(딜러 > 16) 딜러 카드 배분 제외
  			receiveCard(player, cardDeck, scan);
  			if(player.isStay())stayPlayers.add(player);
  		}
//		bust 플레이어 제외
  	}  		
  	return stayPlayers;
  }
  
  private void receiveCard(Player player, CardDeck cardDeck, Scanner scan) {
  	System.out.print("카드를 받으시겠습니까? 종료하시겠습니까?");
  	if(scan.next().equals("1")) {
	  	if(player instanceof Dealer) {
	  		if(playerPoint(player) > 16) {
	  			player.changeTheTurnAction();
	  			return;
	  		}
	  	}
	  	Card card = cardDeck.drawACard();
	  	player.recieveACard(card);
  	}else {
  		player.changeTheTurnAction();
  	}
  }
  
  private void bettingTurn(Player player) {
  	player.bet(Contstants.bettingMoney);
  }
  
  private int playerPoint(Player player) {
		int point = 0;
		for(Card card : player.getCards()) {
			point += card.getDenominationPoint();
		}
		return point;
	}
  
  private boolean isAllPlayerStay(List<Player> players) {
  	for(Player player : players) {
  		if(!player.isStay()) {
  			return false;
  		}
  	}
  	return true;
  }
  
}
