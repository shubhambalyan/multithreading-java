package demo06.threads.countdowntask;

import java.util.Scanner;

import in.conceptarchitect.threading.Threading;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Thread t1= new Thread(new Runnable() {
			
			public void run() {
				countDown(20);
			}
		});
		
		
		Thread t2= new Thread(()-> countDown(30));
		
		t1.start();
		t2.start();
		
		Threading.waitFor(t1,t2);
		
		Threading.println("main ends");
		
	}
	
	static void countDown(int max) {
		Threading.println("starts");
		while(max>=0) {
			Threading.println("counts %d",max);
			max--;
		}
		
		Threading.println("stops");
	}
}
