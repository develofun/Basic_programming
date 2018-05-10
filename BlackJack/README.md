# BlackJack

블랙잭을 객체 지향 프로그래밍으로 구현<br><br>


### 블랙잭 게임 진행<hr>
 - 딜러와 플레이어가 게임에 참여
 - 카드를 두장씩 받음
 - 딜러 카드 1장 오픈
 - 플레이어는 카드를 더 받을지 선택 
 - 딜러는 카드 숫자 합이 17 이상이면 **STAY**
 - 모든 플레이어가 카드를 받지 않으면 게임 종료
 - 카드 숫자 합계를 정산 및 승패 결정<br><br>

### 승/패 요건
 - 플레이어의 첫 두장에 A, 10으로 블랙잭이 나올 경우 플레이어 자동 승리
 - 17 이상에서 더 큰 숫자인 딜러 or 플레이어가 승리
 - 17 이상에서 숫자가 동일할 때 보류
 - 플레이어 or 딜러 중 21이 넘으면 패배(bust)<br><br>

### Entity <hr>
딜러
 - 카드 오픈
 - 카드 hit/stay(17점 이상 hit 불가)
 - 카드 소유

플레이어
 - 카드 오픈
 - 카드 hit/stay/surrender 
 - 카드 소유

카드덱
 - 52개 카드 보유
 - 섞기
 - 카드 주기

규칙
 - 점수 계산
 - 승패 판단

게임
 - 플레이어, 딜러 순으로 카드 두장씩 받음
 - 딜러는 자신의 카드 중 한장 오픈
 - 플레이어는 딜러의 카드를 보고 hit/stay를 결정
<br><br>

### Implemented Objects <hr>

<pre>
<code>
public interface User {
	// 카드 오픈
	ArrayList<Card> openCards();
	// 카드 hit/stay
	boolean isStay();
	// 카드 소유
	void receiveCard(Card card);		
}
</code>
</pre>

<pre>
<code>
public class CardDeck {
	private Stack<Card> cards;

	public CardDeck() {
		this.cards = generateCardDeck();
		Collections.shuffle(this.cards);
	}
	
	private Stack<Card> generateCardDeck() {
		Stack<Card> newCards = new Stack<>();		
		return newCards;
	}
}
</code>
</pre>

<pre>
<code>

public interface User {
	// 카드 오픈
	ArrayList<Card> openCards();
	// 카드 hit/stay
	boolean isStay();
	// 카드 소유
	void receiveCard(Card card);		
}
</code>
</pre>


