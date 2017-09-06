# blackjack-oop

블랙잭을 객체 지향 프로그래밍으로 구현<hr><br>


### 블랙잭 게임 진행<hr>
 - 플레이어 2명이 게임에 참여한다 (플레이어, 딜러)
 - 초기 베팅을 진행한다
 - 카드를 두장 받는다
 - 배팅을 한다
 - 카드를 더 받을지 선택한다 (이때, 딜러는 카드 숫자 합이 17 이상이면 **STAY**)
 - 모든 플레이어가 카드를 받지 않으면 게임 진행이 종료된다
 - 카드 숫자 합계를 정산한다<br><br>

### 승리/패배 요건<hr>
 - 블랙잭을 만든다
 - 상대보다 큰 수를 만들었을 경우 (단, 21보다 작은)
 - 동일한 수일 경우 적은 카드로 만들었을 경우
 - 21을 넘기면 무조건 패배<br><br>

### Object <hr>
#### Card
##### CardDeck
##### Player
##### Rule
##### Game
