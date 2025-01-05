package com.buenosdev;

public class VolatileExample {
    private static volatile boolean flag = false;

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread 1 is running...");
                while (!flag) {
                    // Waiting for the flag to become true
                }
                System.out.println("Flag is now true! Thread 1 exiting...");
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread 2 is running...");
                try {
                    Thread.sleep(2000); // Simulate some work with sleep
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                flag = true;
                System.out.println("Thread 2 has set flag to true.");
            }
        }).start();
    }
}
