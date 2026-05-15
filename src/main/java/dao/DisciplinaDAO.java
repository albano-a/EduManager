package dao;

import core.Disciplina;
import core.Professor;
import core.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * DAO (Data Access Object) para a classe Disciplina
 * Gerencia operações de CRUD no banco de dados
 */
public class DisciplinaDAO {

    /**
     * Insere uma nova disciplina no banco de dados
     */
    public static int inserir(Disciplina disciplina) {
        String sql = "INSERT INTO disciplinas (nome, id_professor, carga_horaria) VALUES (?, ?, ?)";

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = DatabaseConnection.getConnection();
            pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, disciplina.getNome());
            pstmt.setInt(2, disciplina.getProf().getId());
            pstmt.setInt(3, 60);

            pstmt.executeUpdate();
            rs = pstmt.getGeneratedKeys();

            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            System.err.println("Erro ao inserir disciplina: " + e.getMessage());
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeResources(rs, pstmt, conn);
        }

        return -1;
    }

    /**
     * Busca uma disciplina pelo ID
     */
    public static Disciplina buscarPorId(int id) {
        String sql = "SELECT d.*, p.id_professor, p.nome as prof_nome, p.especialidade " +
                "FROM disciplinas d " +
                "JOIN professors p ON d.id_professor = p.id_professor " +
                "WHERE d.id_disciplina = ?";

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = DatabaseConnection.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                return mapearResultSetParaDisciplina(rs);
            }
        } catch (SQLException e) {
            System.err.println("Erro ao buscar disciplina: " + e.getMessage());
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeResources(rs, pstmt, conn);
        }

        return null;
    }

    /**
     * Lista todas as disciplinas
     */
    public static List<Disciplina> listarTodas() {
        List<Disciplina> disciplinas = new ArrayList<>();
        String sql = "SELECT d.*, p.id_professor, p.nome as prof_nome, p.especialidade " +
                "FROM disciplinas d " +
                "JOIN professors p ON d.id_professor = p.id_professor " +
                "ORDER BY d.nome";

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            conn = DatabaseConnection.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                disciplinas.add(mapearResultSetParaDisciplina(rs));
            }
        } catch (SQLException e) {
            System.err.println("Erro ao listar disciplinas: " + e.getMessage());
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeResources(rs, stmt, conn);
        }

        return disciplinas;
    }

    /**
     * Atualiza os dados de uma disciplina
     */
    public static boolean atualizar(Disciplina disciplina) {
        String sql = "UPDATE disciplinas SET nome = ?, id_professor = ? WHERE id_disciplina = ?";

        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = DatabaseConnection.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, disciplina.getNome());
            pstmt.setInt(2, disciplina.getProf().getId());
            pstmt.setInt(3, disciplina.getId());

            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Erro ao atualizar disciplina: " + e.getMessage());
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(conn);
        }

        return false;
    }

    /**
     * Deleta uma disciplina
     */
    public static boolean deletar(int id) {
        String sql = "DELETE FROM disciplinas WHERE id_disciplina = ?";

        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = DatabaseConnection.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);

            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Erro ao deletar disciplina: " + e.getMessage());
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(conn);
        }

        return false;
    }

    /**
     * Mapeia um ResultSet para um objeto Disciplina
     */
    private static Disciplina mapearResultSetParaDisciplina(ResultSet rs) throws SQLException {
        int id = rs.getInt("id_disciplina");
        String nome = rs.getString("nome");

        // Recuperar professor
        int idProf = rs.getInt("id_professor");
        String nomProf = rs.getString("prof_nome");
        String discPrincipal = rs.getString("especialidade");
        Professor prof = new Professor(idProf, nomProf, discPrincipal);

        return new Disciplina(id, nome, prof);
    }
}
