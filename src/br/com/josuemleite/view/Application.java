package br.com.josuemleite.view;

import br.com.josuemleite.controller.CurrencySearch;
import br.com.josuemleite.model.CurrencyPairConversion;

import java.util.Scanner;

public class Application {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        CurrencySearch search = new CurrencySearch();

        System.out.println("Digite o código de três caracteres da moeda base:");
        String baseCurrency = sc.nextLine();
        System.out.println("Digite o código de três caracteres da moeda a ser convertida:");
        String targetCurrency = sc.nextLine();
        System.out.println("Informa o valor (decimal) a ser convertido:");
        Double amount = sc.nextDouble();

        try {
            CurrencyPairConversion newConversion = search.searchConversion(baseCurrency, targetCurrency, amount);
            System.out.println(newConversion);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            System.out.println("Ending application");
        }
    }
}
