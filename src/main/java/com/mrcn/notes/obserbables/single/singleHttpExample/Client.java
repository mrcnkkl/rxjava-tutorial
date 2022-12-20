package com.mrcn.notes.obserbables.single.singleHttpExample;

import io.reactivex.rxjava3.core.Single;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Client {

    public static void main(String[] args) {
        Server.startServer();

        Single<String> responseSingle = Single.fromCallable(() -> {
            String url = "http://localhost:8080/";
            HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);
            StringBuilder response = new StringBuilder();
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
            }
            return response.toString();
        });

        responseSingle.subscribe(resp -> System.out.println(resp));
    }
}
