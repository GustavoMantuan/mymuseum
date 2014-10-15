package br.edu.mymuseum.dao;


import br.edu.mymuseum.classe.Salao;

import br.edu.mymuseum.conexao.ConexaoOracle;
import br.edu.mymuseum.validacao.UltimaSequencia;

/**
 *
 * @author Dorga
 */
public class DaoSalao {

    ConexaoOracle conecta_oracle;
    UltimaSequencia ultima;

    public DaoSalao() {
        conecta_oracle = new ConexaoOracle();
    }

    public void incluir(Salao pessoa) {

        try {
            conecta_oracle.incluirSQL("INSERT INTO SALAO (CD_SALAO,CD_ANDAR) VALUES ("
                    + pessoa.getCd_salao()
                    + ", " + pessoa.getCd_andar()
                  
                    + ")"
            );
        } catch (Exception e) {
        }
    }

   

  

    public void excluir(Salao pessoa) {
        conecta_oracle.deleteSQL("DELETE FROM SALAO WHERE CD_SALAO = " + pessoa.getCd_salao());
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

    
    public void consultaGeral(Salao pessoa) {
        conecta_oracle.executeSQL("SELECT * FROM SALAO");
        pessoa.setRetorno(conecta_oracle.resultset);
    }
//
//    public void consultaCodigo(Pessoa pessoa) {
//        conecta_oracle.executeSQL("SELECT * FROM CAD_PESSOA WHERE CD_PESSOA = " + pessoa.getCd_pessoa());
//        pessoa.setRetorno(conecta_oracle.resultset);
//    }
//
//    public void consultaPessoa(Pessoa pessoa) {
//        conecta_oracle.executeSQL("SELECT * FROM CAD_PESSOA WHERE DS_PESSOA LIKE '%" + pessoa.getDs_pessoa()+ "%'");
//        pessoa.setRetorno(conecta_oracle.resultset);
//    }
}
