package hust.soict.hedspi.lab01;

import javax.swing.JOptionPane;

public class calculation {
	public static void main(String[] args) {
		String strNum1, strNum2, strPlus, strMinus, strMul, strDiv;
		String strNote = "You have just entered: ";
		String strResult = "the results of the sum, subtraction, multiplication, and division are respectively";
		strNum1 = JOptionPane.showInputDialog(null, "Please input the first number:", "Input the first number",
				JOptionPane.INFORMATION_MESSAGE);
		strNote += strNum1 + " and ";

		strNum2 = JOptionPane.showInputDialog(null, "Please input the second number:", "Input the second number",
				JOptionPane.INFORMATION_MESSAGE);
		strNote += strNum2;
		double num1, num2, plus, minus, mul, div;
		num1 = Double.parseDouble(strNum1);
		num2 = Double.parseDouble(strNum2);
		plus = num1 + num2;
		minus = num1 - num2;
		mul = num1 * num2;
		div = num1 / num2;
		strPlus = String.valueOf(plus);
		strMinus = String.valueOf(minus);
		strMul = String.valueOf(mul);
		strDiv = String.valueOf(div);
		strResult = "Sum:" + strPlus + "  Subtraction:" + strMinus + "  Multiplication:" + strMul + "  Division:"
				+ strDiv;
		JOptionPane.showInternalMessageDialog(null, strNote, "show 2 numbers: ", JOptionPane.INFORMATION_MESSAGE);
		JOptionPane.showInternalMessageDialog(null, strResult, "Result", JOptionPane.INFORMATION_MESSAGE);

		System.exit(0);

	}

}
