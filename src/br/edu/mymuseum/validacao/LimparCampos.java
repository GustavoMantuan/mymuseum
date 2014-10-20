package br.edu.mymuseum.validacao;

import java.awt.Component;
import java.awt.Container;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ads
 */
public class LimparCampos {

    public void LimparCampos(Container container) {
        Component components[] = container.getComponents();
        for (Component component : components) {
            if (component instanceof JTextField) {
                JTextField texto = (JTextField) component;
                texto.setText("");}
//            else if ((component instanceof JComboBox)) {
//                JComboBox combo = (JComboBox) component;
//                combo.removeAllItems();
//            }
            
            else if (component instanceof JScrollPane){
            
               JScrollPane table = (JScrollPane) component;
               
               
            }
            System.out.println(component);
        }
    }

}
