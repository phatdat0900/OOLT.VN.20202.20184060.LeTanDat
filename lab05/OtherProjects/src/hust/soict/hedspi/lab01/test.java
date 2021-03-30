package hust.soict.hedspi.lab01;

public class test {
	public static void main(String[] args) {
		int n [] = {1,2,3,4};
		System.out.println(sumArray(n));	
	}
	
	public static int sumArray(int n []) {
		assert  n.length > 8 :"do dai cua mang qua be"  ;
		int total =0;
		for(int i =0 ;i < n.length;i++) {
			total +=n[i];
		}
		return total;
	}
	

}
