package com.marketi.entidades;

public class Monitor extends Produto {

    public int getTamanho() {
        return tamanho;
    }

    final int tamanho, taxaDeAtualizacao;
    final String resolucao, tipoDeTela;

    public Monitor(
            String id,
            String marca,
            String modelo,
            String lote,
            double preco,
            int tamanho,
            int taxaDeAtualizacao,
            String resolucao,
            String tipoDeTela) {
        super(id, marca, modelo, lote, preco);
        this.tamanho = tamanho;
        this.taxaDeAtualizacao = taxaDeAtualizacao;
        this.resolucao = resolucao;
        this.tipoDeTela = tipoDeTela;
        this.categoria = "Monitor";
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();

        builder.append(
                String.format(
                        "|%-5s|%-10s|%-15s|%-15s|%-10s|%-15s|%-10s|%-15s|%-10s|%-10s|%n",
                        "Id",
                        "Categoria",
                        "Marca",
                        "Modelo",
                        "Preço",
                        "Lote",
                        "Tamanho",
                        "Tx. atualização",
                        "Resolução",
                        "Tipo Tela"));
        builder.append(
                String.format(
                        "|%-5s|%-10s|%-15s|%-15s|R$%-8.2f|%-15s|%-6s pol|%-12s Hz|%-10s|%-10s|%n",
                        id,
                        categoria,
                        marca,
                        modelo,
                        preco,
                        lote,
                        tamanho,
                        taxaDeAtualizacao,
                        resolucao,
                        tipoDeTela));
        return builder.toString();
    }

    public int getTaxaDeAtualizacao() {
        return taxaDeAtualizacao;
    }

    public String getResolucao() {
        return resolucao;
    }

    public String getTipoDeTela() {
        return tipoDeTela;
    }

}