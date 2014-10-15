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
public class Pintura {
    private int cd_obra;
    private int tp_obra;
    private String ds_estilo;
    private ResultSet retorno;

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

    public String getDs_estilo() {
        return ds_estilo;
    }

    public void setDs_estilo(String ds_estilo) {
        this.ds_estilo = ds_estilo;
    }

    public ResultSet getRetorno() {
        return retorno;
    }

    public void setRetorno(ResultSet retorno) {
        this.retorno = retorno;
    }
    
}
