# Spring Boot + Thymeleaf - Tutorial Completo

Este projeto é um exemplo prático e didático de como utilizar o **Thymeleaf** como engine de templates no Spring Boot. O projeto implementa um sistema simples de gerenciamento de tarefas (CRUD) para demonstrar as principais funcionalidades do Thymeleaf.

## 🎯 O que você vai aprender

- Como configurar o Thymeleaf no Spring Boot
- Como usar expressões Thymeleaf para exibir dados
- Como trabalhar com formulários e binding de dados
- Como implementar iteração e condicionais
- Como criar URLs dinâmicas
- Como formatar dados no template

## 🚀 Tecnologias Utilizadas

- **Java 21**
- **Spring Boot 3.5.5**
- **Thymeleaf** (Engine de templates)
- **Bootstrap 5.3.8** (Interface)
- **H2 Database** (Banco em memória)
- **Maven** (Gerenciamento de dependências)

## 📋 Funcionalidades do Projeto

- ✅ **Criar tarefas** - Formulário para cadastro de novas tarefas
- ✅ **Listar tarefas** - Visualização de todas as tarefas cadastradas
- ✅ **Editar tarefas** - Modificação de tarefas existentes
- ✅ **Formatação de datas** - Exibição de datas no formato brasileiro
- ✅ **Interface responsiva** - Design moderno com Bootstrap

## 🛠️ Como Executar o Projeto

### Pré-requisitos
- Java 21 ou superior
- Maven 3.6+

### Passos para execução

1. **Clone o repositório**
```bash
git clone <url-do-repositorio>
cd springboot-thymeleaf-helloworld/helloprj
```

2. **Execute o projeto**
```bash
mvn spring-boot:run
```

3. **Acesse a aplicação**
```
http://localhost:8080
```

## 📚 Conceitos do Thymeleaf Demonstrados

### 1. **Expressões de Variáveis**
```html
<!-- Exibe o valor de uma variável -->
<td th:text="${task.name}"></td>

<!-- Exibe o valor com formatação -->
<td th:text="${{task.date}}"></td>
```

### 2. **Binding de Objetos em Formulários**
```html
<!-- th:object vincula o formulário ao objeto Task -->
<form method="POST" action="/create" th:object="${task}">
    <!-- th:value preenche o campo com o valor do objeto -->
    <input type="text" name="name" th:value="${task.name}">
</form>
```

### 3. **Iteração com th:each**
```html
<!-- Itera sobre a lista de tarefas -->
<tr th:each="task : ${taskList}">
    <td th:text="${task.id}"></td>
    <td th:text="${task.name}"></td>
    <td th:text="${{task.date}}"></td>
</tr>
```

### 4. **URLs Dinâmicas**
```html
<!-- Cria URLs dinâmicas para edição -->
<a th:href="@{'/edit/'+${task.id}}">Editar</a>
```

### 5. **Formatação de Dados**
```java
// No modelo Task.java
@DateTimeFormat(pattern = "dd/MM/yyyy HH:mm:ss")
private Date date;
```

## 🏗️ Estrutura do Projeto

```
src/
├── main/
│   ├── java/br/dev/josenalde/helloprj/
│   │   ├── controller/
│   │   │   └── TaskController.java    # Controlador REST
│   │   ├── model/
│   │   │   └── Task.java              # Modelo de dados
│   │   └── HelloprjApplication.java   # Classe principal
│   └── resources/
│       ├── templates/                 # Templates Thymeleaf
│       │   ├── index.html            # Página inicial
│       │   ├── create.html           # Formulário de criação/edição
│       │   └── list.html             # Listagem de tarefas
│       └── static/css/
│           └── style.css              # Estilos customizados
```

## 🔍 Análise Detalhada dos Templates

### **create.html** - Formulário de Criação/Edição
```html
<!-- Binding do objeto Task ao formulário -->
<form method="POST" action="/create" th:object="${task}">
    <!-- Campo oculto para ID (edição) -->
    <input type="hidden" th:value="${task.id}" name="id">
    
    <!-- Campo de nome com binding -->
    <input type="text" name="name" th:value="${task.name}">
    
    <!-- Campo de data com formatação -->
    <input type="text" name="date" th:value="${{task.date}}">
</form>
```

**Conceitos demonstrados:**
- `th:object` - Vincula o formulário ao objeto
- `th:value` - Preenche campos com dados do objeto
- `${{}}` - Aplica formatação definida no modelo

### **list.html** - Listagem de Tarefas
```html
<!-- Iteração sobre a lista de tarefas -->
<tr th:each="task : ${taskList}">
    <!-- Exibição de dados -->
    <td th:text="${task.id}"></td>
    <td th:text="${task.name}"></td>
    <td th:text="${{task.date}}"></td>
    
    <!-- URL dinâmica para edição -->
    <td><a th:href="@{'/edit/'+${task.id}}">Editar</a></td>
</tr>
```

**Conceitos demonstrados:**
- `th:each` - Iteração sobre coleções
- `th:text` - Exibição de texto
- `th:href` - Criação de URLs dinâmicas
- `@{}` - Sintaxe para URLs no Thymeleaf

## 🎨 Interface e Estilização

O projeto utiliza **Bootstrap 5.3.8** para criar uma interface moderna e responsiva:

- **Formulários estilizados** com classes Bootstrap
- **Tabelas responsivas** para listagem de dados
- **Botões e componentes** com design consistente
- **Layout responsivo** que se adapta a diferentes telas

## 🔧 Configurações Importantes

### **pom.xml** - Dependências
```xml
<!-- Thymeleaf Starter -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-thymeleaf</artifactId>
</dependency>

<!-- Web Starter -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
</dependency>
```

### **TaskController.java** - Controlador
```java
@Controller
public class TaskController {
    
    // Lista em memória para simular banco de dados
    List<Task> taskList = new ArrayList<Task>();
    
    // Retorna view com dados
    @GetMapping("/list")
    public ModelAndView list() {
        ModelAndView mv = new ModelAndView("list");
        mv.addObject("taskList", taskList);
        return mv;
    }
}
```

## 🎯 Principais Vantagens do Thymeleaf

1. **Templates Naturais** - HTML válido que pode ser aberto no navegador
2. **Expressões Poderosas** - Sintaxe similar a OGNL/SpEL
3. **Integração Spring** - Funciona perfeitamente com Spring Boot
4. **Internacionalização** - Suporte nativo a i18n
5. **Segurança** - Proteção contra XSS por padrão

## 📖 Recursos Adicionais

- [Documentação Oficial do Thymeleaf](https://www.thymeleaf.org/)
- [Spring Boot + Thymeleaf Guide](https://spring.io/guides/gs/serving-web-content/)
- [Thymeleaf Tutorial](https://www.thymeleaf.org/doc/tutorials/3.0/usingthymeleaf.html)

## 🤝 Contribuindo

Este é um projeto educacional. Sinta-se à vontade para:
- Reportar bugs
- Sugerir melhorias
- Adicionar novos exemplos
- Criar issues para dúvidas

## 📄 Licença

Este projeto é de uso educacional e está disponível sob a licença MIT.

---

**Desenvolvido com ❤️ para fins educacionais**

---

<img src="/dog.jpg" alt="Meu Dog" width="300">
