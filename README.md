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
│   ├── Paciente.java
│   └── PacienteValidator.java
├── repository/
│   ├── InterfacePacienteRepository.java
│   ├── PacienteRepository.java
├── service/
│   └── CadastroPaciente.java
│   └── PacienteExporter.java
└── ui/
│   └── MenuCadastro.java
└── .gitignore
└── README.md
```

- `domain/`: Contém classes relacionadas ao modelo de domínio do sistema. Ela encapsula a lógica de validação e estrutura os dados principais.
- `repository/`: Centraliza a persistência dos dados, com abstrações para gerenciar a lista de pacientes. 
- `validator/`: Contém classes que implementam a lógica de negócios do sistema, interagindo com o repositório e facilitando operações complexas.
- `ui/`: Contém classes que fornecem um menu interativo para o usuário.

### **Passo 4: Executar o programa**

1. Localize o arquivo principal: `CadastroPaciente.java`.
2. Execute o programa a partir desse arquivo pelo IntelliJ IDEA ou pelo terminal usando o seguinte comando:
```bash
java CadastroPaciente
```

### **Passo 5: Testar funcionalidades**

- **Cadastrar Paciente:** Insira as informações solicitadas
- **Listar Pacientes:** Visualize a lista de pacientes cadastrados.
- **Exportar Pacientes:** Gera um arquivo `.txt` contendo os dados dos pacientes.
