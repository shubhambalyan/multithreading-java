package test.multithreading18.futureandcallable;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class Program
{

    public static void main(final String[] args)
            throws InterruptedException, ExecutionException
    {

        //TODO: 1. create a ThreadPool object
        final ExecutorService executor = Executors.newCachedThreadPool();

        //This is three rang of prime finding Job
        final int[] ranges = {
                100000,
                50000,
                200000
        };

        //TODO: 2. Create a List of Future Objects returning PrimeResult
        final List<Future<PrimeResult>> results = new ArrayList<>();

        for (final int max : ranges)
        {

            //TODO: 3. Create a Future Object returning prime result by calling executor.sumit
            //Object result=null;
            final Callable<PrimeResult> callable = () -> countPrimes(2, max);
            final Future<PrimeResult> result = executor.submit(callable);
            //TODO: 4. Add the result to the List
            results.add(result);

        }

        System.out.println("waiting for responses");

        final List<Future<PrimeResult>> completed = new ArrayList<>();
        //TODO: 5. loop through the result to find the answers
        while (results.size() > 0)
        {
            for (final Future<PrimeResult> result : results)
            {
                if (result.isDone() && !completed.contains(result))
                {
                    System.out.println(result.get());
                    completed.add(result);
                }
            }
        }

        //TODO: 6. Shutdown Executor
        executor.shutdown();

        //TODO: 7. Wait for Current Jobs to terminate
        executor.awaitTermination(1, TimeUnit.HOURS);
    }

    static PrimeResult countPrimes(final int min, final int max)
    {
        final PrimeResult result = new PrimeResult(min, max);
        for (int i = min; i < max; i++)
        {
            if (isPrime(i))
            {
                result.addPrime();
            }

        }
        return result;
    }

    private static boolean isPrime(int x)
    {

        x = Math.abs(x);
        if (x < 2)
        {
            return false;
        }

        for (int i = 2; i < x; i++)
        {
            if (x % i == 0)
            {
                return false;
            }
        }

        return true;
    }

}
