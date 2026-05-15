
Projeto: EduManager
===================

Status: Em desenvolvimento

**Tecnologias**:
- **Java**: linguagem principal do projeto.
- **Maven**: gerenciamento de dependências e build.
- **JDBC**: acesso a banco de dados relacional (scripts em SQL disponíveis em `sql/`).
- **Swing (GUI)**: interfaces gráficas geradas pelo NetBeans (arquivos em `src/main/java/core/ui` / `src/main/java/ui`).
- **SQL**: scripts de criação e inserção localizados na pasta `sql/`.

**Time de desenvolvedores**:
- Equipe: Alunos da turma SENAC PI_2 (EduManager)

**Objetivo do software**:
EduManager é um sistema de gestão acadêmica simples para cadastrar e gerenciar informações de alunos, professores, disciplinas, turmas e notas. Deve servir como ferramenta didática para práticas de persistência, interfaces gráficas e operações CRUD.

**Funcionalidades (requisitos)**:
- **Gerenciar Alunos**: cadastrar, editar, excluir e listar alunos.
- **Gerenciar Professores**: cadastrar, editar, excluir e listar professores.
- **Gerenciar Disciplinas**: cadastrar, editar, excluir e listar disciplinas.
- **Gerenciar Turmas**: criar turmas, alocar alunos e vincular disciplinas e professores.
- **Gerenciar Notas**: lançar, editar e consultar notas por aluno/disciplina.
- **Persistência**: armazenar dados em banco relacional via JDBC; scripts de criação/importação ficam em `sql/`.
- **Interface Gráfica**: telas para cadastro e consulta usando Swing (forms gerados disponíveis em `src/main/java/ui` e em `target/` para visualização).
- **Relatórios/Consulta**: visualizar notas e composição de turmas (filtros básicos por aluno, disciplina e turma).

Instruções rápidas:
- Configure `database.properties` na pasta `sql/` com os parâmetros de conexão.
- Use `mvn compile` e `mvn exec:java` (ou execute a classe `core.EduManager`) para iniciar a aplicação.

Licença e atribuições:
- Projeto desenvolvido como parte das atividades do curso SENAC PI_2.
