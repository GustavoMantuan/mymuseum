package br.edu.mymuseum.dao;


import br.edu.mymuseum.classe.Autor;

import br.edu.mymuseum.conexao.ConexaoOracle;
import br.edu.mymuseum.validacao.UltimaSequencia;
import java.sql.ResultSet;
import javax.swing.JComboBox;

/**
 *
 * @author Dorga
 */
public class DaoAutor {

    ConexaoOracle conecta_oracle;
    UltimaSequencia ultima;

    public DaoAutor() {
        conecta_oracle = new ConexaoOracle();
    }

    public void incluir(Autor pessoa) {

        try {
            conecta_oracle.incluirSQL("INSERT INTO AUTORES (CD_AUTOR,NM_AUTOR,NC_AUTOR) VALUES ("
                    + pessoa.getCd_autor()
                    + ", '" + pessoa.getNm_autor()
                    + "', '" + pessoa.getNc_autor()
                    
                    + "')"
            );
        } catch (Exception e) {
        }
    }

   

    public void alterar(Autor pessoa) {
        conecta_oracle.atualizarSQL("UPDATE AUTORES SET NM_AUTOR = '" + pessoa.getNm_autor()
                + "', NC_AUTOR = '" + pessoa.getNc_autor()              
                + "'  WHERE CD_AUTOR = " + pessoa.getCd_autor()
        );
    }

    public void excluir(Autor pessoa) {
        conecta_oracle.deleteSQL("DELETE FROM AUTORES WHERE CD_AUTOR = " + pessoa.getCd_autor());
    }
    public void retornardados(Autor pessoa) {
        conecta_oracle.executeSQL("SELECT * FROM AUTORES WHERE CD_AUTOR = " + pessoa.getCd_autor());
        try {
            conecta_oracle.resultset.first();
            pessoa.setCd_autor(conecta_oracle.resultset.getInt("CD_AUTOR"));
            pessoa.setNm_autor(conecta_oracle.resultset.getString("NM_AUTOR"));
            pessoa.setNc_autor(conecta_oracle.resultset.getString("NC_AUTOR"));
          
        } catch (Exception e) {
        }
    }

    public void consultaGeral(Autor pessoa) {
        conecta_oracle.executeSQL("SELECT * FROM AUTORES");
        pessoa.setRetorno(conecta_oracle.resultset);
    }
    
    

    public void consultaCodigo(Autor pessoa) {
        conecta_oracle.executeSQL("SELECT * FROM AUTORES WHERE CD_AUTOR = " + pessoa.getCd_autor());
        pessoa.setRetorno(conecta_oracle.resultset);
    }

    public void consultaPessoa(Autor pessoa) {
        conecta_oracle.executeSQL("SELECT * FROM AUTORES WHERE NM_AUTOR LIKE '%" + pessoa.getNm_autor()+ "%'");
        pessoa.setRetorno(conecta_oracle.resultset);
    }
}
