package com.marketi.auxiliares;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Classe responsável pela leitura de dados fornecidos pelo usuário através do
 * terminal
 */
public class Leitor {
    private static Scanner scanner;

    /**
     * Imprime uma mensagem e lê um inteiro
     * 
     * @param mensagem Mensagem destinada ao usuário
     * @return Inteiro digitado pelo usuário
     */
    public static int lerInt(String mensagem) {
        scanner = new Scanner(System.in);
        System.out.print(mensagem);
        try {
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Esse valor deve ser um número inteiro. Tente novamente.");
            return lerInt(mensagem);
        }
    }

    /**
     * Imprime uma mensagem e lê uma String
     * 
     * @param mensagem Mensagem destinada ao usuário
     * @return String digitada pelo usuário
     */
    public static String lerString(String mensagem) {
        scanner = new Scanner(System.in);
        System.out.print(mensagem);
        return scanner.nextLine();
    }

    /**
     * Imprime uma mensagem e lê um double
     * 
     * @param mensagem Mensagem destinada ao usuário
     * @return Double digitado pelo usuário
     */
    public static double lerDouble(String mensagem) {
        scanner = new Scanner(System.in);
        System.out.print(mensagem);
        try {
            return scanner.nextDouble();
        } catch (InputMismatchException e) {
            System.out.println("Esse valor deve ser um número. Tente novamente.");
            return lerDouble(mensagem);
        }
    }
}
