package dao;

import core.Frequencia;
import core.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * DAO (Data Access Object) para a classe Frequencia
 */
public class FrequenciaDAO {

    /**
     * Insere um novo registro de frequência
     */
    public static int inserir(Frequencia frequencia) {
        String sql = "INSERT INTO frequencias (id_aluno, id_disciplina, data_aula, presente) " +
                "VALUES (?, ?, NOW(), ?)";

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = DatabaseConnection.getConnection();
            pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pstmt.setInt(1, frequencia.getAluno().getId());
            pstmt.setInt(2, frequencia.getDisc().getId());
            pstmt.setBoolean(3, frequencia.isPresente());

            pstmt.executeUpdate();
            rs = pstmt.getGeneratedKeys();

            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            System.err.println("Erro ao inserir frequência: " + e.getMessage());
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeResources(rs, pstmt, conn);
        }

        return -1;
    }

    /**
     * Busca frequências de um aluno
     */
    public static List<Frequencia> buscarPorAluno(int idAluno) {
        List<Frequencia> frequencias = new ArrayList<>();
        String sql = "SELECT * FROM frequencias WHERE id_aluno = ? ORDER BY data_aula";

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = DatabaseConnection.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, idAluno);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                frequencias.add(mapearResultSetParaFrequencia(rs));
            }
        } catch (SQLException e) {
            System.err.println("Erro ao buscar frequências: " + e.getMessage());
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeResources(rs, pstmt, conn);
        }

        return frequencias;
    }

    /**
     * Mapeia um ResultSet para um objeto Frequencia
     */
    private static Frequencia mapearResultSetParaFrequencia(ResultSet rs) throws SQLException {
        int id = rs.getInt("id_frequencia");
        boolean presente = rs.getBoolean("presente");

        return new Frequencia(id, null, null, new Date(), presente);
    }
}
