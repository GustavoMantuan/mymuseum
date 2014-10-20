/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.mymuseum.interfaces;

import br.edu.mymuseum.classe.Autor;
import br.edu.mymuseum.classe.Escultura;
import br.edu.mymuseum.classe.EsculturaMaterial;
import br.edu.mymuseum.classe.Material;
import br.edu.mymuseum.classe.Obra;
import br.edu.mymuseum.classe.Pintura;
import br.edu.mymuseum.classe.Salao;
import br.edu.mymuseum.dao.DaoAutor;
import br.edu.mymuseum.dao.DaoEsculturaMaterial;
import br.edu.mymuseum.dao.DaoMaterial;
import br.edu.mymuseum.dao.DaoObra;
import br.edu.mymuseum.dao.DaoSalao;
import br.edu.mymuseum.validacao.LimparCampos;
import br.edu.mymuseum.validacao.PreencherComboBoxGenerico;
import br.edu.mymuseum.validacao.Rotinas;
import br.edu.mymuseum.validacao.UltimaSequencia;
import br.edu.mymuseum.validacao.ValidaBotoes;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Dorga
 */
public class ObrasInterface extends javax.swing.JFrame {

    int situacao = Rotinas.INCLUIR;
    Obra obra = new Obra();
    DaoObra daoobra = new DaoObra();
    ValidaBotoes validabotoes = new ValidaBotoes();
    UltimaSequencia ultima;
    Pintura pintura = new Pintura();
    Escultura escultura = new Escultura();
    DaoEsculturaMaterial daoesculturamaterial = new DaoEsculturaMaterial();
    DaoAutor daoautor = new DaoAutor();
    DaoSalao daosalao = new DaoSalao();
    DaoMaterial daomaterial = new DaoMaterial();
    Material material = new Material();
    EsculturaMaterial esculturamaterial = new EsculturaMaterial();
    Salao salao = new Salao();
    Autor autor = new Autor();
    int sequencia = 0;
    LimparCampos limparcampos = new LimparCampos();
    PreencherComboBoxGenerico preenchecombo = new PreencherComboBoxGenerico();

    public ObrasInterface() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanelSala = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cd_salao = new javax.swing.JComboBox();
        jPanelAutor = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        cd_autor = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        cd_obra = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        tp_obra = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        ano_obra = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        ti_obra = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        Novo = new javax.swing.JButton();
        Alterar = new javax.swing.JButton();
        Gravar = new javax.swing.JButton();
        Excluir = new javax.swing.JButton();
        Cancelar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        ds_estilo = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        codmaterial = new javax.swing.JTextField();
        psmaterial = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanelSala.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel1.setText("Salão e Andar");

        cd_salao.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Escolha" }));

        javax.swing.GroupLayout jPanelSalaLayout = new javax.swing.GroupLayout(jPanelSala);
        jPanelSala.setLayout(jPanelSalaLayout);
        jPanelSalaLayout.setHorizontalGroup(
            jPanelSalaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelSalaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelSalaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(cd_salao, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(166, Short.MAX_VALUE))
        );
        jPanelSalaLayout.setVerticalGroup(
            jPanelSalaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelSalaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cd_salao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelAutor.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel2.setText("Autor");

        cd_autor.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Escolha" }));

        javax.swing.GroupLayout jPanelAutorLayout = new javax.swing.GroupLayout(jPanelAutor);
        jPanelAutor.setLayout(jPanelAutorLayout);
        jPanelAutorLayout.setHorizontalGroup(
            jPanelAutorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAutorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelAutorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelAutorLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(cd_autor, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanelAutorLayout.setVerticalGroup(
            jPanelAutorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAutorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cd_autor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jLabel3.setText("Codigo da Obra");
        jLabel3.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        cd_obra.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        cd_obra.setEnabled(false);

        jLabel4.setText("Tipo de Obra");

        tp_obra.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Escolha", "Pintura", "Escultura" }));
        tp_obra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tp_obraActionPerformed(evt);
            }
        });

        jLabel5.setText("Ano da Obra");

        jLabel6.setText("Titulo da Obra");

        Novo.setText("Novo");
        Novo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NovoActionPerformed(evt);
            }
        });

        Alterar.setText("Alterar");
        Alterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AlterarActionPerformed(evt);
            }
        });

        Gravar.setText("Gravar");
        Gravar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GravarActionPerformed(evt);
            }
        });

        Excluir.setText("Excluir");

        Cancelar.setText("Cancelar");
        Cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(Novo)
                .addGap(54, 54, 54)
                .addComponent(Alterar)
                .addGap(54, 54, 54)
                .addComponent(Gravar)
                .addGap(66, 66, 66)
                .addComponent(Excluir)
                .addGap(57, 57, 57)
                .addComponent(Cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(40, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(27, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Novo)
                    .addComponent(Alterar)
                    .addComponent(Gravar)
                    .addComponent(Excluir)
                    .addComponent(Cancelar))
                .addContainerGap())
        );

        jLabel7.setText("Estilo da Obra");
        jLabel7.setEnabled(false);

        ds_estilo.setEnabled(false);
        ds_estilo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ds_estiloActionPerformed(evt);
            }
        });

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Sel", "Codigo", "Material", "Quantidade"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Boolean.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable2.setEnabled(false);
        jTable2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTable2FocusLost(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);

        jButton1.setText("+");
        jButton1.setEnabled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("-");
        jButton2.setEnabled(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        codmaterial.setEnabled(false);
        codmaterial.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                codmaterialFocusLost(evt);
            }
        });

        psmaterial.setEnabled(false);
        psmaterial.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                psmaterialFocusLost(evt);
            }
        });

        jLabel8.setText("Código");
        jLabel8.setEnabled(false);

        jLabel9.setText("Quantidade");
        jLabel9.setEnabled(false);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jPanelSala, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanelAutor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(60, 60, 60)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(jLabel8)
                                        .addGap(23, 23, 23))
                                    .addComponent(jLabel9))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(psmaterial)
                                    .addComponent(codmaterial)
                                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 424, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(cd_obra, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(113, 113, 113)
                                        .addComponent(jLabel6))
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(ano_obra, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(61, 61, 61)
                                        .addComponent(ti_obra, javax.swing.GroupLayout.PREFERRED_SIZE, 419, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(tp_obra, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(203, 203, 203)
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel7)
                                            .addComponent(ds_estilo, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cd_obra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanelAutor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelSala, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tp_obra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ds_estilo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(codmaterial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(psmaterial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton2)
                            .addComponent(jButton1)))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ano_obra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ti_obra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(34, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Cadastro", jPanel1);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 656, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 509, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Consulta", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelarActionPerformed
        situacao = Rotinas.PADRÃO;
        validabotoes.ValidaEstado(jPanel3, situacao);
        limparcampos.LimparCampos(jPanel1);
        // TODO add your handling code here:
    }//GEN-LAST:event_CancelarActionPerformed

    private void GravarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GravarActionPerformed
        getcomp();
        daoobra.incluir(obra);
        if (tp_obra.getSelectedIndex() == 1) {            
            daoobra.incluir(pintura);
        } else if (tp_obra.getSelectedIndex() == 2) {
            daoobra.incluir(escultura);
           // daoesculturamaterial.gravar(esculturamaterial,Integer.parseInt(cd_obra.getText()),2);
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_GravarActionPerformed

    private void AlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AlterarActionPerformed
        situacao = Rotinas.ALTERAR;
        validabotoes.ValidaEstado(jPanel3, situacao);
        // TODO add your handling code here:
    }//GEN-LAST:event_AlterarActionPerformed

    private void NovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NovoActionPerformed
        situacao = Rotinas.INCLUIR;
        validabotoes.ValidaEstado(jPanel3, situacao);
        cd_obra.setEnabled(false);
        ultima = new UltimaSequencia();
        sequencia = (Integer) (ultima.ultimasequencia("OBRAS", "CD_OBRA"));
        cd_obra.setText(Integer.toString(sequencia));
        daoautor.consultaGeral(autor);
        preenchecombo.PreencherComboBoxGenerico(cd_autor, "NM_AUTOR", "CD_AUTOR", autor.getRetorno());
        daosalao.consultaGeral(salao);
        preenchecombo.PreencherComboBoxGenerico(cd_salao, "CD_ANDAR", "CD_SALAO", salao.getRetorno());

        // TODO add your handling code here:
    }//GEN-LAST:event_NovoActionPerformed

    private void tp_obraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tp_obraActionPerformed
        if (tp_obra.getSelectedIndex() == 1) {
            jLabel7.setEnabled(true);
            jLabel7.setText("Escolha o estilo da pintura");
            ds_estilo.setEnabled(true);
           

        } else if (tp_obra.getSelectedIndex() == 2) {
            jLabel7.setEnabled(true);
            jLabel7.setText("Peso Total da Escultura");
            ds_estilo.setEnabled(true);
            jTabbedPane1.setEnabled(true);
            codmaterial.setEnabled(true);
            psmaterial.setEnabled(true);
            jLabel8.setEnabled(true);
            jLabel9.setEnabled(true);
            jTable2.setEnabled(true);
            ds_estilo.setEnabled(false);

        } else {
            jLabel7.setEnabled(false);
            jLabel7.setText("Escolha o estilo da pintura");
            ds_estilo.setEnabled(false);
           

        }
        // TODO add your handling code here:
    }//GEN-LAST:event_tp_obraActionPerformed

    private void ds_estiloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ds_estiloActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ds_estiloActionPerformed

    private void codmaterialFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_codmaterialFocusLost
        // TODO add your handling code here:
        material.setCd_material(Integer.parseInt(codmaterial.getText()));
        daomaterial.consultaCodigo(material);
        try {
            material.getRetorno().first();
            if (material.getRetorno().getString("NM_MATERIA") != null) {
                esculturamaterial.setDs_material(material.getRetorno().getString("NM_MATERIA"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Insira um material válido");
            codmaterial.setText("");
        }

    }//GEN-LAST:event_codmaterialFocusLost

    private void jTable2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTable2FocusLost

        // TODO add your handling code here:
    }//GEN-LAST:event_jTable2FocusLost

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        esculturamaterial.setCd_obra(Integer.parseInt(cd_obra.getText()));
        esculturamaterial.setCd_material(Integer.parseInt(codmaterial.getText()));
        esculturamaterial.setTp_obra(2);
        esculturamaterial.setPs_material(Integer.parseInt(psmaterial.getText()));
        esculturamaterial.setTotal(Integer.parseInt(psmaterial.getText()));
        esculturamaterial.setTabela(jTable2);
        daoesculturamaterial.incluiritens(esculturamaterial);
        daoesculturamaterial.calcultatotal(esculturamaterial);
        ds_estilo.setText(Integer.toString(esculturamaterial.getTotal()));
        codmaterial.setText("");
        psmaterial.setText("");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void psmaterialFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_psmaterialFocusLost
        // TODO add your handling code here:
        if (!psmaterial.getText().equals("")){
            jButton1.setEnabled(true);
            jButton2.setEnabled(true);
        }else {
            jButton1.setEnabled(false);
            jButton2.setEnabled(false);
        }
    }//GEN-LAST:event_psmaterialFocusLost

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        daoesculturamaterial.excluiitens(esculturamaterial);
        daoesculturamaterial.calcultatotal(esculturamaterial);
        ds_estilo.setText(Integer.toString(esculturamaterial.getTotal()));
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ObrasInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ObrasInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ObrasInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ObrasInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ObrasInterface().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton Alterar;
    public javax.swing.JButton Cancelar;
    public javax.swing.JButton Excluir;
    public javax.swing.JButton Gravar;
    public javax.swing.JButton Novo;
    public javax.swing.JTextField ano_obra;
    public javax.swing.JComboBox cd_autor;
    public javax.swing.JTextField cd_obra;
    public javax.swing.JComboBox cd_salao;
    public javax.swing.JTextField codmaterial;
    public javax.swing.JTextField ds_estilo;
    public javax.swing.JButton jButton1;
    public javax.swing.JButton jButton2;
    public javax.swing.JLabel jLabel1;
    public javax.swing.JLabel jLabel2;
    public javax.swing.JLabel jLabel3;
    public javax.swing.JLabel jLabel4;
    public javax.swing.JLabel jLabel5;
    public javax.swing.JLabel jLabel6;
    public javax.swing.JLabel jLabel7;
    public javax.swing.JLabel jLabel8;
    public javax.swing.JLabel jLabel9;
    public javax.swing.JPanel jPanel1;
    public javax.swing.JPanel jPanel2;
    public javax.swing.JPanel jPanel3;
    public javax.swing.JPanel jPanel4;
    public javax.swing.JPanel jPanelAutor;
    public javax.swing.JPanel jPanelSala;
    public javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JScrollPane jScrollPane2;
    public javax.swing.JTabbedPane jTabbedPane1;
    public javax.swing.JTable jTable1;
    public javax.swing.JTable jTable2;
    public javax.swing.JTextField psmaterial;
    public javax.swing.JTextField ti_obra;
    public javax.swing.JComboBox tp_obra;
    // End of variables declaration//GEN-END:variables
    public void getcomp() {
        if (situacao == Rotinas.INCLUIR) {
            obra.setCd_obra(Integer.parseInt(cd_obra.getText()));
            obra.setAno_obra(Integer.parseInt(ano_obra.getText()));
            if (tp_obra.getSelectedIndex() == 1) {
                obra.setTp_obra(1);
                pintura.setCd_obra(Integer.parseInt(cd_obra.getText()));
                pintura.setTp_obra(1);
                pintura.setDs_estilo(ds_estilo.getText());
            } else if (tp_obra.getSelectedIndex() == 2) {
                obra.setTp_obra(2);
                escultura.setCd_obra(Integer.parseInt(cd_obra.getText()));
                escultura.setTp_obra(2);
                escultura.setTt_peso(Integer.parseInt(ds_estilo.getText()));

            } else {
                JOptionPane.showMessageDialog(null, "Escolha um tipo de obra!");
            }
            String autor = cd_autor.getSelectedItem().toString();
            String autor2[] = autor.split("-");
            obra.setCd_autor(Integer.parseInt(autor2[0].trim()));
            String salao = cd_salao.getSelectedItem().toString();
            String salao2[] = salao.split("-");
            obra.setCd_andar(Integer.parseInt(salao2[0].trim()));
            obra.setCd_salao(Integer.parseInt(salao2[1].trim()));
            obra.setTi_obra(ti_obra.getText());
        }
    }

}
