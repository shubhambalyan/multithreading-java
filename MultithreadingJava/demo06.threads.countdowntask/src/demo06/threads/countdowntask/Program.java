package demo06.threads.countdowntask;

import in.conceptarchitect.threading.Threading;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		CountDownTask task1=new CountDownTask(200);
		CountDownTask task2=new CountDownTask(150);
		CountDownTask task3=new CountDownTask(300);
		
		
		
		task1.start();
		task2.start();
		task3.start();
	
		Threading.println("Main ends");
	}
}
