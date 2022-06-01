package com.marketi.menus;

import java.util.List;

/**
 * Classe abstrata que define o formato das classes de menus
 */
public abstract class Menus {

    List<String> opcoes;

    /**
     * Executa o menu.
     * Mostra as opções, lê a opção escolhida pelo usuário e executa o método
     * desejado
     */
    public abstract void executar();

    /**
     * Imprime para o usuário todas as opções do menu
     */
    public void mostrarOpcoes() {

        for (String opcao : opcoes) {
            System.out.println(opcao);
        }
    }

    /**
     * Imprime uma linha no menu para organização visual
     */
    public void printLinha() {

        System.out.println("---------------------------------------");
    }

}
