/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import core.DatabaseConnection;
import core.Turma;

import java.sql.*;
/**
 *
 * @author aalbano
 */
public class TurmasDAO {
    /**
     * Busca uma turma pelo ID
     *
     * @param id id da turma
     * @return objeto Turma ou null se não encontrado
     */
    public static Turma buscarPorId(int id) {

        String sql = """
            SELECT id_turma, nome, ano_letivo
            FROM turmas
            WHERE id_turma = ?
        """;

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {

            conn = DatabaseConnection.getConnection();

            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);

            rs = pstmt.executeQuery();

            if (rs.next()) {

                int idTurma = rs.getInt("id_turma");
                String nome = rs.getString("nome");
                int anoLetivo = rs.getInt("ano_letivo");

                return new Turma(idTurma, nome, anoLetivo);
            }

        } catch (SQLException e) {

            System.err.println("Erro ao buscar turma: " + e.getMessage());
            e.printStackTrace();

        } finally {

            DatabaseConnection.closeResources(rs, pstmt, conn);

        }

        return null;
    }
}
