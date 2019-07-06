package demo06.threads.countdowntask;

import in.conceptarchitect.threading.Threading;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		CountDownTask task1=new CountDownTask(200,false);  //auto start
		CountDownTask task2=new CountDownTask(2000,false); //manual start
		CountDownTask task3=new CountDownTask(300,false); //auto start
		
		//lets make second thread a non-critical thread
		task2.thread.setDaemon(true);
		//task1.thread.setDaemon(true);
		task3.thread.setDaemon(false);
		
		task1.start();
		task2.start();
		task3.start();
		
		
		Threading.waitFor(task1.thread,task3.thread);
		
		Threading.print("main ends");
	}
}
