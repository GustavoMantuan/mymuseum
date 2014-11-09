/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.mymuseum.validacao;


import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author ads
 */
public class PreencherJtableGenerico {

    public void FormatarJtable(JTable tabela, int valores[]) {
        DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();
        modelo.setNumRows(0);
        if (modelo.getColumnCount() == valores.length) {
            for (int x = 0; x < valores.length; x++) {
                tabela.getColumnModel().getColumn(x).setPreferredWidth(valores[x]);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Favor verificar os parametros passados !");
        }

    }

    public void PreencherJtableGenerico(JTable tabela, String campos[], ResultSet resultSet) {
        DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();
        
        modelo.setNumRows(0);
        try {
            while (resultSet.next()) {
                int len = campos.length;
                Object[] row = new Object[len];
                for (int i = 0; i < len; i++) {
                    row[i] = resultSet.getString(campos[i]);
                }
                modelo.addRow(row);
            }
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Não foi possivel preencher " + erro);
        }
    }
    
    public void limparJtable(JTable table){
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setNumRows(0);
    }
     public void PreencherJtableGenericoSel(JTable tabela, String campos[], ResultSet resultSet) {
        DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();
        modelo.setNumRows(0);
        try {
            while (resultSet.next()) {
                int len = campos.length;
                Object[] row = new Object[len+1];
                for (int i = 0; i < len; i++) {
                    if (i == 0) {
                       row[i] = false; 
                    } else {
                    row[i] = resultSet.getString(campos[i]);
                }
                }
                modelo.addRow(row);
            }
                } catch (SQLException erro) {
                    JOptionPane.showMessageDialog(null, "Erro ao listar no JTable " + erro);
            }
        }
}
