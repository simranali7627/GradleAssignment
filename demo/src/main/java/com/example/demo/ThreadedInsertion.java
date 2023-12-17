package com.example.demo;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class ThreadedInsertion {

    public void startInsertion(List<Student> allEmployees) {


        int threadPoolSize = 5; // You can adjust this based on your requirements
        ExecutorService executorService = Executors.newFixedThreadPool(threadPoolSize);

        int chunkSize = allEmployees.size() / threadPoolSize;

        for (int i = 0; i < threadPoolSize; i++) {
            int startIndex = i * chunkSize;
            int endIndex = (i == threadPoolSize - 1) ? allEmployees.size() : (i + 1) * chunkSize;

            List<Student> chunk = allEmployees.subList(startIndex, endIndex);

            executorService.submit(() -> DatabaseInsertion.insertEmployees(chunk));
        }

        executorService.shutdown();
    }
}
