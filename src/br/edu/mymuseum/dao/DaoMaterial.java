package br.edu.mymuseum.dao;


import br.edu.mymuseum.classe.Material;

import br.edu.mymuseum.conexao.ConexaoOracle;
import br.edu.mymuseum.validacao.UltimaSequencia;

/**
 *
 * @author Dorga
 */
public class DaoMaterial {

    ConexaoOracle conecta_oracle;
    UltimaSequencia ultima;

    public DaoMaterial() {
        conecta_oracle = new ConexaoOracle();
    }

    public void incluir(Material pessoa) {

        try {
            conecta_oracle.incluirSQL("INSERT INTO MATERIAL (CD_MATERIAL,NM_MATERIA,QT_ESTOQUE) VALUES ("
                    + pessoa.getCd_material()
                    + ", '" + pessoa.getNm_materia()
                    + "', " + pessoa.getQt_estoque()
                    
                    + ")"
            );
        } catch (Exception e) {
        }
    }

   

    public void alterar(Material pessoa) {
        conecta_oracle.atualizarSQL("UPDATE MATERIAL SET NM_MATERIAL = '" + pessoa.getNm_materia()
                + ", QT_ESTOQUE = '" + pessoa.getQt_estoque()
                + "  WHERE CD_MATERIAL = " + pessoa.getCd_material()
        );
    }

    public void excluir(Material pessoa) {
        conecta_oracle.deleteSQL("DELETE FROM MATERIAL WHERE CD_MATERIAL = " + pessoa.getCd_material());
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
    public void consultaCodigo(Material pessoa) {
        conecta_oracle.executeSQL("SELECT * FROM MATERIAL WHERE CD_MATERIAL = " + pessoa.getCd_material());
        pessoa.setRetorno(conecta_oracle.resultset);
    }
//
//    public void consultaPessoa(Pessoa pessoa) {
//        conecta_oracle.executeSQL("SELECT * FROM CAD_PESSOA WHERE DS_PESSOA LIKE '%" + pessoa.getDs_pessoa()+ "%'");
//        pessoa.setRetorno(conecta_oracle.resultset);
//    }
}
