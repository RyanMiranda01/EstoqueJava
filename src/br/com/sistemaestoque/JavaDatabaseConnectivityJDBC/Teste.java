package br.com.sistemaestoque.JavaDatabaseConnectivityJDBC;

import javax.swing.*;

public class Teste {
    public static void main(String[] args) {
            try {
                new Conexao().conectar();
                JOptionPane.showMessageDialog(null, "Conexao feita");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

    }
