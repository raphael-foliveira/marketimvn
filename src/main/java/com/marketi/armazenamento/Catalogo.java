package com.marketi.armazenamento;

import java.util.Comparator;
import java.util.List;

import com.marketi.entidades.*;

/**
 * Implementação da classe que armazena os produtos
 */
public class Catalogo {
    // classe responsável pelo armazenamento das entidades no catálogo
    List<Produto> produtos;
    GerenciadorDatabase bancoDeDados;

    public Catalogo() {
        bancoDeDados = new GerenciadorDatabase();
        produtos = bancoDeDados.carregarProdutos();

    }

    /**
     * Adiciona um produto
     * 
     * @param produto
     */
    public void adicionar(Produto produto) {
        bancoDeDados.adicionarAoBanco(produto);
        produtos.add(produto);

    }

    /**
     * Remove um produto, caso ele exista
     * 
     * @param produto
     * @return true se o produto for removido, false se não for encontrado
     */
    public boolean remover(Produto produto) {
        bancoDeDados.apagarDoBanco(produto);
        return produtos.remove(produto);
    }

    /**
     * Encontra um produto
     * 
     * @param id
     * @return O produto, caso ele exista, ou null se não existir
     */
    public Produto encontrarProduto(String id) {
        int index = produtos.indexOf(new Produto(id));
        if (produtos.size() == 0 || index == -1) {
            return null;
        }
        return produtos.get(index);
    }

    public void atualizarPrecoProduto(Produto produto, double novoPreco) {
        bancoDeDados.atualizarPrecoNoBanco(produto, novoPreco);
        produto.setPreco(novoPreco);
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();

        builder.append(
                String.format("|%-5s|%-20s|%-10s|%n", "Id", "Modelo", "Preço"));

        builder.append(String.format("%s%n", "---------------------------------------"));

        // Cada produto é adicionado à string, sendo separado por uma quebra de linha
        for (Produto produto : produtos) {
            builder.append(String.format(
                    "|%-5s|%-20s|R$%-8.2f|%n",
                    produto.getId(),
                    produto.getModelo(),
                    produto.getPreco()));
        }
        return builder.toString();
    }

    /**
     * Ordena os produtos com base nos Ids
     */
    public void ordenarPorId() {
        produtos.sort(Comparator.comparing(Produto::getId));
    }

    /**
     * Ordena os produtos com base no preço
     */
    public void ordenarPorPreco() {
        produtos.sort(Comparator.comparing(Produto::getPreco));
    }

    /**
     * Ordena os produtos em ordem alfabética (através do nome do modelo)
     */
    public void ordenarPorModelo() {

        produtos.sort(Comparator.comparing(Produto::getModelo));
    }

    /**
     * adicionando produtos para preencher a lista e demonstrar o funcionamento do
     * sistema
     */
    public void adicionarProdutosDemo() {
        adicionar(
                new Produto(
                        "001",
                        "Zowie",
                        "Ec2A",
                        "10",
                        399));
        adicionar(
                new Computador(
                        "002",
                        "Dell",
                        "Onyx",
                        "155vx",
                        4900,
                        16,
                        512,
                        "Windows"));
        adicionar(
                new Auricular(
                        "003",
                        "JBL",
                        "125BT",
                        "KGBUX",
                        150,
                        220,
                        100,
                        "Bluetooth"));
        adicionar(
                new Monitor(
                        "004",
                        "Acer",
                        "VA270H",
                        "A1098",
                        1800,
                        29,
                        144,
                        "1920x1080",
                        "LED"));
        adicionar(
                new Produto(
                        "005",
                        "GFallen",
                        "Falcão Peregrino",
                        "GF21983",
                        399));
        adicionar(
                new Computador(
                        "006",
                        "Apple",
                        "Macbook Pro",
                        "AAP298342893",
                        23000,
                        16,
                        1000,
                        "OSX"));
        adicionar(
                new Auricular(
                        "007",
                        "Razer",
                        "Kraken",
                        "RK21983747",
                        680,
                        180,
                        110,
                        "USB"));
    }

    public List<Produto> getProdutos() {
        return produtos;
    }
}