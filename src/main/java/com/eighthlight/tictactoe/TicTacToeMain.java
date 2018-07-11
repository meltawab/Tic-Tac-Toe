package com.eighthlight.tictactoe;

import java.util.Scanner;


/**
 * TicTacToeMain is the main class used to start your program.
 * @author Mohamed El-Tawab
 * @version 1.0
 */
public class TicTacToeMain {

	/**
	* main Method is called when you start the program Solution.
	* @param args Arguments passed by the command Line as options required. 
	*/
	public static void main(String[] args) {
		System.out.println("Welcome to Tic-Tac-Toe Game .. Enjoy it!");
		System.out.println("++++++++++++++++++++++++++++++++++++++++");
		Scanner scanner = new Scanner(System.in);			// Scanner to handle user input.
		boolean gameIsOver = false;
		while (!gameIsOver) {
			System.out.println("You have two levels to choose from:");
			System.out.println("===================================");
			System.out.println("1. Easy .. The computer is a little stupid!");
			System.out.println("2. Hard .. The computer is smart!");
			System.out.println("Choose 1 or 2 and press enter:");
			int inputNumber = 0;
			inputNumber = TicTacToeHelper.validateInput(scanner);			// Validate the user input.
			if(inputNumber == 1) {
				new EasyTicTacToe();				// Easy Level
			} else if (inputNumber == 2) {
				new HardTicTacToe();				// Hard level
			} else {
				continue;							// Wrong input!
			}
			while(!gameIsOver) {
				System.out.println("Want to play again?");
				System.out.println("1. Sure!");
				System.out.println("2. Nah, I'm good for today");
				System.out.println("Choose 1 or 2 and press enter:");
				inputNumber = TicTacToeHelper.validateInput(scanner);		// Validate the user input.	
				if(inputNumber == 1) {
					break;
				} else if (inputNumber == 2) {
					gameIsOver = true;
					System.out.println("Have a good day! and stay tuned for new difficulty levels!");
					scanner.close();
				}
			}
		}
	}

	

}
