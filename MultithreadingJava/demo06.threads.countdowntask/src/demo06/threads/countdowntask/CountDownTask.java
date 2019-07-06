package demo06.threads.countdowntask;

import org.omg.PortableServer.POAManagerPackage.State;

import in.conceptarchitect.threading.Threading;

public class CountDownTask implements Runnable {

	int max;
	Thread thread;
	
	public CountDownTask(int max) {
		this(max,true);
	}
	
	public CountDownTask(int max,boolean autoStart) {
		super();
		this.max = max;
		thread=new Thread(this);
		if(autoStart)
			start();
	}
	
	public void start() {
		if(thread.getState()==Thread.State.NEW)
			thread.start();
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
