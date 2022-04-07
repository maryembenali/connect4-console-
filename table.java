package trial;
import java.util.*;
public class table {
	public static int nbreligne=6;
	public static int nbrecol=7;
	piece [][] tab = new piece[6][7];  //check
		
	
	
	public int getligne () {
		return this.nbreligne;
	}
	public int getcol() {
		return this.nbrecol;
	}
	
	public boolean checkforwinner(int col , String winningcolor) {
		boolean someonewon=false;
		for ( int ligne=0 ; ligne< nbreligne; ligne++) {
			if (tab[ligne][col] != null) {
				int winningstreak=3;
				//verifier verticallement
				for(int winligne=ligne+1;winligne<nbreligne;winligne++) {
					if (tab[winligne][col].getcolor()==winningcolor) {
						winningstreak--;
						if (winningstreak == 0) 
							return true;
					
					}else 
						winningstreak=3;
				}
				winningstreak=4;
				//verifier horizontallement
				for (int wincol=col-3;wincol<nbrecol + 3;wincol++) {
					if (wincol<0)
						continue;
					if (wincol>=nbrecol) {
						break;
					}
					
					if( tab[ligne][wincol]!= null && tab[ligne][wincol].getcolor()==winningcolor){
						winningstreak--;
						if (winningstreak == 0) {
							return true;
						}
					
					}
					else
						winningstreak=4;
					
				}winningstreak=4;
				//verifier diagonalement (ligne pente negative )
				for (int winligne=ligne - 3, wincol= col - 3;winligne<= nbreligne + 3 && wincol<= nbrecol + 3;winligne++, wincol++) {
					if (winligne < 0 || wincol < 0)
						continue;
					if (winligne>= nbreligne || wincol>= nbrecol) 
						break;
					if( tab[winligne][wincol] != null && tab[winligne][wincol].getcolor() == winningcolor){
						winningstreak--;
						if (winningstreak == 0) {
							return true;
						}
					
					} else winningstreak = 4;
				} //end of the for loop of the left diagonal
				winningstreak=4;
				
				//verifier diagonalement (ligne pente positive )
				
				for (int winligne=ligne - 3, wincol= col + 3;winligne<= nbreligne + 3 && wincol >= nbrecol - 3;winligne++, wincol--) {
					if (winligne < 0 || wincol >= nbrecol )
						continue;
					if (winligne>= nbreligne || wincol < 0) 
						break;
					if( tab[winligne][wincol] != null && tab[winligne][wincol].getcolor() == winningcolor){
						winningstreak--;
						if (winningstreak == 0) {
							return true;
						}
					
					} else winningstreak = 4;
				} 
				return false ;
			}//end of " if " the one that verifies whether the space is empty or not 
		} //first for
	return  false ;	
	}//end of checkwinner
	
	public boolean canweadd(int col , String color) {
		
		if (col >= 0 && col < nbrecol ) 
		{   if (tab[0][col]==null) {
			boolean test=false;
			for( int ligne=nbreligne - 1 ; ligne >=0; ligne--)
			{
			if  (tab[ligne][col]==null)
					{
				tab[ligne][col]= new piece();
				tab[ligne][col].setcolor(color);
				test=true;
				break;
					}
			} return test;
			}else
				{System.out.print("it's full sorry :/");
				return false;
				}
		}
		else
			{System.out.print("insertion impossible out of our range");
			return false;
			}
		
	}
	
	public void printtab() {
		for ( int i=0 ; i<nbreligne;i++)
		{ System.out.print("|");
		
			for (int j=0; j<nbrecol;j++)
				{if (tab[i][j]== null)
					System.out.print("-");
				else   System.out.print( tab[i][j].getcolor()) ;
			System.out.print("|");	
				}
		
		System.out.println();
		}
		
		
	}
	
	
public table() {
		
		for ( int i=0 ; i<nbreligne;i++)
		{
			for (int j=0; j<nbrecol;j++)
				tab[i][j]= null ;
		}
	}	


}
