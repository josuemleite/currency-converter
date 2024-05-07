package br.com.josuemleite.controller;

import br.com.josuemleite.model.CurrencyPairConversion;
import com.google.gson.Gson;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Properties;

public class CurrencySearch {

    private static final String API_KEY;

    static {
        Properties properties = new Properties();
        try (FileInputStream input = new FileInputStream("src/secure.properties")) {
            properties.load(input);
            API_KEY = properties.getProperty("API_KEY");
        } catch (IOException e) {
            throw new RuntimeException("Erro ao carregar a chave da API", e);
        }
    }

    public CurrencyPairConversion searchConversion(String baseCode,
                                                   String targetCode,
                                                   Double amount) {

        URI resourceAddress = URI.create("https://v6.exchangerate-api.com/v6/" +
                              API_KEY +
                              "/pair/" +
                              baseCode + "/" +
                              targetCode + "/" +
                              amount);

        HttpRequest request = HttpRequest.newBuilder()
                              .uri(resourceAddress)
                              .build();

        try {
            HttpResponse<String> response = HttpClient
                                            .newHttpClient()
                                            .send(request, HttpResponse.BodyHandlers.ofString());

            return new Gson().fromJson(response.body(), CurrencyPairConversion.class);
        } catch (Exception e){
            throw new RuntimeException("Não foi possível realizar a conversão: " + e.getMessage());
        }
    }
}
