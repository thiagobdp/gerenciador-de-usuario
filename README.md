# Gerenciador de Usuário

## Iniciando

Clone este repositório em seu computador: https://github.com/thiagobdp/gerenciador-de-usuario

## Objetivo

Este projeto tem como objetivo fornecer um serviço externo para ser acessado pelo projeto abaixo

* https://github.com/thiagobdp/gerenciador-de-assembleias

Foi desenvolvido um serviço rest que valida se um CPF é válido e retorna se o CPF pode ou não votar.

Esse aplicativo está disponível na URL abaixo com documentação Swagger
* https://thiagobdp-usuarios-cpf.herokuapp.com/swagger-ui.html

## 🔬 Testes automatizados de integração

Foi criado teste automatizado para a classe UserController com 100% de cobertura

Resultando no total de cobertura de teste do sistema em 75,0%.

Utilize Manven Test para executar todos teste juntos. No Eclipse IDE, clique com o botão direito do mouse "pom.xml" -> "Run as" -> "Maven test".

Os testes utilizam o profile "test" e as operações são executadas no banco em memória H2.
