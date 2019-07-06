package demo03.threads.countdownthread;

public class CountDownTask implements Runnable {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		Thread currentThread=Thread.currentThread();
		int max=10;
		while(max>=0) {
			System.out.printf("Thread #%d : counts %d\n",currentThread.getId(), max);
			max--;
		}
		System.out.printf("Thread #%d : ends\n",currentThread.getId());
		
	}

}
