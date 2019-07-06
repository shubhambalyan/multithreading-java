// Factorial.java - (insert one line description here)
// (C) Copyright 2018 Hewlett Packard Enterprise Development LP

package demo.threading08.dameonthread;

import in.conceptarchitect.threading.ThreadUtils;

/**
 *
 */
public class Factorial implements Runnable
{

    int n;
    int result;
    Thread t;

    /**
     * @return the result
     */
    public int getResult()
    {
        if (t.isAlive())
        {
            ThreadUtils.waitFor(t);
        }
        return result;

    }

    public Factorial(final int n)
    {
        // TODO Auto-generated constructor stub
        System.out.println("calculating factorial");
        this.n = n;
        t = new Thread(this);
        t.start();
        //        ThreadUtils.waitFor(t);
    }

    int factorial(final int n)
    {
        try
        {
            Thread.sleep(1000);
        }
        catch (final InterruptedException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        int fact = 1;
        for (int i = 1; i <= n; i++)
        {
            try
            {
                Thread.sleep(1000);
            }
            catch (final InterruptedException e)
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            fact = fact * i;
        }
        return fact;
    }

    /*
     * @see java.lang.Runnable#run()
     */
    @Override
    public void run()
    {
        result = factorial(n);

    }

}
