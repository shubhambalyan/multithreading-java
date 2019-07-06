package demo06.threads.countdowntask;

import java.util.Scanner;

import in.conceptarchitect.threading.Threading;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		Basket singleBasket=new Basket();
		
		int workerCount=Input.readInt("How many workers? ");
		int workCount= Input.readInt("Items per worker? ");
		boolean useSameBasket=Input.readBoolean("Use Same Basket?");
		boolean lockRequired=false;
		if(useSameBasket)
			lockRequired=Input.readBoolean("Lock Basket?");
		
		Worker [] workers=new Worker[workerCount];
		
		System.out.println("Hiring Workers...");
		for(int i=0;i<workerCount;i++) {
			
			Basket basket= useSameBasket? singleBasket : new Basket();
			
			Worker worker=new Worker(basket, workCount,lockRequired);
			workers[i]=worker;
			
		}
		
		long start=System.currentTimeMillis();
		
		System.out.println("Sending workers to work...");
		for(Worker worker : workers)
			worker.start();
		
		System.out.println("waiting for workers to finish...");
		for(Worker worker :workers)
			Threading.waitFor(worker.thread);
		
		long end=System.currentTimeMillis();
		
		System.out.println("verifying work done");
		
		long totalWorkDone=0;
		if(useSameBasket)
			totalWorkDone=singleBasket.getItems();
		else {
			for(Worker worker :workers)
				totalWorkDone+= worker.basket.getItems();
		}
		
		System.out.println("Total works done by all worker is "+totalWorkDone);
		System.out.println("Total time taken is "+(end-start)+" ms");
		System.out.println("Total Failed attempts "+Worker.failedLockAttempt);
		
		
		
		
	}
	
	
}
