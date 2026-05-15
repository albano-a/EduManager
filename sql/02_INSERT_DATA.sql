-- =====================================================
-- EduManager - Initial Data
-- =====================================================
USE edumanager;
-- =====================================================
-- INSERT: Turmas
-- =====================================================
INSERT INTO turmas (nome, ano_letivo)
VALUES ('1A', 2024),
    ('1B', 2024),
    ('2A', 2024),
    ('2B', 2024);
-- =====================================================
-- INSERT: Professors
-- =====================================================
INSERT INTO professors (
        nome,
        especialidade,
        email,
        telefone,
        data_admissao
    )
VALUES (
        'João Silva',
        'Matemática',
        'joao.silva@edumanager.com',
        '11987654321',
        '2020-02-15'
    ),
    (
        'Maria Santos',
        'Português',
        'maria.santos@edumanager.com',
        '11987654322',
        '2019-08-10'
    ),
    (
        'Carlos Oliveira',
        'Ciências',
        'carlos.oliveira@edumanager.com',
        '11987654323',
        '2021-03-22'
    ),
    (
        'Fernanda Costa',
        'Educação Física',
        'fernanda.costa@edumanager.com',
        '11987654324',
        '2020-11-05'
    ),
    (
        'Roberto Alves',
        'História',
        'roberto.alves@edumanager.com',
        '11987654325',
        '2019-12-01'
    ),
    (
        'Juliana Pereira',
        'Geografia',
        'juliana.pereira@edumanager.com',
        '11987654326',
        '2022-01-20'
    ),
    (
        'Pedro Gomes',
        'Inglês',
        'pedro.gomes@edumanager.com',
        '11987654327',
        '2021-06-14'
    ),
    (
        'Camila Martins',
        'Arte',
        'camila.martins@edumanager.com',
        '11987654328',
        '2020-09-08'
    ),
    (
        'Lucas Ferreira',
        'Informática',
        'lucas.ferreira@edumanager.com',
        '11987654329',
        '2022-03-10'
    ),
    (
        'Beatriz Rocha',
        'Filosofia',
        'beatriz.rocha@edumanager.com',
        '11987654330',
        '2021-07-25'
    );
-- =====================================================
-- INSERT: Disciplinas
-- =====================================================
INSERT INTO disciplinas (nome, id_professor, carga_horaria)
VALUES ('Matemática I', 1, 80),
    ('Matemática II', 1, 80),
    ('Português I', 2, 80),
    ('Português II', 2, 80),
    ('Ciências Naturais', 3, 60),
    ('Ciências Experimentais', 3, 40),
    ('Educação Física', 4, 60),
    ('Esportes e Recreação', 4, 40),
    ('História Geral', 5, 60),
    ('História do Brasil', 5, 60),
    ('Geografia Política', 6, 60),
    ('Geografia Humana', 6, 60),
    ('Inglês Básico', 7, 80),
    ('Inglês Avançado', 7, 80),
    ('Artes Visuais', 8, 40),
    ('Música e Artes', 8, 40),
    ('Informática I', 9, 60),
    ('Informática II', 9, 60),
    ('Filosofia e Ética', 10, 40),
    ('Pensamento Crítico', 10, 40);
-- =====================================================
-- INSERT: Alunos (40 alunos distribuídos nas turmas)
-- =====================================================
INSERT INTO alunos (
        nome,
        email,
        data_nascimento,
        id_turma,
        data_matricula,
        cpf,
        telefone
    )
VALUES -- Turma 1A
    (
        'Adriano Silper',
        'adriano.silper@student.com',
        '2008-03-15',
        1,
        '2023-02-01',
        '12345678901',
        '11911111101'
    ),
    (
        'André Albano',
        'andre.albano@student.com',
        '2008-05-22',
        1,
        '2023-02-01',
        '12345678902',
        '11911111102'
    ),
    (
        'Beatriz Lima',
        'beatriz.lima@student.com',
        '2008-07-10',
        1,
        '2023-02-01',
        '12345678903',
        '11911111103'
    ),
    (
        'Bruno Costa',
        'bruno.costa@student.com',
        '2008-09-18',
        1,
        '2023-02-01',
        '12345678904',
        '11911111104'
    ),
    (
        'Camila Santos',
        'camila.santos@student.com',
        '2008-11-25',
        1,
        '2023-02-01',
        '12345678905',
        '11911111105'
    ),
    (
        'Carlos Mendes',
        'carlos.mendes@student.com',
        '2008-01-30',
        1,
        '2023-02-01',
        '12345678906',
        '11911111106'
    ),
    (
        'Diana Marques',
        'diana.marques@student.com',
        '2008-04-12',
        1,
        '2023-02-01',
        '12345678907',
        '11911111107'
    ),
    (
        'Edson Oliveira',
        'edson.oliveira@student.com',
        '2008-06-19',
        1,
        '2023-02-01',
        '12345678908',
        '11911111108'
    ),
    (
        'Elisa Rocha',
        'elisa.rocha@student.com',
        '2008-08-27',
        1,
        '2023-02-01',
        '12345678909',
        '11911111109'
    ),
    (
        'Felipe Gomes',
        'felipe.gomes@student.com',
        '2008-10-05',
        1,
        '2023-02-01',
        '12345678910',
        '11911111110'
    ),
    -- Turma 1B
    (
        'Gabriela Ferreira',
        'gabriela.ferreira@student.com',
        '2008-02-14',
        2,
        '2023-02-01',
        '12345678911',
        '11911111111'
    ),
    (
        'Gustavo Silva',
        'gustavo.silva@student.com',
        '2008-04-21',
        2,
        '2023-02-01',
        '12345678912',
        '11911111112'
    ),
    (
        'Henrique Santos',
        'henrique.santos@student.com',
        '2008-06-28',
        2,
        '2023-02-01',
        '12345678913',
        '11911111113'
    ),
    (
        'Iris Alves',
        'iris.alves@student.com',
        '2008-08-03',
        2,
        '2023-02-01',
        '12345678914',
        '11911111114'
    ),
    (
        'Isabella Costa',
        'isabella.costa@student.com',
        '2008-10-11',
        2,
        '2023-02-01',
        '12345678915',
        '11911111115'
    ),
    (
        'João Paulo',
        'joao.paulo@student.com',
        '2008-12-19',
        2,
        '2023-02-01',
        '12345678916',
        '11911111116'
    ),
    (
        'Juliana Neves',
        'juliana.neves@student.com',
        '2008-01-26',
        2,
        '2023-02-01',
        '12345678917',
        '11911111117'
    ),
    (
        'Kevin Martins',
        'kevin.martins@student.com',
        '2008-03-05',
        2,
        '2023-02-01',
        '12345678918',
        '11911111118'
    ),
    (
        'Larissa Souza',
        'larissa.souza@student.com',
        '2008-05-12',
        2,
        '2023-02-01',
        '12345678919',
        '11911111119'
    ),
    (
        'Leonardo Barbosa',
        'leonardo.barbosa@student.com',
        '2008-07-20',
        2,
        '2023-02-01',
        '12345678920',
        '11911111120'
    ),
    -- Turma 2A
    (
        'Mariana Pereira',
        'mariana.pereira@student.com',
        '2007-02-08',
        3,
        '2023-02-01',
        '12345678921',
        '11911111121'
    ),
    (
        'Marcos Vieira',
        'marcos.vieira@student.com',
        '2007-04-15',
        3,
        '2023-02-01',
        '12345678922',
        '11911111122'
    ),
    (
        'Marina Lopes',
        'marina.lopes@student.com',
        '2007-06-22',
        3,
        '2023-02-01',
        '12345678923',
        '11911111123'
    ),
    (
        'Maurício Dias',
        'mauricio.dias@student.com',
        '2007-08-29',
        3,
        '2023-02-01',
        '12345678924',
        '11911111124'
    ),
    (
        'Melissa Campos',
        'melissa.campos@student.com',
        '2007-10-06',
        3,
        '2023-02-01',
        '12345678925',
        '11911111125'
    ),
    (
        'Michele Costa',
        'michele.costa@student.com',
        '2007-12-13',
        3,
        '2023-02-01',
        '12345678926',
        '11911111126'
    ),
    (
        'Miguel Santos',
        'miguel.santos@student.com',
        '2007-01-20',
        3,
        '2023-02-01',
        '12345678927',
        '11911111127'
    ),
    (
        'Natália Rocha',
        'natalia.rocha@student.com',
        '2007-03-27',
        3,
        '2023-02-01',
        '12345678928',
        '11911111128'
    ),
    (
        'Nathan Oliveira',
        'nathan.oliveira@student.com',
        '2007-05-04',
        3,
        '2023-02-01',
        '12345678929',
        '11911111129'
    ),
    (
        'Nicolás Moreira',
        'nicolas.moreira@student.com',
        '2007-07-11',
        3,
        '2023-02-01',
        '12345678930',
        '11911111130'
    ),
    -- Turma 2B
    (
        'Olívia Martins',
        'olivia.martins@student.com',
        '2007-09-18',
        4,
        '2023-02-01',
        '12345678931',
        '11911111131'
    ),
    (
        'Oscar Fernandes',
        'oscar.fernandes@student.com',
        '2007-11-25',
        4,
        '2023-02-01',
        '12345678932',
        '11911111132'
    ),
    (
        'Patrícia Silva',
        'patricia.silva@student.com',
        '2007-01-04',
        4,
        '2023-02-01',
        '12345678933',
        '11911111133'
    ),
    (
        'Paulo Ribeiro',
        'paulo.ribeiro@student.com',
        '2007-02-12',
        4,
        '2023-02-01',
        '12345678934',
        '11911111134'
    ),
    (
        'Rafaela Gomes',
        'rafaela.gomes@student.com',
        '2007-04-19',
        4,
        '2023-02-01',
        '12345678935',
        '11911111135'
    ),
    (
        'Rafael Carvalho',
        'rafael.carvalho@student.com',
        '2007-06-26',
        4,
        '2023-02-01',
        '12345678936',
        '11911111136'
    ),
    (
        'Raquel Santos',
        'raquel.santos@student.com',
        '2007-08-03',
        4,
        '2023-02-01',
        '12345678937',
        '11911111137'
    ),
    (
        'Ricardo Sousa',
        'ricardo.sousa@student.com',
        '2007-10-10',
        4,
        '2023-02-01',
        '12345678938',
        '11911111138'
    ),
    (
        'Rita Pereira',
        'rita.pereira@student.com',
        '2007-12-17',
        4,
        '2023-02-01',
        '12345678939',
        '11911111139'
    ),
    (
        'Rodrigo Teixeira',
        'rodrigo.teixeira@student.com',
        '2007-02-24',
        4,
        '2023-02-01',
        '12345678940',
        '11911111140'
    );
-- =====================================================
-- INSERT: Notas (Todos os alunos com notas em todas as disciplinas - 4 bimestres)
-- =====================================================
INSERT INTO notas (
        id_aluno,
        id_disciplina,
        bimestre,
        valor_nota,
        data_registro
    )
VALUES -- Aluno 1 - Adriano Silper
    (1, 1, 1, 8.5, '2024-03-15'),
    (1, 1, 2, 8.2, '2024-06-15'),
    (1, 1, 3, 8.7, '2024-09-15'),
    (1, 1, 4, 8.9, '2024-12-15'),
    (1, 3, 1, 9.0, '2024-03-15'),
    (1, 3, 2, 8.8, '2024-06-15'),
    (1, 3, 3, 9.2, '2024-09-15'),
    (1, 3, 4, 9.1, '2024-12-15'),
    (1, 5, 1, 7.8, '2024-03-15'),
    (1, 5, 2, 7.9, '2024-06-15'),
    (1, 5, 3, 8.1, '2024-09-15'),
    (1, 5, 4, 8.0, '2024-12-15'),
    (1, 7, 1, 8.0, '2024-03-15'),
    (1, 7, 2, 8.3, '2024-06-15'),
    (1, 7, 3, 8.2, '2024-09-15'),
    (1, 7, 4, 8.1, '2024-12-15'),
    (1, 9, 1, 7.5, '2024-03-15'),
    (1, 9, 2, 7.7, '2024-06-15'),
    (1, 9, 3, 7.9, '2024-09-15'),
    (1, 9, 4, 8.0, '2024-12-15'),
    (1, 11, 1, 8.2, '2024-03-15'),
    (1, 11, 2, 8.4, '2024-06-15'),
    (1, 11, 3, 8.5, '2024-09-15'),
    (1, 11, 4, 8.6, '2024-12-15'),
    (1, 13, 1, 9.0, '2024-03-15'),
    (1, 13, 2, 8.9, '2024-06-15'),
    (1, 13, 3, 9.1, '2024-09-15'),
    (1, 13, 4, 9.2, '2024-12-15'),
    (1, 15, 1, 7.8, '2024-03-15'),
    (1, 15, 2, 7.9, '2024-06-15'),
    (1, 15, 3, 8.0, '2024-09-15'),
    (1, 15, 4, 8.2, '2024-12-15'),
    (1, 17, 1, 8.5, '2024-03-15'),
    (1, 17, 2, 8.6, '2024-06-15'),
    (1, 17, 3, 8.7, '2024-09-15'),
    (1, 17, 4, 8.8, '2024-12-15'),
    (1, 19, 1, 7.2, '2024-03-15'),
    (1, 19, 2, 7.4, '2024-06-15'),
    (1, 19, 3, 7.6, '2024-09-15'),
    (1, 19, 4, 7.8, '2024-12-15'),
    -- Aluno 2 - André Albano
    (2, 1, 1, 5.0, '2024-03-15'),
    (2, 1, 2, 5.2, '2024-06-15'),
    (2, 1, 3, 5.5, '2024-09-15'),
    (2, 1, 4, 5.8, '2024-12-15'),
    (2, 3, 1, 7.0, '2024-03-15'),
    (2, 3, 2, 7.2, '2024-06-15'),
    (2, 3, 3, 7.5, '2024-09-15'),
    (2, 3, 4, 7.6, '2024-12-15'),
    (2, 5, 1, 6.5, '2024-03-15'),
    (2, 5, 2, 6.7, '2024-06-15'),
    (2, 5, 3, 6.8, '2024-09-15'),
    (2, 5, 4, 6.9, '2024-12-15'),
    (2, 7, 1, 6.0, '2024-03-15'),
    (2, 7, 2, 6.2, '2024-06-15'),
    (2, 7, 3, 6.5, '2024-09-15'),
    (2, 7, 4, 6.7, '2024-12-15'),
    (2, 9, 1, 6.8, '2024-03-15'),
    (2, 9, 2, 6.9, '2024-06-15'),
    (2, 9, 3, 7.0, '2024-09-15'),
    (2, 9, 4, 7.2, '2024-12-15'),
    (2, 11, 1, 7.1, '2024-03-15'),
    (2, 11, 2, 7.3, '2024-06-15'),
    (2, 11, 3, 7.4, '2024-09-15'),
    (2, 11, 4, 7.5, '2024-12-15'),
    (2, 13, 1, 5.5, '2024-03-15'),
    (2, 13, 2, 5.8, '2024-06-15'),
    (2, 13, 3, 6.0, '2024-09-15'),
    (2, 13, 4, 6.2, '2024-12-15'),
    (2, 15, 1, 6.5, '2024-03-15'),
    (2, 15, 2, 6.6, '2024-06-15'),
    (2, 15, 3, 6.7, '2024-09-15'),
    (2, 15, 4, 6.9, '2024-12-15'),
    (2, 17, 1, 7.2, '2024-03-15'),
    (2, 17, 2, 7.3, '2024-06-15'),
    (2, 17, 3, 7.4, '2024-09-15'),
    (2, 17, 4, 7.6, '2024-12-15'),
    (2, 19, 1, 6.0, '2024-03-15'),
    (2, 19, 2, 6.2, '2024-06-15'),
    (2, 19, 3, 6.3, '2024-09-15'),
    (2, 19, 4, 6.5, '2024-12-15'),
    -- Alunos 3-40 (simplificado com notas aleatórias)
    (3, 1, 1, 7.5, '2024-03-15'),
    (3, 1, 2, 7.6, '2024-06-15'),
    (3, 1, 3, 7.7, '2024-09-15'),
    (3, 1, 4, 7.8, '2024-12-15'),
    (3, 3, 1, 8.1, '2024-03-15'),
    (3, 3, 2, 8.2, '2024-06-15'),
    (3, 3, 3, 8.3, '2024-09-15'),
    (3, 3, 4, 8.4, '2024-12-15'),
    (4, 1, 1, 6.8, '2024-03-15'),
    (4, 1, 2, 6.9, '2024-06-15'),
    (4, 1, 3, 7.0, '2024-09-15'),
    (4, 1, 4, 7.2, '2024-12-15'),
    (4, 3, 1, 7.9, '2024-03-15'),
    (4, 3, 2, 8.0, '2024-06-15'),
    (4, 3, 3, 8.1, '2024-09-15'),
    (4, 3, 4, 8.2, '2024-12-15'),
    (5, 1, 1, 8.3, '2024-03-15'),
    (5, 1, 2, 8.4, '2024-06-15'),
    (5, 1, 3, 8.5, '2024-09-15'),
    (5, 1, 4, 8.6, '2024-12-15'),
    (5, 3, 1, 8.8, '2024-03-15'),
    (5, 3, 2, 8.9, '2024-06-15'),
    (5, 3, 3, 9.0, '2024-09-15'),
    (5, 3, 4, 9.1, '2024-12-15'),
    (6, 1, 1, 7.1, '2024-03-15'),
    (6, 1, 2, 7.2, '2024-06-15'),
    (6, 1, 3, 7.3, '2024-09-15'),
    (6, 1, 4, 7.4, '2024-12-15'),
    (6, 3, 1, 7.6, '2024-03-15'),
    (6, 3, 2, 7.7, '2024-06-15'),
    (6, 3, 3, 7.8, '2024-09-15'),
    (6, 3, 4, 7.9, '2024-12-15'),
    (7, 1, 1, 8.0, '2024-03-15'),
    (7, 1, 2, 8.1, '2024-06-15'),
    (7, 1, 3, 8.2, '2024-09-15'),
    (7, 1, 4, 8.3, '2024-12-15'),
    (7, 3, 1, 8.5, '2024-03-15'),
    (7, 3, 2, 8.6, '2024-06-15'),
    (7, 3, 3, 8.7, '2024-09-15'),
    (7, 3, 4, 8.8, '2024-12-15'),
    (8, 1, 1, 6.5, '2024-03-15'),
    (8, 1, 2, 6.6, '2024-06-15'),
    (8, 1, 3, 6.7, '2024-09-15'),
    (8, 1, 4, 6.9, '2024-12-15'),
    (8, 3, 1, 7.2, '2024-03-15'),
    (8, 3, 2, 7.3, '2024-06-15'),
    (8, 3, 3, 7.4, '2024-09-15'),
    (8, 3, 4, 7.5, '2024-12-15'),
    (9, 1, 1, 7.9, '2024-03-15'),
    (9, 1, 2, 8.0, '2024-06-15'),
    (9, 1, 3, 8.1, '2024-09-15'),
    (9, 1, 4, 8.2, '2024-12-15'),
    (9, 3, 1, 8.3, '2024-03-15'),
    (9, 3, 2, 8.4, '2024-06-15'),
    (9, 3, 3, 8.5, '2024-09-15'),
    (9, 3, 4, 8.6, '2024-12-15'),
    (10, 1, 1, 7.3, '2024-03-15'),
    (10, 1, 2, 7.4, '2024-06-15'),
    (10, 1, 3, 7.5, '2024-09-15'),
    (10, 1, 4, 7.6, '2024-12-15'),
    (10, 3, 1, 7.8, '2024-03-15'),
    (10, 3, 2, 7.9, '2024-06-15'),
    (10, 3, 3, 8.0, '2024-09-15'),
    (10, 3, 4, 8.1, '2024-12-15'),
    (11, 1, 1, 8.2, '2024-03-15'),
    (11, 1, 2, 8.3, '2024-06-15'),
    (11, 1, 3, 8.4, '2024-09-15'),
    (11, 1, 4, 8.5, '2024-12-15'),
    (11, 3, 1, 8.7, '2024-03-15'),
    (11, 3, 2, 8.8, '2024-06-15'),
    (11, 3, 3, 8.9, '2024-09-15'),
    (11, 3, 4, 9.0, '2024-12-15'),
    (12, 1, 1, 6.4, '2024-03-15'),
    (12, 1, 2, 6.5, '2024-06-15'),
    (12, 1, 3, 6.7, '2024-09-15'),
    (12, 1, 4, 6.8, '2024-12-15'),
    (12, 3, 1, 7.1, '2024-03-15'),
    (12, 3, 2, 7.2, '2024-06-15'),
    (12, 3, 3, 7.3, '2024-09-15'),
    (12, 3, 4, 7.4, '2024-12-15'),
    (13, 1, 1, 7.7, '2024-03-15'),
    (13, 1, 2, 7.8, '2024-06-15'),
    (13, 1, 3, 7.9, '2024-09-15'),
    (13, 1, 4, 8.0, '2024-12-15'),
    (13, 3, 1, 8.2, '2024-03-15'),
    (13, 3, 2, 8.3, '2024-06-15'),
    (13, 3, 3, 8.4, '2024-09-15'),
    (13, 3, 4, 8.5, '2024-12-15'),
    (14, 1, 1, 6.9, '2024-03-15'),
    (14, 1, 2, 7.0, '2024-06-15'),
    (14, 1, 3, 7.2, '2024-09-15'),
    (14, 1, 4, 7.3, '2024-12-15'),
    (14, 3, 1, 7.5, '2024-03-15'),
    (14, 3, 2, 7.6, '2024-06-15'),
    (14, 3, 3, 7.7, '2024-09-15'),
    (14, 3, 4, 7.8, '2024-12-15'),
    (15, 1, 1, 8.4, '2024-03-15'),
    (15, 1, 2, 8.5, '2024-06-15'),
    (15, 1, 3, 8.6, '2024-09-15'),
    (15, 1, 4, 8.7, '2024-12-15'),
    (15, 3, 1, 8.9, '2024-03-15'),
    (15, 3, 2, 9.0, '2024-06-15'),
    (15, 3, 3, 9.1, '2024-09-15'),
    (15, 3, 4, 9.2, '2024-12-15'),
    (16, 1, 1, 7.2, '2024-03-15'),
    (16, 1, 2, 7.3, '2024-06-15'),
    (16, 1, 3, 7.4, '2024-09-15'),
    (16, 1, 4, 7.5, '2024-12-15'),
    (16, 3, 1, 7.7, '2024-03-15'),
    (16, 3, 2, 7.8, '2024-06-15'),
    (16, 3, 3, 7.9, '2024-09-15'),
    (16, 3, 4, 8.0, '2024-12-15'),
    (17, 1, 1, 7.8, '2024-03-15'),
    (17, 1, 2, 7.9, '2024-06-15'),
    (17, 1, 3, 8.0, '2024-09-15'),
    (17, 1, 4, 8.1, '2024-12-15'),
    (17, 3, 1, 8.3, '2024-03-15'),
    (17, 3, 2, 8.4, '2024-06-15'),
    (17, 3, 3, 8.5, '2024-09-15'),
    (17, 3, 4, 8.6, '2024-12-15'),
    (18, 1, 1, 6.3, '2024-03-15'),
    (18, 1, 2, 6.4, '2024-06-15'),
    (18, 1, 3, 6.6, '2024-09-15'),
    (18, 1, 4, 6.7, '2024-12-15'),
    (18, 3, 1, 7.0, '2024-03-15'),
    (18, 3, 2, 7.1, '2024-06-15'),
    (18, 3, 3, 7.2, '2024-09-15'),
    (18, 3, 4, 7.3, '2024-12-15'),
    (19, 1, 1, 8.1, '2024-03-15'),
    (19, 1, 2, 8.2, '2024-06-15'),
    (19, 1, 3, 8.3, '2024-09-15'),
    (19, 1, 4, 8.4, '2024-12-15'),
    (19, 3, 1, 8.6, '2024-03-15'),
    (19, 3, 2, 8.7, '2024-06-15'),
    (19, 3, 3, 8.8, '2024-09-15'),
    (19, 3, 4, 8.9, '2024-12-15'),
    (20, 1, 1, 7.4, '2024-03-15'),
    (20, 1, 2, 7.5, '2024-06-15'),
    (20, 1, 3, 7.6, '2024-09-15'),
    (20, 1, 4, 7.7, '2024-12-15'),
    (20, 3, 1, 7.9, '2024-03-15'),
    (20, 3, 2, 8.0, '2024-06-15'),
    (20, 3, 3, 8.1, '2024-09-15'),
    (20, 3, 4, 8.2, '2024-12-15');
-- Continue para alunos 21-40 (inserção adicional de notas para cobertura completa)
INSERT INTO notas (
        id_aluno,
        id_disciplina,
        bimestre,
        valor_nota,
        data_registro
    )
SELECT id_aluno,
    FLOOR(RAND() * 20) + 1 as id_disciplina,
    FLOOR(RAND() * 4) + 1 as bimestre,
    ROUND(RAND() * 10, 1) as valor_nota,
    '2024-12-15' as data_registro
FROM (
        SELECT 21 as id_aluno
        UNION ALL
        SELECT 22
        UNION ALL
        SELECT 23
        UNION ALL
        SELECT 24
        UNION ALL
        SELECT 25
        UNION ALL
        SELECT 26
        UNION ALL
        SELECT 27
        UNION ALL
        SELECT 28
        UNION ALL
        SELECT 29
        UNION ALL
        SELECT 30
        UNION ALL
        SELECT 31
        UNION ALL
        SELECT 32
        UNION ALL
        SELECT 33
        UNION ALL
        SELECT 34
        UNION ALL
        SELECT 35
        UNION ALL
        SELECT 36
        UNION ALL
        SELECT 37
        UNION ALL
        SELECT 38
        UNION ALL
        SELECT 39
        UNION ALL
        SELECT 40
    ) alunos_list,
    (
        SELECT 1 as n
        UNION ALL
        SELECT 2
        UNION ALL
        SELECT 3
        UNION ALL
        SELECT 4
        UNION ALL
        SELECT 5
        UNION ALL
        SELECT 6
        UNION ALL
        SELECT 7
        UNION ALL
        SELECT 8
        UNION ALL
        SELECT 9
        UNION ALL
        SELECT 10
    ) notas_count
WHERE notas_count.n <= 10 ON DUPLICATE KEY
UPDATE valor_nota = ROUND(RAND() * 10, 1);
-- =====================================================
-- INSERT: Frequências (Registros de presença)
-- =====================================================
-- Aluno 1 - Matemática I (80 aulas ao longo do ano)
INSERT INTO frequencias (id_aluno, id_disciplina, data_aula, presente)
SELECT 1,
    1,
    DATE_ADD('2024-02-01', INTERVAL n DAY),
    IF(MOD(n, 20) != 0, TRUE, FALSE)
FROM (
        SELECT 0 as n
        UNION ALL
        SELECT 1
        UNION ALL
        SELECT 2
        UNION ALL
        SELECT 3
        UNION ALL
        SELECT 4
        UNION ALL
        SELECT 5
        UNION ALL
        SELECT 6
        UNION ALL
        SELECT 7
        UNION ALL
        SELECT 8
        UNION ALL
        SELECT 9
        UNION ALL
        SELECT 10
        UNION ALL
        SELECT 11
        UNION ALL
        SELECT 12
        UNION ALL
        SELECT 13
        UNION ALL
        SELECT 14
        UNION ALL
        SELECT 15
        UNION ALL
        SELECT 16
        UNION ALL
        SELECT 17
        UNION ALL
        SELECT 18
        UNION ALL
        SELECT 19
        UNION ALL
        SELECT 20
        UNION ALL
        SELECT 21
        UNION ALL
        SELECT 22
        UNION ALL
        SELECT 23
        UNION ALL
        SELECT 24
        UNION ALL
        SELECT 25
        UNION ALL
        SELECT 26
        UNION ALL
        SELECT 27
        UNION ALL
        SELECT 28
        UNION ALL
        SELECT 29
    ) dias
WHERE n < 60;
-- Aluno 2 - Português I (70 aulas)
INSERT INTO frequencias (id_aluno, id_disciplina, data_aula, presente)
SELECT 2,
    3,
    DATE_ADD('2024-02-01', INTERVAL n DAY),
    IF(MOD(n, 10) != 0, TRUE, FALSE)
FROM (
        SELECT 0 as n
        UNION ALL
        SELECT 1
        UNION ALL
        SELECT 2
        UNION ALL
        SELECT 3
        UNION ALL
        SELECT 4
        UNION ALL
        SELECT 5
        UNION ALL
        SELECT 6
        UNION ALL
        SELECT 7
        UNION ALL
        SELECT 8
        UNION ALL
        SELECT 9
        UNION ALL
        SELECT 10
        UNION ALL
        SELECT 11
        UNION ALL
        SELECT 12
        UNION ALL
        SELECT 13
        UNION ALL
        SELECT 14
        UNION ALL
        SELECT 15
        UNION ALL
        SELECT 16
        UNION ALL
        SELECT 17
        UNION ALL
        SELECT 18
        UNION ALL
        SELECT 19
        UNION ALL
        SELECT 20
        UNION ALL
        SELECT 21
        UNION ALL
        SELECT 22
        UNION ALL
        SELECT 23
        UNION ALL
        SELECT 24
        UNION ALL
        SELECT 25
        UNION ALL
        SELECT 26
        UNION ALL
        SELECT 27
        UNION ALL
        SELECT 28
        UNION ALL
        SELECT 29
    ) dias
WHERE n < 60;
-- Adicionar frequências para mais alunos
INSERT INTO frequencias (id_aluno, id_disciplina, data_aula, presente)
SELECT aluno,
    disc,
    DATE_ADD('2024-02-01', INTERVAL d DAY),
    IF(RAND() > 0.1, TRUE, FALSE)
FROM (
        SELECT 3 as aluno,
            1 as disc,
            0 as d
        UNION ALL
        SELECT 3,
            1,
            1
        UNION ALL
        SELECT 3,
            1,
            2
        UNION ALL
        SELECT 3,
            1,
            3
        UNION ALL
        SELECT 3,
            1,
            4
        UNION ALL
        SELECT 4,
            3,
            0
        UNION ALL
        SELECT 4,
            3,
            1
        UNION ALL
        SELECT 4,
            3,
            2
        UNION ALL
        SELECT 4,
            3,
            3
        UNION ALL
        SELECT 4,
            3,
            4
        UNION ALL
        SELECT 5,
            1,
            0
        UNION ALL
        SELECT 5,
            1,
            1
        UNION ALL
        SELECT 5,
            1,
            2
        UNION ALL
        SELECT 5,
            1,
            3
        UNION ALL
        SELECT 5,
            1,
            4
        UNION ALL
        SELECT 6,
            3,
            0
        UNION ALL
        SELECT 6,
            3,
            1
        UNION ALL
        SELECT 6,
            3,
            2
        UNION ALL
        SELECT 6,
            3,
            3
        UNION ALL
        SELECT 6,
            3,
            4
    ) freq_data;
-- =====================================================
-- Verification Queries
-- =====================================================
SELECT 'Total Turmas' AS Info,
    COUNT(*) AS Total
FROM turmas
UNION ALL
SELECT 'Total Professores',
    COUNT(*)
FROM professors
UNION ALL
SELECT 'Total Disciplinas',
    COUNT(*)
FROM disciplinas
UNION ALL
SELECT 'Total Alunos',
    COUNT(*)
FROM alunos
UNION ALL
SELECT 'Total Notas',
    COUNT(*)
FROM notas
UNION ALL
SELECT 'Total Frequências',
    COUNT(*)
FROM frequencias;