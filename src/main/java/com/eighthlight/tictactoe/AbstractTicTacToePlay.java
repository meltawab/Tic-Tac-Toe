package com.eighthlight.tictactoe;

import java.util.Scanner;

/**
 * AbstractTicTacToePlay is an abstract class that can be extended into different
 * difficulty levels in TicTacToe game program.
 * @author Mohamed El-Tawab
 * @version 1.0
 */

public abstract class AbstractTicTacToePlay {
	protected char[] board;
	protected char human;
	protected char computer;
	private Scanner gameScanner;
	private int turnCount;
    private enum Player {
        HUMAN,
        COMPUTER;
    }
	private Player turn;
	
	public AbstractTicTacToePlay(){
		board = new char[9];
		gameScanner = new Scanner(System.in);
		turnCount = 0;
		initializeBoard();
	}
	
	protected abstract void computerPlay();

	/**
	* Method to initialize the Tic-Tac-Toe board
	*/	
	private void initializeBoard() {
		System.out.println("======================================");
		System.out.println("**************************************");
		System.out.println("======================================");
		for (int i = 0; i < 9; i++) {
				board[i]= ' ';
		}
	}
	
	/**
	* Method to start the game
	*/
	protected void play() {
		int choice = retrieveGameLead(); 	// Who would start the game
		initializeGame(choice);				// Initialize the game according to the previous choice
		startGameLoop();					// Start the game loop 
	}

	/**
	* Method to initialize the game according to who will start.
	* @param choice of user
	*/
	private void initializeGame(int choice) {
		if (choice == 1){					// Human Starts
			human = 'X';
			computer = 'O';
			turn = Player.HUMAN;
		} else if (choice == 2) {			// Computer Starts
			computer = 'X';	
			human = 'O';
			turn = Player.COMPUTER;
		}
	}

	/**
	* Method to start the game loop.
	*/
	private void startGameLoop() {
		Player winner = null;
		while(winner == null && turnCount < 9){			// As no winner and not draw yet
			if(turn == Player.HUMAN){
				humanPlay();
				turn = Player.COMPUTER;
			} else if(turn == Player.COMPUTER){
				computerPlay();
				turn = Player.HUMAN;
			}
			turnCount++;
			winner = checkWinner();
		}
		printResults(winner);
	}

	/**
	* Method to print the results at the end
	* @param winner of the game
	*/
	private void printResults(Player winner) {
		System.out.println("#######################RESULT############################");
		printBoard();
		if(winner == Player.COMPUTER) {
			System.out.println("Computer is the winner! Good Luck next time!");
		} else if (winner == Player.HUMAN) {
			System.out.println("You are the winner you are good!");
		} else {
			System.out.println("It's a draw! You didn't defeat the computer!");
		}
	}
	
	/**
	* Method to check if there's any current winner
	* @return a Player object with the winner! null in case of no winner yet
	*/
	private Player checkWinner() {
		Player player = null;
		for (int i = 0; i < 8; i++) {
			StringBuilder line = new StringBuilder();
			switch (i) {
				case 0:
					line.append(board[0]).append(board[1]).append(board[2]);  // -
					break;
				case 1:
					line.append(board[3]).append(board[4]).append(board[5]);  // -
					break;
				case 2:
					line.append(board[6]).append(board[7]).append(board[8]);  // - 
					break;
				case 3:
					line.append(board[0]).append(board[3]).append(board[6]);  // |  
					break;
				case 4:
					line.append(board[1]).append(board[4]).append(board[7]);  // | 
					break;
				case 5:
					line.append(board[2]).append(board[5]).append(board[8]); // |   
					break;
				case 6:
					line.append(board[0]).append(board[4]).append(board[8]); // \  
					break;
				case 7:
					line.append(board[2]).append(board[4]).append(board[6]); // / 
					break;
			}
			if (line.toString().equals("XXX")) {
				if(human == 'X') {
					return Player.HUMAN;
				} else if (computer == 'X') {
					return Player.COMPUTER;
				}
			} else if (line.toString().equals("OOO")) {
				if(human == 'O') {
					return Player.HUMAN;
				} else if (computer == 'O') {
					return Player.COMPUTER;
				}
			}
		}
		return player;
	}

	/**
	* Method to add the user selection in the game
	*/
	private void humanPlay() {
		printBoard();
		System.out.println("It's Your turn!");
		boolean validSelection = false;
		int input = 0;
		while(!validSelection) {
			try {
				System.out.println("Choose from 1 - 9 the place you want to place your "+human );
				input = Integer.parseInt(gameScanner.nextLine());
				if (!(input > 0 && input <= 9)) {
					System.out.println("Invalid input!");
					continue;
				} else {
					if(board[input - 1] == ' ') {	 // Check for empty cell
						board[input - 1] = human;
						validSelection = true;
					} else {
						System.out.println("This is not an empty cell please try again!");
					}
					
				}
			} catch (NumberFormatException e) {
				System.out.println("Invalid input!");
				continue;
			}	
		}
	}

	
	/**
	* Method to check who will start the game.
	* @return the selection of the user of who will start the game
	*/
	private int retrieveGameLead() {
		while(true) {
			System.out.println("Would you like to start? Starter will always be X !:");
			System.out.println("===================================================");
			System.out.println("1. Yes, I will go first this time!");
			System.out.println("2. No, computer go first.");
			System.out.println("Choose 1 or 2 and press enter:");
			int inputNumber = 0;
			inputNumber = TicTacToeHelper.validateInput(gameScanner);	// Validate the user input.
			if(inputNumber == 1 || inputNumber == 2) {
				return inputNumber;
	 		} 
		}
	}

	/**
	* Method to print the board.
	*/
	protected void printBoard() {
		System.out.println("|-1-|-2-|-3-|");
		System.out.println("| " + board[0] + " | " + board[1] + " | " + board[2] + " |");
		System.out.println("|-4-|-5-|-6-|");
		System.out.println("| " + board[3] + " | " + board[4] + " | " + board[5] + " |");
		System.out.println("|-7-|-8-|-9-|");
		System.out.println("| " + board[6] + " | " + board[7] + " | " + board[8] + " |");
		System.out.println("|---|---|---|");
	}
	
}
