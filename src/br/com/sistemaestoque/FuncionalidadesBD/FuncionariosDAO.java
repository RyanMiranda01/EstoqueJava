package br.com.sistemaestoque.FuncionalidadesBD;

import br.com.sistemaestoque.FuncoesSistema.LimparTerminal;
import br.com.sistemaestoque.JavaDatabaseConnectivityJDBC.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class FuncionariosDAO {
    LimparTerminal limparTerminal = new LimparTerminal();
    private Connection conn;

    public FuncionariosDAO() {
        this.conn = new Conexao().conectar();
    }






    public void adicionarFuncionarios(String nome, String genero, String email, String senha, String nivel){
        try {
            String sql = "insert into funcionarios (nome, genero, email, senha, nivel_acesso)" +
                    "values" +
                    "(?,?,?,?,?)";

            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setString(1,nome);
            stmt.setString(2,genero);
            stmt.setString(3,email);
            stmt.setString(4,senha);
            stmt.setString(5,nivel);

            stmt.execute();
            stmt.close();
            limparTerminal.limpeza();
            System.out.println("FUNCIONÁRIO ADICIONADO COM SUCESSO");

        } catch (Exception e) {
            System.out.println("ERRO É " + e);
        }
    }





    public void deletarFuncionariop(Integer id ){
        try {
            String sql = "delete from funcionarios where (id=?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1,id);
            stmt.execute();
            stmt.close();
            limparTerminal.limpeza();
            System.out.println("FUNCIONÁRIO EXCLUIDO COM SUCESSO");

        } catch (Exception e) {
            System.out.println("ERRO É " + e);
        }
    }
}
