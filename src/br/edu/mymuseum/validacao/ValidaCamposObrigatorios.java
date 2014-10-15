package br.edu.mymuseum.validacao;

import javax.swing.JOptionPane;
import br.edu.mymuseum.conexao.ConexaoOracle;
import java.awt.Component;
import java.awt.Container;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JTextField;

/**
 *
 * @author ads
 */
public class ValidaCamposObrigatorios {

    ConexaoOracle conecta_oracle = new ConexaoOracle();
    public ResultSetMetaData metaData;

    public int validacamposobrigatorios(Container container, String tabela) {
        int retorno = 0;
        ArrayList obrigatorios = new ArrayList();
        conecta_oracle.executeSQL("SELECT * FROM " + tabela + " WHERE ROWNUM = 1");
        try {
            metaData = conecta_oracle.resultset.getMetaData();
            int conta = metaData.getColumnCount();
            //JOptionPane.showMessageDialog(null," "+ conta);
            for (int i = 1; i <= conta; i++) {
                int situacao = metaData.isNullable(i);
                if (situacao == 0) {
                    
                    obrigatorios.add(metaData.getColumnName(i));
                    //String atributo = metaData.getColumnName(i);
                }
            }
            Component components[] = container.getComponents();
            for (Component component : components) {
                if (component instanceof JTextField) {                   
                    JTextField field = (JTextField) component;
                    String nome = field.getName();
                    String texto = field.getToolTipText();
                   
                    if (field.isEnabled()) {
                        
                        if (obrigatorios.contains(nome)) {
                           
                            String conteudo = field.getText();
                            if (conteudo.equals("")) {
                                JOptionPane.showMessageDialog(null, "O Campo " + texto + " eh obrigatorio");
                                field.requestFocus();
                                retorno = 1;
                                break;
                            }
                        }
                    }
                }
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "erro na classe de validar campos" + ex);
        }

        return retorno;
    }
}
