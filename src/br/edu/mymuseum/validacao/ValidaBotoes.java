package br.edu.mymuseum.validacao;

import java.awt.Component;
import java.awt.Container;
import javax.swing.JButton;

/**
 *
 * @author ads
 */
public class ValidaBotoes {

    public void ValidaEstado(Container container, int estado) {
        Component components[] = container.getComponents();
        for (Component component : components) {
            if (component instanceof JButton) {
                JButton field = (JButton) component;
                String texto = field.getText();
                if ((estado == Rotinas.INCLUIR) || (estado == Rotinas.ALTERAR)) {
                    if (texto.equals("Novo") || (texto.equals("Alterar")) || (texto.equals("Excluir"))) {
                        field.setEnabled(false);
                    } else {
                        field.setEnabled(true);
                    }
                } else if (estado == Rotinas.PADRÃO) {
                    
                    if (texto.equals("Novo") || (texto.equals("Alterar")) || (texto.equals("Excluir"))) {
                        field.setEnabled(true);
                    } else {
                        field.setEnabled(false);
                    }
                } else if (estado == Rotinas.EXCLUIR) {
                    if (texto.equals("Excluir")) {
                        field.setEnabled(true);
                    } else {
                        field.setEnabled(false);
                    }
                }
            }
        }
    }
}
