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
public class Obra {
       private int cd_obra;
       private int tp_obra;
       private int cd_autor;
       private int cd_andar;
       private int cd_salao;
       private String ti_obra;
       private int ano_obra;

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

    public int getCd_autor() {
        return cd_autor;
    }

    public void setCd_autor(int cd_autor) {
        this.cd_autor = cd_autor;
    }

    public int getCd_andar() {
        return cd_andar;
    }

    public void setCd_andar(int cd_andar) {
        this.cd_andar = cd_andar;
    }

    public int getCd_salao() {
        return cd_salao;
    }

    public void setCd_salao(int cd_salao) {
        this.cd_salao = cd_salao;
    }

    public String getTi_obra() {
        return ti_obra;
    }

    public void setTi_obra(String ti_obra) {
        this.ti_obra = ti_obra;
    }

    public int getAno_obra() {
        return ano_obra;
    }

    public void setAno_obra(int ano_obra) {
        this.ano_obra = ano_obra;
    }
       
    
}
