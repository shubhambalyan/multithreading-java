package demo06.threads.countdowntask;

import org.omg.PortableServer.POAManagerPackage.State;

import in.conceptarchitect.threading.Threading;

public class Counter  {
	
	long count;
	volatile boolean stopRequested; //avoid optimizing this value
	
	public void count() {
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
