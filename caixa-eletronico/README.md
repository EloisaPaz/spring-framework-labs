# Caixa Eletrônico

## Objetivo:

### Desenvolva um programa que simule a entrega de notas quando um cliente efetuar um saque em um caixa eletrônico. Os requisitos básicos são os seguintes:

- Entregar o menor número de notas;
- É possível sacar o valor solicitado com as notas disponíveis;
- Saldo do cliente infinito;
- Quantidade de notas infinito (pode-se colocar um valor finito de cédulas para aumentar a dificuldade do problema);
- Notas disponíveis de *R$ 10,00; R$ 20,00; R$ 50,00 e R$ 100,00*

### Exemplos:

**- Valor do Saque:** *R$ 30,00* 

**- Resultado Esperado:** Entregar 1 nota de *R$20,00* e 1 nota de *R$ 10,00*

**- Valor do Saque:** *R$ 80,00* 

**- Resultado Esperado:** Entregar 1 nota de *R$50,00* 1 nota de *R$ 20,00* e 1 nota de *R$ 10,00*

___

## Arquitetura: 

### Projeto feito com SpringBoot utilizando a seguinte estrutura de pacotes:

**- Raiz do projeto:**  ```Application.java:``` classe main responsável pela execução do projeto.  

**- Config:** bean que faz a comunicação com a classe service.

**- Service:** responsável pela lógica do algoritmo.

**- Controller:** responsável pela configuração do endpoint que irá receber o valor do saque.

**- Exception:** responsável pelo tratamento de exceções. 

___

## Lógica do Algoritmo: 

    É feita uma validação no input do usuário:

    - O valor não pode ser 0
    - O valor não poder ser negativo
    - O valor tem que ser divisível por 10

    Se o valor do input não passar na validação o erro é tratado através de exceções de acordo com cada caso.
    
    Após ser validado o valor é passado a um algoritmo iterativo que utiliza o valor das notas disponíveis e
    a quantidade de notas disponíveis para encontrar o menor número de notas possível.

___

## Instruções para execução:

- Abra o terminal na pasta raiz do projeto e digite o seguinte comando: 

        gradle build

> Este comando vai gerar um jar do projeto no diretório **build/libs/**

- Vá até o diretório *build/libs/* e digite o seguinte comando: 

        java -jar {nome_do_jar}.jar

### A aplicação estará disponível em: 

- http://localhost:8080/saque/{valor_do_saque}
 
