package test.baseBall.oop;

public class GamePlay {
	public static void main(String[] args) {
		System.out.println("========= 야구 게임 SBO Baseball =========");
		
		ComputerPlayer computerPlayer=new ComputerPlayer();
		UserPlayer userPlayer=new UserPlayer();
		BaseballGame baseBallGame=new BaseballGame(computerPlayer, userPlayer);
		
		int[] computerNumbers=computerPlayer.makeNumbers(baseBallGame.NUMBERCOUNT);
		String gameResult="";

		do{
			gameResult=baseBallGame.inningGame(computerNumbers, userPlayer.makeNumbers(baseBallGame.NUMBERCOUNT));
		}while(baseBallGame.isGameOver(gameResult));
		
		System.exit(0);
	}
}
