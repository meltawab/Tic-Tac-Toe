package com.eighthlight.tictactoe;
import java.util.Scanner;

/**
 * TicTacToeHelper is a helper class that contains static methods that could be 
 * used in TicTacToe game program
 * @author Mohamed El-Tawab
 * @version 1.0
 */
public class TicTacToeHelper {

	/**
	* Method to validate the user input in case of 2 choices
	* @param scanner to get the user input. 
	* @return the input number.
	*/
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
