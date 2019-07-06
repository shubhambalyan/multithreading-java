package demo06.threads.countdowntask;

public class Worker {

	Basket basket;
	int itemsToAdd;
	Thread thread;
	
	public Worker(Basket basket, int itemsToAdd) {
		super();
		this.basket = basket;
		this.itemsToAdd = itemsToAdd;
		thread=new Thread(this::work);
	}
	
	public void start() {
		if(thread.getState()==Thread.State.NEW)
			thread.start();
	}
	
	
	private void work() {
	
		for(int i=0;i<itemsToAdd;i++) {
			
			basket.addItem();
			
		}
			
		
	}
	
	

}
