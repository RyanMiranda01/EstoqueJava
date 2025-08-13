package br.com.sistemaestoque.FuncionalidadesBD;

import br.com.sistemaestoque.JavaDatabaseConnectivityJDBC.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class HistoricoDAO {

    private Connection conn;

    public HistoricoDAO() {
        this.conn = new Conexao().conectar();
    }

    public void salvarHitoricoInsercao(Integer idFunc, Integer idProduto, Integer qtd) {
        try {

            String sqlSelect = "select max(id) as id_maior from estoque;";

            PreparedStatement stmtSelect = conn.prepareStatement(sqlSelect);

            ResultSet rs = stmtSelect.executeQuery();

            if (rs.next()) {
                idProduto = rs.getInt("id_maior");
            }

            String sqlHistorico = "Insert into historicoestoque(id_funcionario, id_produto, Qtd, data_alt, tipo)" +
                    "values" +
                    "(?,?,?,CURDATE(),?)";
            PreparedStatement stmt2 = conn.prepareStatement(sqlHistorico);
            stmt2.setInt(1, idFunc);
            stmt2.setInt(2, idProduto);
            stmt2.setInt(3, qtd);
            stmt2.setString(4, "ADICIONADO");
            stmt2.execute();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void salvarHistoricoAlteracao(Integer id, Integer idProduto, Integer idFunc, Integer qtd){
        try {
            String sqlSelect = "select id as ultimoId from estoque WHERE id=?;";

            PreparedStatement stmtSelect = conn.prepareStatement(sqlSelect);
            stmtSelect.setInt(1, id);

            ResultSet rs = stmtSelect.executeQuery();

            if (rs.next()) {
                idProduto = rs.getInt("ultimoId");
            }

            String sqlHistorico = "Insert into historicoestoque (id_funcionario, id_produto, Qtd, data_alt, tipo)" +
                    "values" +
                    "(?,?,?,CURDATE(),?)";
            PreparedStatement stmt2 = conn.prepareStatement(sqlHistorico);
            stmt2.setInt(1, idFunc);
            stmt2.setInt(2, idProduto);
            stmt2.setInt(3, qtd);
            stmt2.setString(4, "ALTERAÇÃO");
            stmt2.execute();
            stmt2.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}