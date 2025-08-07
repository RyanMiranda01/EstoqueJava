package br.com.sistemaestoque.FuncionalidadesBD;

import br.com.sistemaestoque.JavaDatabaseConnectivityJDBC.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FuncDB {
    private Connection conn;

    public FuncDB() throws SQLException {
        this.conn = new Conexao().conectar();
    }


    public void ListarTabelaEstoque(){
        try{
            String sql = "select * from estoque;";

            PreparedStatement stmt = conn.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                System.out.println(
                                "ID         | "+rs.getInt("id")+ "\n"+
                                "NOME       | "+rs.getString("nome_produto")+"\n"+
                                "VALOR      | "+rs.getString("valor")+"\n"+
                                "QUANTIDADE | "+rs.getInt("Qtd"));
                System.out.println("---------------------------------");
            }
        } catch (
                SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void ListarTabelaFuncionarios(){
        try{
            String sql = "select * from funcionarios;";

            PreparedStatement stmt = conn.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                System.out.println(
                                "ID         | "+rs.getInt("id")+ "\n"+
                                "NOME       | "+rs.getString("nome")+"\n"+
                                "GENERO     | "+rs.getString("genero")+"\n"+
                                "EMAIL      | "+rs.getString("email"));
                System.out.println("---------------------------------");
            }
        } catch (
                SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void ListarTabelaHistorico(){
        try{
            String sql = "select h.id, f.nome, e.nome_produto, h.Qtd, h.data_alt from historicoestoque h " +
                    "inner join estoque e inner join funcionarios f on(h.id_funcionario=f.id and h.id_produto=e.id);";

            PreparedStatement stmt = conn.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                System.out.println(
                                "ID                    | "+rs.getInt("h.id")+ "\n"+
                                "NOME DO FUNCIONÁRIO   | "+rs.getString("f.nome") +"\n"+
                                "NOME DO PRODUTO       | "+rs.getString("e.nome_produto")+"\n"+
                                "QUANTIDADE            | "+rs.getString("Qtd")+"\n"+
                                "DATA DA ALTERAÇÃO     | "+rs.getString("data_alt"));
                System.out.println("---------------------------------");
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (
                SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
