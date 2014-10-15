package br.edu.mymuseum.validacao;



import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;


/**
 *
 * @author ads
 */
public class PreencherComboBoxGenerico {

    

//    public void PreencherComboBoxGenerico(JComboBox combo, String campo, ResultSet retorno, String atributo_array, ClasseCidade cidade) {
//        DefaultComboBoxModel modelo = (DefaultComboBoxModel) combo.getModel();
//        combo.removeAllItems();
//        int cont = 0;
//        try {
//            retorno.last();
//            int[] array_cor = new int[retorno.getRow()];
//            retorno.first();
//            combo.addItem(retorno.getString(campo));
//            while (retorno.next()) {
//                combo.addItem(retorno.getString(campo));
//                array_cor[cont] = retorno.getInt(atributo_array);
//                cont++;
//            }
//            cidade.setArray_cidade(array_cor);
//        } catch (SQLException e) {
//            JOptionPane.showMessageDialog(null, "Dados não encontrados!");
//        }
//    }

    public void PreencherComboBoxGenerico(JComboBox combo, String campo, String chave, ResultSet retorno) {
        DefaultComboBoxModel modelo = (DefaultComboBoxModel) combo.getModel();
        combo.removeAllItems();

        try {
            while (retorno.next()) {
                combo.addItem(retorno.getString(chave) + " - " + retorno.getString(campo));
                //cdcidade.add(retorno.getString(campo) + "-" +retorno.getInt(chave));

            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Dados não Encontrados");
        }
        combo.addItem("Escolha");
       
    }

}
