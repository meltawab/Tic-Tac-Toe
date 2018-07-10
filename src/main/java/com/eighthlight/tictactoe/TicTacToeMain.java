package com.eighthlight.tictactoe;

import java.util.Scanner;

public class TicTacToeMain {

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
			inputNumber = validateInput(scanner);			// Validate the user input.
			if(inputNumber == 1) {
				new EasyTicTacToe();				// Easy Level
			} else if (inputNumber == 2) {
				new HardTicTacToe();				// Hard level
			} else {
				continue;							// Wrong input!
			}
			while(true) {
				System.out.println("Want to play again?");
				System.out.println("1. Sure!");
				System.out.println("2. Nah, I'm good for today");
				System.out.println("Choose 1 or 2 and press enter:");
				inputNumber = validateInput(scanner);		// Validate the user input.	
				if(inputNumber == 1) {
					break;
				} else if (inputNumber == 2) {
					gameIsOver = true;
					System.out.println("Have a good day! and stay tuned for new difficulty levels!");
					scanner.close();
					break;
				}
			}
		}
	}

	private static int validateInput(Scanner scanner) {
		int inputNumber = 0;
		try {
			inputNumber = Integer.parseInt(scanner.nextLine());
			if (inputNumber != 1 && inputNumber != 2) {
				System.out.println("Invalid .. Choice again");
			}
		} catch (NumberFormatException e) {
			System.out.println("Invalid number!");
		}
		return inputNumber;
	}

}
