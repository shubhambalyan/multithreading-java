package demo06.threads.countdowntask;

import in.conceptarchitect.threading.Threading;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		CountDownTask task1=new CountDownTask(200);
		CountDownTask task2=new CountDownTask(150);
		CountDownTask task3=new CountDownTask(300);
		
		
		
		task1.start();
		task2.start();
		task3.start();
		
		//no easy way to find how much to count.
				//wastes cpu cycle
				//busyMain();
				
				//GOOD: always know when to stop
				//BAD: wastes CPU cycle
				//isAliveCheck(task1, task2, task3);
				
				//GOOD: CPU cycle is not wasted
				//BAD: no way to predict how much to sleep
				//letMainSleep();
				//Threading.sleep(5000);

				
				//GOOD: No CPU cycle wasted
				//GOOD: CPU handles waking of current thread as soon as other thread ends
				//joinTest(task1, task2, task3);
				
				Threading.waitFor(task1.thread, task2.thread,task3.thread);
				
				
				//This should be the last line to execute
				Threading.println("main ends");
				
			}

			private static void joinTest(CountDownTask task1, CountDownTask task2, CountDownTask task3) {
				try {
					task1.thread.join();
					task2.thread.join();
					task3.thread.join();
				}catch(InterruptedException e) {
					System.out.println("will never occur in this code");
				}
			}

			private static void letMainSleep() {
				try {
					Thread.sleep(5000);
				}
				catch(InterruptedException ex) {
					System.out.println("You will never reach here!!!");
				}
			}

			private static void isAliveCheck(CountDownTask task1, CountDownTask task2, CountDownTask task3) {
				while(task1.thread.isAlive() || task2.thread.isAlive() || task3.thread.isAlive())
					System.out.print("+");
			}

			private static void busyMain() {
				//let main be busy doing something
				for(int i=0;i<25000;i++)
					System.out.println("+");
			}


}
