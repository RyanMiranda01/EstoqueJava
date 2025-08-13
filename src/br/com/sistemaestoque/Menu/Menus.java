package br.com.sistemaestoque.Menu;

import br.com.sistemaestoque.FuncionalidadesBD.SelectDAO;
import br.com.sistemaestoque.FuncionalidadesBD.LoginDAO;
import br.com.sistemaestoque.FuncionalidadesBD.EstoqueDAO;
import br.com.sistemaestoque.FuncionalidadesBD.FuncionariosDAO;
import br.com.sistemaestoque.FuncoesSistema.LimparTerminal;

import java.sql.SQLException;
import java.util.Scanner;

public class Menus {
    LimparTerminal limparTerminal = new LimparTerminal();
    LoginDAO funcLogin = new LoginDAO();
    Scanner digitar = new Scanner(System.in);
    private EstoqueDAO funcionalidadesDoEstoque;
    FuncionariosDAO funcionalidadesDoFuncionarios = new FuncionariosDAO();
    private SelectDAO funcSelect;
    {
        try {
            funcSelect = new SelectDAO();
        } catch (SQLException erro) {
            System.out.println("O ERRO É " + erro);
        }
    }



    public void menuPrincipal() {
        try {
            System.out.println("BEM-VINDO AO SEU ESTOQUE!");
            int idFuncionarioLogado = funcLogin.VerificadorLogin();
            funcionalidadesDoEstoque = new EstoqueDAO(idFuncionarioLogado);
            menuSelecionarOpcoesIniciais();

        } catch (SQLException erro) {
            System.out.println("O ERRO É " + erro);
        }
    }



    public void menuSelecionarOpcoesIniciais() {
        try {
            while (true) {
                System.out.println("ESCOLHA UMA OPÇÃO ABAIXO");
                System.out.println("1. VER ESTOQUE");
                System.out.println("2. VER FUNCIONARIOS");
                System.out.println("3. VER HISTÓRICO DE ALTERAÇÃO");
                System.out.println("4. MUDAR DE USUÁRIO");
                System.out.println("5. SAIR");
                Integer opcoes = digitar.nextInt();



                if(opcoes <1 || opcoes >5) {
                    System.out.println("OPÇÃO INVÁLIDA!!");
                }else{
                menuDasOpcoesDeEscolhaDasTabela(opcoes);
            }
            }
        } catch (Exception erro) {
            System.out.println("O ERRO É " + erro);
        }
    }



    public void menuDoUsuario() {
        try {
            while (true) {
                System.out.println("ESCOLHA UMA OPÇÃO ABAIXO");
                System.out.println("1. VER ESTOQUE");
                System.out.println("2. VER HISTÓRICO DE ALTERAÇÃO");
                System.out.println("3. MUDAR DE USUÁRIO");
                System.out.println("4. SAIR");

                switch (digitar.nextInt()) {
                    case 1:
                        funcSelect.ListarTabelaEstoque();
                        System.out.println("ESCOLHA UMA DAS OPÇÕES ABAIXO");
                        System.out.println("1. PESQUISAR PRODUTO");
                        System.out.println("2. SAIR");
                        Integer opc = digitar.nextInt();
                        switch (opc){
                            case 1:

                                limparTerminal.limpeza();
                                digitar.nextLine();
                                System.out.println("DIGITE O NOME DO PRODUTO QUE GOSTARIA DE PESQUISAR");
                                String nomeProduto = digitar.nextLine();
                                funcSelect.pesquisarProdutoPorNome(nomeProduto);
                                break;
                            case 2:
                                break;
                        }
                        break;
                    case 2:
                        funcSelect.ListarTabelaHistorico();
                        break;
                    case 3:
                        limparTerminal.limpeza();
                        menuPrincipal();
                    case 4:
                        System.out.println("OBRIGADO POR USAR O SISTEMA, ATÉ A PRÓXIMA!");
                        System.exit(0);

                }
            }
        } catch (Exception erro) {
            System.out.println("O ERRO É " + erro);
        }
    }




    public void menuDasOpcoesDeEscolhaDasTabela(Integer opcao) {
        try {

            switch (opcao) {
                case 1:
                    funcSelect.ListarTabelaEstoque();
                    System.out.println("ESCOLHA UMA DAS OPÇÕES A SEGUIR");
                    System.out.println("1. ADICIONAR PRODUTO");
                    System.out.println("2. ALTERAR PRODUTO PELO ID");
                    System.out.println("3. DELETAR PRODUTO");
                    System.out.println("4. PESQUISAR PRODUTO");
                    System.out.println("5. VOLTAR");
                    Integer opcao2 = digitar.nextInt();

                    switch (opcao2) {
                        case 1:
                            limparTerminal.limpeza();
                            System.out.println("DIGITE O NOME DO PRODUTO");
                            digitar.nextLine();
                            String nome = digitar.nextLine();
                            System.out.println("DIGITE O VALOR DO PRODUTO");
                            Double valor = digitar.nextDouble();
                            System.out.println("DIGITE A QUANTIDADE DO PRODUTO");
                            Integer qtd = digitar.nextInt();
                            funcionalidadesDoEstoque.adicionarProduto(nome, valor, qtd);
                            break;
                        case 2:
                            funcSelect.ListarTabelaEstoque();
                            System.out.println("DIGITE O ID DO PRODUTO QUE DESEJA ALTERAR");
                            Integer id = digitar.nextInt();
                            System.out.println("QUAL SERÁ O NOME ATUAL");
                            digitar.nextLine();
                            String nomeAlt = digitar.nextLine();
                            System.out.println("QUAL O VALOR ATUAL");
                            Double valorAlt = digitar.nextDouble();
                            System.out.println("QUAL A QUANTIDADE ATUAL");
                            Integer qtdAlt = digitar.nextInt();
                            funcionalidadesDoEstoque.alterarProduto(id, nomeAlt, valorAlt, qtdAlt);
                            break;
                        case 3:
                            funcSelect.ListarTabelaEstoque();
                            System.out.println("DIGITE O ID DP PRODUTO QUE GOSTARIA DE EXCLUIR");
                            Integer idProduto = digitar.nextInt();
                            funcionalidadesDoEstoque.excluirProduto(idProduto);
                            break;
                        case 4:
                            digitar.nextLine();
                            System.out.println("DIGITE O NOME DO PRODUTO QUE GOSTARIA DE PESQUISAR");
                            String nomeProduto = digitar.nextLine();
                            funcSelect.pesquisarProdutoPorNome(nomeProduto);
                            break;
                        case 5:
                            break;
                    }
                    break;

                case 2:
                    funcSelect.ListarTabelaFuncionarios();
                    System.out.println("ESCOLHA UMA DAS OPÇÕES A SEGUIR");
                    System.out.println("1. ADICIONAR FUNCIONÁRIO");
                    System.out.println("2. DELETAR FUNCIONÁRIO ");
                    System.out.println("3. PESQUISAR FUNCIONÁRIO ");
                    System.out.println("4. VOLTAR");
                    Integer opcao3 = digitar.nextInt();
                    switch (opcao3) {

                        case 1:
                            limparTerminal.limpeza();
                            System.out.println("DIGITE O NOME DO FUNCIONÁRIO");
                            digitar.nextLine();
                            String nomeFunc = digitar.nextLine();
                            System.out.println("DIGITE O GÊNERO (MASCULINO) OU (FEMININO)");
                            String genero = digitar.nextLine();
                            System.out.println("DIGITE O EMAIL");
                            String email = digitar.nextLine();
                            System.out.println("DIGITE A SENHA");
                            String senha = digitar.nextLine();
                            System.out.println("DIGITE O NIVEL DE ACESSO 'ADMINISTRADOR' OU 'USUÁRIO'(DO JETO QUE ESTÁ NO ANÚNCIADO)");
                            String nivelAcesso = digitar.nextLine();
                            funcionalidadesDoFuncionarios.adicionarFuncionarios(nomeFunc, genero, email, senha, nivelAcesso);
                            break;
                        case 2:
                            System.out.println("DIGITE O ID DO FUNCIONÁRIO QUE GOSTARIA DE EXCLUIR");
                            Integer idFunc = digitar.nextInt();
                            funcionalidadesDoFuncionarios.deletarFuncionariop(idFunc);
                            break;
                        case 3:
                            limparTerminal.limpeza();
                            digitar.nextLine();
                            System.out.println("DIGITE O NOME DO FUNCIONÁRIO");
                            String nomeFuncionario = digitar.nextLine();
                            funcSelect.pesquisarFuncionario(nomeFuncionario);
                            break;

                        case 4:
                            break;
                    }
                    break;
                case 3:
                    funcSelect.ListarTabelaHistorico();
                    break;
                case 4:
                    limparTerminal.limpeza();
                    menuPrincipal();
                    break;
                case 5:
                    System.out.println("OBRIGADO POR USAR O SISTEMA, ATÉ A PRÓXIMA!");
                    System.exit(0);
            }

        }catch (Exception erro){
            System.out.println("O ERRO É " + erro);
        }

    }
}