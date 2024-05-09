package br.com.josuemleite.view;

import br.com.josuemleite.controller.CurrencySearch;
import br.com.josuemleite.model.CurrencyPairConversion;

import java.util.Scanner;

public class Application {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        try {

            CurrencySearch currencySearch = new CurrencySearch();
            CurrencyPairConversion newConversion;

            double amount = 0.0;

            byte option;
            while (true) {
                option = menu();

                switch (option) {
                    case 1: {
                        amount = amountMenu();
                        newConversion = currencySearch.searchConversion("BRL", "USD", amount);
                        double conversionResult = Double.parseDouble(newConversion.conversionResult());
                        System.out.printf("R$ %.2f equivale a $ %.2f\n", amount, conversionResult);
                        System.out.println("Pressione a teclada de entrada (enter) para continuar...");
                        scanner.nextLine();
                        break;
                    }
                    case 2: {
                        break;
                    }
                    case 3: {
                        break;
                    }
                    case 4: {
                        break;
                    }
                    case 5: {
                        break;
                    }
                    case 6: {
                        break;
                    }
                    case 7: {
                        break;
                    }
                    case 8: {
                        break;
                    }
                    case 9: {
                        break;
                    }
                    case 0: {
                        return;
                    }
                }
            }
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            System.out.println("Ending application");
        }
    }

    private static byte menu() {
        System.out.println("=================================================");
        System.out.println("| [1] Real para Dólar dos Estados Unidos        |");
        System.out.println("| [2] Dólar dos Estados Unidos para Real        |");
        System.out.println("| [3] Real para Dólar Canadense                 |");
        System.out.println("| [4] Dólar Canadense para Real                 |");
        System.out.println("| [5] Real para Dólar Australiano               |");
        System.out.println("| [6] Dólar Australiano para Real               |");
        System.out.println("| [7] Real para Libra Esterlina                 |");
        System.out.println("| [8] Libra Esterlina para Real                 |");
        System.out.println("| [9] Outra conversão                           |");
        System.out.println("| [0] Sair do programa                          |");
        System.out.println("-------------------------------------------------");
        System.out.println("Insira e confirma abaixo o valor correspondente à ação desejada");
        System.out.print("> ");
        byte option = scanner.nextByte();
        scanner.nextLine();
        return option;
    }

    private static double amountMenu() {
        System.out.println("Qual a quantidade total a ser convertida?");
        System.out.print("> ");
        double amount = scanner.nextDouble();
        scanner.nextLine();
        return amount;
    }

    private static void otherConversionOptionFlow() {
        System.out.println("Digite o código de três caracteres da moeda base:");
        String baseCurrency = scanner.nextLine();
        System.out.println("Digite o código de três caracteres da moeda a ser convertida:");
        String targetCurrency = scanner.nextLine();
        System.out.println("Informa o valor (decimal) a ser convertido:");
        Double amount = scanner.nextDouble();
    }
}
