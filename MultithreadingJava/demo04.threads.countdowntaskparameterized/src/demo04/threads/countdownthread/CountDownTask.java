package demo04.threads.countdownthread;

import in.conceptarchitect.threading.Threading;

public class CountDownTask implements Runnable {

	int max;
	
	
	public CountDownTask(int max) {
		super();
		this.max = max;
	}


	@Override
	public void run() {
		// TODO Auto-generated method stub
		Threading.println("starts");
		
		while(max>=0) {
			Threading.println("counts %d",max);
			max--;
		}
		Threading.println("ends");
		
	}

}
