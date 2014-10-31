/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.mymuseum.interfaces;

import br.edu.mymuseum.classe.Autor;
import br.edu.mymuseum.classe.Obra;
import br.edu.mymuseum.classe.Salao;
import br.edu.mymuseum.dao.DaoAutor;
import br.edu.mymuseum.dao.DaoObra;
import br.edu.mymuseum.dao.DaoSalao;
import br.edu.mymuseum.validacao.PreencherComboBoxGenerico;
import br.edu.mymuseum.validacao.PreencherJtableGenerico;
import br.edu.mymuseum.validacao.Rotinas;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author gustavo
 */
public class GerenciarExposicao extends javax.swing.JFrame {
    
    int situacao = Rotinas.ALTERAR;
    PreencherJtableGenerico preencherjtable = new PreencherJtableGenerico();
    PreencherComboBoxGenerico preenchercombo = new PreencherComboBoxGenerico();
    Autor autor = new Autor();
    DaoAutor daoautor = new DaoAutor();
    Salao salao = new Salao();
    DaoSalao daosalao = new DaoSalao();
    Obra obra = new Obra();
    DaoObra daoobra = new DaoObra();

    public GerenciarExposicao() {
        initComponents();
        daoautor.consultaGeral(autor);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JTBGerenciarObras = new javax.swing.JTabbedPane();
        jPGerenciarObras = new javax.swing.JPanel();
        jPSalao = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cd_salao = new javax.swing.JTextField();
        cd_andar = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        tp_obra = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTObras = new javax.swing.JTable();
        Alterar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPSalao.setBorder(javax.swing.BorderFactory.createTitledBorder("Informações para filtro"));

        jLabel1.setText("Salão");

        cd_salao.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                cd_salaoFocusLost(evt);
            }
        });

        cd_andar.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                cd_andarFocusLost(evt);
            }
        });

        jLabel2.setText("Andar");

        jLabel3.setText("Tipo da Obra");

        tp_obra.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Todos", "Pintura", "Escultura" }));

        jButton1.setText("Pesquisar");
        jButton1.setEnabled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPSalaoLayout = new javax.swing.GroupLayout(jPSalao);
        jPSalao.setLayout(jPSalaoLayout);
        jPSalaoLayout.setHorizontalGroup(
            jPSalaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPSalaoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPSalaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cd_salao, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(jPSalaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(cd_andar, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(jPSalaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tp_obra, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(11, Short.MAX_VALUE))
        );
        jPSalaoLayout.setVerticalGroup(
            jPSalaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPSalaoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPSalaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPSalaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cd_salao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cd_andar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tp_obra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Exposição Altere o Salão e o Andar da Obra"));

        jTObras.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Tipo", "Ano", "Título", "Salão", "Andar", "Autor"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTObras);

        Alterar.setText("Gerenciar");
        Alterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AlterarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(Alterar, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Alterar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPGerenciarObrasLayout = new javax.swing.GroupLayout(jPGerenciarObras);
        jPGerenciarObras.setLayout(jPGerenciarObrasLayout);
        jPGerenciarObrasLayout.setHorizontalGroup(
            jPGerenciarObrasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPSalao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPGerenciarObrasLayout.setVerticalGroup(
            jPGerenciarObrasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPGerenciarObrasLayout.createSequentialGroup()
                .addComponent(jPSalao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        JTBGerenciarObras.addTab("Gerenciar Exposição", jPGerenciarObras);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JTBGerenciarObras)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JTBGerenciarObras)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        int cdsalao = Integer.parseInt(cd_salao.getText());
        int cdandar = Integer.parseInt(cd_andar.getText());
        int tpobra = 0;
        int cdautor = 0;
        if (tp_obra.getSelectedIndex() == 1) {
            tpobra = 1;
        } else if (tp_obra.getSelectedIndex() == 2) {
            tpobra = 2;
        }
       
        if (tpobra != 0) {
            obra.setCd_andar(cdandar);
            obra.setCd_salao(cdsalao);
            obra.setTp_obra(tpobra);
            daoobra.consultaTpObra(obra);
            preencherjtable.PreencherJtableGenerico(jTObras, new String[]{"cd_obra", "tp_obra", "ano_obra", "ti_obra", "cd_salao", "cd_andar", "cd_autor"}, obra.getRetorno());
        } else if (tpobra ==0){
            daoobra.consultaCodigo(obra);
            obra.setCd_andar(cdandar);
            obra.setCd_salao(cdsalao);
            preencherjtable.PreencherJtableGenerico(jTObras, new String[]{"cd_obra", "tp_obra", "ano_obra", "ti_obra", "cd_salao", "cd_andar", "cd_autor"}, obra.getRetorno());
       
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void AlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AlterarActionPerformed
        situacao = Rotinas.ALTERAR;
        obra.setTabela(jTObras);        
        daoobra.grava_itens(obra);
//        validabotoes.ValidaEstado(jPanel3, situacao);
        // TODO add your handling code here:
    }//GEN-LAST:event_AlterarActionPerformed

    private void cd_salaoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cd_salaoFocusLost
        // TODO add your handling code here:
        salao.setCd_salao(Integer.parseInt(cd_salao.getText()));
        daosalao.consultaCodigo(salao);
        try {
            salao.getRetorno().first();
            if (salao.getRetorno().getInt("CD_ANDAR") != 0) {
                //esculturamaterial.setDs_material(material.getRetorno().getString("NM_MATERIA"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Insira um salão válido");
            cd_salao.setText("");
            cd_salao.requestFocus();
        }

    }//GEN-LAST:event_cd_salaoFocusLost

    private void cd_andarFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cd_andarFocusLost
        // TODO add your handling code here:
        salao.setCd_salao(Integer.parseInt(cd_salao.getText()));
        salao.setCd_andar(Integer.parseInt(cd_andar.getText()));
        daosalao.consultaCodigo(salao);
        try {
            salao.getRetorno().first();
            if (salao.getRetorno().getInt("CD_ANDAR") != 0) {
                //esculturamaterial.setDs_material(material.getRetorno().getString("NM_MATERIA"));
                jButton1.setEnabled(true);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Insira um salão válido");
            cd_salao.setText("");
            cd_salao.requestFocus();
        }
    }//GEN-LAST:event_cd_andarFocusLost

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(GerenciarExposicao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(GerenciarExposicao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(GerenciarExposicao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(GerenciarExposicao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new GerenciarExposicao().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Alterar;
    private javax.swing.JTabbedPane JTBGerenciarObras;
    private javax.swing.JTextField cd_andar;
    private javax.swing.JTextField cd_salao;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPGerenciarObras;
    private javax.swing.JPanel jPSalao;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTObras;
    private javax.swing.JComboBox tp_obra;
    // End of variables declaration//GEN-END:variables
}
