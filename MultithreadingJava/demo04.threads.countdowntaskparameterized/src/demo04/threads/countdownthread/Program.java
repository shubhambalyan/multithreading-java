package demo04.threads.countdownthread;

import in.conceptarchitect.threading.Threading;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		CountDownTask task1=new CountDownTask(200);
		CountDownTask task2=new CountDownTask(150);
		CountDownTask task3=new CountDownTask(300);
		
		Thread thread1=new Thread(task1);
		Thread thread2=new Thread(task2);
		Thread thread3=new Thread(task3);
		
		thread1.start();
		thread2.start();
		thread3.start();
		
		Threading.println("main ends");
		
	}

}
