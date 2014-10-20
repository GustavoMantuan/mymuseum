/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.mymuseum.classe;

import java.sql.ResultSet;
import javax.swing.JTable;

/**
 *
 * @author Dorga
 */
public class EsculturaMaterial {
    private int cd_material;
    private int cd_obra;
    private int tp_obra;
    private int ps_material;
    private String ds_material;
    private int[] inserir;
    private ResultSet retorno;
    private int total;
    private JTable tabela;
    

    public int getCd_material() {
        return cd_material;
    }

    public void setCd_material(int cd_material) {
        this.cd_material = cd_material;
    }

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

    public int getPs_material() {
        return ps_material;
    }

    public void setPs_material(int ps_material) {
        this.ps_material = ps_material;
    }

    public ResultSet getRetorno() {
        return retorno;
    }

    public void setRetorno(ResultSet retorno) {
        this.retorno = retorno;
    }

    public int[] getInserir() {
        return inserir;
    }

    public void setInserir(int[] inserir) {
        this.inserir = inserir;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {        
        this.total = total;
    }

    public JTable getTabela() {
        return tabela;
    }

    public void setTabela(JTable tabela) {
        this.tabela = tabela;
    }

    public String getDs_material() {
        return ds_material;
    }

    public void setDs_material(String ds_material) {
        this.ds_material = ds_material;
    }
    
}
