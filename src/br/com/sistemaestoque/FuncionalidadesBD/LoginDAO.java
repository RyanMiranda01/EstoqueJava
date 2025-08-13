package br.com.sistemaestoque.FuncionalidadesBD;

import br.com.sistemaestoque.FuncoesSistema.LimparTerminal;
import br.com.sistemaestoque.JavaDatabaseConnectivityJDBC.Conexao;
import br.com.sistemaestoque.Menu.Menus;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class LoginDAO {
    LimparTerminal limparTerminal = new LimparTerminal();

    private Integer idFuncionario;
    Scanner digitar = new Scanner(System.in);

    private Connection conn;

    public LoginDAO(){
        this.conn = new Conexao().conectar();
    }




    public Integer VerificadorLogin(){
        try {
            while (true) {
                System.out.println("COLOQUE SEU LOGIN AQUI");
                String login = digitar.nextLine();
                System.out.println("COLOQUE SUA SENHA AQUI!");
                String senha = digitar.nextLine();
                String sql = "select * from funcionarios where email=? and senha=?";
                System.out.println("--------------------------------");
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setString(1, login);
                stmt.setString(2, senha);

                ResultSet rs = stmt.executeQuery();

                if (rs.next()) {
                    if (rs.getString("email").equals(login) && rs.getString("senha").equals(senha)) {
                        if (rs.getString("nivel_acesso").equals("ADMINISTRADOR")) {
                            limparTerminal.limpeza();
                            System.out.println("LOGIN: " + rs.getString("nome"));
                            System.out.println("NIVEL: " + rs.getString("nivel_acesso"));
                            System.out.println("--------------------------------");
                            this.idFuncionario = rs.getInt("id");
                            return this.idFuncionario;

                        } else if (rs.getString("nivel_acesso").equals("USUÁRIO")) {
                            Menus menu = new Menus();
                            limparTerminal.limpeza();
                            System.out.println("LOGIN: " + rs.getString("nome"));
                            System.out.println("NIVEL: " + rs.getString("nivel_acesso"));
                            System.out.println("--------------------------------");
                            menu.menuDoUsuario();
                        }
                    }
                }else {
                    System.out.println("USUÁRIO NÃO ENCONTRADO TENTE NOVAMENTE!");
                }
                rs.close();
                stmt.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}
