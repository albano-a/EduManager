package dao;

import core.Professor;
import core.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * DAO (Data Access Object) para a classe Professor
 * Gerencia operações de CRUD no banco de dados
 */
public class ProfessorDAO {

    /**
     * Insere um novo professor no banco de dados
     */
    public static int inserir(Professor professor) {
        String sql = "INSERT INTO professors (nome, especialidade, email, telefone, data_admissao) " +
                "VALUES (?, ?, ?, ?, NOW())";

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = DatabaseConnection.getConnection();
            pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, professor.getNome());
            pstmt.setString(2, professor.getDiscPrincipal());
            pstmt.setString(3, professor.getNome().toLowerCase().replace(" ", ".") + "@profesor.com");
            pstmt.setString(4, null);

            pstmt.executeUpdate();
            rs = pstmt.getGeneratedKeys();

            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            System.err.println("Erro ao inserir professor: " + e.getMessage());
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeResources(rs, pstmt, conn);
        }

        return -1;
    }

    /**
     * Busca um professor pelo ID
     */
    public static Professor buscarPorId(int id) {
        String sql = "SELECT * FROM professors WHERE id_professor = ?";

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = DatabaseConnection.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                return mapearResultSetParaProfessor(rs);
            }
        } catch (SQLException e) {
            System.err.println("Erro ao buscar professor: " + e.getMessage());
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeResources(rs, pstmt, conn);
        }

        return null;
    }

    /**
     * Lista todos os professores
     */
    public static List<Professor> listarTodos() {
        List<Professor> professores = new ArrayList<>();
        String sql = "SELECT * FROM professors ORDER BY nome";

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            conn = DatabaseConnection.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                professores.add(mapearResultSetParaProfessor(rs));
            }
        } catch (SQLException e) {
            System.err.println("Erro ao listar professores: " + e.getMessage());
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeResources(rs, stmt, conn);
        }

        return professores;
    }

    /**
     * Atualiza os dados de um professor
     */
    public static boolean atualizar(Professor professor) {
        String sql = "UPDATE professors SET nome = ?, especialidade = ?, email = ? WHERE id_professor = ?";

        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = DatabaseConnection.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, professor.getNome());
            pstmt.setString(2, professor.getDiscPrincipal());
            pstmt.setString(3, professor.getNome().toLowerCase().replace(" ", ".") + "@profesor.com");

            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Erro ao atualizar professor: " + e.getMessage());
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(conn);
        }

        return false;
    }

    /**
     * Deleta um professor
     */
    public static boolean deletar(int id) {
        String sql = "DELETE FROM professors WHERE id_professor = ?";

        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = DatabaseConnection.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);

            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Erro ao deletar professor: " + e.getMessage());
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(conn);
        }

        return false;
    }

    /**
     * Mapeia um ResultSet para um objeto Professor
     */
    private static Professor mapearResultSetParaProfessor(ResultSet rs) throws SQLException {
        int id = rs.getInt("id_professor");
        String nome = rs.getString("nome");
        String discPrincipal = rs.getString("especialidade");

        return new Professor(id, nome, discPrincipal);
    }
}
