package test.blackjack.domain;

/*
 * 블랙잭 카드 구성
 * 
*/

public class Card {
	private final String[] patterns = 
		{"SPADE", "CLOVER", "HEART", "DIAMOND"};
	private final String[] denominations = 
		{"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
	private String pattern;
	private String denomination;
	
	
	public Card() {}

	public Card(String pattern, String denomination) {
		this.pattern = pattern;
		this.denomination = denomination;
	}

	public String[] getPatterns() {
		return patterns;
	}

	public String[] getDenominations() {
		return denominations;
	}
	
}
