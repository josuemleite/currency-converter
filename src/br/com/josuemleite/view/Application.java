package br.com.josuemleite.view;

import br.com.josuemleite.controller.CurrencySearch;
import br.com.josuemleite.model.CurrencyPairConversion;

import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;

public class Application {

    private static Scanner scanner;

    public static void main(String[] args) {
        try {
            scanner = new Scanner(System.in);

            CurrencySearch currencySearch = new CurrencySearch();
            CurrencyPairConversion newConversion;

            double amount;
            double conversionResult;

            byte option;

            while (true) {
                option = menu();

                switch (option) {
                    case 1:
                        amount = amountMenu();
                        newConversion = currencySearch.searchConversion("BRL", "USD", amount);
                        conversionResult = Double.parseDouble(newConversion.conversionResult());
                        System.out.printf("R$ %.2f equivale a $ %.2f\n", amount, conversionResult);
                        systemPause();
                        break;
                    case 2:
                        amount = amountMenu();
                        newConversion = currencySearch.searchConversion("USD", "BRL", amount);
                        conversionResult = Double.parseDouble(newConversion.conversionResult());
                        System.out.printf("$ %.2f equivale a R$ %.2f\n", amount, conversionResult);
                        systemPause();
                        break;
                    case 3:
                        amount = amountMenu();
                        newConversion = currencySearch.searchConversion("BRL", "CAD", amount);
                        conversionResult = Double.parseDouble(newConversion.conversionResult());
                        System.out.printf("R$ %.2f equivale a C$ %.2f\n", amount, conversionResult);
                        systemPause();
                        break;
                    case 4:
                        amount = amountMenu();
                        newConversion = currencySearch.searchConversion("CAD", "BRL", amount);
                        conversionResult = Double.parseDouble(newConversion.conversionResult());
                        System.out.printf("C$ %.2f equivale a R$ %.2f\n", amount, conversionResult);
                        systemPause();
                        break;
                    case 5:
                        amount = amountMenu();
                        newConversion = currencySearch.searchConversion("BRL", "AUD", amount);
                        conversionResult = Double.parseDouble(newConversion.conversionResult());
                        System.out.printf("R$ %.2f equivale a A$ %.2f\n", amount, conversionResult);
                        systemPause();
                        break;
                    case 6:
                        amount = amountMenu();
                        newConversion = currencySearch.searchConversion("AUD", "BRL", amount);
                        conversionResult = Double.parseDouble(newConversion.conversionResult());
                        System.out.printf("A$ %.2f equivale a R$ %.2f\n", amount, conversionResult);
                        systemPause();
                        break;
                    case 7:
                        amount = amountMenu();
                        newConversion = currencySearch.searchConversion("BRL", "GBP", amount);
                        conversionResult = Double.parseDouble(newConversion.conversionResult());
                        System.out.printf("R$ %.2f equivale a £ %.2f\n", amount, conversionResult);
                        systemPause();
                        break;
                    case 8:
                        amount = amountMenu();
                        newConversion = currencySearch.searchConversion("GBP", "BRL", amount);
                        conversionResult = Double.parseDouble(newConversion.conversionResult());
                        System.out.printf("£ %.2f equivale a R$ %.2f\n", amount, conversionResult);
                        systemPause();
                        break;
                    case 9:
                        System.out.println("Insira o código de três caracteres da moeda base:");
                        String baseCurrency = scanner.nextLine();
                        System.out.println("Insira o código de três caracteres da moeda para a qual deseja converter:");
                        String targetCurrency = scanner.nextLine();
                        amount = amountMenu();
                        newConversion = currencySearch.searchConversion(baseCurrency, targetCurrency, amount);
                        conversionResult = Double.parseDouble(newConversion.conversionResult());
                        System.out.printf("%s %.2f equivale a %s %.2f\n", baseCurrency.toUpperCase(), amount, targetCurrency.toUpperCase(), conversionResult);
                        systemPause();
                        break;
                    case 0:
                        return;
                    default:
                        System.out.println("Opção inválida. Por favor, insira uma opção válida.");
                        systemPause();
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("Valor muito diferente do esperado...");
        } catch (NullPointerException e) {
            System.out.println("Objeto com valor nulo foi encontrado: " + e.getMessage());
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        } finally {
            if (!Objects.isNull(scanner)) {
                scanner.close();
            }
            System.out.println("Finalizando a aplicação...");
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

    private static void systemPause() {
        System.out.println("Pressiona a teclada de entrada (enter) para continuar...");
        scanner.nextLine();
    }
}
