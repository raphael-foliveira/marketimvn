package com.marketi.entidades;

public class Produto {
    final String id, marca, modelo, lote;
    String categoria;
    double preco;

    public Produto(
            String id,
            String marca,
            String modelo,
            String lote,
            double preco) {
        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
        this.lote = lote;
        this.preco = preco;
        this.categoria = "Diverso";
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        builder.append(
                String.format(
                        "|%5s|%10s|%15s|%20s|%10s|%15s|%n",
                        "Id",
                        "Categoria",
                        "Marca",
                        "Modelo",
                        "Preço",
                        "Lote"));
        builder.append(
                String.format(
                        "|%5s|%10s|%15s|%20s|R$%8.2f|%15s|%n",
                        id,
                        categoria,
                        marca,
                        modelo,
                        preco,
                        lote));

        return builder.toString();
    }

    public String getId() {
        return id;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getLote() {
        return lote;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

}