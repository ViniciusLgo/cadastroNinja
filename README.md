# 🥷 Sistema de Cadastro de Ninjas

Bem-vindo ao **Sistema de Cadastro de Ninjas**!  
Este projeto é uma aplicação com arquitetura em camadas desenvolvida com **Spring Boot**, projetada para cadastrar ninjas e suas respectivas missões.

> 📚 Projeto desenvolvido com base no **Curso Java10X** do **Fiasco** e com apoio de aulas complementares do **Horácio Muller**.  
> 🔗 Repositório original: [github.com/horaciomuller/CadastroDeNinjas](https://github.com/horaciomuller/CadastroDeNinjas)

---

## 🔍 Visão Geral do Projeto

Este sistema foi desenvolvido para gerenciar **Ninjas** e suas **Missões**.  
Cada **Ninja pode ser atribuído a uma única Missão**, enquanto uma **Missão pode ser associada a vários Ninjas**.

### Funcionalidades:
- Cadastro de ninjas com nome, idade, e-mail e rank
- Cadastro de missões com título e descrição
- Atribuição de uma missão para um ninja
- Listagem, visualização, edição e exclusão de ninjas e missões
- Relacionamento 1:N (missão → ninjas)

---

## 🛠️ Tecnologias Utilizadas

- **Spring Boot**: Framework principal da aplicação
- **Spring Data JPA**: Integração com banco de dados via ORM
- **Banco de Dados H2**: Banco de dados em memória (ambiente dev)
- **Flyway**: Controle de versões do banco de dados (migrações)
- **Maven**: Build e gerenciamento de dependências
- **Docker**: (Opcional) Para ambiente externo com banco persistente
- **SQL**: Manipulação e consultas de dados
- **Git & GitHub**: Versionamento de código

---

## 🧩 Design do Banco de Dados

**Entidades e Relacionamentos**:

- **Ninja**:
  - `id` (UUID)
  - `nome`
  - `idade`
  - `email`
  - `rank`
  - `missao_id` (chave estrangeira)

- **Missão**:
  - `id` (UUID)
  - `titulo`
  - `descricao`

🔗 Relação: **Uma missão pode ter vários ninjas** (1:N)

---

## 🚀 Como Executar o Projeto

1. Clone o repositório:
   ```bash
   git clone https://github.com/viniciuslago/CadastroDeNinjas.git
   ```

2. Navegue até o projeto:
   ```bash
   cd CadastroDeNinjas
   ```

3. Construa o projeto:
   ```bash
   mvn clean install
   ```

4. Execute a aplicação:
   ```bash
   mvn spring-boot:run
   ```

5. Acesse no navegador:
   ```
   http://localhost:8080
   ```

---

## 🙏 Agradecimentos

Este projeto foi construído com base nas aulas do:

- **Curso Java10X** do [Fiasco](https://www.youtube.com/@fiascodev)
- E nas aulas complementares de banco de dados com o professor **Horácio Muller**

Muito obrigado aos criadores de conteúdo que tornam o aprendizado mais acessível e prático! 💙

---

Feito com 💻, 🧠 e 🥷 por [Vinicius Lago](https://github.com/viniciuslago)
