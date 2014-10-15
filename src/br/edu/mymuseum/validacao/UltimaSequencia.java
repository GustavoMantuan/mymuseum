/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.mymuseum.validacao;

import br.edu.mymuseum.conexao.ConexaoOracle;
import static br.edu.mymuseum.conexao.ConexaoOracle.*;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author ads
 */
public class UltimaSequencia {

    ConexaoOracle con = new ConexaoOracle();

    public int ultimasequencia(String tabela, String atributo) {
        con.executeSQL("SELECT COALESCE(MAX(" + atributo + "),0)+1 AS ULTIMO FROM " + tabela);
        try {
            resultset.first();
            return resultset.getInt("ULTIMO");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Resultado nao encontrado");
            return 0;
        }
    }
}
