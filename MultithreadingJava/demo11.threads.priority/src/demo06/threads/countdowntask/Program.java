package demo06.threads.countdowntask;

import java.util.Scanner;

import in.conceptarchitect.threading.Threading;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		CounterTask c1=new CounterTask();
		CounterTask c2=new CounterTask();
		
		Thread t1=new Thread(c1);
		Thread t2=new Thread(c2);
		
		t1.setPriority(Thread.NORM_PRIORITY+2);
		t2.setPriority(Thread.NORM_PRIORITY-2);
		Thread.currentThread().setPriority(Thread.MAX_PRIORITY);
		
		System.out.println("Hit Enter to Start");
		Scanner scanner=new Scanner(System.in);
		scanner.nextLine();
		
		t1.start();
		t2.start();
		
		messageAndSleep("Sleeping for 5 seconds", 5000);
		
		Threading.println("stopping counters");
		c1.stop();
		c2.stop();
		
		
		Threading.println("c1 * counts %d\n",c1.getCount());
		Threading.println("c2 - counts %d\n",c2.getCount());
		
		
		
		
		
		
		
		Threading.println("main ends");
		
		
		
	}
	
	static void messageAndSleep(String message, int sleep) {
		Threading.println(message);
		Threading.sleep(sleep);
	}
}
