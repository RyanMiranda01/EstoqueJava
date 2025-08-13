package br.com.sistemaestoque.JavaDatabaseConnectivityJDBC;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    final String conexao = "jdbc:Mysql://localhost:3306/EstoqueJava";
    final String user = "root";
    final String password = "123456";


    public Connection conectar(){
        try {
           return DriverManager.getConnection(conexao, user, password);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Seu erro de conexão ocorreu pois" + e);
        }
        return null;
    }
}
