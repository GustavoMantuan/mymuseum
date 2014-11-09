/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.mymuseum.validacao;

import javax.print.event.PrintJobEvent;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author Dorga
 */
public class FormatarCampo {
    
    public void FormatarCampo(String maskFormat, JFormattedTextField jFormattedText, String validaCar){
        String numeros = "1234567890";
        String letras = "ABCDEFGHIJKLMNOPQRSTUVXWYZ";
        String numerosletras = "ABCDEFGHIJKLMNOPQRSTUVXWYZ1234567890abcdefghijklmnopqrstuvxwyz";
        try {
            MaskFormatter mf = new MaskFormatter(maskFormat);
            if (validaCar.equals("letras")){
                mf.setValidCharacters(letras);
            }
            if (validaCar.equals("numeros")){
                mf.setValidCharacters(numeros);
            }
            if (validaCar.equals("numerosletras")){
                mf.setValidCharacters(numerosletras);
            }
            mf.setPlaceholderCharacter(' ');
            mf.install(jFormattedText);
        } catch (Exception ex){
            JOptionPane.showMessageDialog(null, "Erro na conversao de dados no campo: "+ex,"Erro!",JOptionPane.ERROR_MESSAGE);
        }
    }
    
}
