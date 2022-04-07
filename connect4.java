package trial;
import java.util.*;

public class connect4 {
	
	private table board;
	private String color1;
	private String color2;
	
	private boolean currentplayer; // true if it's player1's turn
	
	public connect4(String color1,String color2) {
		this.board = new table();
		this.color1=color1;
		this.color2=color2;
		currentplayer=(new Random()).nextBoolean();
	}
	
	public void reset () {
		this.board = new table();
        currentplayer = (new Random()).nextBoolean();
        startgame();
        
        
	}
		
	
	public boolean checkwinner(int col) {
		boolean someonewon =false;
		String winningcolor = currentplayer ? color1: color2;
		return board.checkforwinner(col,winningcolor);
		
		
		//public static void main(String[] args ) {}
			
		
	}
	public void startgame() {
		

		Boolean running = true;
		while (running)
		{ String color;//how and where
		  board.printtab();
			if (currentplayer)
			{
				color=color1;
				System.out.println("player's 1 turn");}
			else
			{
				color=color2;
				System.out.println("player's 2 turn");}
		
		System.out.println("choose the column where you want to put your piece");
		System.out.print("choose between 1 and "+board.getcol()+":");
		Scanner input = new Scanner( System.in);
		int col = input.nextInt() - 1;
		Boolean success= board.canweadd(col, color);
			
		if (success)
			
		{ if (checkwinner(col)) {
			board.printtab();
			running=false;
			if (currentplayer) {
				System.out.println("player "+ color1+" has won ! ");
				
			} else {
				System.out.println("player "+color2+" 2 has won !");
			}
			System.out.println("Would you like to play again ?");
			String playagain = input.next();
	    	if (playagain.equals("Yes")|| playagain.equals("YES")|| playagain.equals("yes")){
	    		reset();
	    	}else {running =false;
	    	System.out.println("it was fun having you as our game tester !");
	    	System.out.println("          come back later !");
	    	System.out.println("               bye!");
	    	}
	    	
		}
		currentplayer= !currentplayer;	
	}
	
	}

}
}
