package ticTakToeMain;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;


import javax.swing.*;

public class Gui implements ActionListener{
	JButton one;
	JButton two;
	JButton three;
	JButton four;
	JButton five;
	JButton six;
	JButton seven;
	JButton eight;
	JButton nine;
	JFrame frame;
	
	static ArrayList<Integer> playerPos = new ArrayList<Integer>();
	static ArrayList<Integer> cpuPos = new ArrayList<Integer>();

	public Gui(){
		
		//frame set up
		frame = new JFrame();
	
		 one = new JButton("click");
		 two = new JButton("click");
		 three = new JButton("click");
		 four = new JButton("click");
		 five = new JButton("click");
		 six = new JButton("click");
		 seven = new JButton("click");
		 eight = new JButton("click");
		 nine = new JButton("click");
		
		
		one.addActionListener(this);
		two.addActionListener(this);
		three.addActionListener(this);
		four.addActionListener(this);
		five.addActionListener(this);
		six.addActionListener(this);
		seven.addActionListener(this);
		eight.addActionListener(this);
		nine.addActionListener(this);
		

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Tic Tak Toe Yo");
		frame.pack();
		frame.setVisible(true);
		frame.setLayout(new GridLayout(3,3,5,5));
		frame.setSize(300,300);
		frame.setBackground(Color.BLACK);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2);
		
		//adding buttons
		frame.add(one);frame.add(two);frame.add(three);frame.add(four);frame.add(five);frame.add(six);frame.add(seven);frame.add(eight);frame.add(nine);

	}
	public static void main(String[] args) {
		new Gui();
		
		

	}
	public void actionPerformed(ActionEvent e) {
		  if (e.getSource()==one)
	         {
			  if (checkAvailablity(1) == true)
		    	 {
			  one.setText("X");
			  cpuSet();
		    	 }
			  checkWinner();
	         }
	     else if (e.getSource()==two)
	         {
	    	 if (checkAvailablity(2) == true)
	    	 {
	    	 two.setText("X");
	    	 cpuSet();
	    	 }
			  checkWinner();
	    	 }
	     else if (e.getSource()==three)
	         {
	    	 if (checkAvailablity(3) == true)
	    	 {
	    	 three.setText("X");
	    	 cpuSet();
	    	 }
			  checkWinner();
	    	 }
	     else if (e.getSource()==four)
	         {
	    	 if (checkAvailablity(4) == true)
	    	 {
	    	 four.setText("X");
	    	 cpuSet();
	    	 }
			  checkWinner();
	    	 }
	     else if (e.getSource()==five)
	         {
	    	 if (checkAvailablity(5) == true){	
	    	 five.setText("X");
	    	 cpuSet();
	    	 }
			  checkWinner();
	    	 }
	     else if (e.getSource()==six)
         {
	    	 if (checkAvailablity(6) == true)
	    	 { 
	    	 six.setText("X");
	    	 cpuSet();
	    	 }
			  checkWinner();
	    	 }
	     else if (e.getSource()==seven)
         {
	    	 if (checkAvailablity(7) == true)
	    	 {
	    	 seven.setText("X");
	    	 cpuSet();
	    	 }
			  checkWinner();
         }
	     else if (e.getSource()==eight)
         {
	    	 if (checkAvailablity(8) == true)
	    	 {
	    	 eight.setText("X");
	    	 cpuSet();
	    	 }
			  checkWinner();
         }
	     else if (e.getSource()==nine)
         {
	    	 if (checkAvailablity(9) == true)
	    	 {
	    	 nine.setText("X");
			  cpuSet();
	    	 }
			  checkWinner();
         }
		  
		
		
		
	}
	public boolean checkAvailablity(int x)
	{
		if(playerPos.contains(x) || cpuPos.contains(x)){
			JOptionPane.showMessageDialog(null,"Positions already taken, choose another");
			return false;
		}else{
			playerPos.add(x);
			if(playerPos.size() + cpuPos.size() >= 9)
			{
				return false;
			}
			else
			{
			return true;
			}
		}
	}
	public void cpuSet()
	{
		Random rand = new Random();
		int cPos= rand.nextInt(9) +1;

		while(playerPos.contains(cPos) || cpuPos.contains(cPos))
		{
			cPos= rand.nextInt(9) +1;
		}
		cpuPos.add(cPos);
		
		  if (cPos == 1)
	         {
			  one.setText("O");
	         }
	     else if (cPos == 2)
	         {
	    	 	two.setText("O");       
	    	 }
	     else if (cPos == 3)
	         {
	    	 	 three.setText("O");      
	    	 }
	     else if (cPos == 4)
	         {
	    	 	  four.setText("O");      
	    	 }
	     else if (cPos == 5)
	         {
	    	 	  five.setText("O");       
	    	 }
	     else if (cPos == 6)
      {
	    	  six.setText("O");        
	    	 }
	     else if (cPos == 7)
      {
	    	 seven.setText("O");
      }
	     else if (cPos == 8)
      {
	    	 eight.setText("O");
      }
	     else if (cPos == 9)
      {
	    	 nine.setText("O");
      }
	}
	
public void checkWinner(){
		
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
			if(playerPos.containsAll(l))
			{
				JOptionPane.showMessageDialog(null,"Congrats You Win!!");
				Reset();
			}
			else if(cpuPos.containsAll(l))
			{
				JOptionPane.showMessageDialog(null,"CPU wins, bummer :( ");
				Reset();
			}
			else if(playerPos.size() + cpuPos.size() >= 9)
			{
				JOptionPane.showMessageDialog(null,"Its a Tie!");
				Reset();
				
			}
		}
		
	}

	public void Reset(){
		 one.setText("click");
		 two.setText("click");
		 three.setText("click");
		 four.setText("click");
		 five.setText("click");
		 six.setText("click");
		 seven.setText("click");
		 eight.setText("click");
		 nine.setText("click");
		 
		 playerPos.clear();
		 cpuPos.clear();
	}

}
