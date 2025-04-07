# 🥷 CadastroDeNinjas

Sistema web de gerenciamento de Ninjas e Missões, inspirado no universo **Naruto**, desenvolvido com **Spring Boot + Thymeleaf**. A proposta é oferecer uma interface estilizada, interativa e funcional para registrar, listar, editar e visualizar informações de ninjas e suas respectivas missões.

> 📚 Projeto desenvolvido durante as aulas do **Curso Java10X** do **Fiasco**.

---

## 🔥 Funcionalidades

### Ninja 🥷
- Listar ninjas cadastrados
- Criar novo ninja (com nome, vila, ranking, especialidade, etc.)
- Editar informações de um ninja
- Visualizar detalhes completos do ninja
- Deletar ninja

### Missão 🎯
- Listar missões registradas
- Criar nova missão (com título, descrição, nível, status, etc.)
- Editar missão existente
- Visualizar detalhes completos da missão
- Deletar missão

---

## 🎨 Estilo Visual

- Tema visual escuro com **inspiração no clã Uchiha**
- Tipografia com estilo ninja
- Ícones personalizados para ações (editar, excluir, voltar)
- Paleta baseada em tons de cinza, vermelho e detalhes em chakra azul

---

## 🛠️ Tecnologias Utilizadas

- **Java 17**
- **Spring Boot 3**
- **Thymeleaf**
- **Spring Web MVC**
- **Spring Data JPA**
- **H2 Database (modo dev)**
- **Bootstrap (customizado)**
- **CSS puro com animações**

---

## 💻 Estrutura do Projeto

```bash
CadastroDeNinjas
├── src
│   └── main
│       ├── java
│       │   └── dev.vinicius.CadastroDeNinjas
│       │       ├── Ninjas
│       │       │   ├── Controller
│       │       │   └── Model
│       │       └── Missoes
│       │           ├── Controller
│       │           └── Model
│       └── resources
│           ├── static
│           │   └── css
│           │       └── estilo.css
│           └── templates
│               ├── criar-ninja.html
│               ├── editar-ninja.html
│               ├── listar-ninjas.html
│               ├── detalhes-ninja.html
│               ├── criar-missao.html
│               ├── editar-missao.html
│               ├── listar-missoes.html
│               └── detalhes-missao.html
```

---

## 📸 Prints do Sistema

> 💡 _Adicione aqui imagens dos principais recursos da aplicação:_

```markdown
![Listagem de Ninjas](prints/listar-ninjas.png)
![Criação de Missão](prints/criar-missao.png)
```

---

## 🚀 Como Executar Localmente

1. Clone o repositório:
   ```bash
   git clone https://github.com/viniciuslago/CadastroDeNinjas.git
   ```

2. Navegue até o projeto e abra no seu editor favorito.

3. Execute a aplicação:
   - Via terminal:
     ```bash
     ./mvnw spring-boot:run
     ```
   - Ou diretamente pela sua IDE (IntelliJ, VS Code...)

4. Acesse o sistema em:
   ```
   http://localhost:8080/ninjas/ui
   ```

---

## 🧪 Banco de Dados H2 (modo dev)

- URL: `http://localhost:8080/h2-console`
- JDBC URL: `jdbc:h2:mem:testdb`
- Usuário: `sa`
- Senha: _(deixe em branco)_

---

## 📂 Melhorias Futuras (TODO)

- [ ] Adicionar autenticação com Spring Security
- [ ] Relacionar ninja com missão
- [ ] Exportar dados em PDF
- [ ] Adicionar responsividade mobile
- [ ] Filtros, paginação e busca por nome/vila

---

## 🤝 Contribuições

Sinta-se à vontade para abrir issues, sugerir melhorias ou enviar PRs!  
Este projeto é um aprendizado em constante evolução.

---

Feito com 💙 e chakra por [Vinicius Lago](https://github.com/viniciuslago)  
Inspirado nas aulas do **Curso Java10X do Fiasco**
