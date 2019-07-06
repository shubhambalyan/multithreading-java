package in.conceptarchitect.threading;

public class Threading {
	
	public static void print(String format, Object ...args) {
		
		String message=String.format(format, args);
		
		System.out.printf( "[%d]:\t%s",Thread.currentThread().getId(), message); 
	}
	
	public static void println(String format, Object ...args) {
		print(format+"\n",args);
	}
	
	public static void print(Object o) {
		print("%s",o);
	}
	
	public static void println(Object o) {
		print("%s\n",o);
	}
	
	
	public static void sleep(int ms) {
		
		try {
			Thread.sleep(ms);
		}
		catch(InterruptedException e) {
			throw new ThreadInterruptedException(e.getMessage(), e);
		}
		
	}

	public static void waitFor(Thread ...threads ) {
		// TODO Auto-generated method stub
		
		for(Thread thread: threads) {
			try {
				thread.join();
			}
			catch(InterruptedException ex) {
				throw new ThreadInterruptedException(ex.getMessage(), ex);
			}
		}
		
	}

}
