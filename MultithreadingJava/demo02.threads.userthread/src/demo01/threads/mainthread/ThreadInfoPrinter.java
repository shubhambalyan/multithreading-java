package demo01.threads.mainthread;

public class ThreadInfoPrinter implements Runnable {

	@Override
	public void run() {
		
		Thread currentThread=Thread.currentThread();
		
		System.out.println("Thread #"+currentThread.getId()+"\t"+currentThread);

	}

}
