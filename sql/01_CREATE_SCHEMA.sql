-- =====================================================
-- EduManager - Database Creation Script
-- =====================================================
-- Database: edumanager
-- =====================================================
-- Drop database if it exists
DROP DATABASE IF EXISTS edumanager;
-- Create database
CREATE DATABASE edumanager DEFAULT CHARACTER SET utf8mb4 DEFAULT COLLATE utf8mb4_unicode_ci;
USE edumanager;
-- =====================================================
-- Table: turmas (Turmas)
-- =====================================================
CREATE TABLE turmas (
    id_turma INT NOT NULL AUTO_INCREMENT,
    nome VARCHAR(50) NOT NULL,
    ano_letivo INT NOT NULL,
    PRIMARY KEY (id_turma),
    UNIQUE KEY uk_turma_nome_ano (nome, ano_letivo)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_unicode_ci;
-- =====================================================
-- Table: professors (Professores)
-- =====================================================
CREATE TABLE professors (
    id_professor INT NOT NULL AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    especialidade VARCHAR(100) NOT NULL,
    email VARCHAR(100),
    telefone VARCHAR(20),
    data_admissao DATE,
    PRIMARY KEY (id_professor),
    UNIQUE KEY uk_professor_email (email)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_unicode_ci;
-- =====================================================
-- Table: disciplinas (Disciplinas)
-- =====================================================
CREATE TABLE disciplinas (
    id_disciplina INT NOT NULL AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    id_professor INT NOT NULL,
    carga_horaria INT,
    PRIMARY KEY (id_disciplina),
    FOREIGN KEY (id_professor) REFERENCES professors(id_professor) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_unicode_ci;
-- =====================================================
-- Table: alunos (Alunos)
-- =====================================================
CREATE TABLE alunos (
    id_aluno INT NOT NULL AUTO_INCREMENT,
    nome VARCHAR(150) NOT NULL,
    email VARCHAR(100),
    data_nascimento DATE NOT NULL,
    id_turma INT NOT NULL,
    data_matricula DATE NOT NULL,
    cpf VARCHAR(11),
    telefone VARCHAR(20),
    PRIMARY KEY (id_aluno),
    UNIQUE KEY uk_aluno_email (email),
    UNIQUE KEY uk_aluno_cpf (cpf),
    FOREIGN KEY (id_turma) REFERENCES turmas(id_turma) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_unicode_ci;
-- =====================================================
-- Table: notas (Notas)
-- =====================================================
CREATE TABLE notas (
    id_nota INT NOT NULL AUTO_INCREMENT,
    id_aluno INT NOT NULL,
    id_disciplina INT NOT NULL,
    bimestre INT NOT NULL,
    valor_nota DECIMAL(5, 2) NOT NULL,
    data_registro DATE,
    PRIMARY KEY (id_nota),
    UNIQUE KEY uk_nota_aluno_disc_bim (id_aluno, id_disciplina, bimestre),
    FOREIGN KEY (id_aluno) REFERENCES alunos(id_aluno) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (id_disciplina) REFERENCES disciplinas(id_disciplina) ON DELETE CASCADE ON UPDATE CASCADE,
    CHECK (
        valor_nota >= 0
        AND valor_nota <= 10
    ),
    CHECK (
        bimestre >= 1
        AND bimestre <= 4
    )
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_unicode_ci;
-- =====================================================
-- Table: frequencias (Frequências)
-- =====================================================
CREATE TABLE frequencias (
    id_frequencia INT NOT NULL AUTO_INCREMENT,
    id_aluno INT NOT NULL,
    id_disciplina INT NOT NULL,
    data_aula DATE NOT NULL,
    presente BOOLEAN NOT NULL DEFAULT TRUE,
    PRIMARY KEY (id_frequencia),
    UNIQUE KEY uk_freq_aluno_disc_data (id_aluno, id_disciplina, data_aula),
    FOREIGN KEY (id_aluno) REFERENCES alunos(id_aluno) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (id_disciplina) REFERENCES disciplinas(id_disciplina) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_unicode_ci;
-- =====================================================
-- Indexes for better performance
-- =====================================================
CREATE INDEX idx_alunos_turma ON alunos(id_turma);
CREATE INDEX idx_disciplinas_professor ON disciplinas(id_professor);
CREATE INDEX idx_notas_aluno ON notas(id_aluno);
CREATE INDEX idx_notas_disciplina ON notas(id_disciplina);
CREATE INDEX idx_frequencias_aluno ON frequencias(id_aluno);
CREATE INDEX idx_frequencias_disciplina ON frequencias(id_disciplina);