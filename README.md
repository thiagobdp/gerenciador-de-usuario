# Polling Session Manager

## ⚙ Getting Started

Visual Studio 2015, 2017 e 2019
https://support.microsoft.com/pt-br/topic/os-downloads-do-visual-c-mais-recentes-com-suporte-2647da03-1eea-4433-9aff-95f26a218cc0
ou para sistemas x64: 
https://aka.ms/vs/16/release/vc_redist.x64.exe


MySQL Installer 8.0.25
https://dev.mysql.com/downloads/windows/installer/8.0.html

ou direto no link: 
https://dev.mysql.com/get/Downloads/MySQLInstaller/mysql-installer-community-8.0.25.0.msi

mysql user: root
mysql password: root

Clone this repository in your computer: https://github.com/thiagobdp/voting-sessions







## 💻 Running the project

Start running UserAccreditationApplication.java

In Eclipse IDE right click file UserAccreditationApplication.java -> Run As -> Java Application

## 📄 User Accreditation 

The User Accreditation Rest service receives json data and return success=true and accredited=true/false

## ⭐ Bonus

The User Accreditation Informations are saved to H2 Memory Data Base.

The Rest service receives documents to accreditate an investor. In the first request to a new user_id, the user_id will be saved as accreditated=true with all the documents informed to the service.

In the next requests for an existing user_id, it reverses the previous value of boolean accreditated and updates the data base. Also saves the documents to data base.

Other Rest Services are available to list Entities "User Accreditation", "Payload" and "Document".

The API documentation is available with Swagger at URL: http://localhost:8080/swagger-ui.html

## 🔬 Running Tests

There are automated tests available for the UserController and all Repositories.

Use Manven Test to run all tests together. In Eclipse IDE, righ click "pom.xml" -> "Run as" -> "Maven test"

Tests will use "test" profile, so it uses a specific DB but also in H2.