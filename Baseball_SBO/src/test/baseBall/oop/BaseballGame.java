package test.baseBall.oop;

/*
 * BaseballGame : 게임 객체
 *  - iningGame : 게임 진행
 *  - isNumberEqual : 숫자 비교
 *  - isGameOver : 게임 종료 여부 확인
 *  
 * #추가 요구 사항
 *  - 문제 숫자를 더 용이하게 관리할 수 있게 변경
*/

public class BaseballGame {
	private static final String STRIKE="s";
	private static final String BALL="b";
	private static final String OUT="o";
	public static final int NUMBERCOUNT=3;
	private ComputerPlayer computer;
	private UserPlayer user;
	
	public BaseballGame(ComputerPlayer computer,UserPlayer user){
		this.computer=computer;
		this.user=user;
	}
	
	public String inningGame(int[] computerNumbers, int[] userNumbers){
		String str="";
		String compareResult="";
		for(int i=0;i<NUMBERCOUNT;i++){
			for(int j=0;j<NUMBERCOUNT;j++){
				if(isNumberEqual(userNumbers[i],computerNumbers[j])){
					str=(isNumberEqual(i,j))?STRIKE:BALL;
					break;
				}else{
					str=OUT;
				}
			}
			compareResult+=str;
		}
		return compareResult;
	}
	
	private boolean isNumberEqual(int firstNumber, int secondNumber){
		return firstNumber==secondNumber;
	}

	public boolean isGameOver(String compareResult){
//		String[] splitStr=compareResult.split(",");
		int strikeCount=0;
		int ballCount=0;
		int outCount=0;
		for(int i=0;i<compareResult.length();i++){
			String ch=compareResult.substring(i,i+1);
			if(ch.equals(STRIKE)){
				strikeCount++;
			}else if(ch.equals(BALL)){
				ballCount++;
			}else if(ch.equals(OUT)){
				outCount++;
			}
		}
		if(strikeCount==NUMBERCOUNT){
			System.out.println("Strike"+NUMBERCOUNT+"로 게임을 종료합니다.");
			return false;
		}else{
			System.out.println("===== 이번 라운드 결과는 ["+strikeCount
			+"S "+ballCount+"B "+outCount+"O]입니다 =====");
			return true;
		}
	}
}
