package br.edu.mymuseum.dao;

import br.edu.mymuseum.classe.EsculturaMaterial;
import br.edu.mymuseum.classe.Material;

import br.edu.mymuseum.conexao.ConexaoOracle;
import br.edu.mymuseum.validacao.PreencherJtableGenerico;
import br.edu.mymuseum.validacao.UltimaSequencia;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Dorga
 */
public class DaoEsculturaMaterial {

    ConexaoOracle conecta_oracle;
    PreencherJtableGenerico pj = new PreencherJtableGenerico();

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
            int cd_item = Integer.parseInt(escultura.getTabela().getValueAt(conta, 1).toString());
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
            TabelaItem.setValueAt(escultura.getPs_material(), linha, 3);
        }
//
//        escultura.setVl_total_item(escultura.getVl_item() * escultura.getQt_item());
//        calcultatotal(escultura);

    }

    public void excluiitens(EsculturaMaterial classe) {
        DefaultTableModel tabela = (DefaultTableModel) classe.getTabela().getModel();
        int totlinha = tabela.getRowCount();
        Boolean sel = false;

        int opcao = JOptionPane.showConfirmDialog(null, "Deseja Excluir o item?", "Excluir", JOptionPane.YES_NO_OPTION);
        if (opcao == JOptionPane.YES_OPTION) {
            for (int i = totlinha - 1; i >= 0; i--) {
                Boolean selecionado = (Boolean) tabela.getValueAt(i, 0);
                if (selecionado == true) {
                    sel = true;
                    tabela.removeRow(i);

                }
            }
            if (sel == false) {
                JOptionPane.showMessageDialog(null, "Não tem nada selecionado!");
            }
        }

    }

    public void calcultatotal(EsculturaMaterial classe) {
        int totlinha = classe.getTabela().getRowCount();

        int total = 0;
        for (int i = 0; i < totlinha; i++) {
            int valor = Integer.parseInt(classe.getTabela().getValueAt(i, 3).toString());
            total += valor;
        }
        classe.setTotal(total);
        System.out.println(total);
    }

    public void gravar(EsculturaMaterial escultura, int cd_obra, int tp_obra) {
        DefaultTableModel TabelaItem = (DefaultTableModel) escultura.getTabela().getModel();
        int totalinha = escultura.getTabela().getRowCount();
        int conta = 0;
        int linha = 0;

        for (int i = 0; i < totalinha; i++) {
            escultura.setCd_obra(cd_obra);
            escultura.setTp_obra(tp_obra);
            escultura.setCd_material(Integer.parseInt(TabelaItem.getValueAt(i, 1).toString()));
            escultura.setPs_material(Integer.parseInt(TabelaItem.getValueAt(i, 3).toString()));
            incluir(escultura);
        }

    }
    

    public void incluir(EsculturaMaterial escultura) {
        UltimaSequencia ultima = new UltimaSequencia();
        try {
            int ult = ultima.ultimasequencia("ESCULTURA_MATERIAIS", "CD_ESMA");
            conecta_oracle.incluirSQL("INSERT INTO ESCULTURA_MATERIAIS (CD_MATERIAL,CD_OBRA,TP_OBRA,PS_MATERIAL,CD_ESMA) VALUES ("
                    + escultura.getCd_material()
                    + ", " + escultura.getCd_obra()
                    + ", " + escultura.getTp_obra()
                    + ", " + escultura.getPs_material()
                    + ", " + ult
                    + ")"
            );
        } catch (Exception e) {
        }
    }

    public void consultaCodigo(EsculturaMaterial escultura_material) {
        conecta_oracle.executeSQL("SELECT em.CD_MATERIAL as CD,em.PS_MATERIAL as PESO, m.NM_MATERIA AS MATERIAL FROM ESCULTURA_MATERIAIS em INNER JOIN MATERIAL m on (m.CD_MATERIAL = em.CD_MATERIAL) WHERE CD_OBRA = " + escultura_material.getCd_obra() + " AND TP_OBRA = " + escultura_material.getTp_obra());
        escultura_material.setRetorno(conecta_oracle.resultset);
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
