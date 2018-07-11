package com.eighthlight.tictactoe;

import java.util.Scanner;

public class TicTacToeHelper {

	public static int validateInput(Scanner scanner) {
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
