package com.albano.edumanager.dao;

import com.albano.edumanager.Aluno;
import com.albano.edumanager.DatabaseConnection;
import com.albano.edumanager.Turma;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * DAO (Data Access Object) para a classe Aluno
 * Gerencia operações de CRUD no banco de dados
 */
public class AlunoDAO {

    /**
     * Insere um novo aluno no banco de dados
     * 
     * @param aluno objeto Aluno a ser inserido
     * @return id gerado ou -1 se falhar
     */
    public static int inserir(Aluno aluno) {
        String sql = "INSERT INTO alunos (nome, email, data_nascimento, id_turma, data_matricula, cpf, telefone) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?)";

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = DatabaseConnection.getConnection();
            pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, aluno.getNome());
            pstmt.setString(2, aluno.getNome().toLowerCase().replace(" ", ".") + "@student.com");
            pstmt.setDate(3, new java.sql.Date(aluno.getDtNasc().getTime()));
            pstmt.setInt(4, aluno.getTurma().getId());
            pstmt.setDate(5, new java.sql.Date(new java.util.Date().getTime()));
            pstmt.setString(6, null);
            pstmt.setString(7, null);

            pstmt.executeUpdate();
            rs = pstmt.getGeneratedKeys();

            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            System.err.println("Erro ao inserir aluno: " + e.getMessage());
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeResources(rs, pstmt, conn);
        }

        return -1;
    }

    /**
     * Busca um aluno pelo ID
     * 
     * @param id id do aluno
     * @return objeto Aluno ou null se não encontrado
     */
    public static Aluno buscarPorId(int id) {
        String sql = "SELECT a.*, t.id_turma, t.nome as turma_nome, t.ano_letivo " +
                "FROM alunos a " +
                "JOIN turmas t ON a.id_turma = t.id_turma " +
                "WHERE a.id_aluno = ?";

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = DatabaseConnection.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                return mapearResultSetParaAluno(rs);
            }
        } catch (SQLException e) {
            System.err.println("Erro ao buscar aluno: " + e.getMessage());
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeResources(rs, pstmt, conn);
        }

        return null;
    }

    /**
     * Lista todos os alunos
     * 
     * @return lista de alunos
     */
    public static List<Aluno> listarTodos() {
        List<Aluno> alunos = new ArrayList<>();
        String sql = "SELECT a.*, t.id_turma, t.nome as turma_nome, t.ano_letivo " +
                "FROM alunos a " +
                "JOIN turmas t ON a.id_turma = t.id_turma " +
                "ORDER BY a.nome";

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            conn = DatabaseConnection.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                alunos.add(mapearResultSetParaAluno(rs));
            }
        } catch (SQLException e) {
            System.err.println("Erro ao listar alunos: " + e.getMessage());
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeResources(rs, stmt, conn);
        }

        return alunos;
    }

    /**
     * Lista alunos de uma turma específica
     * 
     * @param idTurma id da turma
     * @return lista de alunos da turma
     */
    public static List<Aluno> listarPorTurma(int idTurma) {
        List<Aluno> alunos = new ArrayList<>();
        String sql = "SELECT a.*, t.id_turma, t.nome as turma_nome, t.ano_letivo " +
                "FROM alunos a " +
                "JOIN turmas t ON a.id_turma = t.id_turma " +
                "WHERE a.id_turma = ? " +
                "ORDER BY a.nome";

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = DatabaseConnection.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, idTurma);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                alunos.add(mapearResultSetParaAluno(rs));
            }
        } catch (SQLException e) {
            System.err.println("Erro ao listar alunos por turma: " + e.getMessage());
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeResources(rs, pstmt, conn);
        }

        return alunos;
    }

    /**
     * Atualiza os dados de um aluno
     * 
     * @param aluno objeto Aluno com dados atualizados
     * @return true se atualizado com sucesso, false caso contrário
     */
    public static boolean atualizar(Aluno aluno) {
        String sql = "UPDATE alunos SET nome = ?, email = ?, data_nascimento = ?, id_turma = ?, cpf = ?, telefone = ? "
                +
                "WHERE id_aluno = ?";

        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = DatabaseConnection.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, aluno.getNome());
            pstmt.setString(2, aluno.getNome().toLowerCase().replace(" ", ".") + "@student.com");
            pstmt.setDate(3, new java.sql.Date(aluno.getDtNasc().getTime()));
            pstmt.setInt(4, aluno.getTurma().getId());
            pstmt.setString(5, null);
            pstmt.setString(6, null);
            pstmt.setInt(7, aluno.getId());

            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Erro ao atualizar aluno: " + e.getMessage());
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(conn);
        }

        return false;
    }

    /**
     * Deleta um aluno
     * 
     * @param id id do aluno
     * @return true se deletado com sucesso, false caso contrário
     */
    public static boolean deletar(int id) {
        String sql = "DELETE FROM alunos WHERE id_aluno = ?";

        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = DatabaseConnection.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);

            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Erro ao deletar aluno: " + e.getMessage());
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(conn);
        }

        return false;
    }

    /**
     * Mapeia um ResultSet para um objeto Aluno
     */
    private static Aluno mapearResultSetParaAluno(ResultSet rs) throws SQLException {
        int id = rs.getInt("id_aluno");
        String nome = rs.getString("nome");
        Date dataNascimento = new Date(rs.getDate("data_nascimento").getTime());

        // Recuperar turma
        int idTurma = rs.getInt("id_turma");
        String nomeTurma = rs.getString("turma_nome");
        int anoLetivo = rs.getInt("ano_letivo");
        Turma turma = new Turma(idTurma, nomeTurma, anoLetivo);

        return new Aluno(id, nome, dataNascimento, turma);
    }
}
