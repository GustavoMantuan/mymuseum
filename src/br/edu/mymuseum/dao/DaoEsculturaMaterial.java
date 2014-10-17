package br.edu.mymuseum.dao;

import br.edu.mymuseum.classe.EsculturaMaterial;

import br.edu.mymuseum.conexao.ConexaoOracle;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Dorga
 */
public class DaoEsculturaMaterial {

    ConexaoOracle conecta_oracle;

    public DaoEsculturaMaterial() {
        conecta_oracle = new ConexaoOracle();
    }

    public void incluiritens(EsculturaMaterial escultura) {
         DefaultTableModel TabelaItem = (DefaultTableModel) escultura.getTabela().getModel();
        double soma = 0;
        int totalinha = escultura.getTabela().getRowCount();
        int alterar = 0;
        int conta = 0;
        int linha = 0;
        for (int i = 1; i <= totalinha; i++) {
            Integer cd_item = (Integer) escultura.getTabela().getValueAt(conta, 2);
            if (escultura.getCd_material() == cd_item) {
                int opcao = JOptionPane.showConfirmDialog(null, "Material já cadastrado, deseja alterar?", "Alteração", JOptionPane.YES_NO_OPTION);
                if (opcao == JOptionPane.YES_OPTION) {
                    alterar = 1;
                    linha = conta;
                } else {
                    return;
                }
            }
            conta += 1;
        }
        if (alterar == 0) {
            TabelaItem.setNumRows(totalinha + 1);
            TabelaItem.setValueAt((false), totalinha, 0);
            TabelaItem.setValueAt(escultura.getCd_material(), totalinha, 1);
            TabelaItem.setValueAt(escultura.getDs_material(), totalinha, 2);
            TabelaItem.setValueAt(escultura.getPs_material(), totalinha, 3);
           
        } else if (alterar == 1) {
            TabelaItem.setValueAt(escultura.getPs_material(), linha, 4);
        }
//
//        escultura.setVl_total_item(escultura.getVl_item() * escultura.getQt_item());
//        calcultatotal(escultura);
        
    }
    
    public void gravar(EsculturaMaterial escultura,int cd_obra,int tp_obra){
        
    }

    public void incluir(EsculturaMaterial pessoa) {

        try {
            conecta_oracle.incluirSQL("INSERT INTO ESCULTURA_MATERIAIS (CD_MATERIAL,CD_OBRA,TP_OBRA,PS_MATERIAL) VALUES ("
                    + pessoa.getCd_material()
                    + ", " + pessoa.getCd_obra()
                    + ", " + pessoa.getTp_obra()
                    + ", " + pessoa.getPs_material()
                    + ")"
            );
        } catch (Exception e) {
        }
    }

    public void alterar(EsculturaMaterial pessoa) {
        conecta_oracle.atualizarSQL("UPDATE ESCULTURA_MATERIAIS SET cd_material = " + pessoa.getCd_material()
                + ", PS_MATERIAL = '" + pessoa.getPs_material()
                + "  WHERE CD_OBRA = " + pessoa.getCd_obra()
                + " AND TP_OBRA = " + pessoa.getTp_obra()
        );
    }

    public void excluir(EsculturaMaterial pessoa) {
        conecta_oracle.deleteSQL("DELETE FROM ESCULTURA_MATERIAIS WHERE CD_OBRA = " + pessoa.getCd_obra() + "AND TP_OBRA = " + pessoa.getTp_obra());
    }
//    public void retornardados(Funcionario pessoa) {
//        conecta_oracle.executeSQL("SELECT * FROM CAD_PESSOA WHERE CD_PESSOA = " + pessoa.getCd_pessoa());
//        try {
//            conecta_oracle.resultset.first();
//            pessoa.setCd_pessoa(conecta_oracle.resultset.getInt("CD_PESSOA"));
//            pessoa.setDs_pessoa(conecta_oracle.resultset.getString("DS_PESSOA"));
//            pessoa.setIn_ativo(conecta_oracle.resultset.getString("IN_ATIVO"));
//            pessoa.setDt_cadastro(conecta_oracle.resultset.getString("DT_CADASTRO"));
//          
//        } catch (Exception e) {
//        }
//    }

//    public void consultaGeral(Pessoa pessoa) {
//        conecta_oracle.executeSQL("SELECT * FROM CAD_PESSOA");
//        pessoa.setRetorno(conecta_oracle.resultset);
//    }
//
//    public void consultaCodigo(Material pessoa) {
//        conecta_oracle.executeSQL("SELECT * FROM MATERIAL WHERE CD_MATERIAL = " + pessoa.getCd_material());
//        pessoa.setRetorno(conecta_oracle.resultset);
//    }
//
//    public void consultaPessoa(Pessoa pessoa) {
//        conecta_oracle.executeSQL("SELECT * FROM CAD_PESSOA WHERE DS_PESSOA LIKE '%" + pessoa.getDs_pessoa()+ "%'");
//        pessoa.setRetorno(conecta_oracle.resultset);
//    }
}
