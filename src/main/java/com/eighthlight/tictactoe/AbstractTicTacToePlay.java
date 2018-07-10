package com.eighthlight.tictactoe;

public abstract class AbstractTicTacToePlay {
 
	private char[][] board;
	
	public AbstractTicTacToePlay(){
		board = new char[3][3];
		intializeBoard();
		printBoard();
	}
	

	private void intializeBoard() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				board[i][j]= ' ';
			}
		}
	}


	protected void printBoard() {
		System.out.println("|-1-|-2-|-3-|");
		System.out.println("| " + board[0][0] + " | " + board[0][1] + " | " + board[0][2] + " |");
		System.out.println("|-4-|-5-|-6-|");
		System.out.println("| " + board[1][0] + " | " + board[1][1] + " | " + board[1][2] + " |");
		System.out.println("|-7-|-8-|-9-|");
		System.out.println("| " + board[2][0] + " | " + board[2][1] + " | " + board[2][2] + " |");
		System.out.println("|---|---|---|");
	}
	
}
