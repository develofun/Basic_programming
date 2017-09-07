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
	private int totalBettingCoins;
//	플레이어 참여 인원은 2명
	
  public void playtheBlackjack() {
  	System.out.println(" =========== Black Jack =========== ");
  	Scanner scan = new Scanner(System.in);
  	CardDeck cardDeck = new CardDeck();
  	GameRule gameRule = new GameRule();

  	//  플레이어를 설정한다.
//  게임 카드덱을 섞는다.(생성한다)
//	if(라운드 == 1) 카드 2장 씩 배분 / else 카드 1장씩 배분
//	<Loop>
//	베팅을 한다
//	if(딜러 > 16) 딜러 카드 배분 제외
//	bust 플레이어 제외
//	hit/stay 행동 선택
  	
  	List<Player> players = new ArrayList<>();
  	players.add(new Gamer("user_1", 1000));
  	players.add(new Dealer());
  	
  	List<Player> firstTurnPlayers = initPhase(players, cardDeck, scan);
  	
  	List<Player> finishGamePlayers = gamePhase(firstTurnPlayers, cardDeck, scan); 
		
  	Player player = gameRule.finalWinner(finishGamePlayers);
		
  	System.out.println("승자는 [" + player.getName() + "] 입니다.");
	}
  
  private List<Player> initPhase(List<Player> players, CardDeck cardDeck, Scanner scan) {
  	System.out.println("초기 배팅 및 카드 배분을 진행합니다.");
  	for(int i = 0 ; i < 2 ; i ++) {
	  	for(Player player : players) {
	  		if(i==0)bettingTurn(player);
	  		
	  		Card card = cardDeck.drawACard();
	  		player.recieveACard(card);
	  	}
  	}
  	System.out.println("현재 베팅 금액 합계 : " + totalBettingCoins);
  	return players;
  }
  
  private List<Player> gamePhase(List<Player> players, CardDeck cardDeck, Scanner scan) {
  	List<Player> stayPlayers = new ArrayList<>();
  	
  	while(!isAllPlayerStay(players)) {
  		for(Player player : players) {
  			System.out.println("["+player.getName()+"] 님의 턴입니다.");
//		베팅을 한다
  			bettingTurn(player);
//		if(딜러 > 16) 딜러 카드 배분 제외
  			receiveCard(player, cardDeck, scan);
//  			if(player.isStay())stayPlayers.add(player);
  		}
  		System.out.println("현재 베팅 금액 합계 : " + totalBettingCoins);
//		bust 플레이어 제외
  	}
  	return players;
  }
  
  private void receiveCard(Player player, CardDeck cardDeck, Scanner scan) {
  	System.out.print("카드를 받으시겠습니까? 종료하시겠습니까? (1 / 0) => ");
  	String turnAction = scan.next();
  	if(turnAction.equals("1")) {
	  	if(player instanceof Dealer) {
	  		if(playerPoint(player) > 16) {
	  			System.out.println("딜러의 끗 수 합이 16을 초과하여 카드를 더 받을 수 없습니다.");
	  			player.changeTheTurnAction();
	  			player.checkPresentCards();
	  			return;
	  		}
	  	}
	  	Card card = cardDeck.drawACard();
	  	player.recieveACard(card);
  	}else {
  		player.changeTheTurnAction();
  	}
  	player.checkPresentCards();
  }
  
  private void bettingTurn(Player player) {
  	player.bet(Contstants.bettingMoney);
  	totalBettingCoins += Contstants.bettingMoney;
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
