package br.com.sistemaestoque.referencias;

import java.time.LocalDate;

public class HistoricoEstoque {
    private int id;
    private Funcionarios nome;
    private Estoque nome_produto;
    private Integer Qtd;
    private LocalDate data_alt;

    public Funcionarios getNome() {
        return nome;
    }

    public void setNome(Funcionarios nome) {
        this.nome = nome;
    }

    public Estoque getNome_produto() {
        return nome_produto;
    }

    public void setNome_produto(Estoque nome_produto) {
        this.nome_produto = nome_produto;
    }

    public Integer getQtd() {
        return Qtd;
    }

    public void setQtd(Integer qtd) {
        Qtd = qtd;
    }

    public LocalDate getData_alt() {
        return data_alt;
    }

    public void setData_alt(LocalDate data_alt) {
        this.data_alt = data_alt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
