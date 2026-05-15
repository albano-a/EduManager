package dao;

import core.Nota;
import core.Aluno;
import core.Disciplina;
import core.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * DAO (Data Access Object) para a classe Nota
 */
public class NotaDAO {

    /**
     * Insere uma nova nota no banco de dados
     */
    public static int inserir(Nota nota) {
        String sql = "INSERT INTO notas (id_aluno, id_disciplina, bimestre, valor_nota, data_registro) " +
                "VALUES (?, ?, ?, ?, NOW())";

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = DatabaseConnection.getConnection();
            pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pstmt.setInt(1, nota.getAluno().getId());
            pstmt.setInt(2, nota.getDisc().getId());
            pstmt.setInt(3, nota.getBimestre());
            pstmt.setDouble(4, nota.getNota());

            pstmt.executeUpdate();
            rs = pstmt.getGeneratedKeys();

            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            System.err.println("Erro ao inserir nota: " + e.getMessage());
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeResources(rs, pstmt, conn);
        }

        return -1;
    }

    /**
     * Busca notas de um aluno
     */
    public static List<Nota> buscarPorAluno(int idAluno) {
        List<Nota> notas = new ArrayList<>();
        String sql = "SELECT n.*, a.id_aluno, a.nome as aluno_nome, d.id_disciplina, d.nome as disc_nome " +
                "FROM notas n " +
                "JOIN alunos a ON n.id_aluno = a.id_aluno " +
                "JOIN disciplinas d ON n.id_disciplina = d.id_disciplina " +
                "WHERE n.id_aluno = ? " +
                "ORDER BY d.nome, n.bimestre";

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = DatabaseConnection.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, idAluno);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                notas.add(mapearResultSetParaNota(rs));
            }
        } catch (SQLException e) {
            System.err.println("Erro ao buscar notas: " + e.getMessage());
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeResources(rs, pstmt, conn);
        }

        return notas;
    }

    /**
     * Deleta uma nota
     */
    public static boolean deletar(int id) {
        String sql = "DELETE FROM notas WHERE id_nota = ?";

        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = DatabaseConnection.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);

            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Erro ao deletar nota: " + e.getMessage());
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(conn);
        }

        return false;
    }

    /**
     * Mapeia um ResultSet para um objeto Nota
     */
    private static Nota mapearResultSetParaNota(ResultSet rs) throws SQLException {
        int id = rs.getInt("id_nota");
        int bimestre = rs.getInt("bimestre");
        double nota = rs.getDouble("valor_nota");

        Aluno aluno = AlunoDAO.buscarPorId(rs.getInt("id_aluno"));

        // Obter Disciplina completa via DAO (mantém consistência com DisciplinaDAO)
        Disciplina disc = DisciplinaDAO.buscarPorId(rs.getInt("id_disciplina"));

        return new Nota(id, aluno, disc, bimestre, nota);
    }
}
