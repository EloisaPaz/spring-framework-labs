- Coloque o .war do eureka na pasta webapps do tomcat:

tomcat $

  ./catalina.sh start
tema-09 $

  .gradlew build
  cd pow-microservice/.gradlew run
  cd ..
  cd calc-microservice/.gradlew run

É possível verificar seus estados pelo Eureka, em:

  http://localhost:8080/eureka/ 

Para realizar um cálculo diretamente pelo microserviços de potenciação:

  http://127.0.0.1:6006/math/pow/{valor}/{valor}

Para realizar o cálculo pela calculadora:

  http://localhost:6005/math/calc/{a}{b}^
