# Baseball Game(SBO)

> 숫자 야구 게임을 객체 지향 프로그래밍으로 구현


>## 주요 객체
> 1. GamePlay: 프로그램 시작/종료
> 2. BaseballGame: 게임 진행
> 3. Player : 게임 참여자



>### 1. GamePlay
> - 프로그램 시작
> - 프로그램 종료
<pre>
<code>
public class GamePlay{
  public static void main(String[] args){
    BaseballGame baseBallGame=new BaseballGame();
    ...
  }
}
</code>
</pre>

>### 2. BaseballGame
> - 게임 진행
> - 숫자 비교
> - 게임 완료 여부 확인
<pre>
<code>
public class BaseballGame{
  public void inningGame(){};
  public boolean isNumberEqual(int firstNumber, int secontNumber){};
  public boolean isGameOver(){};
}
</code>
</pre>

>### 3. Player
> - 숫자 생성(or 입력)
<pre>
<code>
public abstract class Player{
  public void makeNumbers(){};
}

public class UserPlayer extends Player{
  private int[] userNumbers;
  public void makeNumbers(){}; // 숫자 입력(등록)
  public int[] getUserNumbers(){return userNumbers;}
}

public class Computer extends Player{
  private int[] computerNumbers;
  public void makeNumbers(){}; // 유저가 맞춰야할 숫자 생성
  public int[] getComputerNumbers(){return computerNumbers;}
}
</code>
</pre>
