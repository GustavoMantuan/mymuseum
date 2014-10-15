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
public class Salao {
    private int cd_salao;
    private int cd_andar;
    private ResultSet retorno;

    public int getCd_salao() {
        return cd_salao;
    }

    public void setCd_salao(int cd_salao) {
        this.cd_salao = cd_salao;
    }

    public int getCd_andar() {
        return cd_andar;
    }

    public void setCd_andar(int cd_andar) {
        this.cd_andar = cd_andar;
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
