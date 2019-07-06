package test.multithreading17.executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import in.conceptarchitect.threading.ThreadUtils;

public class Program {



	public static void main(final String[] args) throws InterruptedException {


		// TODO-1 Create the Executors
        final ExecutorService executor = Executors.newFixedThreadPool(4);

        for (int i = 0; i < 20; i++)
        {
			final int id=i;

			executor.execute(() ->{
				int max=5;
				System.out.printf("[Thread #%d] [Task #%d] starts\n",Thread.currentThread().getId(),id);
				while(max>=0) {
					System.out.printf("[Thread #%d] [Task #%d] counts %d\n",Thread.currentThread().getId(),id,max);
					max--;
					ThreadUtils.sleep(1000);
				}
				System.out.printf("[Thread #%d] [Task #%d] ends\n",Thread.currentThread().getId(),id);
			});
		}


		//TODO-2 shutdown executor

		//TODO-3 wait for termination of current task


	}

}
