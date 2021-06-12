# Em construção - Gerenciador de Assembleias para Votação

## ⚙ Iniciando

Clone este repositório em seu computador: https://github.com/thiagobdp/voting-sessions


## Configurando MySql

### Instalar Visual Studio 2015, 2017 e 2019

Versões mais recentes do Visual C++:
- https://support.microsoft.com/pt-br/topic/os-downloads-do-visual-c-mais-recentes-com-suporte-2647da03-1eea-4433-9aff-95f26a218cc0

A versão utilizada neste projeto é o link abaixo: 

- https://aka.ms/vs/16/release/vc_redist.x64.exe

### Instalar MySQL 8.0.25

MySQL Installer 8.0.25:
- https://dev.mysql.com/downloads/windows/installer/8.0.html

ou diretamente pelo link:
- https://dev.mysql.com/get/Downloads/MySQLInstaller/mysql-installer-community-8.0.25.0.msi

Sugestão de senha para root:
- mysql password: root

## Criar um novo banco de dados e um usuário para a aplicação
Abra o aplicativo MySQL 8.0 Command Line Client. Ao abrir será solicitada a senha de root fornecida no passo anterior.

Execute os seguintes comando no mysql prompt ( mysql> ):

1- Cria o novo banco 
* `create database bd_gerenciador_assembleias;`

2- Cria o novo usuário

* `create user 'pmanageruser'@'%' identified by 'pmanageruser';`

3- Fornece todos privilégios para o novo usuário no novo banco de dados
* `grant all on bd_gerenciador_assembleias.* to 'pmanageruser'@'%';`
















