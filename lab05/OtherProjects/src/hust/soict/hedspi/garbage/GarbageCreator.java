package hust.soict.hedspi.garbage;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class GarbageCreator {
	public static void main(String[] args) throws FileNotFoundException {
		String n="";
		File file = new File("C:\\Users\\DELL\\eclipse-workspace\\OtherProjects\\src\\hust\\soict\\hedspi\\garbage\\text.txt");
		Scanner scan = new Scanner(file);
		while(scan.hasNextLine()) {
			n+=scan.nextLine();
		}
		System.out.println(n);
		 
		
	}
	
    
}
