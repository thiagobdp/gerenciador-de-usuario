# UNDER CONSTRUCTION - Polling Session Manager

## ⚙ Getting Started

Clone this repository in your computer: https://github.com/thiagobdp/voting-sessions


## Configuring MySql

### Install Visual Studio 2015, 2017 e 2019

The latest supported Visual C++ downloads:
- https://support.microsoft.com/pt-br/topic/os-downloads-do-visual-c-mais-recentes-com-suporte-2647da03-1eea-4433-9aff-95f26a218cc0

The version used in this project is x64: 

- https://aka.ms/vs/16/release/vc_redist.x64.exe

### Install MySQL 8.0.25

MySQL Installer 8.0.25:
- https://dev.mysql.com/downloads/windows/installer/8.0.html

or directly on the link:
- https://dev.mysql.com/get/Downloads/MySQLInstaller/mysql-installer-community-8.0.25.0.msi

Set user root:
- mysql password: root

## Create a new Database and Application User
Run the following commands at the mysql prompt (MySQL 8.0 Command Line Client):
- `mysql> create database db_polling_manager; -- Creates the new database`
- `mysql> create user 'pmanageruser'@'%' identified by 'pmanageruser'; -- Creates the user`
- `mysql> grant all on db_polling_manager.* to 'pmanageruser'@'%'; -- Gives all privileges to the new user on the newly created database`
