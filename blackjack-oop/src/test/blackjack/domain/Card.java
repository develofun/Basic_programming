package test.blackjack.domain;

/*
 * 블랙잭 카드 구성
 * 
*/

public class Card {
	private String pattern;
	private String denomination;
	
	public Card() {}

	public Card(String pattern, String denomination) {
		this.pattern = pattern;
		this.denomination = denomination;
	}

	public String getPattern() {
		return pattern;
	}

	public String getDenomination() {
		return denomination;
	}
	
	public int getDenominationPoint() {
		switch(denomination) {
			case "A" : return 1;
			case "2" :return 2;
			case "3" :return 3;
			case "4" :return 4;
			case "5" :return 5;
			case "6" :return 6;
			case "7" :return 7;
			case "8" :return 8;
			case "9" :return 9;
			default : return 10;
		}
	}
	
}
