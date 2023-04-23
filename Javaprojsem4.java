import java.util.*;

class TicTacToe{
	static char[][] board;															//creation of board through 2-d array 
																					//and assigning static to use it in another class without object declaration
	public TicTacToe()																//constructor to create the board at the time of obj creation
	{
		board = new char[3][3];  																
		initBoard();																//to initialise the board 
	}
	
	// Initially the board would be filled with /uoooo so to create space we initialise the board with empty space
	
	void initBoard()
	{
		for(int i = 0; i<board.length; i++){
			for(int j = 0; j<board[i].length; j++){
				board[i][j] = ' ';
			}
		}
	
	}
	// To display board with it's characters on display
	
	static void displayBoard(){
	
		System.out.println("--------------");
		
		for(int i = 0; i<board.length; i++){
		
			System.out.print("| ");
			
			for(int j = 0; j<board[i].length; j++){
				System.out.print(board[i][j] + " | ");	
			}
			System.out.println();
			System.out.println("--------------");
		}
	}

	//sign placement 
	static void mark(int row, int col, char mark){
		if(row >= 0 && row <=2 && col >= 0 && col <= 2){
			board[row][col] = mark;
		}
		else{
			System.out.println("Position not allowed");
		}
}

	static boolean checkcolwin(){
		for(int j = 0; j<=2; j++){
			if(board[0][j] != ' ' && board[0][j] == board[1][j] && board[1][j] == board[2][j]){
				return true;
			}
		}
		return false;
}

	static boolean checkrowwin(){
		for(int i = 0; i<=2; i++){
			if(board[i][0] != ' ' && board[i][0] == board[i][1] && board[i][1] == board[i][2]){
					return true;
			}
		}
		return false;
}

	static boolean checkdiagwin(){
		if(board[0][0] != ' ' && board[0][0] == board[1][1] && board[1][1] == board[2][2] || board[0][2] != ' ' && board[0][2] == board[1][1] && board[1][1] == board[2][0]){
			return true;
		}
		return false;
}
}


class sentientPlayer{
	
	String name;
	char mark;
	
	sentientPlayer(String name, char mark){
		this.name = name;
		this.mark = mark;
	}
	
	//ask for the row and column the player wants to place the move
	
	void makeMove(){
		
		int row;
		int col;
		do{
		Scanner sc = new Scanner(System.in);
		System.out.println("Which row and column you want to place the move:");
		row = sc.nextInt();
		col = sc.nextInt();
		}while(!isLegitMove(row,col));
		TicTacToe.mark(row,col,mark);
	}
	
	//checks for a legit move
	boolean isLegitMove(int row, int col){
		if(row>=0 && row<=2 && col>=0 && col<=2){
			if(TicTacToe.board[row][col] == ' '){
				return true;
			}
		}
		return false;
	}
		
}

class main{
	public static void main(String[] args){
		TicTacToe obj1 = new TicTacToe();
		obj1.displayBoard();

		sentientPlayer s1 = new sentientPlayer("Sankit", 'X');
		sentientPlayer s2 = new sentientPlayer("Saquib", 'O');
		sentientPlayer currentPlayer;
		currentPlayer = s1;
		
		while(true){
			
			System.out.println(currentPlayer.name + " " + "chance to mark:");
			currentPlayer.makeMove();
			TicTacToe.displayBoard();
			
			if(TicTacToe.checkcolwin() || TicTacToe.checkrowwin() || TicTacToe.checkdiagwin()){
				System.out.println("The winner is:" + currentPlayer.name);
				break;
			}
			else{
				if(currentPlayer == s1){
					currentPlayer = s2;
				}
				else{
					currentPlayer = s1;
				}
			}
		}
	}

}
