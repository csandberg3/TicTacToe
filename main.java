import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		//Getting players
		System.out.print("Player 1, what is your name? ");
		String p1 = input.nextLine();
		System.out.print("Player 2, what is your name? ");
		String p2 = input.nextLine();
		
		//make board
		char[][] board = new char[3][3];
		
		//fill board
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				board[i][j] = '-';
			}
		}
		//whose turn
		boolean isPlayer1 = true;
		
		boolean gameEnded = false;
		
		while(!gameEnded) {
		//draw board
		drawBoard(board);
		

		
		//keep track
		char symbol = '-';
		if(isPlayer1) {
			symbol = 'x';
		}
		else {
			symbol = 'o';
		}
		
		if(isPlayer1) {
			System.out.println(p1 + "'s Turn (x)");
		}
		else {
			System.out.println(p2 + "'s Turn (x)");
		}
		
		int row = 0;
		int col = 0;
		
		//Getting players moves
		while(true) {
		System.out.print("Where do you want to go? Enter a row 0, 1, or 2: ");
		row = input.nextInt();
		
		System.out.print("Next, enter a column 0, 1, or 2: ");
		col = input.nextInt();
		
		if(row<0||col<0||row>2||col>2) {
			System.out.println("Your move is out of bounds");
		}
		else if(board[row][col] != '-') {
			System.out.println("Someone has already made a move there");
		}
		else {
			break;
		}
		}
		
		//set their move 
		board[row][col] = symbol;
		//drawBoard(board);
		
		if(whoWon(board) == 'x') {
			System.out.println(p1 + " has won!");
			gameEnded = true;
		}
		else if(whoWon(board) == 'o') {
			System.out.println(p2 + " has won!");
			gameEnded = true;
		}
		else {
			if(tied(board)) {
				System.out.println("Game ended in a tie. Play again!");
				gameEnded = true;
			}
			else {
				isPlayer1 = !isPlayer1;
			}
			
		}
		}
		drawBoard(board);
		
	}
	public static void drawBoard(char[][] board) {
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				System.out.print(board[i][j]);
			}
			System.out.println();
		
		}
	}
	
	public static char whoWon(char[][] board) {
		//Check if they won in a row
		for(int i = 0; i<3; i++) {
			if(board[i][0] == board[i][1] && board[i][1] == board[i][2] && board[i][0] != '-') {
				return board[i][0];
			}
		}
		//Check if they won in a column
		for(int j = 0; j<3; j++) {
			if(board[0][j] == board[1][j] && board[1][j] == board[2][j] && board[0][j] != '-') {
				return board[0][j];
			}
		}
		
		//Diag check
		if(board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] != '-') {
			return board[0][0];
		}
		if(board[2][0] == board[1][1] && board[1][1] == board[0][2] && board[1][1] != '-') {
			return board[1][1];
		}
		return '-';
		
		
	}
	
	public static boolean tied(char[][] board){
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				if(board[i][j] == '-') {
					return false;
				}
			}
		
		}
		return true;
	}
	
	
	
	
}