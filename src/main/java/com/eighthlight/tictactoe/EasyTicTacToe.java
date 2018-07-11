package com.eighthlight.tictactoe;

import java.util.Random;

public class EasyTicTacToe extends AbstractTicTacToePlay {

	Random rand;
	public EasyTicTacToe() {
		rand = new Random();
		System.out.println("Welcome to the Easy Tic Tac Toe Level!");
		play();
	}

	@Override
	protected void computerPlay() {
		printBoard();
		System.out.println("It's Computer turn!");
		boolean validRandom = false;
		while(!validRandom){
			int value = rand.nextInt(9);			// Get a Random number from 0 - 8 
			if (board[value] == ' ') {				// Make sure it's empty cell
				validRandom = true;
				board[value] = computer;
			}
		}
		
	}

	
	
}
