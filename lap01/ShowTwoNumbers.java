package Lap01;

import javax.swing.JOptionPane;

public class ShowTwoNumbers {
public static void main(String[] args) {
	String num1,num2;
	String strNote= "You have just entered: ";
	num1 = JOptionPane.showInputDialog(null,"Please input the first number:"
			                           ,"Input the first number",JOptionPane.INFORMATION_MESSAGE);
	strNote += num1 + " and ";
	num2 = JOptionPane.showInputDialog(null,"Please input the second number:"
            ,"Input the second number",JOptionPane.INFORMATION_MESSAGE);
	strNote += num2;
	JOptionPane.showInternalMessageDialog(null,strNote,
			"show 2 numbers: ",JOptionPane.INFORMATION_MESSAGE);
	System.exit(0);
}
}
