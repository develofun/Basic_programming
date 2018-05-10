package cs.blackjack.game;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Game {
	private CardDeck cardDeck;
	private int playTurn;
	
	public void start() {
		cardDeck = new CardDeck();
		Dealer dealer = new Dealer();
		Player player = new Player();
		
		List<User> userList = Arrays.asList(dealer, player);
		
//		플레이어, 딜러 순으로 카드 두장씩 받음
		initialSet(dealer);
		initialSet(player);
		
		Scanner scan = new Scanner(System.in);
		while(playTurn == -1) {
//			딜러는 자신의 카드 중 한장 오픈
			System.out.println("딜러 카드 오픈 : " + dealer.openCards());
			
//			플레이어 카드 확인
			System.out.print("플레이어 카드 확인 : " + player.openCards());
			
//			플레이어는 딜러의 카드를 보고 hit/stay를 결정
			System.out.println("Hit? or Stay?('h' is Hit, 's' is Stay) > ");
			String turn = scan.next();
			if(turn.toLowerCase().equals("s")) {
				player.changeTurnStatus();
			} else {
				
				playTurn++;
			}
		}
	}
	
	private void initialSet(User user) {
		for(int i = 0; i < 2; i++) {
			// 카드덱에서 카드를 한장 뽑음			
			// 뽑은 카드를 플레이어 or 딜러에게 줌
			user.receiveCard(cardDeck.drawCard());
		}
	}
	
	private void allUserGetCard(List<User> userList) {
		for(int i = 0; i < userList.size(); i++) {
			
		}
	}
	
	private boolean isAllUserStay(List<User> userList) {
		for(User user : userList) {
			if(!user.isStay()) {
				return false; 
			}
		}
		
		return true;
	}
}
