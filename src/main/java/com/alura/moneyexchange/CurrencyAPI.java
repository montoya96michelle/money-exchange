package com.alura.moneyexchange;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.util.Set;

public class CurrencyAPI {

    private static final String API_KEY = "e164fb7cb7839f9da2293514";

   
    public static double getRate(String from, String to) {
        String url = "https://v6.exchangerate-api.com/v6/" + API_KEY + "/pair/" + from + "/" + to;

        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            Gson gson = new Gson();
            JsonObject data = gson.fromJson(response.body(), JsonObject.class);

            if (data.get("result").getAsString().equals("success")) {
                return data.get("conversion_rate").getAsDouble();
            }

        } catch (IOException | InterruptedException e) {
            System.out.println("Error al obtener la tasa: " + e.getMessage());
        }

        return -1; // error
    }

    // Todas las monedas desde la API
    public static String[] getCurrencies() {
        String url = "https://v6.exchangerate-api.com/v6/" + API_KEY + "/latest/USD";

        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            Gson gson = new Gson();
            JsonObject data = gson.fromJson(response.body(), JsonObject.class);

            JsonObject rates = data.getAsJsonObject("conversion_rates");

            Set<String> keys = rates.keySet();
            return keys.toArray(new String[0]);

        } catch (IOException | InterruptedException e) {
            System.out.println("Error al obtener la lista de monedas: " + e.getMessage());
        }

        // fallback mínimo
        return new String[] {"USD", "PEN"};
    }
}
