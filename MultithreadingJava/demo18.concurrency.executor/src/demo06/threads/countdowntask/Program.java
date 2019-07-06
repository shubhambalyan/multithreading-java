package demo06.threads.countdowntask;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import in.conceptarchitect.threading.Threading;

public class Program {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		ExecutorService executor= Executors.newFixedThreadPool(4);
		
		for(int i=1;i<=20;i++) {
			
			final int id=i;
			executor.execute(()->work(id));
			
		}
			
		System.out.println("All works scheduled");
		executor.execute(()->Threading.println("I am a task before shutdown") );
		
		executor.shutdown(); //no extra work coming your way
		
		//executor.execute(()->Threading.println("I am a task after shutdown") );
		
		executor.awaitTermination(1, TimeUnit.HOURS);
		
		System.out.println("Program ends");
		
		
		
		
		
	}
	static Random r=new Random();
	static void work(int id) {
		
		int workTime=r.nextInt(5)*1000;
		Threading.println("worker #%d working for %d ms",id,workTime);
		Threading.sleep(workTime);
		Threading.println("worker #%d finished",id);
		
	}
	
	
}
