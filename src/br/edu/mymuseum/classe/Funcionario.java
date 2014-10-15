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
public class Funcionario {
    
private int cd_funcionario;
private int tp_funcinario;
private String nm_funcionario;
private Double sl_funcionario;
private Long cpf;

    public int getCd_funcionario() {
        return cd_funcionario;
    }

    public void setCd_funcionario(int cd_funcionario) {
        this.cd_funcionario = cd_funcionario;
    }

    public int getTp_funcinario() {
        return tp_funcinario;
    }

    public void setTp_funcinario(int tp_funcinario) {
        this.tp_funcinario = tp_funcinario;
    }

    public String getNm_funcionario() {
        return nm_funcionario;
    }

    public void setNm_funcionario(String nm_funcionario) {
        this.nm_funcionario = nm_funcionario;
    }

    public Double getSl_funcionario() {
        return sl_funcionario;
    }

    public void setSl_funcionario(Double sl_funcionario) {
        this.sl_funcionario = sl_funcionario;
    }

    public Long getCpf() {
        return cpf;
    }

    public void setCpf(Long cpf) {
        this.cpf = cpf;
    }
}
