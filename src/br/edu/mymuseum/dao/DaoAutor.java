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

    public void consultaGeral(Autor pessoa) {
        conecta_oracle.executeSQL("SELECT * FROM AUTORES");
        pessoa.setRetorno(conecta_oracle.resultset);
    }
    
    
//
//    public void consultaCodigo(Pessoa pessoa) {
//        conecta_oracle.executeSQL("SELECT * FROM CAD_PESSOA WHERE CD_PESSOA = " + pessoa.getCd_pessoa());
//        pessoa.setRetorno(conecta_oracle.resultset);
//    }
//
    public void consultaPessoa(Autor pessoa) {
        conecta_oracle.executeSQL("SELECT * FROM AUTORES WHERE NM_AUTOR LIKE '%" + pessoa.getNm_autor()+ "%'");
        pessoa.setRetorno(conecta_oracle.resultset);
    }
}
