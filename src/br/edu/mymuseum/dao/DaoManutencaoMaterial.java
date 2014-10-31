package br.edu.mymuseum.dao;

import br.edu.mymuseum.classe.EsculturaMaterial;
import br.edu.mymuseum.classe.ManutencaoMaterial;
import br.edu.mymuseum.classe.Obra;

import br.edu.mymuseum.conexao.ConexaoOracle;
import br.edu.mymuseum.validacao.UltimaSequencia;
import java.sql.CallableStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Dorga
 */
public class DaoManutencaoMaterial {

    ConexaoOracle conecta_oracle;

    public DaoManutencaoMaterial() {
        conecta_oracle = new ConexaoOracle();
    }

    public void incluiritens(ManutencaoMaterial escultura) {
        DefaultTableModel TabelaItem = (DefaultTableModel) escultura.getTabela().getModel();
        double soma = 0;
        int totalinha = escultura.getTabela().getRowCount();
        int alterar = 0;
        int conta = 0;
        int linha = 0;
        for (int i = 1; i <= totalinha; i++) {
            Integer cd_item = (Integer) escultura.getTabela().getValueAt(conta, 1);
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
            TabelaItem.setValueAt(escultura.getQt_material(), totalinha, 3);
            TabelaItem.setValueAt(escultura.getCd_obra(), totalinha, 4);
            TabelaItem.setValueAt(escultura.getTp_obra(), totalinha, 5);
        } else if (alterar == 1) {
            TabelaItem.setValueAt(escultura.getQt_material(), linha, 3);
        }
//
//        escultura.setVl_total_item(escultura.getVl_item() * escultura.getQt_item());
//        calcultatotal(escultura);

    }

    public void excluiitens(ManutencaoMaterial classe) {
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
            int valor = (Integer) classe.getTabela().getValueAt(i, 3);
            total += valor;
        }
        classe.setTotal(total);
        System.out.println(total);
    }

    public void grava_itens(ManutencaoMaterial obra) {
        DefaultTableModel TabelaItem = (DefaultTableModel) obra.getTabela().getModel();
        int totalinha = obra.getTabela().getRowCount();
        for (int i = 0; i < totalinha; i++) {
            obra.setCd_material(Integer.parseInt(TabelaItem.getValueAt(i, 1).toString()));
            obra.setQt_material(Integer.parseInt(TabelaItem.getValueAt(i, 3).toString()));
            obra.setCd_obra(Integer.parseInt(TabelaItem.getValueAt(i, 4).toString()));
            obra.setTp_obra(Integer.parseInt(TabelaItem.getValueAt(i, 5).toString()));
            incluir(obra);
            CallableStatement cs;
            try {
                cs = ConexaoOracle.conecta().prepareCall("{call ATUALIZA_ESTOQUE_MATERIAL (?, ?)}");
                cs.setInt(1, obra.getCd_material());
                cs.setInt(2, obra.getQt_material());
                cs.execute();
            } catch (SQLException ex) {
                Logger.getLogger(DaoManutencaoMaterial.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

    public void incluir(ManutencaoMaterial escultura) {

        try {

            conecta_oracle.incluirSQL("INSERT INTO MANUTENCAO_MATERIAL (CD_MATERIAL,CD_OBRA,TP_OBRA,DT_INICIO,QT_MATERIAL) VALUES ("
                    + escultura.getCd_material()
                    + ", " + escultura.getCd_obra()
                    + ", " + escultura.getTp_obra()
                    + ", '" + escultura.getDt_inicio()
                    + "', " + escultura.getQt_material()
                    + ")"
            );
        } catch (Exception e) {
        }
    }

    public void alterar(ManutencaoMaterial pessoa) {
        conecta_oracle.atualizarSQL("UPDATE MANUTENCAO_MATERIAL SET cd_material = " + pessoa.getCd_material()
                + ", PS_MATERIAL = '" + pessoa.getQt_material()
                + "  WHERE CD_OBRA = " + pessoa.getCd_obra()
                + " AND TP_OBRA = " + pessoa.getTp_obra()
                + " AND DT_INICIO = " + pessoa.getDt_inicio()
        );
    }

    public void excluir(ManutencaoMaterial pessoa) {
        conecta_oracle.deleteSQL("DELETE FROM MANUTENCAO_MATERIAL WHERE CD_OBRA = " + pessoa.getCd_obra() + "AND TP_OBRA = " + pessoa.getTp_obra());
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
