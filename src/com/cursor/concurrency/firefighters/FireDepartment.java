package com.cursor.concurrency.firefighters;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class FireDepartment {
    private List<Fireman> fireMen;
    private Queue<Call> calls;
    private static final int DELAY =1000;

    public FireDepartment() {
        fireMen = new ArrayList<>();
        fireMen.add(new Fireman("Ronnie"));
        fireMen.add(new Fireman("Stevie"));
        fireMen.add(new Fireman("Tony"));
        calls = new ArrayDeque<>();
    }

    synchronized void processCall(Call call) {
        while (!calls.isEmpty()) {
            try {
                wait();
            } catch (InterruptedException ie) {
                ie.printStackTrace();
            }
        }
        calls.add(call);
        notify();
    }

    synchronized void extinguishFire() {
        while (calls.isEmpty()) {
            try {
                wait();
            } catch (InterruptedException ie) {
                ie.printStackTrace();
            }
        }
        Call currentCall;
        for (Fireman fireman : fireMen) {
            if (fireman.isFree()) {
                currentCall = calls.peek();
                System.out.println("Fireman " + fireman.getName() + " is out on call at address: " + currentCall.getAddress());
                fireman.setFree(false);
            }
        }
        try {
            Thread.sleep(DELAY);
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }
        for (Fireman fireman : fireMen) {
            System.out.println("Fireman " + fireman.getName() + " is done extinguishing fire at " + calls.peek().getAddress());
            fireman.setFree(true);
        }
        calls.poll();
        notify();

    }


}
