package demo06.threads.countdowntask;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import in.conceptarchitect.threading.Threading;

public class Program {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		ExecutorService executor= Executors.newFixedThreadPool(4);
		int workCount=Input.readInt("How may worker ?");
		final CountDownLatch latch=new CountDownLatch(workCount);
		
		
		
		for(int i=1;i<=workCount;i++) {
			
			final int id=i;
			
			executor.execute(()->work(id,latch));
			
			//new Thread(()->work(id,latch)).start();
			
		}
			
		System.out.println("All works scheduled");
		//executor.shutdownNow();
		executor.shutdown();
		
		latch.await(); //wait till latch count becomes 0
		
		
		System.out.println("All works finished.");
		
	}
	static Random r=new Random();
	static void work(int id, CountDownLatch latch) {
		
		int workTime=r.nextInt(5)*1000;
		Threading.println("worker #%d working for %d ms",id,workTime);
		Threading.sleep(workTime);
		Threading.println("worker #%d finished",id);
		latch.countDown();
		
	}
	
	
}
