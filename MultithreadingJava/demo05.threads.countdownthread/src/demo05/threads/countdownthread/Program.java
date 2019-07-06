package demo05.threads.countdownthread;

import in.conceptarchitect.threading.Threading;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		CountDownThread task1=new CountDownThread(200);
		CountDownThread task2=new CountDownThread(150);
		CountDownThread task3=new CountDownThread(300);
		
		
		
		task1.start();
		task2.start();
		task3.start();
		
		Threading.println("main ends");
		
	}

}
