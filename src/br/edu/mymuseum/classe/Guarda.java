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
public class Guarda {
    private int cd_funcionario;
    private int cd_andar;
    private int cd_salao;
    private String hr_entrada;
    private String hr_saida;
    private ResultSet retorno;

    /**
     * @return the cd_funcionario
     */
    public int getCd_funcionario() {
        return cd_funcionario;
    }

    /**
     * @param cd_funcionario the cd_funcionario to set
     */
    public void setCd_funcionario(int cd_funcionario) {
        this.cd_funcionario = cd_funcionario;
    }

    /**
     * @return the cd_andar
     */
    public int getCd_andar() {
        return cd_andar;
    }

    /**
     * @param cd_andar the cd_andar to set
     */
    public void setCd_andar(int cd_andar) {
        this.cd_andar = cd_andar;
    }

    /**
     * @return the cd_salao
     */
    public int getCd_salao() {
        return cd_salao;
    }

    /**
     * @param cd_salao the cd_salao to set
     */
    public void setCd_salao(int cd_salao) {
        this.cd_salao = cd_salao;
    }

    /**
     * @return the hr_entrada
     */
    public String getHr_entrada() {
        return hr_entrada;
    }

    /**
     * @param hr_entrada the hr_entrada to set
     */
    public void setHr_entrada(String hr_entrada) {
        this.hr_entrada = hr_entrada;
    }

    /**
     * @return the hr_saida
     */
    public String getHr_saida() {
        return hr_saida;
    }

    /**
     * @param hr_saida the hr_saida to set
     */
    public void setHr_saida(String hr_saida) {
        this.hr_saida = hr_saida;
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
