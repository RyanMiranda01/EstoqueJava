package br.com.sistemaestoque.FuncionalidadesBD;

import br.com.sistemaestoque.FuncoesSistema.LimparTerminal;
import br.com.sistemaestoque.JavaDatabaseConnectivityJDBC.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EstoqueDAO {
    LimparTerminal limparTerminal = new LimparTerminal();
    HistoricoDAO historicoDAO = new HistoricoDAO();
    private Integer idFunc;
    private Integer idProduto;
    private Connection conn;
    private Integer qtd;

    public EstoqueDAO(Integer idFunc) throws SQLException {
        this.conn = new Conexao().conectar();
        this.idFunc = idFunc;
    }





    public void adicionarProduto( String nome, Double valor, Integer qtd){
        try {
            String sql = "Insert into estoque(nome_produto, valor, qtd) value" +
                    "(?,?,?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1,nome);
            stmt.setDouble(2,valor);
            stmt.setInt(3,qtd);
            stmt.execute();

            historicoDAO.salvarHitoricoInsercao(idFunc,idProduto,qtd);
            stmt.close();
            limparTerminal.limpeza();
            System.out.println("PRODUTO INSERIDO COM SUCESSO");


        } catch (SQLException e) {
            System.out.println("ERRO É " + e);
        }
    }




    public void alterarProduto(Integer id, String nome, Double valor, Integer qtd){
        try {
            String sql = "UPDATE estoque SET nome_produto =?, valor =?, qtd=? WHERE (id = ?);";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, nome);
            stmt.setDouble(2, valor);
            stmt.setInt(3, qtd);
            stmt.setInt(4,id);

            stmt.execute();

           historicoDAO.salvarHistoricoAlteracao(id,idProduto, idFunc,qtd);
            stmt.close();
            limparTerminal.limpeza();
            System.out.println("PRODUTO ATUALIZADO COM SUCESSO");

        } catch (Exception e) {
            System.out.println("ERRO É " + e);
        }
    }




    public void excluirProduto(Integer id){
        try {
            String sql = "DELETE FROM estoque WHERE (id = ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            limparTerminal.limpeza();
            System.out.println("PRODUTO EXCLUIDO COM SUCESSO");


            stmt.execute();
            stmt.close();

        } catch (SQLException e) {
            System.out.println("ERRO É " + e);
        }
    }

}
