package demo06.threads.countdowntask;

import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import in.conceptarchitect.threading.Threading;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Executor executor= Executors.newFixedThreadPool(4);
		
		for(int i=1;i<=20;i++) {
			
			final int id=i;
			executor.execute(()->work(id));
			
		}
			
		System.out.println("All works scheduled");
		
		
		
		
		
	}
	static Random r=new Random();
	static void work(int id) {
		
		int workTime=r.nextInt(5)*1000;
		Threading.println("worker #%d working for %d ms",id,workTime);
		Threading.sleep(workTime);
		Threading.println("worker #%d finished",id);
		
	}
	
	
}
