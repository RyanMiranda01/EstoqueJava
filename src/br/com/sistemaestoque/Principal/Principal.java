package br.com.sistemaestoque.Principal;

import br.com.sistemaestoque.FuncionalidadesBD.FuncDB;
import br.com.sistemaestoque.JavaDatabaseConnectivityJDBC.Conexao;



import java.sql.SQLException;


public class Principal {
    public static void main(String[] args) throws SQLException {

        FuncDB fc = new FuncDB();
        fc.ListarTabelaEstoque();
        fc.ListarTabelaFuncionarios();
        fc.ListarTabelaHistorico();
    }

}