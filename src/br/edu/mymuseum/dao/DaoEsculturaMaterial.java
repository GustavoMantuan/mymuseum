package br.edu.mymuseum.dao;


import br.edu.mymuseum.classe.EsculturaMaterial;

import br.edu.mymuseum.conexao.ConexaoOracle;


/**
 *
 * @author Dorga
 */
public class DaoEsculturaMaterial {

    ConexaoOracle conecta_oracle;
    

    public DaoEsculturaMaterial() {
        conecta_oracle = new ConexaoOracle();
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
