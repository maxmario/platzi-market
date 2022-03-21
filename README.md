# Platzi-Market
Curso de platzi market con Spring

# Levantar aplicación local
.\gradlew bootrun

# Generar jar
.\gradlew bootjar

# Ejecutar aplicación DEV
java -jar .\build\libs\platzi-market-1.0.jar

# Ejecutar aplicación PROD
java -jar "-Dspring.profiles.active=prod" .\build\libs\platzi-market-1.0.jar

# Swagger
http://localhost:8090/platzi-market/api/swagger-ui.html#/

# Login en Heroku
heroku login

# Crear aplicación
heroku create platzimarket

# Agregar postgresql
heroku addons:create heroku-postgresql

# Ver las configuraciónes de la base de datos de heroku
heroku config
