package demo06.threads.countdowntask;

import org.omg.PortableServer.POAManagerPackage.State;

import in.conceptarchitect.threading.Threading;

public class CounterTask implements Runnable {
	
	long count;
	volatile boolean stopRequested; //avoid optimizing this value
	
	

	@Override
	public void run() {
		// TODO Auto-generated method stub
		Threading.println("starts");
		while(!stopRequested) {
			count++;
		}
		Threading.println("stops");
	}


	public void stop() {
		stopRequested=true;
	}
	
	
	public long getCount() {
		return count;
	}
	
	


}
