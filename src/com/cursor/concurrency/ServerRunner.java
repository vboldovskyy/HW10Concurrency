package com.cursor.concurrency;

import com.cursor.concurrency.server.HTTPMethod;
import com.cursor.concurrency.server.Request;
import com.cursor.concurrency.server.Server;

class ServerRunner {

    void start() {
        System.out.println("Hello, let's see how our server works:");
        Server server = new Server();
        for (HTTPMethod method : HTTPMethod.values()) {
            server.processRequest(new Request(method, "RequestBody"));
        }
    }
}
