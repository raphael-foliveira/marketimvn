package com.marketi.entidades;

public class Computador extends Produto {
    final int memoriaRam, armazenamento;
    final String sistemaOperacional;

    public Computador(
            String id,
            String marca,
            String modelo,
            String lote,
            double preco,
            int memoriaRam,
            int armazenamento,
            String sistemaOperacional) {
        super(id, marca, modelo, lote, preco);
        this.memoriaRam = memoriaRam;
        this.armazenamento = armazenamento;
        this.sistemaOperacional = sistemaOperacional;
        this.categoria = "Computador";
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();

        builder.append(
                String.format(
                        "|%5s|%10s|%15s|%20s|%10s|%20s|%15s|%13s|%20s|%n",
                        "Id",
                        "Categoria",
                        "Marca",
                        "Modelo",
                        "Preço",
                        "Lote",
                        "Memória RAM",
                        "Armazenamento",
                        "Sistema Operacional"));
        builder.append(
                String.format(
                        "|%5s|%10s|%15s|%20s|R$%8.2f|%20s|%12s GB|%10s GB|%20s|%n",
                        id,
                        categoria,
                        marca,
                        modelo,
                        preco,
                        lote,
                        memoriaRam,
                        armazenamento,
                        sistemaOperacional));
        return builder.toString();
    }

    public int getMemoriaRam() {
        return memoriaRam;
    }

    public int getArmazenamento() {
        return armazenamento;
    }

    public String getSistemaOperacional() {
        return sistemaOperacional;
    }

}