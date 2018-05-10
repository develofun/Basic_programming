package test.baseBall.oop;

import java.util.Scanner;

/*
 * User : 숫자를 맞추는 이용자 객체
 *  - makeNumbers : 예상하는 숫자들을 입력 (3개)
 *  
*/

public class UserPlayer extends Player{
	Scanner scan=new Scanner(System.in);
	
	public UserPlayer(){}
	
	public int[] makeNumbers(int numberCount){
		int[] userNumbers=new int[numberCount];
		for(int i=0;i<numberCount;i++){
			System.out.print((i+1)+"번째 숫자 입력(0~9) : ");
			userNumbers[i]=scan.nextInt();
		}
		System.out.println("[Notice] User 숫자 입력 완료!");
		return userNumbers;
	}
}