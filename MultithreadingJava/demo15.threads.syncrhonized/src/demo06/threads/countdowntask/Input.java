package demo06.threads.countdowntask;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Input {
	
	static Scanner scanner=new Scanner(System.in);


	public static String readString(String prompt) {
		System.out.print(prompt);
		return scanner.nextLine();
	}
	
	public static int readInt(String prompt) {
		System.out.print(prompt);
		return Integer.parseInt(scanner.nextLine());
	}
	
	public static boolean readBoolean(String prompt) {
		String answer=readString(prompt).toLowerCase();
		List<String> trues= Arrays.asList( "yes","y","ok","true" );
		List<String> falses=Arrays.asList( "no","n","cancle","false" );
		
		if(trues.contains(answer))
			return true;
		else if (falses.contains(answer))
			return false;
		else
			throw new RuntimeException("Invalid Input "+answer);
		
	}
}
