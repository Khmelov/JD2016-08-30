package by.it.akhmelev.jd02_03.classroom3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class Dispatcher {
    static ExecutorService poolCashiers= Executors.newFixedThreadPool(5);


    static public AtomicInteger countCashiers=new AtomicInteger(0);
    static AtomicInteger countBuyers=new AtomicInteger(0);
    static AtomicInteger countOutBuyers=new AtomicInteger(0);
    static final int PLAN_COUNT_BUYERS=10;

    static boolean isFinished(){
        return (countOutBuyers.get()>=PLAN_COUNT_BUYERS);
    }
    //

}
