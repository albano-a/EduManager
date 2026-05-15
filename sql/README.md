# EduManager - Database Setup Guide

## 📋 Conteúdo

Este diretório contém os scripts SQL para criar e popular o banco de dados do EduManager.

### Arquivos:

1. **01_CREATE_SCHEMA.sql** - Script para criar a estrutura do banco de dados
   - Cria o banco de dados `edumanager`
   - Define as tabelas: turmas, professors, disciplinas, alunos, notas, frequencias
   - Define chaves primárias, estrangeiras e índices

2. **02_INSERT_DATA.sql** - Script para popular o banco com dados iniciais
   - 4 turmas (1A, 1B, 2A, 2B)
   - 10 professores com especialidades variadas
   - 20 disciplinas
   - 40 alunos distribuídos entre as turmas
   - Notas de todos os alunos em disciplinas (4 bimestres)
   - Registros de frequência (presença/ausência)

## 📊 Estrutura do Banco de Dados

### Tabelas Principais:

#### `turmas`
- id_turma (PK)
- nome
- ano_letivo

#### `professors`
- id_professor (PK)
- nome
- especialidade
- email (UNIQUE)
- telefone
- data_admissao

#### `disciplinas`
- id_disciplina (PK)
- nome
- id_professor (FK)
- carga_horaria

#### `alunos`
- id_aluno (PK)
- nome
- email (UNIQUE)
- data_nascimento
- id_turma (FK)
- data_matricula
- cpf (UNIQUE)
- telefone

#### `notas`
- id_nota (PK)
- id_aluno (FK)
- id_disciplina (FK)
- bimestre (1-4)
- valor_nota (0-10)
- data_registro

#### `frequencias`
- id_frequencia (PK)
- id_aluno (FK)
- id_disciplina (FK)
- data_aula
- presente (boolean)

## 🔗 Configuração da Conexão JDBC no Java

### Credenciais do Banco:
```
Host: localhost
Port: 3306
Database: edumanager
Username: root
Password: 17092013
```

### URL JDBC:
```
jdbc:mysql://localhost:3306/edumanager?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true
```

A classe `DatabaseConnection.java` gerencia automaticamente essa conexão. Você pode usá-la assim:

```java
// Testar conexão
DatabaseConnection.testConnection();

// Obter conexão
Connection conn = DatabaseConnection.getConnection();
// ... usar a conexão
conn.close();
```

## 📝 Dados Iniciais

- **4 Turmas**: 1A, 1B, 2A, 2B (ano letivo 2024)
- **10 Professores**: João Silva, Maria Santos, Carlos Oliveira, etc.
- **20 Disciplinas**: Cobrindo Matemática, Português, Ciências, Educação Física, História, Geografia, Inglês, Arte, Informática e Filosofia
- **40 Alunos**: Distribuídos igualmente entre as turmas
- **Notas**: Cada aluno tem até 10 disciplinas com 4 notas (bimestres)
- **Frequências**: Registros de presença para rastreamento de assiduidade

## 📦 Usando DAOs

O projeto inclui a classe `AlunoDAO` para realizar operações CRUD com alunos:

```java
// Listar todos os alunos
List<Aluno> alunos = AlunoDAO.listarTodos();

// Buscar aluno por ID
Aluno aluno = AlunoDAO.buscarPorId(1);

// Listar alunos de uma turma
List<Aluno> alunosTurma = AlunoDAO.listarPorTurma(1);

// Inserir novo aluno
int novoId = AlunoDAO.inserir(novoAluno);

// Atualizar aluno
AlunoDAO.atualizar(alunoAtualizado);

// Deletar aluno
AlunoDAO.deletar(id);
```

## ✅ Verificação

Após executar os scripts, verifique se os dados foram carregados corretamente no MySQL:

```sql
USE edumanager;

-- Ver resumo dos dados
SELECT 'Total Turmas' AS Info, COUNT(*) FROM turmas
UNION ALL SELECT 'Total Professores', COUNT(*) FROM professors
UNION ALL SELECT 'Total Disciplinas', COUNT(*) FROM disciplinas
UNION ALL SELECT 'Total Alunos', COUNT(*) FROM alunos
UNION ALL SELECT 'Total Notas', COUNT(*) FROM notas
UNION ALL SELECT 'Total Frequências', COUNT(*) FROM frequencias;

-- Ver alunos com média acima de 8.0
SELECT a.nome, AVG(n.valor_nota) as media
FROM alunos a
JOIN notas n ON a.id_aluno = n.id_aluno
GROUP BY a.id_aluno, a.nome
HAVING AVG(n.valor_nota) >= 8.0
ORDER BY media DESC;

-- Ver boletim completo de um aluno
SELECT a.nome, t.nome as turma, d.nome as disciplina, 
       n.bimestre, n.valor_nota
FROM alunos a
JOIN turmas t ON a.id_turma = t.id_turma
JOIN notas n ON a.id_aluno = n.id_aluno
JOIN disciplinas d ON n.id_disciplina = d.id_disciplina
WHERE a.id_aluno = 1
ORDER BY d.nome, n.bimestre;
```

## 📋 Classes Java para Acesso ao Banco

### DatabaseConnection.java
- Gerencia conexões JDBC
- Fornece métodos para obter conexões
- Testa a conectividade do banco

### AlunoDAO.java
- Data Access Object para alunos
- Implementa operações CRUD
- Mapeia resultados SQL para objetos Java

## 🚀 Próximos Passos

1. ✅ Banco de dados criado e populado
2. ✅ Conexão JDBC configurada
3. ✅ DAO para Alunos implementado
4. ⏳ Criar DAOs para outras entidades (Professor, Disciplina, Nota, Frequencia)
5. ⏳ Integrar DAOs com as interfaces UI existentes
6. ⏳ Implementar funcionalidades de relatórios

---

**Credenciais**: root | 17092013  
**Última atualização**: 2026-05-09  
**Versão**: 1.0
