package demo06.threads.countdowntask;

import java.util.concurrent.locks.ReentrantLock;

public class Basket {

	long items;
	ReentrantLock lock=new ReentrantLock();
	
	
	public  void addItem() {
		
		
		long current=items;
		current++;
		items=current;
		
	}
	
	public long getItems() {return items;}

}
