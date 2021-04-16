package OCP.Chapter7;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MyRunnableClass {

    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {

//        ExecutorService executorService = Executors.newSingleThreadExecutor();
//        executorService.execute(() -> System.out.println("This is ceco"));
//        System.out.println("MAIN THREAD");
//        executorService.execute(() -> {
//            for (int i = 0; i < 100; i++) {
//                System.out.println("number = " + i);
//            }
//        });
//        System.out.println("MAIN THREAD 2");
//        Thread.sleep(2);
//        System.out.println("MAIN THREAD 3");
//        executorService.shutdown();
//
//        ExecutorService executorService2 = Executors.newSingleThreadExecutor();
//
//        try {
//            Future<?> ceco = executorService2.submit(() -> {
//
//                try {
//                    Thread.sleep(15000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                System.out.println("Ceco");
//
//            });
//            Thread.sleep(10000);
//            ceco.get(10, TimeUnit.SECONDS);
//        }
//        finally {
//            executorService2.shutdown();
//        }

//        ExecutorService executorService3 = Executors.newSingleThreadExecutor();
//        try {
//            System.out.println((executorService3.submit(() -> 23 + 20).get()));
//        }
//        finally {
//            executorService3.shutdown();
//        }

        List<Integer> myList = new ArrayList<>();
        for (int i = 0; i < 100_000_000; i++) {
            myList.add(i);
        }
        long startTime = System.currentTimeMillis();
        System.out.println(myList.stream().map(x -> {
            return x * 2;}).
                count());
        System.out.println("Time Required = " + (System.currentTimeMillis() - startTime));

        ForkJoinPool pool  = new ForkJoinPool();


    }


}
