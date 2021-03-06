package com.exuberant.tutorials.javaconcept.concurrent.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class ExecutorServiceTest {

    private static Logger logger = LoggerFactory.getLogger(ExecutorServiceTest.class);

    private static final int NTHREDS = 100;
    private static final int iterations = 100000;

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        callableTest();
        /*runnableTest();
        callableTest();
        futureTest();
        futureTaskTest();*/
    }

    public static void futureTaskTest() throws InterruptedException, ExecutionException {
        FutureTask<Integer> f = new FutureTask<>(new MyCallable(10));
        ExecutorService service = Executors.newFixedThreadPool(1);
        service.submit(f);
        logger.info(String.valueOf(f.get()));
        logger.info("Done with Future...");
    }

    public static void futureTest() throws InterruptedException, ExecutionException {
        ExecutorService callableExecutor = Executors.newFixedThreadPool(NTHREDS);
        List<Callable<Integer>> call = new ArrayList<>();
        for (int i = 0; i < iterations; i++) {
            Callable<Integer> worker = new MyCallable(10 + i);
            call.add(worker);
        }
        List<Future<Integer>> out = callableExecutor.invokeAll(call);
        callableExecutor.shutdown();
        for (Future<Integer> f : out) {
            logger.info("Hey" + f.get());
        }
    }

    public static void callableTest() {
        ExecutorService callableExecutor = Executors.newFixedThreadPool(NTHREDS);
        for (int i = 0; i < iterations; i++) {
            Callable<Integer> worker = new MyCallable(1000 + i);
            Future<Integer> f = callableExecutor.submit(worker);
            try {
                logger.info(String.valueOf(f.get()));
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        // This will make the executor accept no new threads
        // and finish all existing threads in the queue
        callableExecutor.shutdown();
        // Wait until all threads are finish
        if (!callableExecutor.isTerminated()) {
            logger.info("waiting");
        }
        logger.info("Finished all Callable threads");

    }

    public static void runnableTest() {
        ExecutorService runnableExecutor = Executors.newFixedThreadPool(NTHREDS);
        for (int i = 0; i < NTHREDS; i++) {
            Runnable worker = new MyRunnable(1000L + i);
            runnableExecutor.execute(worker);
        }
        // This will make the executor accept no new threads
        // and finish all existing threads in the queue
        runnableExecutor.shutdown();
        // Wait until all threads are finish
        while (!runnableExecutor.isTerminated()) {

        }
        logger.info("Finished all Runnable threads");
    }

}