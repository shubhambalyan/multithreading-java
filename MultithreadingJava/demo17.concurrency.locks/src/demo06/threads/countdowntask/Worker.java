package demo06.threads.countdowntask;

public class Worker {
	Basket basket;
	int itemsToAdd;
	Thread thread;
	boolean lockRequired;
	static long failedLockAttempt=0;
	boolean lockAquired;
	
	private void work() {
	
		for(int i=0;i<itemsToAdd;i++) {
			
			try {
				lockAquired=false;
				if(lockRequired) {
				
					
					int attempts=0;
					while(attempts<3 && ! lockAquired) {
						lockAquired= basket.lock.tryLock();
						attempts++;
					}
					
					if(!lockAquired) {
						failedLockAttempt++;
						return ;
					}
					
					
				}
				
				basket.addItem(); //what if exception is thrown here???
			}
			finally {
				
				if( lockAquired)
					basket.lock.unlock();
			}
		}
			
		
	}
	
	public Worker(Basket basket, int itemsToAdd,boolean lockRequired) {
		super();
		this.basket = basket;
		this.itemsToAdd = itemsToAdd;
		this.lockRequired=lockRequired;
		thread=new Thread(this::work);
	}
	
	
	public void start() {
		if(thread.getState()==Thread.State.NEW)
			thread.start();
	}
	

}
