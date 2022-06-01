package com.marketi.entidades;

public class Auricular extends Produto {
    final int impedancia, sensibilidade;
    final String conexao;

    public Auricular(
            String id,
            String marca,
            String modelo,
            String lote,
            double preco,
            int impedancia,
            int sensibilidade,
            String conexao) {
        super(id, marca, modelo, lote, preco);
        this.impedancia = impedancia;
        this.sensibilidade = sensibilidade;
        this.conexao = conexao;
        this.categoria = "Auricular";
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(
                String.format(
                        "|%5s|%10s|%15s|%20s|%10s|%20s|%15s|%13s|%10s|%n",
                        "Id",
                        "Categoria",
                        "Marca",
                        "Modelo",
                        "Preço",
                        "Lote",
                        "Impedância",
                        "Sensibilidade",
                        "Conexão"));
        builder.append(
                String.format(
                        "|%5s|%10s|%15s|%20s|R$%8.2f|%20s|%10s Ohms|%10s dB|%10s|%n",
                        id,
                        categoria,
                        marca,
                        modelo,
                        preco,
                        lote,
                        impedancia,
                        sensibilidade,
                        conexao));
        return builder.toString();
    }

    public int getImpedancia() {
        return impedancia;
    }

    public int getSensibilidade() {
        return sensibilidade;
    }

    public String getConexao() {
        return conexao;
    }

}