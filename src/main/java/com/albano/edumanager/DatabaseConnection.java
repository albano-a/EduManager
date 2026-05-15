package com.albano.edumanager;

import java.sql.*;

/**
 * Classe utilitária para gerenciar conexões com o banco de dados MySQL
 * 
 * Uso:
 * Connection conn = DatabaseConnection.getConnection();
 * // ... usar a conexão
 * conn.close();
 */
public class DatabaseConnection {

    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/edumanager?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    private static final String USER = "root";
    private static final String PASSWORD = "17092013";

    static {
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            System.err.println("Erro ao carregar driver MySQL: " + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * Retorna uma conexão com o banco de dados
     * 
     * @return Connection objeto de conexão
     * @throws SQLException se ocorrer erro na conexão
     */
    public static Connection getConnection() throws SQLException {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            System.err.println("Erro ao conectar ao banco de dados:");
            System.err.println("URL: " + URL);
            System.err.println("Usuário: " + USER);
            System.err.println("Mensagem: " + e.getMessage());
            e.printStackTrace();
            throw e;
        }
    }

    /**
     * Testa a conexão com o banco de dados
     * 
     * @return true se a conexão foi bem-sucedida, false caso contrário
     */
    public static boolean testConnection() {
        try {
            Connection conn = getConnection();
            if (conn != null) {
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT 1");
                if (rs.next()) {
                    System.out.println("✓ Conexão com banco de dados estabelecida com sucesso!");
                    rs.close();
                    stmt.close();
                    conn.close();
                    return true;
                }
            }
        } catch (SQLException e) {
            System.err.println("✗ Falha ao conectar com banco de dados: " + e.getMessage());
        }
        return false;
    }

    /**
     * Fecha uma conexão, statement e resultset com segurança
     */
    public static void closeResources(ResultSet rs, Statement stmt, Connection conn) {
        try {
            if (rs != null)
                rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (stmt != null)
                stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (conn != null)
                conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Fecha uma conexão com segurança
     */
    public static void closeConnection(Connection conn) {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
