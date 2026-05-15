package com.albano.edumanager;

import java.util.Date;
import java.sql.Connection;
import ui.Dashboard;

public class EduManager {

    public static void exibirBoletim(Aluno a) {
        System.out.println("########################################");
        System.out.println("BOLETIM - " + a.getNome());
        System.out.println("Turma: " + a.getTurma().getNome());
        System.out.println("----------------------------------------");
        if (a.getNotas().isEmpty()) {
            System.out.println("Nenhuma nota lancada.");
        } else {
            for (Nota n : a.getNotas()) {
                System.out.printf("%-15s Bim %d: %.1f %s%n",
                        n.getDisc().getNome(),
                        n.getBimestre(),
                        n.getNota(),
                        n.isAprovado() ? "" : "[ABAIXO DA MEDIA]");
            }
            System.out.printf("%-15s        %.1f%n", "Media geral:", a.calcMedia());
            System.out.printf("%-15s        %.0f%%%n", "Frequencia:", a.calcFreqPct());
            System.out.println("Status: " + (a.isAprovado() ? "APROVADO" : "REPROVADO"));
        }
        System.out.println("########################################");
    }

    public static void main(String[] args) {
        // Teste de conexão com o banco de dados
        System.out.println("========================================");
        System.out.println("EDUMANAGER - Iniciando aplicação");
        System.out.println("========================================");
        System.out.println("Tentando conectar ao banco de dados...");

        try {
            Connection conn = DatabaseConnection.getConnection();
            if (conn != null && !conn.isClosed()) {
                System.out.println("✓ Conexão com banco de dados estabelecida com sucesso!");
                System.out.println("  Banco: edumanager");
                System.out.println("  URL: jdbc:mysql://localhost:3306/edumanager");
                conn.close(); // Fecha a conexão de teste
            }
        } catch (Exception e) {
            System.err.println("✗ Erro ao conectar com o banco de dados!");
            System.err.println("  Mensagem: " + e.getMessage());
            System.err.println("  Verifique se o MySQL está rodando e o banco 'edumanager' existe.");
            return;
        }
        System.out.println("========================================\n");

        /* Set the Windows look and feel */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            ex.printStackTrace();
        }

        Dashboard dsh = new Dashboard();
        dsh.setVisible(true);

        Turma t1 = new Turma(1, "1A", 2026);

        Professor pJoao = new Professor(1, "João", "Matemática");
        Professor pMaria = new Professor(2, "Maria", "Português");

        Disciplina mat = new Disciplina(1, "Matemática", pJoao);
        Disciplina port = new Disciplina(2, "Português", pMaria);

        pJoao.addDisc(mat);
        pMaria.addDisc(port);

        Aluno adriano = new Aluno(1, "Adriano Silper", new Date(), t1);
        Aluno andre = new Aluno(2, "André Albano", new Date(), t1);
        t1.addAluno(adriano);
        t1.addAluno(andre);

        Nota n1 = new Nota(1, adriano, mat, 1, 8.5);
        Nota n2 = new Nota(2, adriano, port, 1, 9.0);
        Nota n3 = new Nota(3, andre, mat, 1, 5.0);
        Nota n4 = new Nota(4, andre, port, 1, 7.0);

        adriano.addNota(n1);
        adriano.addNota(n2);
        andre.addNota(n3);
        andre.addNota(n4);

        Frequencia f1 = new Frequencia(1, adriano, mat, new Date(), true);
        Frequencia f2 = new Frequencia(2, adriano, mat, new Date(), true);
        Frequencia f3 = new Frequencia(3, adriano, mat, new Date(), true);
        Frequencia f4 = new Frequencia(4, andre, mat, new Date(), true);
        Frequencia f5 = new Frequencia(5, andre, mat, new Date(), false);
        Frequencia f6 = new Frequencia(6, andre, mat, new Date(), false);

        adriano.addFreq(f1);
        adriano.addFreq(f2);
        adriano.addFreq(f3);
        andre.addFreq(f4);
        andre.addFreq(f5);
        andre.addFreq(f6);

        exibirBoletim(adriano);
        exibirBoletim(andre);

    }
}
