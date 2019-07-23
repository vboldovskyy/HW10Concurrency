package com.cursor.concurrency;

import com.cursor.concurrency.firefighters.Call;
import com.cursor.concurrency.firefighters.FireDepartment;
import com.cursor.concurrency.server.HTTPMethod;
import com.cursor.concurrency.server.Request;
import com.cursor.concurrency.server.Server;

class AppRunner {
    private static final int DELAY = 1500;

    void start() {
        System.out.println("Hello, let's see how our server works:");
        Server server = new Server();
        for (HTTPMethod method : HTTPMethod.values()) {
            server.processRequest(new Request(method, "RequestBody"));
        }
        try {
            Thread.sleep(DELAY);
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }
        System.out.println("Now let's go to fire department and make a few fire calls");
        FireDepartment department = new FireDepartment();
        new Call("Downing street 10", department);
        new Call("The white house", department);
        new Call("Verkhovna rada", department);


    }
}
