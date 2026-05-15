package dao;

import core.Disciplina;
import core.Professor;
import core.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

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
            if (disciplina.getProf() != null) {
                pstmt.setInt(2, disciplina.getProf().getId());
            } else {
                pstmt.setNull(2, Types.INTEGER);
            }
            pstmt.setInt(3, disciplina.getCargaHoraria());

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
     * Busca uma disciplina pelo nome (retorna a primeira ocorrência)
     */
    public static Disciplina buscarPorNome(String nome) {
        String sql = "SELECT d.*, p.id_professor, p.nome as prof_nome, p.especialidade, p.telefone as prof_telefone, p.data_admissao as dt_admissao "
                +
                "FROM disciplinas d " +
                "LEFT JOIN professors p ON d.id_professor = p.id_professor " +
                "WHERE d.nome = ? LIMIT 1";

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = DatabaseConnection.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, nome);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                return mapearResultSetParaDisciplina(rs);
            }
        } catch (SQLException e) {
            System.err.println("Erro ao buscar disciplina por nome: " + e.getMessage());
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeResources(rs, pstmt, conn);
        }

        return null;
    }
    
    public static int totalDisciplinas() {
        String sql = "SELECT COUNT(*) AS total FROM disciplinas";
        
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        
        try {
            conn = DatabaseConnection.getConnection();
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            
            if (rs.next()) {
                return rs.getInt("total");
            }
        } catch (SQLException e) {
            System.err.println("Erro ao contar disciplinas: " + e.getMessage());
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeResources(rs, pstmt, conn);
        }
        
        return 0;
    }

    /**
     * Associa um professor a uma disciplina na tabela de relação
     */
    public static boolean associarProfessor(int idDisciplina, int idProfessor) {
        String sql = "INSERT IGNORE INTO disciplinas_professores (id_disciplina, id_professor) VALUES (?, ?)";

        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = DatabaseConnection.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, idDisciplina);
            pstmt.setInt(2, idProfessor);
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Erro ao associar professor e disciplina: " + e.getMessage());
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(conn);
        }

        return false;
    }

    /**
     * Busca uma disciplina pelo ID
     */
    public static Disciplina buscarPorId(int id) {
        String sql = "SELECT d.*, p.id_professor, p.nome as prof_nome, p.especialidade, p.telefone as prof_telefone, p.data_admissao as dt_admissao "
                +
                "FROM disciplinas d " +
                "LEFT JOIN professors p ON d.id_professor = p.id_professor " +
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
        String sql = "SELECT d.*, p.id_professor, p.nome as prof_nome, p.especialidade, p.telefone as prof_telefone, p.data_admissao as dt_admissao "
                +
                "FROM disciplinas d " +
                "LEFT JOIN professors p ON d.id_professor = p.id_professor " +
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
        String nm = rs.getString("nome");
        int ch = rs.getInt("carga_horaria");
        int idProf = rs.getInt("id_professor");
        boolean hasProf = !rs.wasNull();

        Professor prof = null;
        if (hasProf) {
            String nmProf = rs.getString("prof_nome");
            String esp = rs.getString("especialidade");
            String tel = rs.getString("prof_telefone");
            java.sql.Date sqlDt = rs.getDate("dt_admissao");
            LocalDate dtAdm = (sqlDt != null) ? sqlDt.toLocalDate() : null;
            prof = new Professor(idProf, nmProf, tel, dtAdm, esp);
        }
        return new Disciplina(id, nm, prof, ch);
    }
}
