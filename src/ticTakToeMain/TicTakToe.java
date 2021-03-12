package ticTakToeMain;

import java.awt.*;
import java.util.*;
import java.util.List;


public class TicTakToe {
	static ArrayList<Integer> playerPosistions = new ArrayList<Integer>();
	static ArrayList<Integer> cpuPosistions = new ArrayList<Integer>();
	
	public static void main(String[] args) {
		char[] [] gameBoard = {{' ','|',' ','|',' '},
							   {'-','+','-','+','-'},
							   {' ','|',' ','|',' '},
							   {'-','+','-','+','-'},
							   {' ','|',' ','|',' '}};
		printGameBoard(gameBoard);
		
		while(true){
			Scanner scan = new Scanner(System.in);
			System.out.println("enter your placement (1-9) 1 = top left corner");
			int playerPos = scan.nextInt();
			while(playerPosistions.contains(playerPos) || cpuPosistions.contains(playerPos)){
				System.out.println("Positions already taken, choose another");
				playerPos = scan.nextInt();
			}
			placePiece(gameBoard, playerPos, "player" );
			String result = checkWinner();
			System.out.println(result);
			if(result.length()> 1)
			{
				break;
			}
			
			Random rand = new Random();
			int cpuPos= rand.nextInt(9) +1;
			while(playerPosistions.contains(cpuPos) || cpuPosistions.contains(cpuPos)){
				cpuPos= rand.nextInt(9) +1;
			}
			placePiece(gameBoard, cpuPos, "cpu" );
			
			result = checkWinner();
			System.out.println(result);
			
			if(result.length()> 1)
			{
				break;
			}
		}
		

	}
	
	public static void printGameBoard(char[] [] gameBoard){
		for(char[] row : gameBoard){
			for(char c : row){
				System.out.print(c);
			}
			System.out.println();
		}
	}
		
	public static void placePiece(char[] [] gameBoard, int pos, String user){
		
		char symbol = ' ';
		
		if(user.equals("player")){
			symbol = 'X';
			playerPosistions.add(pos);
		}else{
			symbol = 'O';
			cpuPosistions.add(pos);
		}
		
		switch(pos){
			case 1: gameBoard[0] [0] = symbol; break;
			case 2: gameBoard[0] [2] = symbol; break;
			case 3: gameBoard[0] [4] = symbol; break;
			case 4: gameBoard[2] [0] = symbol; break;
			case 5: gameBoard[2] [2] = symbol; break;
			case 6: gameBoard[2] [4] = symbol; break;
			case 7: gameBoard[4] [0] = symbol; break;
			case 8: gameBoard[4] [2] = symbol; break;
			case 9: gameBoard[4] [4] = symbol; break;
			default: break;
		
		}
		
		printGameBoard(gameBoard);
	}
	
	public static String checkWinner(){
		
		List<Integer> topRow = Arrays.asList(1, 2, 3);
		List<Integer> midRow =  Arrays.asList(4, 5, 6);
		List<Integer> bottomRow =  Arrays.asList(7, 8, 9);
		List<Integer> liftRow = Arrays.asList(1, 4, 7);
		List<Integer> midVertRow = Arrays.asList(2, 5, 8);
		List<Integer> rightRow = Arrays.asList(3, 6, 9);
		List<Integer> diag1Row = Arrays.asList(1, 5, 9);
		List<Integer> diag2Row = Arrays.asList(7, 5, 3);
		
		ArrayList<List<Integer>> winning = new ArrayList<List<Integer>>();
		winning.add(topRow);
		winning.add(midRow);
		winning.add(bottomRow);
		winning.add(liftRow);
		winning.add(midVertRow);
		winning.add(rightRow);
		winning.add(diag1Row);
		winning.add(diag2Row);
		
		for(List<Integer> l : winning){
			if(playerPosistions.containsAll(l))
			{
				return "Congrats You Win!!";
			}
			else if(cpuPosistions.containsAll(l))
			{
				return "CPU wins, bummer :(";
			}
			else if(playerPosistions.size() + cpuPosistions.size() >= 9)
			{
				return "Its a Tie";
			}
		}
		
		
		return "";
	}
}

