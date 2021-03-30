package hust.soict.hedspi.lab02;

import java.util.Scanner;

public class matrix {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[][] a = new int[m][n];
		int[][] b = new int[m][n];
		int[][] c = new int[m][n];
		System.out.println("nhap ma tran A:");
		makeMatrix(a, m, n);
		System.out.println("nhap ma tran B:");
		makeMatrix(b, m, n);
		System.out.println("Tong cua ma tran A va B:");
		int i, j;
		for (i = 0; i < m; i++) {
			for (j = 0; j < n; j++) {
				c[i][j] = a[i][j]+b[i][j];
			}
		}
		for (i = 0; i < m; i++) {
			for (j = 0; j < n; j++) {
				System.out.print(c[i][j] + "\t");
			}
			System.out.println("\n");
		}

	}

	static void makeMatrix(int a[][], int m, int n) {
		Scanner sc = new Scanner(System.in);
		int i, j;
		for (i = 0; i < m; i++) {
			for (j = 0; j < n; j++) {
				System.out.println("nhap[" + i + "][" + j + "] = ");
				a[i][j] = sc.nextInt();
			}
		}
		for (i = 0; i < m; i++) {
			for (j = 0; j < n; j++) {
				System.out.print(a[i][j] + "\t");
			}
			System.out.println("\n");
		}

	}

}
