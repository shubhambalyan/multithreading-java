package demo06.threads.countdowntask;

public class Basket {

	long items;
	
	public  void addItem() {
		
		long current=items;
		current++;
		items=current;
	}
	
	public long getItems() {return items;}

}
