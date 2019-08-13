package com.cursor.concurrency.server;

public class Request {

    private HTTPMethod method;
    private String body;

    public Request(HTTPMethod method, String body) {
        this.method = method;
        this.body = body;
    }

    HTTPMethod getMethod() {
        return method;
    }

    String getBody() {
        return body;
    }
}
