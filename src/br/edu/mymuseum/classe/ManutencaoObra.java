/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.mymuseum.classe;

/**
 *
 * @author Dorga
 */
public class ManutencaoObra {
    private int cd_funcionario;
    private int cd_obra;
    private int tp_obra;
    private String dt_inicio;
    private String dt_final;
    private String ds_servico;
    private Double custo;

    public int getCd_funcionario() {
        return cd_funcionario;
    }

    public void setCd_funcionario(int cd_funcionario) {
        this.cd_funcionario = cd_funcionario;
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

    public String getDt_inicio() {
        return dt_inicio;
    }

    public void setDt_inicio(String dt_inicio) {
        this.dt_inicio = dt_inicio;
    }

    public String getDt_final() {
        return dt_final;
    }

    public void setDt_final(String dt_final) {
        this.dt_final = dt_final;
    }

    public String getDs_servico() {
        return ds_servico;
    }

    public void setDs_servico(String ds_servico) {
        this.ds_servico = ds_servico;
    }

    public Double getCusto() {
        return custo;
    }

    public void setCusto(Double custo) {
        this.custo = custo;
    }
}
