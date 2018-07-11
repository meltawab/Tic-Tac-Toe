package com.eighthlight.tictactoe;


public class HardTicTacToe extends AbstractTicTacToePlay {
	
    private enum Action {
        WIN,			// Computer can win in one move.
        LOSE,			// Computer can lose in one move (must defend).
        PROGRESSIVE;	// Computer can build its win from previous moves.
    }
    
	public HardTicTacToe() {
		System.out.println("Welcome to the Hard Tic Tac Toe Level!");
		play();
	}

	@Override
	protected void computerPlay() {
		printBoard();
		System.out.println("It's Computer turn!");
		/*
		 * First check if Computer can win in one move
		 * Second check if Computer can lose in one move (must defend)
		 * Third check if a win can be built from previous moves
		 * Finally make a smart move!
		 */
		if(!findDirectAction(Action.WIN) && !findDirectAction(Action.LOSE) && !findDirectAction(Action.PROGRESSIVE)){
			makeSmartMove();
		}	
	}
	
	/**
	* Method to find the direct action that should be taken.
	* @param which action should this method check for(winning move, defense move or progressive move).
	* @return true in case of an action has been taken or false in case of no action.
	*/
	private boolean findDirectAction(Action action) {
		for (int i = 0; i < 8; i++) {
			StringBuilder line = new StringBuilder();
			switch (i) {
				case 0:
					line.append(board[0]).append(board[4]).append(board[8]); // \  
					if(isDirectActionNeeded(line, action)) {	
						int index = findEmptyCell(0, 4, 8);
						board[index] = computer; 
						return true;
					}
					break;
				case 1:
					line.append(board[2]).append(board[4]).append(board[6]); // / 
					if(isDirectActionNeeded(line, action)) {
						int index = findEmptyCell(2, 4, 6);
						board[index] = computer; 
						return true;
					}
					break;
				case 2:
					line.append(board[0]).append(board[1]).append(board[2]);  // -
					if(isDirectActionNeeded(line, action)) {
						int index = findEmptyCell(0, 1, 2);
						board[index] = computer; 
						return true;
					}
					break;
				case 3:
					line.append(board[3]).append(board[4]).append(board[5]);  // -
					if(isDirectActionNeeded(line, action)) {
						int index = findEmptyCell(3, 4, 5);
						board[index] = computer; 
						return true;
					}
					break;
				case 4:
					line.append(board[6]).append(board[7]).append(board[8]);  // - 
					if(isDirectActionNeeded(line, action)) {
						int index = findEmptyCell(6, 7, 8);
						board[index] = computer; 
						return true;
					}
					break;
				case 5:
					line.append(board[0]).append(board[3]).append(board[6]);  // |  
					if(isDirectActionNeeded(line, action)) {
						int index = findEmptyCell(0, 3, 6);
						board[index] = computer; 
						return true;
					}
					break;
				case 6:
					line.append(board[1]).append(board[4]).append(board[7]);  // | 
					if(isDirectActionNeeded(line, action)) {
						int index = findEmptyCell(1, 4, 7);
						board[index] = computer; 
						return true;
					}
					break;
				case 7:
					line.append(board[2]).append(board[5]).append(board[8]); // |   
					if(isDirectActionNeeded(line, action)) {
						int index = findEmptyCell(2, 5, 8);
						board[index] = computer; 
						return true;
					}
					break;
			}
		}
		return false;			
	}

	/**
	* Method to find the first empty cell to make an action.
	* @param the 3 cells to check for empty one.
	* @return index of empty cell.
	*/
	private int findEmptyCell(int cell1, int cell2, int cell3) {
		if(board[cell1] == ' ') {
			return cell1;
		} else if (board[cell2] == ' ') {
			return cell2;
		} else {
			return cell3;
		}
	}

	/**
	* Method to check if there's a direct action should be taken (winning move, defense move or progressive move).
	* @param the line of 3 cells and the target action.
	* @return true if action should be taken or not if no need for action
	*/
	private boolean isDirectActionNeeded(StringBuilder line, Action action) {
		String lineString = line.toString();
		lineString = lineString.replaceAll("\\s","");
		if (lineString.equals("XX")) { // Computer can win if apply this move or lose if ignore this move
			if((action == Action.WIN && computer == 'X') || ((action == Action.LOSE && computer == 'O'))) {
				return true;
			}
		} else if (lineString.equals("OO")) { // Computer can win if apply this move or lose if ignore this move
			if((action == Action.WIN && computer == 'O') || ((action == Action.LOSE && computer == 'X'))) {
				return true;
			}
		} else if (lineString.equals("X")) { // Computer can build up win by applying this move
			if(action == Action.PROGRESSIVE && computer == 'X'){
				return true;
			}		
		} else if (lineString.equals("O")) { // Computer can build up win by applying this move
			if(action == Action.PROGRESSIVE && computer == 'O'){
				return true;
			}
		}
		return false;
	}
	
	/**
	* Method to make a smart move in case of no action has been taken. 
	* Start with the middle cell then the 4 diagonals cells and then any of the 4 other cells
	*/
	private void makeSmartMove() {
		if(board[4] == ' ') {				// Start with the middle cell
			board[4] = computer;				
		} else if (board[0] == ' ') {		// Diagonals 
			board[0] = computer;
		} else if (board[2] == ' ') {		// Diagonals 
			board[2] = computer;
		} else if (board[6] == ' ') {		// Diagonals 	
			board[6] = computer;
		} else if (board[8] == ' ') {		// Diagonals 
			board[8] = computer;
		} else if (board[1] == ' ') {		// Other cells
			board[1] = computer;
		} else if (board[3] == ' ') {       // Other cells
			board[3] = computer;
		} else if (board[5] == ' ') {		// Other cells
			board[5] = computer;
		} else if (board[7] == ' ') {		// Other cells
			board[7] = computer;
		}
		
	}


}
