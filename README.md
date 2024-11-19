Projeto Final Arquitetura Java - Cadastro de Locadoras e Veiculos
Este projeto faz parte da disciplina de Arquitetura Java na qual implementamos a funcionalidade de Cadastro de Locadoras e Veiculos, que permite registrar locadoras com seus respectivos veiculos (carros e motos) em um sistema básico utilizando Spring Boot.

Funcionalidades Entregues

Cadastro de Locadoras: Cada locadora possui razão social, cnpj, veiculos e um endereço associado.
Cadastro de Veiculos: Dois tipos de veiculos podem ser cadastrados:
Carros: Veiculos com informações de marca, modelo, valor, categoria e se possui gps ou não.
Motos: Veiculos com informações de marca, modelo, valor, cilindrada e autonomia.
Leitura de Arquivo: O sistema lê um arquivo de texto com informações de locadoras e veiculos e realiza o cadastro automático no sistema.
Listagem de Locadoras e Veiculos: Exibe os locadoras cadastradas, bem como seus veiculos associados.

Estrutura do Projeto:
br.edu.infnet.jefferson.JeffersonApplication: Classe principal do projeto Spring Boot.
br.edu.infnet.jefferson.Loader: Classe responsável por carregar dados iniciais a partir de um arquivo de texto.
br.edu.infnet.jefferson.SwaggerConfig: Classe de configuração Java para Metadados da API.
br.edu.infnet.jefferson.Constantes: Classe para organizar um grupo de constantes, facilitando o reaproveitamento e a coesão do conteúdo estático no projeto.
br.edu.infnet.jefferson.GlobalExceptionHandler: Classe para organizar um grupo de exceções do projeto.

Domínio:
Locadora: Representa a locadora e contém uma lista de veiculos.
Veiculo: Classe abstrata para representar veiculos.
Carro: Subclasse de Veiculo que representa veiculos do tipo carros.
Moto: Subclasse de Veiculo que representa veiculos do tipo motos.
Endereco: Representa o endereço da locadora.

Serviço:
LocadoraService: Classe que gerencia a inclusão, alteração, exclusão e recuperação das locadoras cadastradas.
VeiculoService: Classe que gerencia a inclusão, alteração, exclusão e recuperação das veiculos cadastrados.
CarroService: Classe que gerencia a inclusão, alteração e recuperação dos carros cadastrados.
MotoService: Classe que gerencia a inclusão, alteração e recuperação das motos cadastrados.

Repositorio:
LocadoraRepository: Classe responsável por acessar e manipular dados de locadoras no banco de dados.
VeiculoRepository: Classe responsável por acessar e manipular dados de veiculos no banco de dados.
CarroRepository: Classe responsável por acessar e manipular dados de carros no banco de dados.
MotoRepository: Classe responsável por acessar e manipular dados de motos no banco de dados.

Controles:
LocadoraController: Classe responsável por controlar as requisições de locadoras.
VeiculoController: Classe responsável por controlar as requisições de veiculos.
CarroController: Classe responsável por controlar as requisições de carros.
MotoController: Classe responsável por controlar as requisições de motos.
AppController: Classe responsável por controlar as requisições do Frond-End modelo.

Exceções:
RegistroNaoEncontradoException: Classe de exceção de registro não encontrado.

Tecnologias Utilizadas
Java 17
Spring Boot 3.3.4
Maven
Como Executar
Clone este repositório.

Certifique-se de que o Java 17 e o Maven estão instalados em sua máquina.

Compile o projeto executando: mvn clean install

Execute o projeto com o comando: mvn spring-boot

O sistema irá carregar os dados a partir do arquivo files/locadoras.txt e exibir a lista de locadoras e seus veiculos no console.

Autor
Jefferson Belem - br.edu.infnet
