/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ui;

import javax.swing.*;
import java.util.*;
import javax.swing.table.*;
import java.awt.*;

/**
 *
 * @author aalbano
 */
public class CadastroItem extends javax.swing.JFrame {

    ArrayList<JTextField> cps = new ArrayList<>();

    DefaultTableModel mdl;
    int linhaEdicao = -1;

    public CadastroItem(String[] cols, boolean[] edt, DefaultTableModel mdlTb) {
        this.mdl = mdlTb;
        this.linhaEdicao = -1;

        setTitle("Cadastro");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(500, 350);
        setLocationRelativeTo(null);

        JPanel pnlFrm = new JPanel();
        pnlFrm.setLayout(new GridBagLayout());
        pnlFrm.setBackground(new Color(245, 245, 245));
        pnlFrm.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        GridBagConstraints gbc = new GridBagConstraints();

        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1;

        for (int i = 0; i < cols.length; i++) {

            JLabel lbl = new JLabel(cols[i]);
            lbl.setFont(new Font("SansSerif", Font.PLAIN, 12));

            JTextField txt = new JTextField();
            txt.setPreferredSize(new Dimension(250, 30));
            txt.setEditable(edt[i]);

            if (!edt[i]) {
                txt.setBackground(new Color(230, 230, 230));
            }

            cps.add(txt);

            gbc.gridx = 0;
            gbc.gridy = i;
            gbc.weightx = 0;

            pnlFrm.add(lbl, gbc);

            gbc.gridx = 1;
            gbc.weightx = 1;

            pnlFrm.add(txt, gbc);
        }

        JButton btn = new JButton("Salvar");
        btn.setPreferredSize(new Dimension(100, 35));
        btn.setFocusPainted(false);
        btn.setFont(new Font("SansSerif", Font.BOLD, 14));
        btn.setBackground(new Color(70, 130, 180));
        btn.setForeground(Color.WHITE);
        btn.setCursor(new Cursor(Cursor.HAND_CURSOR));

        btn.addActionListener(e -> salvar());

        gbc.gridx = 0;
        gbc.gridy = cols.length;
        gbc.gridwidth = 2;
        gbc.weightx = 0;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(20, 10, 10, 10);

        pnlFrm.add(btn, gbc);

        JScrollPane scroll = new JScrollPane(pnlFrm);
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        getContentPane().add(scroll);
    }

    /**
     * Carrega dados existentes para edição
     */
    public void setDados(Object[] dados) {
        for (int i = 0; i < dados.length && i < cps.size(); i++) {
            cps.get(i).setText(String.valueOf(dados[i]));
        }
    }

    /**
     * Define o modo de edição (indicando qual linha editar)
     */
    public void setModoEdicao(int linhaIndice) {
        this.linhaEdicao = linhaIndice;
        setTitle("Editar");
    }

    private void salvar() {

        Object[] vals = new Object[cps.size()];

        for (int i = 0; i < cps.size(); i++) {
            vals[i] = cps.get(i).getText();
        }

        if (linhaEdicao >= 0) {
            // Modo de edição - atualizar linha existente
            for (int i = 0; i < vals.length; i++) {
                mdl.setValueAt(vals[i], linhaEdicao, i);
            }
        } else {
            // Modo de adição - adicionar nova linha
            mdl.addRow(vals);
        }

        dispose();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
