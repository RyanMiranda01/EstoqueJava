# EstoqueJava - Sistema de estoque via terminal

 O EstoqueJava é um sistema que consiste com a manipulações das tabelas de estoque, funcionários e histórico de estoque, onde você pode:

✅ Ver Estoque, funcionários e histórico de alteração 
✅ Inserir, deletar e editar a tabela estoque
✅ Inserir e deletar a tabela funcionários
✅ Pesquisar em ambas das tabelas  
✅ Ver histórico de alterações  
✅ Acesso só é permitido se for funcionário
✅ Alteração de usuário("ADMINISTRADOR" OU "USUÁRIO")

---

## 🖼️ Demonstração

```bash
BEM-VINDO AO SEU ESTOQUE!
COLOQUE SEU LOGIN AQUI
root@empresa.com
COLOQUE SUA SENHA AQUI!
root
--------------------------------

LOGIN: Administrador Root
NIVEL: ADMINISTRADOR
--------------------------------
ESCOLHA UMA OPÇÃO ABAIXO
1. VER ESTOQUE
2. VER FUNCIONARIOS
3. VER HISTÓRICO DE ALTERAÇÃO
4. MUDAR DE USUÁRIO
5. SAIR
1

ID         | 39
NOME       | Notebook Dell i7
VALOR      | 4599.90
QUANTIDADE | 10
---------------------------------
ID         | 40
NOME       | Mouse Sem Fio Logitech
VALOR      | 129.90
QUANTIDADE | 25
---------------------------------
ID         | 41
NOME       | Teclado Mecânico RGB
VALOR      | 349.90
QUANTIDADE | 15
---------------------------------
ESCOLHA UMA DAS OPÇÕES A SEGUIR
1. ADICIONAR PRODUTO
2. ALTERAR PRODUTO PELO ID
3. DELETAR PRODUTO
4. PESQUISAR PRODUTO
5. VOLTAR

```
🔧 Tecnologias Utilizadas
---

Java 17+

jar MySqlConnector

Scanner

PreparedStatement(Evita SQL Injection)-Compila o código SQL

ResultSet-Guarda e age como cursor pela tabela

🧩 Estrutura dos Pacotes
---
```
Pacote	Conteúdo
br.com.sistemaestoque.FuncionalidadesBD
br.com.sistemaestoque.FuncionalidadesBD
├── EstoqueDAO
├── FuncionariosDAO
├── HistoricoDAO
├── LoginDAO
└── SelectDAO

br.com.sistemaestoque.FuncionalidadesInternas
├── FuncionalidadeDoSistema
└── LimparTerminal

br.com.sistemaestoque.JavaDatabaseConnectivityJDBC
└── Conexao

br.com.sistemaestoque.Menus
└── Menu

br.com.sistemaestoque.Principal
└── Principal


```
# ▶️ Como Executar o Projeto

✅ Usando IDE (IntelliJ ou NetBeans)
---

Importe o projeto como Projeto Java

Configure a biblioteca MySQL Connector/J (JDBC)

No IntelliJ: File > Project Structure > Libraries

Ou adicione o .jar manualmente

Rode a classe br.com.sistemaestoque.Principal

------------------------------------------------------------------------------------
------------------------------------------------------------------------------------
📦 Arquivos Gerados
---

NoticiasSalvas.txt: armazena os artigos que o usuário escolheu salvar.

Histórico de temas pesquisados é mantido em memória durante execução.

📁 Estrutura do Projeto
---
```
bash
Copiar
Editar
JavaNews/
├── src/
│   └── br/com/JavaNews/
│       ├── API/
│       │   └── API.java
│       ├── FuncionalidadeAPI/
│       │   └── FuncionalidadeAPI.java
│       ├── Formatacao/
│       │   ├── Artigo.java
│       │   ├── ArtigoJava.java
│       │   └── LocalArtigo.java
│       └── Principal/
│           └── Principal.java
├── NoticiasSalvas.txt
└── README.md
```
📌 Funcionalidades Completas
---

 Buscar notícias por tema personalizado

 Buscar notícias por tema pré-definido (15 categorias)

 Exibir artigos com título, autor, descrição, data, imagem, fonte

 Salvar artigos em arquivo .txt

 Visualizar histórico de temas pesquisados

 Visualizar artigos salvos

 Limpar o histórico de artigos salvos

 Navegação interativa por menus

 Tratamento de erros (input inválido, artigo inexistente, exceções)

📄 Licença
---

Este projeto está licenciado sob a MIT License.

👨‍💻 Desenvolvedor
---

Ryan Miranda Barbosa

🎓 Estudante de Análise e Desenvolvimento de Sistemas

📍 Santa Isabel – SP

📧 ryandilei17@gmail.com

📱 (11) 93095-5271
