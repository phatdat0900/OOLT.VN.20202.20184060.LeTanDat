package hust.soict.hedspi.lab02;

import java.util.Scanner;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ex6 {
	public static void main(String[] args) {
		int b = 0;
		int i, j, n;
		Random rand = new Random();
		Pattern pattern = Pattern.compile("\\d*");
		// nhap chieu dai cho mang
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();

		// nhap day so
		if (n <= 1000) {
			int[] ranNum = new int[n];
			usingRandomClass(ranNum);
			String str;
			int[] a = new int[n];
			makeArray(a, n);
			for (i = 0; i < n; i++) {
				str = sc.next();
				Matcher matcher = pattern.matcher(str);
				if (matcher.matches()) {
					a[i] = Integer.parseInt(str);
				} else {// nhap ky tu bat ki thi se sinh so ngau nhien
					a[i] = ranNum[i];
				}

			}
			System.out.print("\nday so moi la: ");
			for (i = 0; i < n; i++) {
				System.out.print(a[i] + " ");
			}

			System.out.print("\nday so tu be den lon la: ");

			sort(a);
			for (i = 0; i < n; i++) {

				System.out.print(a[i] + " ");
			}
			System.out.println();
			// tinh tong
			int count = sum(a);
			System.out.println(count);
			// tinh gia tri trung binh
			double avg = Average(a);
			System.out.println(avg);

		} else {
			System.out.println("max cua n la 1000");
			System.exit(0);

		}
	}

	static void makeArray(int a[], int n) {
		for (int i = 0; i < n; i++) {
			a[i] = 0;
		}

	}

	static void usingRandomClass(int a[]) {
		Random rand = new Random();
		for (int i = 0; i < a.length; i++) {
			a[i] = rand.nextInt(100) + 1;
			System.out.print(a[i] + "\t");
		}
		System.out.println();
	}

	static void sort(int a[]) {
		int i, j, b = 0;
		for (i = 0; i < a.length; i++) {
			for (j = i; j < a.length; j++) {
				if (a[i] >= a[j]) {
					b = a[i];
					a[i] = a[j];
					a[j] = b;
				}
			}
		}

	}

	static int sum(int a[]) {
		int count = 0;
		for (int i = 0; i < a.length; i++) {
			count = count + a[i];
		}
		System.out.print("Tong day so la : ");
		return count;
	}

	static double Average(int a[]) {
		int count = 0;
		double avg = 0;
		count = sum(a);
		avg = count / a.length;
		System.out.print("Gia tri trung binh la : ");
		return avg;

	}
}
