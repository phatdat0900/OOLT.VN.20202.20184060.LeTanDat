package lap02;

import java.util.Scanner;

public class matrix {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] a = new int[n][n];
		int i, j;
		for (i = 0; i < n; i++) {
			for (j = 0; j < n; j++) {
				System.out.println("nhap a[" + i + "][" + j + "] = ");
				a[i][j] = sc.nextInt();
			}
		}
		for (i = 0; i < n; i++) {
			for (j = 0; j < n; j++) {
				System.out.print(a[i][j] + "\t");
			}
			System.out.println("\n");
		}

	}
}
