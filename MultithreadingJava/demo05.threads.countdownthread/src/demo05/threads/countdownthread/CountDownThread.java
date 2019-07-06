package demo05.threads.countdownthread;

import in.conceptarchitect.threading.Threading;

public class CountDownThread extends Thread {

	int max;
	
	
	public CountDownThread(int max) {
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
