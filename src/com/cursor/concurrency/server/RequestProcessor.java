package com.cursor.concurrency.server;

public class RequestProcessor implements Runnable {

    private Request request;
    private static final int DELAY = 1000;

    RequestProcessor(Request request){
        this.request = request;
    }

    public void run(){
        System.out.println("Your "+request.getMethod()+" request started processing in "+Thread.currentThread());
        try {
            Thread.sleep(DELAY);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Your "+request.getMethod()+" request finished processing in "+Thread.currentThread());
    }

}
