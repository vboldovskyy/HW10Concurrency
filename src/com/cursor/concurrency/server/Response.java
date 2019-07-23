package com.cursor.concurrency.server;

public class Response {

    private int status;
    private String body;

    Response() {
        status = 200;
        body = "";
    }

    Response(int status, String body) {
        this.status = status;
        this.body = body;
    }

    public int getStatus() {
        return status;
    }

    public String getBody() {
        return body;
    }
}
