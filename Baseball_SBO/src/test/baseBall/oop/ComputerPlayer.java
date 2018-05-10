package test.baseBall.oop;

import java.util.Random;

/*
 * Computer : 문제를 내는 출제자 객체
 *  - makeNumbers : 문제가 될 숫자들을 생성 (3개) 
*/

public class ComputerPlayer extends Player{
	Random rand=new Random();
	
	public ComputerPlayer(){}
	
	public int[] makeNumbers(int numberCount){
		int[] computerNumbers=new int[numberCount];
		for(int i=0;i<numberCount;i++){
			computerNumbers[i]=rand.nextInt(9);
			i=(isDuplicateNumber(computerNumbers,computerNumbers[i],i))?i--:i;
		}
		System.out.println("[Notice] Computer 문제 생성 완료!");
		return computerNumbers;
	}
	
	private boolean isDuplicateNumber(int[] computerNumbers,int checkNumber,int i){
		boolean checkResult=false;
		if(i==0)return false;
		for(int j=0;j<i;j++){
			checkResult=(computerNumbers[i]==checkNumber)?true:checkResult;
			if(checkResult)break;
		}
		return checkResult;
	}
}
