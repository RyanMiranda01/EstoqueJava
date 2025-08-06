package br.com.sistemaestoque.referencias;

public class Estoque {
    private Integer id;
    private String nome_produto;
    private Double valor;
    private Integer Qtd;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome_produto() {
        return nome_produto;
    }

    public void setNome_produto(String nome_produto) {
        this.nome_produto = nome_produto;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Integer getQtd() {
        return Qtd;
    }

    public void setQtd(Integer qtd) {
        Qtd = qtd;
    }
}
