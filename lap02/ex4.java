package lap02;
import java.util.Scanner;
public class ex4 {
	public static void main (String[] args) {
		Scanner Keyboard = new Scanner(System.in);
		int i,j,count,n ;
		n = Keyboard.nextInt();
		for(i=1;i<=n;i++) {
			for(j=1;j<2*n;j++) {
				count=n-j;
				if(Math.abs(count)<=(i-1)) {
					System.out.print("*");				
				}else System.out.print(" ");
			}
			System.out.println(" ");
		}
	}
	

}
