package com.eighthlight.tictactoe;

import java.util.Scanner;

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

	
	private void initializeBoard() {
		System.out.println("======================================");
		System.out.println("**************************************");
		System.out.println("======================================");
		for (int i = 0; i < 9; i++) {
				board[i]= ' ';
		}
	}
	

	protected void play() {
		int choice = retrieveGameLead();
		initializeGame(choice);
		startGameLoop();
	}

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

	private void startGameLoop() {
		Player winner = null;
		while(winner == null && turnCount < 9){			// No winner and not draw yet
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

	private void humanPlay() {
		printBoard();
		System.out.println("It's Your turn!");
		boolean invalidSelection = false;
		int input = 0;
		while(!invalidSelection) {
			try {
				System.out.println("Choose from 1 - 9 the place you want to place your "+human );
				input = Integer.parseInt(gameScanner.nextLine());
				if (!(input > 0 && input <= 9)) {
					System.out.println("Invalid input!");
					continue;
				} else {
					if(board[input - 1] == ' ') {	 // Check for empty cell
						board[input - 1] = human;
						invalidSelection = true;
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

	
	protected int retrieveGameLead() {
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
