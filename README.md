# mongodb
Aplicação Springboot Rest com MongoDB 3.6

A versão do Swagger 2.9.2 deste projeto é suportada até a versão 2.4.4 do Spring Boot.

Iniciar servidor monogodb caso esteja com erro de conexão pela aplicação ou pelo MongoDB Compass.
C:\Program Files\MongoDB\Server\3.6\bin\mongod.exe

URL Swagger
http://localhost:8080/mongoapi/swagger-ui.html


Se ao instalar o MongoDB ele não conectar(mongodb connect ECONNREFUSED 127.0.0.1:27017) no MongoDB Compass verificar os passos abaixo:

Se a pasta c:\data\db não existir criar ela com o comando abaixo.

Go to Mongodb folder (ex : C:\ProgramFiles\MongoDB\Server\3.4\bin) and open cmd in the folder and type "mongod.exe --dbpath c:\data\db"
