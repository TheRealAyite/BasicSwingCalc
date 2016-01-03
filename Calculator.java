import java.awt.*;
import java.awt.event.*;
import java.util.*;

import javax.swing.*;

public class Calculator {
	
	JPanel numberPanel1;
	JPanel numberPanel2;
	JPanel bigNumberPanel;
	JPanel resultArea;
	JFrame theFrame;
	JTextField result;
	ArrayList<JButton> numberButtons;
	
	
	double [] valuesToOperate = new double[2];
	int operator = 0;
	int equalsCount = 0;
	double lastNum;
	double resultingNumber;
	
	public static void main(String[] args)
	{
		Calculator test = new Calculator();
		test.buildGui();
		
	}
	
	public void buildGui(){
		numberPanel1 = new JPanel();
		numberPanel2 = new JPanel();
		bigNumberPanel = new JPanel();
		theFrame = new JFrame("Ayite Calculator");
		result = new JTextField(19);
		resultArea = new JPanel();
		resultArea.add(result);
		numberButtons = new ArrayList<JButton>();
		
		
		for(int i = 0; i < 5; i++){
			JButton c = new JButton("" + i);
			numberButtons.add(c);
			numberPanel1.add(c);
		}
		 
		for(int i = 5 ; i < 10; i++)
		{
			JButton c = new JButton("" + i);
			numberButtons.add(c);
			numberPanel2.add(c);
		}
		numberButtons.get(0).addActionListener(new numberZero());
		numberButtons.get(1).addActionListener(new numberOne());
		numberButtons.get(2).addActionListener(new numberTwo());
		numberButtons.get(3).addActionListener(new numberThree());
		numberButtons.get(4).addActionListener(new numberFour());
		numberButtons.get(5).addActionListener(new numberFive());
		numberButtons.get(6).addActionListener(new numberSix());
		numberButtons.get(7).addActionListener(new numberSeven());
		numberButtons.get(8).addActionListener(new numberEight());
		numberButtons.get(9).addActionListener(new numberNine());
		
		JButton clear = new JButton("C");
	
		clear.addActionListener(new clearButton());
		
		numberPanel1.setLayout(new BoxLayout(numberPanel1, BoxLayout.Y_AXIS));
		numberPanel2.setLayout(new BoxLayout(numberPanel2, BoxLayout.Y_AXIS));
		bigNumberPanel.add(numberPanel1);
		bigNumberPanel.add(numberPanel2);
		
		JPanel operators = new JPanel();
		JButton equals = new JButton("=");
		JButton add = new JButton("+");
		JButton subtract = new JButton("-");
		JButton multiply = new JButton("*");
		JButton divide = new JButton("/");
		JPanel clearSize = new JPanel();
		
		operators.setLayout(new BoxLayout(operators, BoxLayout.Y_AXIS));
		operators.add(add);
		operators.add(subtract);
		operators.add(multiply);
		operators.add(divide);
		operators.add(equals);
		clearSize.add(clear);
		
		add.addActionListener(new add());
		subtract.addActionListener(new subtract());
		multiply.addActionListener(new multiply());
		divide.addActionListener(new divide());
		equals.addActionListener(new equals());
		
		theFrame.getContentPane().add(BorderLayout.EAST, operators);
		theFrame.getContentPane().add(BorderLayout.NORTH, resultArea);
		theFrame.getContentPane().add(BorderLayout.CENTER, bigNumberPanel);
		theFrame.getContentPane().add(BorderLayout.WEST, clearSize);
		theFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		theFrame.setSize(400,400);
		theFrame.setVisible(true);
	}
	public class numberZero implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent a) {
			result.setText(result.getText() + "0");
		}
		
	}
	public class numberOne implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent a) {
			result.setText(result.getText() + "1");
		}
		
	}
	public class numberTwo implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent a) {
			result.setText(result.getText() + "2");
		}
		
	}
	public class numberThree implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent a) {
			result.setText(result.getText() + "3");
		}
		
	}
	public class numberFour implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent a) {
			result.setText(result.getText() + "4");
		}
		
	}
	public class numberFive implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent a) {
			result.setText(result.getText() + "5");
		}
		
	}
	public class numberSix implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent a) {
			result.setText(result.getText() + "6");
		}
		
	}
	public class numberSeven implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent a) {
			result.setText(result.getText() + "7");
		}
		
	}
	public class numberEight implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent a) {
			result.setText(result.getText() + "8");
		}
		
	}
	public class numberNine implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent a) {
			result.setText(result.getText() + "9");
		}
		
	}
	public class clearButton implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent a) {
			// TODO Auto-generated method stub
			result.setText("");
			valuesToOperate[0] = 0;
			valuesToOperate[1] = 0;
			equalsCount = 0;
			operator = 0;
			lastNum = 0;
			resultingNumber = 0;
			}
	}
	
	public class add implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent arg0) 
		{
			// TODO Auto-generated method stub
			operator = 0;
			valuesToOperate[0] = Double.parseDouble(result.getText());
			result.setText("");
			}
	}

	public class subtract implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent arg0) 
		{
			// TODO Auto-generated method stub
			operator = 1;
			valuesToOperate[0] = Double.parseDouble(result.getText());
			result.setText("");
			}
	}
	public class multiply implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent arg0) 
		{
			// TODO Auto-generated method stub
			operator = 2;
			valuesToOperate[0] = Double.parseDouble(result.getText());
			result.setText("");
			}
	}
	public class divide implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent arg0) 
		{
			// TODO Auto-generated method stub
			operator = 3;
			valuesToOperate[0] = Double.parseDouble(result.getText());
			result.setText("");
			}
	}
	public class equals implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			equalsCount++;
			if(operator == 0){
				if(equalsCount == 1){
					valuesToOperate[1] = Double.parseDouble(result.getText());
					lastNum = valuesToOperate[1];
					resultingNumber = valuesToOperate[0] + valuesToOperate[1];
					valuesToOperate[0] = resultingNumber;
					result.setText("" + resultingNumber);
				}//end of conditional
				if(equalsCount > 1){
					resultingNumber = resultingNumber + lastNum;
					result.setText("" + resultingNumber);
				}
			}// end of operator conditional
			if(operator == 1){
				if(equalsCount == 1){
					valuesToOperate[1] = Double.parseDouble(result.getText());
					lastNum = valuesToOperate[1];
					resultingNumber = valuesToOperate[0] - valuesToOperate[1];
					valuesToOperate[0] = resultingNumber;
					result.setText("" + resultingNumber);
				}//end of conditional
				if(equalsCount > 1){
					resultingNumber = resultingNumber - lastNum;
					result.setText("" + resultingNumber);
				}
			}
			if(operator == 2){
				if(equalsCount == 1){
					valuesToOperate[1] = Double.parseDouble(result.getText());
					lastNum = valuesToOperate[1];
					resultingNumber = valuesToOperate[0] * valuesToOperate[1];
					valuesToOperate[0] = resultingNumber;
					result.setText("" + resultingNumber);
				}//end of conditional
				if(equalsCount > 1){
					resultingNumber = resultingNumber * lastNum;
					result.setText("" + resultingNumber);
				}
			}
			if(operator == 3){
				if(equalsCount == 1){
					valuesToOperate[1] = Double.parseDouble(result.getText());
					lastNum = valuesToOperate[1];
					resultingNumber = valuesToOperate[0] / valuesToOperate[1];
					//valuesToOperate[0] = resultingNumber;
					result.setText("" + resultingNumber);
				}//end of conditional
				if(equalsCount > 1){
					valuesToOperate[0] = resultingNumber;
					resultingNumber = resultingNumber /  lastNum;
					result.setText("" + resultingNumber);
				}
			}
		}// end of method
		
	}// end of class
}
