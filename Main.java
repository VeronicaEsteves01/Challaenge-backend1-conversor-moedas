package main;

import service.ConversorService;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ConversorService conversor = new ConversorService();

        System.out.println("=== Conversor de Moedas ===");
        System.out.println("Exemplo de moedas: USD, BRL, EUR, ARS, GBP, JPY");

        System.out.print("Digite a moeda de origem: ");
        String origem = scanner.nextLine().toUpperCase();

        System.out.print("Digite a moeda de destino: ");
        String destino = scanner.nextLine().toUpperCase();

        System.out.print("Digite o valor a converter: ");
        double valor = scanner.nextDouble();

        try {
            double resultado = conversor.converter(origem, destino, valor);
            System.out.printf("\n%.2f %s = %.2f %s\n", valor, origem, resultado, destino);
        } catch (Exception e) {
            System.out.println("Erro ao converter: " + e.getMessage());
        }

        scanner.close();
    }
}
