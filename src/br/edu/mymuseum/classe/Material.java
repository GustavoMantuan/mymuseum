/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.mymuseum.classe;

import java.sql.ResultSet;

/**
 *
 * @author Dorga
 */
public class Material {
    private int cd_material;
    private String nm_materia;
    private Double qt_estoque;
    private ResultSet retorno;

    public int getCd_material() {
        return cd_material;
    }

    public void setCd_material(int cd_material) {
        this.cd_material = cd_material;
    }

    public String getNm_materia() {
        return nm_materia;
    }

    public void setNm_materia(String nm_materia) {
        this.nm_materia = nm_materia;
    }

    public Double getQt_estoque() {
        return qt_estoque;
    }

    public void setQt_estoque(Double qt_estoque) {
        this.qt_estoque = qt_estoque;
    }

    public ResultSet getRetorno() {
        return retorno;
    }

    public void setRetorno(ResultSet retorno) {
        this.retorno = retorno;
    }
    
}
