# GenericsRepositories
Trabalho de Reuso de Software de um framework simples para gerenciar entidades genéricas em Java, permitindo a realização de operações básicas de CRUD (Create, Read, Update, Delete).

# Boas Práticas Utilizadas
- Modelagem: arquivos de configuração e documentação do projeto estão separados entre a raiz do projeto e a src que contém os arquivos .java da aplicação. Ainda na src os arquivos estão separados em main/java e test/java seguindo a organização de pastas sugerida pelo Maven;
- Utilização da classe Genérica InMemoryRepository: a classe genérica implementada permite utilizar os métodos listados pelo CrudRepository em uma estrutura de dados de HashMap que é excelente para operações de consulta como findById, update e delete utilizando o id como chave;
- Testes Unitários com JUnit 5: os testes unitários permitem a checagem ágil do funcionamento dos métodos que são utilizados na aplicação;
- Utilização da biblioteca java.util.UUID e de ids como String: isto permite gerar ids mais complexos restringindo possíveis tentativas de captura de dados;
- Utilização da biblioteca java.util.logging.Logger já no início do projeto: os logs no início do projeto permitem identificar erros ou simplesmente validar os métodos de uma forma alternativa aos testes;
- Versionamento: o .gitignore contém o arquivo target que deve ser gerado localmente em cada máquina para garantir a execução correta da aplicação.

# Executar
- Tenha o Extension Pack for Java instalado no VSCode
- Instale o JDK e o Maven em sua máquina
- Execute o comando mvn clean: exclui a parta target se houver
- Execute o comando mvn compile: gera os .class na pasta target/classes
- Execute o comando mvn test: executa todos os testes
- Execute o comando mvn package: gera o .jar do projeto
- Execute o comando java -jar target/in-memory-repository-1.0-SNAPSHOT.jar: roda o projeto