package com.fdmgroup.thread_example;

public class MainOne {
    public static void main(String[] args) {
        Thread thread = new NewThread();
        thread.start();
    }

    private static class NewThread extends Thread {
        @Override
        public void run() {
            this.setName("FDM Thread");
            System.out.println("Hello from: " + this.getName());
        }
    }
}
