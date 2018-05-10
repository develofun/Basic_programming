package test.baseBall.oop;

/*
 * Player : 게임 진행/참여자 객체
*/

public abstract class Player {
	int[] numbers;
	public int[] makeNumbers(int numberCount){
		numbers=new int[numberCount];
		return numbers;
	};
}
