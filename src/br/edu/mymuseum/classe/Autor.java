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
public class Autor {
    private int cd_autor;
    private String nm_autor;
    private String nc_autor;
    private ResultSet retorno;

    public int getCd_autor() {
        return cd_autor;
    }

    public void setCd_autor(int cd_autor) {
        this.cd_autor = cd_autor;
    }

    public String getNm_autor() {
        return nm_autor;
    }

    public void setNm_autor(String nm_autor) {
        this.nm_autor = nm_autor;
    }

    public String getNc_autor() {
        return nc_autor;
    }

    public void setNc_autor(String nc_autor) {
        this.nc_autor = nc_autor;
    }

    /**
     * @return the retorno
     */
    public ResultSet getRetorno() {
        return retorno;
    }

    /**
     * @param retorno the retorno to set
     */
    public void setRetorno(ResultSet retorno) {
        this.retorno = retorno;
    }
}
