package demo03.threads.countdownthread;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		CountDownTask task1=new CountDownTask();
		CountDownTask task2=new CountDownTask();
		
		Thread thread1=new Thread(task1);
		Thread thread2=new Thread(task2);
		
		thread1.start();
		thread2.start();
		
		System.out.println("Main Thread Ends...");
		
	}

}
