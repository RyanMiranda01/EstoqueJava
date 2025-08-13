package br.com.sistemaestoque.FuncionalidadesBD;

import br.com.sistemaestoque.FuncoesSistema.LimparTerminal;
import br.com.sistemaestoque.JavaDatabaseConnectivityJDBC.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class SelectDAO {
    Scanner digitar = new Scanner(System.in);
    LimparTerminal limparTerminal = new LimparTerminal();
    private Connection conn;

    public SelectDAO() throws SQLException {
        this.conn = new Conexao().conectar();
    }





    public void ListarTabelaEstoque(){
        try{
            String sql = "select * from estoque;";

            PreparedStatement stmt = conn.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();
            limparTerminal.limpeza();
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
            System.out.println("ERRO É " + e);
        }
    }




    public void ListarTabelaFuncionarios(){
        try{
            String sql = "select * from funcionarios;";

            PreparedStatement stmt = conn.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();
            limparTerminal.limpeza();
            while (rs.next()) {
                System.out.println(
                        "ID         | "+rs.getInt("id")+ "\n"+
                                "NOME       | "+rs.getString("nome")+"\n"+
                                "GENERO     | "+rs.getString("genero")+"\n"+
                                "EMAIL      | "+rs.getString("email")+"\n"+
                                "SENHA      | "+rs.getString("senha")+"\n"+
                                "NIVEL      | "+rs.getString("nivel_acesso"));
                System.out.println("---------------------------------");

            }
        } catch (SQLException e) {
            System.out.println("ERRO É " + e);
        }
    }




    public void ListarTabelaHistorico(){
        try{
            String sql = "select h.id, f.nome, e.nome_produto, h.Qtd, h.data_alt, h.tipo from historicoestoque h " +
                    "inner join estoque e inner join funcionarios f on(h.id_funcionario=f.id and h.id_produto=e.id)";

            PreparedStatement stmt = conn.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();
            limparTerminal.limpeza();
            while (rs.next()) {
                System.out.println(
                        "ID                    | "+rs.getInt("h.id")+ "\n"+
                                "NOME DO FUNCIONÁRIO   | "+rs.getString("f.nome") +"\n"+
                                "NOME DO PRODUTO       | "+rs.getString("e.nome_produto")+"\n"+
                                "QUANTIDADE            | "+rs.getString("Qtd")+"\n"+
                                "DATA DA ALTERAÇÃO     | "+rs.getString("data_alt")+"\n"+
                                "TIPO                  | "+rs.getString("tipo"));
                System.out.println("---------------------------------");
            }


        } catch (SQLException e) {
            System.out.println("ERRO É " + e);
        }
    }





    public void pesquisarProdutoPorNome(String nomeProduto){
        try {
            boolean temProduto = false;
            String sql = "select * from estoque where nome_produto like ?";

            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setString(1, "%"+nomeProduto+"%");

            ResultSet rs = stmt.executeQuery();
            limparTerminal.limpeza();

            while (rs.next()) {
                temProduto = true;
                System.out.println(
                        "ID         | " + rs.getInt("id") + "\n" +
                                "NOME       | " + rs.getString("nome_produto") + "\n" +
                                "VALOR      | " + rs.getString("valor") + "\n" +
                                "QUANTIDADE | " + rs.getInt("Qtd"));
                System.out.println("---------------------------------");
            }
            if(!temProduto) {
                System.out.println("PRODUTO NÃO ENCONTRADO! TENTE NOVAMENTE");
                String nomeProduto2 = digitar.nextLine();
                pesquisarProdutoPorNome(nomeProduto2);
                System.out.println();
            }
        }catch (SQLException e){
            System.out.println("ERRO É "+ e);
        }
    }


    public void pesquisarFuncionario(String nomeFuncionarios){
        try {
            boolean temFuncionario = false;
            String sql = "select * from funcionarios where nome like ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1,"%"+nomeFuncionarios+"%");

            ResultSet rs = stmt.executeQuery();
            limparTerminal.limpeza();

            while (rs.next()) {
                temFuncionario = true;
                System.out.println(
                        "ID         | " + rs.getInt("id") + "\n" +
                                "NOME       | " + rs.getString("nome") + "\n" +
                                "GENERO     | " + rs.getString("genero") + "\n" +
                                "EMAIL      | " + rs.getString("email") + "\n" +
                                "SENHA      | " + rs.getString("senha") + "\n" +
                                "NIVEL      | " + rs.getString("nivel_acesso"));
                System.out.println("---------------------------------");
            }         if(!temFuncionario) {
                System.out.println("FUNCIONÁRIO NÃO ENCONTRADO! TENTE NOVAMENTE");
                String nomeFuncionario2 = digitar.nextLine();
                pesquisarFuncionario(nomeFuncionario2);
                System.out.println();
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
