# language: pt
@login
Funcionalidade: Fazer Login de conta cadastrada
  
  Como usuario do site Advantage Shopping
  Quero realizar o login da minha conta
  Para realizar compras de produtos

@CT_006
  Cenario: Login com Sucesso
    Dado que acesso a tela de login do usuario
    Quando submeto o meu login com nome e senha
    Entao devo ser redirecionado home page

@CT_007
  Cenario: Não informar email
    Dado que acesso a tela de login do usuario
    Quando submeto o meu login senha
    Entao devo ver a mensagem de alerta "Username field is required"

@CT_008
  Cenario: Não informar senha
    Dado que acesso a tela de login do usuario
    Quando submeto o meu login nome
    Entao devo ver a mensagem de alerta "Password field is required"
