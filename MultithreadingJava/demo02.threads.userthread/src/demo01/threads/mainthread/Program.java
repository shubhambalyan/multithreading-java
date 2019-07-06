package demo01.threads.mainthread;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ThreadInfoPrinter infoPrinter=new ThreadInfoPrinter();
		
		Thread userThread=new Thread(infoPrinter, "user-thread");

		userThread.start(); //execute infoPrinter.run() on a new thread
		
		infoPrinter.run();
	}

}
