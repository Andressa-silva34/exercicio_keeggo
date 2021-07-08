# language: pt
@cadastro
Funcionalidade: Cadastrar usuario

  Como usuario 
  Quero realizar meu cadastro no site Advantage Shopping
  Para realizar compras de produtos

  @CT_001
  Cenario: Cadastro campos obrigatorios
    Dado que acesso a tela de cadastro
    Quando submeto o meu cadastro com nome: "andressa", email: "andres@outlook.com", senha: "Pwd123" e senha de confirmacao: "Pwd123"
    Entao devo ser redirecionado pagina incial

  @CT_002
  Cenario: Não informo o nome
    Dado que acesso a tela de cadastro
    Quando submeto o meu cadastro com email: "andressa@yahoo.com", senha: "Ags123" e senha de confirmacao: "Ags123"
    Entao devo ver a mensagem "Username field is required"

  @CT_003
  Cenario: Não informo o email
    Dado que acesso a tela de cadastro
    Quando submeto o meu cadastro com nome: "andressa", senha: "Ags123" e senha de confirmacao: "Ags123"
    Entao devo ver a mensagem "Email field is required"

  @CT_004
  Cenario: Não informo a senha
    Dado que acesso a tela de cadastro
    Quando submeto o meu cadastro com nome: "andressa" e email: "andressa@yahoo.com"
    Entao devo ver a mensagem "Password field is required"

  @CT_005
  Cenario: Informe senhas divergentes
    Dado que acesso a tela de cadastro
    Quando submeto o meu cadastro com submeto o meu cadastro com nome: "andressa", email: "andressa@yahoo.com", senha: "Ags123" e senha de confirmacao: "Ags"
    Entao devo ver a mensagem "Passwords do not match"
