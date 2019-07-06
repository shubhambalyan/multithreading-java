package demo06.threads.countdowntask;

import in.conceptarchitect.threading.Threading;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		CountDownTask task1=new CountDownTask(20,false);  //auto start
		CountDownTask task2=new CountDownTask(20,false); //manual start
		CountDownTask task3=new CountDownTask(20,false); //auto start
		
		
		messageAndSleep("Starting Threads after 2 second", 2000);
		task1.start();
		task2.start();
		task3.start();
		
		messageAndSleep("sleeping for 5 seconds...", 5000);
		
		Threading.println("suspending thread 1");
		task1.thread.suspend();
		messageAndSleep("thread1 suspended. sleeping for 5 seconds",5000);
		
		Threading.println("Resuming thread1, stopping thread2");
		task1.thread.resume();
		task2.thread.stop();
		
		Threading.println("Waiting for Threads to finish");
		
		Threading.waitFor(task1.thread,task3.thread);
		
		
		Threading.println("main ends");
		
		
		
	}
	
	static void messageAndSleep(String message, int sleep) {
		Threading.println(message);
		Threading.sleep(sleep);
	}
}
