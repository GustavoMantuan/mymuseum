/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.mymuseum.classe;

import javax.swing.JTable;

/**
 *
 * @author Dorga
 */
public class ManutencaoMaterial {
    private int cd_obra;
    private int tp_obra;
    private int cd_material;
    private int qt_material; 
    private String ds_material;
    private JTable tabela;

    public int getCd_obra() {
        return cd_obra;
    }

    public void setCd_obra(int cd_obra) {
        this.cd_obra = cd_obra;
    }

    public int getTp_obra() {
        return tp_obra;
    }

    public void setTp_obra(int tp_obra) {
        this.tp_obra = tp_obra;
    }

    public int getCd_material() {
        return cd_material;
    }

    public void setCd_material(int cd_material) {
        this.cd_material = cd_material;
    }

    public int getQt_material() {
        return qt_material;
    }

    public void setQt_material(int qt_material) {
        this.qt_material = qt_material;
    }

    public String getDs_material() {
        return ds_material;
    }

    public void setDs_material(String ds_material) {
        this.ds_material = ds_material;
    }

    public JTable getTabela() {
        return tabela;
    }

    public void setTabela(JTable tabela) {
        this.tabela = tabela;
    }
}
