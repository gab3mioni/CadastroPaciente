# **CadastroPaciente**

Esse repositório é um trabalho final desenvolvido para a matéria de Programação Orientada a Objetos, do 3° ADS/24, 
na FATEC Guaratinguetá - Prof. João Mod. 
O sistema contém a funcionalidade de Cadastro de Pacientes do Projeto Interdisciplinar e Extensão Universitária, 
chamado [PsiFacilita](https://github.com/PsiFacilita).

## *Índice*
1. [Funcionalidades](#funcionalidades)
2. [Requisitos do Sistema](#requisitos-do-sistema)
3. [Ferramentas Utilizadas](#ferramentas-utilizadas)
4. [Como Configurar o Ambiente Local](#como-configurar-o-ambiente-local)

---

## **Funcionalidades**

- **Cadastro de Pacientes:** Cadastre informações de um paciente como nome, CPF, RG, telefone, entre outros.
- **Listagem de Pacientes:** Visualize a lista de pacientes cadastrados.
- **Exportação de dados:** Exporte a lista de pacientes registrados em um arquivo com extensão `.txt`.
- **Importação de dados:** Importa a lista de pacientes registrados em um arquivo com extensão `.txt`.

---

## **Requisitos do sistema**

- **Java Development Kit (JDK):** Versão 22 ou superior.
- **IDE:** IntelliJ IDEA, Geany ou qualquer IDE que suporte Java.
- **Git:** Para versionamento e controle de código.

---

## **Ferramentas utilizadas**

- **Linguagem:** Java
- **IDE:** [IntelliJ IDEA](ttps://www.jetbrains.com/idea/) (recomendado)

---

# **Como configurar o Ambiente Local**

### **Passo 1: Clonar o Repositório**

Certifique-se de ter o Git instalado em sua máquina. Clone o repositório executando o comando:
 
```bash
git clone https://github.com/gab3mioni/CadastroPaciente.git
```

### **Passo 2: Importar o projeto na IDE**

1. Abra sua IDE preferida.
2. Importe o projeto como um projeto Java.
3. Certifique-se de que o JDK está configurado corretamente.

### **Passo 3: Estrutura de Pastas**

Certifique-se de que a estrutura do projeto segue o padrão:

```css
CadastroPaciente/
├── domain/
│   ├── Validator/
│   │   ├── PacienteValidator.java
│   │   ├── PessoaValidator.java
│   │   ├── PsicologoValidator.java
│   │   ├── ValidationException.java
│   ├── Paciente.java
│   └── Pessoa.java
│   └── Psicologo.java
├── repository/
│   ├── InterfaceRepository.java
│   ├── PacienteRepository.java
│   ├── PsicologoRepository.java
├── service/
│   └── CadastroPaciente.java
│   └── PacienteExporter.java
│   └── PacienteReader.java
└── ui/
│   └── Menu.java
└── .gitignore
└── README.md
```

- **`domain/`**: Contém as classes de modelo de dados do sistema, representando as entidades principais, como `Paciente`, `Pessoa` e `Psicologo`. Além disso, inclui a pasta `Validator/` que contém classes de validação específicas para as entidades, como `PacienteValidator`, `PessoaValidator` e `PsicologoValidator`, responsáveis por validar as informações antes de serem processadas, além das validações, possuem a clases `ValidationException`, uma exceção personalizada para sinalizar falha nas validações do sistema.

- **`repository/`**: Armazena classes responsáveis pela persistência dos dados. O `InterfaceRepository` define a interface comum para repositórios de entidades, enquanto `PacienteRepository` e `PsicologoRepository` implementam essa interface para gerenciar as listas de pacientes e psicólogos, respectivamente.

- **`service/`**: Contém classes que implementam a lógica de negócio do sistema. A classe `CadastroPaciente` gerencia o fluxo de cadastro de pacientes, enquanto `PacienteExporter` é responsável pela exportação dos dados dos pacientes para um arquivo e `PacienteReader` é responsável pela leitura dos dados exportados em um arquivo.

- **`ui/`**: Esta pasta contém a classe `Menu`, que oferece uma interface de linha de comando (CLI) para o usuário interagir com o sistema, permitindo funcionalidades como cadastro, listagem e exportação de pacientes.

### **Passo 4: Executar o programa**

1. Localize o arquivo principal: `CadastroPaciente.java`.
2. Execute o programa a partir desse arquivo pelo IntelliJ IDEA ou pelo terminal usando o seguinte comando:
```bash
java CadastroPaciente
```
3. Insira as credenciais de login pré-definidas como `user:` janaina e `password:` senhaTeste123@.

### **Passo 5: Testar funcionalidades**

- **Cadastrar Paciente:** Insira as informações solicitadas
- **Listar Pacientes:** Visualize a lista de pacientes cadastrados.
- **Exportar Pacientes:** Gera um arquivo `.txt` contendo os dados dos pacientes.
- **Importar Pacientes:** Realiza leitura de um arquivo `.txt`, adicionando ao sistema os dados dos pacientes não existentes.
