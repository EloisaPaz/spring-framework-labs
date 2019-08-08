Microserviços com springboot e docker

1 - Adicione suas respectivas chaves de validação do twitter no arquivo "application.properties" localizado na pasta twiiter/src/main/resources

2 - Para cada serviço rode o comando "gradle clean build" dentro da pasta main 

3 - Em seguida para cada serviço rode "docker build -t {NOME_DA_IMAGEM}" dentro da pasta main

4 - Para finalizar rode "docker-compose up" na pasta onde está localizado o arquivo: docker-compose.yml

Instruções para acessar cada serviço:

Twitter: 
- Acesse http://localhost:8080/twitter/{USER}
- Troque {USER} pelo usuário que deseja procurar

Github:
- Acesse http://localhost:8080/github/{USER}
- Troque {USER} pelo usuário que deseja procurar

Twitter e Github:
- Acesse http://localhost:8080/github/{gitUser}/twitter/{ttUser}
- Troque {gitUser} pelo usuário do Github que deseja procurar
- Troque {ttUser} pelo usuário do Twitter que deseja procurar


