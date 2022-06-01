package com.marketi.menus;

import java.util.Arrays;

import com.marketi.armazenamento.Catalogo;
import com.marketi.auxiliares.Leitor;

public class MenuOrdenacao extends Menus {

    Catalogo catalogo;

    public MenuOrdenacao(Catalogo catalogo) {
        this.catalogo = catalogo;
        opcoes = Arrays.asList(
                "1) Id",
                "2) Preço",
                "3) Modelo",
                "4) Voltar ao menu principal");
    }

    @Override
    public void executar() {
        printLinha();
        System.out.println("Como deseja ordenar os dados?");
        mostrarOpcoes();
        int opcao = Leitor.lerInt(">>> ");
        switch (opcao) {
            case 1:
                catalogo.ordenarPorId();
                break;
            case 2:
                catalogo.ordenarPorPreco();
                break;
            case 3:
                catalogo.ordenarPorModelo();
                break;
            case 4:
                MenuPrincipal menuPrincipal = new MenuPrincipal(catalogo);
                menuPrincipal.executar();
                break;

            default:
                System.out.println("Opção inválida");
                executar();
                break;
        }
    }
}
