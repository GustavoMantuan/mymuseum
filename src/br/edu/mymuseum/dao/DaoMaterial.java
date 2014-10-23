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
        conecta_oracle.atualizarSQL("UPDATE MATERIAL SET NM_MATERIA = '" + pessoa.getNm_materia()
                + "', QT_ESTOQUE = " + pessoa.getQt_estoque()
                + "  WHERE CD_MATERIAL = " + pessoa.getCd_material()
        );
    }

    public void excluir(Material pessoa) {
        conecta_oracle.deleteSQL("DELETE FROM MATERIAL WHERE CD_MATERIAL = " + pessoa.getCd_material());
    }
    public void retornardados(Material material) {
        conecta_oracle.executeSQL("SELECT * FROM MATERIAL WHERE CD_MATERIAL = " + material.getCd_material());
        try {
            conecta_oracle.resultset.first();
            material.setCd_material(conecta_oracle.resultset.getInt("CD_MATERIAL"));
            material.setNm_materia(conecta_oracle.resultset.getString("NM_MATERIA"));
            material.setQt_estoque(conecta_oracle.resultset.getDouble("QT_ESTOQUE"));
            
        } catch (Exception e) {
        }
    }

    public void consultaGeral(Material pessoa) {
        conecta_oracle.executeSQL("SELECT * FROM MATERIAL");
        pessoa.setRetorno(conecta_oracle.resultset);
    }
//
    public void consultaCodigo(Material pessoa) {
        conecta_oracle.executeSQL("SELECT * FROM MATERIAL WHERE CD_MATERIAL = " + pessoa.getCd_material());
        pessoa.setRetorno(conecta_oracle.resultset);
    }

    public void consultaMaterial(Material pessoa) {
        conecta_oracle.executeSQL("SELECT * FROM MATERIAL WHERE NM_MATERIAL LIKE '%" + pessoa.getNm_materia()+ "%'");
        pessoa.setRetorno(conecta_oracle.resultset);
    }
}
