package com.marketi.armazenamento;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.marketi.entidades.Auricular;
import com.marketi.entidades.Computador;
import com.marketi.entidades.Monitor;
import com.marketi.entidades.Produto;

/**
 * Classe responsável pela conexão com o banco de dados mysql
 */
public class GerenciadorDatabase {
    Connection connection;

    GerenciadorDatabase() {
        try {
            System.out.println("Conectando ao banco de dados");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/marketi",
                    "root",
                    "");
            System.out.println("Banco de dados conectado.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Adiciona um produto ao banco de dados, dentro das tabelas referentes ao tipo específico do produto
     * @param produto
     */
    public void adicionarAoBanco(Produto produto) {

        String categoria = produto.getCategoria();

        this.adicionarProduto(produto);

        if (categoria.equals("Monitor")) {
            this.adicionarMonitor((Monitor) produto);
        } else if (categoria.equals("Computador")) {
            this.adicionarComputador((Computador) produto);
        } else if (categoria.equals("Auricular")) {
            this.adicionarAuricular((Auricular) produto);
        }
    }

    /**
     * Adiciona um produto diverso ao banco de dados
     * @param produto
     */
    public void adicionarProduto(Produto produto) {

        String id = produto.getId();
        String marca = produto.getMarca();
        String modelo = produto.getModelo();
        String lote = produto.getLote();
        double preco = produto.getPreco();
        String categoria = produto.getCategoria();

        String comando = "INSERT INTO produto VALUES (?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement statement = connection.prepareStatement(comando);
            statement.setString(1, id);
            statement.setString(2, marca);
            statement.setString(3, modelo);
            statement.setString(4, lote);
            statement.setDouble(5, preco);
            statement.setString(6, categoria);
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Adiciona um monitor ao banco de dados
     * @param monitor
     */
    public void adicionarMonitor(Monitor monitor) {

        String id = monitor.getId();
        int tamanho = monitor.getTamanho();
        int taxaDeAtualizacao = monitor.getTaxaDeAtualizacao();
        String resolucao = monitor.getResolucao();
        String tipoDeTela = monitor.getTipoDeTela();

        String comando = "INSERT INTO monitor VALUES (?, ?, ?, ?, ?)";

        try {
            PreparedStatement monitorStatement = connection.prepareStatement(comando);
            monitorStatement.setString(1, id);
            monitorStatement.setInt(2, tamanho);
            monitorStatement.setInt(3, taxaDeAtualizacao);
            monitorStatement.setString(4, resolucao);
            monitorStatement.setString(5, tipoDeTela);
            monitorStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    /**
     * Adiciona um computador ao banco de dados
     * @param computador
     */
    public void adicionarComputador(Computador computador) {

        String id = computador.getId();
        int memoriaRam = computador.getMemoriaRam();
        int armazenamento = computador.getArmazenamento();
        String sistemaOperacional = computador.getSistemaOperacional();

        String comando = "INSERT INTO computador VALUES (?, ?, ?, ?)";

        try {
            PreparedStatement computadorStatement = connection.prepareStatement(comando);
            computadorStatement.setString(1, id);
            computadorStatement.setInt(2, memoriaRam);
            computadorStatement.setInt(3, armazenamento);
            computadorStatement.setString(4, sistemaOperacional);
            computadorStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Adiciona um auricular ao banco de dados
     * @param auricular
     */
    public void adicionarAuricular(Auricular auricular) {

        String id = auricular.getId();
        int impedancia = auricular.getImpedancia();
        int sensibilidade = auricular.getSensibilidade();
        String conexao = auricular.getConexao();

        String comando = "INSERT INTO auricular VALUES (?, ?, ?, ?)";

        try {
            PreparedStatement auricularStatement = connection.prepareStatement(comando);
            auricularStatement.setString(1, id);
            auricularStatement.setInt(2, impedancia);
            auricularStatement.setInt(3, sensibilidade);
            auricularStatement.setString(4, conexao);
            auricularStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Coloca em uma lista todos os produtos existentes no banco de dados 
     * @return Lista com todos os produtos existentes no banco
     */
    public List<Produto> carregarProdutos() {
        ArrayList<Produto> produtosDoBancoDeDados = new ArrayList<>();
        String comando = "SELECT * FROM produto";
        try {
            PreparedStatement statement = connection.prepareStatement(comando);
            ResultSet resultado = statement.executeQuery(comando);

            while (resultado.next()) {
                String id = resultado.getString("id");
                String modelo = resultado.getString("modelo");
                String marca = resultado.getString("marca");
                String lote = resultado.getString("lote");
                double preco = resultado.getDouble("preco");
                String categoria = resultado.getString("categoria");
                if (categoria.equals("Diverso")) {

                    produtosDoBancoDeDados.add(new Produto(id, marca, modelo, lote, preco));

                } else if (categoria.equals("Monitor")) {

                    comando = String.format("SELECT * FROM monitor WHERE id='%s'", id);
                    PreparedStatement monitorStatement = connection.prepareStatement(comando);
                    ResultSet resultadoMonitor = monitorStatement.executeQuery(comando);
                    if (resultadoMonitor.next()) {
                        int tamanho = resultadoMonitor.getInt("tamanho");
                        int taxaDeAtualizacao = resultadoMonitor.getInt("taxadeatualizacao");
                        String resolucao = resultadoMonitor.getString("resolucao");
                        String tipoDeTela = resultadoMonitor.getString("tipodetela");
                        produtosDoBancoDeDados
                                .add(new Monitor(id, marca, modelo, lote, preco, tamanho, taxaDeAtualizacao,
                                        resolucao, tipoDeTela));
                    }

                } else if (categoria.equals("Computador")) {

                    comando = String.format("SELECT * FROM computador WHERE id='%s'", id);
                    PreparedStatement computadorStatement = connection.prepareStatement(comando);
                    ResultSet resultadoComputador = computadorStatement.executeQuery(comando);
                    if (resultadoComputador.next()) {
                        int memoriaRam = resultadoComputador.getInt("memoriaram");
                        int armazenamento = resultadoComputador.getInt("armazenamento");
                        String sistemaOperacional = resultadoComputador.getString("sistemaoperacional");
                        produtosDoBancoDeDados
                                .add(new Computador(id, marca, modelo, lote, preco, memoriaRam, armazenamento,
                                        sistemaOperacional));
                    }

                } else if (categoria.equals("Auricular")) {

                    comando = String.format("SELECT * FROM auricular WHERE id='%s'", id);
                    PreparedStatement auricularStatement = connection.prepareStatement(comando);
                    ResultSet resultadoAuricular = auricularStatement.executeQuery(comando);
                    if (resultadoAuricular.next()) {
                        int impedancia = resultadoAuricular.getInt("impedancia");
                        int sensibilidade = resultadoAuricular.getInt("sensibilidade");
                        String conexao = resultadoAuricular.getString("conexao");
                        produtosDoBancoDeDados
                                .add(new Auricular(id, marca, modelo, lote, preco, impedancia, sensibilidade, conexao));
                    }

                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return produtosDoBancoDeDados;
    }

    /**
     * Apaga um produto do banco de dados
     * @param produto
     */
    public void apagarDoBanco(Produto produto) {
        String comando = String.format("DELETE FROM produto WHERE (id='%s')", produto.getId());
        try {
            connection.prepareStatement(comando).executeUpdate();
        } catch (SQLException e) {
            e.getMessage();
        }
    }

    /**
     * Atualiza o preço de um produto específico no banco de dados
     * @param produto
     * @param novoPreco
     */
    public void atualizarPrecoNoBanco(Produto produto, double novoPreco) {
        String comando = "UPDATE produto SET preco=? WHERE (id=?)";
        try {
            PreparedStatement updateStatement = connection.prepareStatement(comando);
            updateStatement.setDouble(1, novoPreco);
            updateStatement.setString(2, produto.getId());
            updateStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

}
