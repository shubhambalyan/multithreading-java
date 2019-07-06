package demo01.threads.mainthread;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Thread onlyThread = Thread.currentThread();
		System.out.println(onlyThread);
		
		onlyThread.setName("My Personal Thread");
		onlyThread.setPriority(Thread.NORM_PRIORITY+2);
		
		System.out.println(onlyThread);
		
		System.out.println("onlyThread's id is "+onlyThread.getId());

	}

}
