package br.com.josuemleite.controller;

import br.com.josuemleite.model.CurrencyPairConversion;
import br.com.josuemleite.model.exceptions.APICredentialsNotFoundException;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Properties;

public class CurrencySearch {

    private final String API_KEY;
    private final String API_URL = "https://v6.exchangerate-api.com/v6/";

    {
        Properties properties = new Properties();
        try (FileInputStream input = new FileInputStream("src/secure.properties")) {
            properties.load(input);
            API_KEY = properties.getProperty("API_KEY");
            if (API_KEY == null || API_KEY.isEmpty()) {
                throw new APICredentialsNotFoundException("Erro ao carregar API: chave da API é nula ou sem conteúdo.");
            }
        } catch (IOException e) {
            throw new RuntimeException("Erro ao carregar a chave da API. Confira o arquivo em que ela está armazenada.");
        }
    }

    public CurrencySearch() {
        if (!isLinkWorking()) {
            throw new RuntimeException("O link da API não está funcionando.");
        }
    }

    private boolean isLinkWorking() {
        try {
            URL url = new URL(API_URL + API_KEY + "/latest/USD");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            int responseCode = connection.getResponseCode();
            return (responseCode == HttpURLConnection.HTTP_OK);
        } catch (IOException e) {
            return false;
        }
    }

    public CurrencyPairConversion searchConversion(String baseCode,
                                                   String targetCode,
                                                   Double amount) {

        URI resourceAddress = URI.create(API_URL +
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
        } catch (JsonSyntaxException e) {
            throw new RuntimeException("Ocorreu um erro ao passar os dados à API. Verifica-os e tenta novamente.");
        } catch (IllegalStateException e){
            throw new RuntimeException("Não foi possível realizar a conversão devido a um estado inválido: " + e.getMessage());
        } catch (IOException e) {
            throw new RuntimeException("Erro de E/S ao tentar realizar a conversão: " + e.getMessage());
        } catch (InterruptedException e) {
            throw new RuntimeException("A execução foi interrompida ao tentar realizar a conversão: " + e.getMessage());
        } catch (Exception e) {
            throw new RuntimeException("Ocorreu um erro inesperado ao tentar realizar a conversão: " + e.getMessage());
        }
    }
}
