package hust.soict.hedspi.lab01;

import javax.swing.JOptionPane;

public class equation {
	public static void main(String[] args) {
		double num1, num2, num3, num4, x, y;
		String strNum1, strNum2, strNum3, strNum4, var, choice;
		String strNote = "You have just entered: ";
		String fequation = "The first-degree equation:  ";
		String sequation = "The second-degree equation:  ";
		String strResult;
		choice = JOptionPane.showInputDialog(null,
				"input 1 for The first-degree equation - input 2 for The second-degree equation  ", "Input number",
				JOptionPane.INFORMATION_MESSAGE);
		int n = Integer.parseInt(choice);
		switch (n) {
		case 1:
			strNum1 = JOptionPane.showInputDialog(null, "Please input the first number:", "Input the first number",
					JOptionPane.INFORMATION_MESSAGE);
			int i = Integer.parseInt(strNum1);
			if (i == 0) {
				System.exit(0);
			}
			strNote += strNum1 + " and ";
			fequation += strNum1 + "*x + ";

			strNum2 = JOptionPane.showInputDialog(null, "Please input the second number:", "Input the second number",
					JOptionPane.INFORMATION_MESSAGE);
			strNote += strNum2;
			fequation += strNum2 + " = 0";

			num1 = Double.parseDouble(strNum1);
			num2 = Double.parseDouble(strNum2);
			x = -num2 / num1;
			var = String.valueOf(x);
			strResult = "the equation has the solution: " + var;
			JOptionPane.showInternalMessageDialog(null, strNote, "Show 2 numbers: ", JOptionPane.INFORMATION_MESSAGE);
			JOptionPane.showInternalMessageDialog(null, fequation, "The first-degree equation",
					JOptionPane.INFORMATION_MESSAGE);
			JOptionPane.showInternalMessageDialog(null, strResult, "Result", JOptionPane.INFORMATION_MESSAGE);

			System.exit(0);

		case 2:
			strNum1 = JOptionPane.showInputDialog(null, "Please input the first number:", "Input the first number",
					JOptionPane.INFORMATION_MESSAGE);
			i = Integer.parseInt(strNum1);
			if (i == 0) {
				System.exit(0);
			}
			strNote += strNum1 + " and ";
			sequation += strNum1 + "*x*x + ";

			strNum2 = JOptionPane.showInputDialog(null, "Please input the second number:", "Input the second number",
					JOptionPane.INFORMATION_MESSAGE);
			strNote += strNum2 + " and ";
			sequation += strNum2 + "*x + ";

			strNum3 = JOptionPane.showInputDialog(null, "Please input the third number:", "Input the second number",
					JOptionPane.INFORMATION_MESSAGE);
			strNote += strNum3;
			sequation +=strNum3 + "= 0";

			num1 = Double.parseDouble(strNum1);
			num2 = Double.parseDouble(strNum2);
			num3 = Double.parseDouble(strNum3);
			JOptionPane.showInternalMessageDialog(null, strNote, "Show 3 numbers: ", JOptionPane.INFORMATION_MESSAGE);
			JOptionPane.showInternalMessageDialog(null, sequation, "The second-degree equation",
					JOptionPane.INFORMATION_MESSAGE);

			double delta;
			delta = num2 * num2 - 4 * num1 * num3;
			if (delta == 0) {
				x = -num2 / (2 * num1);
				var = String.valueOf(x);
				strResult = "Equations have double solutions" + var;
				JOptionPane.showInternalMessageDialog(null, strResult, "Result", JOptionPane.INFORMATION_MESSAGE);
				System.exit(0);
			}
			if (delta > 0) {
				x = (-num2 + Math.sqrt(delta)) / 2 * num1;
				y = (-num2 - Math.sqrt(delta)) / 2 * num1;
				String var2;
				var = String.valueOf(x);
				var2 = String.valueOf(y);
				strResult = "Equations have two distinct solutions: " + var + "and " + var2;
				JOptionPane.showInternalMessageDialog(null, strResult, "Result", JOptionPane.INFORMATION_MESSAGE);
				System.exit(0);
			}
			if (delta < 0) {
				JOptionPane.showInternalMessageDialog(null, "the equation has no solution");
			}

		default:
			JOptionPane.showMessageDialog(null, "Error", "Error", JOptionPane.ERROR_MESSAGE);
			System.exit(0);
		}

	}

}
