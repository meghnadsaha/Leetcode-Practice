package com.interview.thread;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public class ExecutorServiceExample {

    public static void main(String[] args) {
        // 50000 urls
        List<String> urlList = new ArrayList<>();
        urlList.add("http://www.example.com");
        urlList.add("http://www.example1.com");
        urlList.add("http://www.example2.com");
        urlList.add("http://www.example.com");
        urlList.add("http://www.example1.com");
        urlList.add("http://www.example2.com");
        urlList.add("http://www.example.com");
        urlList.add("http://www.example1.com");
        urlList.add("http://www.example2.com");
        urlList.add("http://www.example.com");
//        urlList.add("http://www.example50000.com");

        // task start time
        long startTime = System.currentTimeMillis();

        initiateRequest(urlList);

        // task end time
        long endTime = System.currentTimeMillis();
        double timeTaken = (endTime - startTime) / 1000;

        System.out.println(
                "Time taken to run " + urlList.size() + " urls = " + timeTaken + " seconds");
    }


    public static void initiateRequest(List<String> urlList) {

        if (urlList.isEmpty()) {
            return;
        }

        int numberOfThreads = 2;
        ExecutorService fixedPoolExecutor = Executors.newFixedThreadPool(numberOfThreads);

        List<Future<String>> futureList = new ArrayList<>();
        urlList.forEach(url -> {
            Future<String> future = fixedPoolExecutor.submit(() -> myTask(url));
            futureList.add(future);
        });

        for (Future<String> future : futureList) {
            try {
                System.out.println("Future = " + future.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Complete");
    }

    private static String myTask(String url) {
        CloseableHttpClient client = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(url);
        int responseCode = 00;
        CloseableHttpResponse response = null;
        try {
            response = client.execute(httpGet);
            responseCode = response.getStatusLine().getStatusCode();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (client != null) {
                    client.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return url + ", response code = " + responseCode;
    }

}
