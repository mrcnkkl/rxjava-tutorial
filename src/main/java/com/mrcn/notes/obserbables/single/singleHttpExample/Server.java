package com.mrcn.notes.obserbables.single.singleHttpExample;

import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

public class Server {

    private static void run() {
        HttpServer server = null;
        try {
            server = HttpServer.create(new InetSocketAddress(8080), 0);
        } catch (IOException e) {
            e.printStackTrace();
        }

        server.createContext("/", httpExchange -> {
            httpExchange.sendResponseHeaders(200, 0);

            try (OutputStream os = httpExchange.getResponseBody()) {
                os.write("Hello Single!!!".getBytes());
            }
        });
        server.start();
    }

    public static void startServer() {
        new Thread(Server::run).start();
    }

}
