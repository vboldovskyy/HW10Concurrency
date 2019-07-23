package com.cursor.concurrency.server;

public class Server  {

    public Response processRequest (Request request){
        new Thread(new RequestProcessor(request)).start();
        return new Response();
    }

}
