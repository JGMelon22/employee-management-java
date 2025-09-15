# 🏢 Java Employee Management Console

Sistema de gerenciamento de funcionários desenvolvido em **Java 21 LTS** para execução em console. O projeto implementa operações completas de CRUD, relatórios formatados e análises salariais usando as APIs modernas do Java.

## 📋 Funcionalidades

- **Cadastro de funcionários** com dados pessoais e profissionais
-️️ **Remoção de funcionários** por nome
- **Relatórios formatados** com padrão brasileiro (datas e valores)
- **Cálculo de aumentos salariais** com precisão decimal
- **Agrupamento por função** usando Collections
- **Filtro de aniversariantes** por mês específico
- **Análise de idades** - funcionário mais velho
- **Ordenação alfabética** dos funcionários
- **Cálculo de totais salariais** da equipe
- **Conversão para salários mínimos** (baseado em R$ 1.212,00)

## 🚀 Como Executar

### Pré-requisitos
- Java 21 LTS ou superior instalado
- Terminal/Prompt de comando

### Passos para execução

1. **Clone o repositório**
   ```bash
   git clone https://github.com/seu-usuario/java-employee-management-console.git
   cd java-employee-management-console
   ```

2. **Compile os arquivos Java**
   ```bash
   javac *.java
   ```

3. **Execute a aplicação**
   ```bash
   java Principal
   ```

## 📁 Estrutura do Projeto

```
📦 java-employee-management-console
├── 📄 Pessoa.java          # Classe base com nome e data de nascimento
├── 📄 Funcionario.java     # Classe filha com salário e função
├── 📄 Principal.java       # Classe principal com todas as operações
└── 📄 README.md           # Documentação do projeto
```

## 🛠️ Tecnologias Utilizadas

- **Java 21 LTS** - Linguagem principal
- **Stream API** - Para operações funcionais em coleções
- **BigDecimal** - Precisão em cálculos monetários
- **LocalDate** - Manipulação moderna de datas
- **Collections Framework** - Estruturas de dados (List, Map, Set)
- **DateTimeFormatter** - Formatação de datas no padrão brasileiro
- **DecimalFormat** - Formatação de valores monetários

## 📝 Exemplo de Saída

```
=== FUNCIONÁRIOS INSERIDOS ===
Nome: Maria, Data Nascimento: 18/10/2000, Salário: R$ 2.009,44, Função: Operador
Nome: João, Data Nascimento: 12/05/1990, Salário: R$ 2.284,38, Função: Operador
...

=== APÓS REMOÇÃO DO JOÃO ===
Nome: Maria, Data Nascimento: 18/10/2000, Salário: R$ 2.009,44, Função: Operador
...

=== FUNCIONÁRIOS AGRUPADOS POR FUNÇÃO ===

Função: Operador
  - Maria, 18/10/2000, R$ 2.210,38
  - Heitor, 19/11/1999, R$ 1.741,00

Função: Gerente
  - Laura, 08/07/1994, R$ 3.319,20
  - Helena, 02/09/1996, R$ 3.079,92
```

## 🏗️ Arquitetura

### Hierarquia de Classes
- **Pessoa** (classe pai)
    - `String nome`
    - `LocalDate dataNascimento`

- **Funcionario** (herda de Pessoa)
    - `BigDecimal salario`
    - `String funcao`

### Operações Principais
1. **Inserção** - Cadastro inicial de funcionários
2. **Remoção** - Exclusão por critério específico
3. **Formatação** - Exibição com padrões brasileiros
4. **Cálculos** - Aumentos e análises salariais
5. **Agrupamentos** - Organização por função
6. **Filtros** - Seleção por critérios diversos
7. **Ordenação** - Classificação alfabética
8. **Análises** - Estatísticas da equipe

## 💡 Conceitos Demonstrados

- **Programação Orientada a Objetos** - Herança, encapsulamento
- **Programação Funcional** - Lambdas, Stream API, method references
- **Tratamento de Datas** - API moderna java.time
- **Precisão Monetária** - BigDecimal para evitar erros de ponto flutuante
- **Collections Framework** - List, Map, Set e suas operações
- **Formatação Internacional** - Padrões brasileiros para datas e números

## 📊 Dados de Exemplo

O sistema vem pré-carregado com 10 funcionários de exemplo distribuídos em diferentes funções:
- **Operadores** (3)
- **Gerentes** (2)
- **Coordenador** (1)
- **Diretor** (1)
- **Recepcionista** (1)
- **Contador** (1)
- **Eletricista** (1)

---

**Desenvolvido com ☕ e Java 21 LTS**