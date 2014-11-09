package br.edu.mymuseum.dao;

import br.edu.mymuseum.classe.Guarda;

import br.edu.mymuseum.conexao.ConexaoOracle;
import br.edu.mymuseum.validacao.UltimaSequencia;

/**
 *
 * @author Dorga
 */
public class DaoGuarda {

    ConexaoOracle conecta_oracle;
    UltimaSequencia ultima;

    public DaoGuarda() {
        conecta_oracle = new ConexaoOracle();
    }

    public void incluir(Guarda pessoa) {

        try {
            conecta_oracle.incluirSQL("INSERT INTO GUARDA (CD_FUNCIONARIO,CD_ANDAR,CD_SALAO,HR_ENTRADA,HR_SAIDA) VALUES ("
                    + pessoa.getCd_funcionario()
                    + ", " + pessoa.getCd_andar()
                    + ", " + pessoa.getCd_salao()
                    + ", '" + pessoa.getHr_entrada()
                    + "','" + pessoa.getHr_saida()
                    + "')"
            );
        } catch (Exception e) {
        }
    }

    public void pega_horario(Guarda pessoa) {
        conecta_oracle.executeSQL("SELECT (HR_SAIDA) - (HR_ENTRADA) AS HORARIO, SUBSTR(HORARIO,10,17) FROM GUARDA WHERE CD_FUNCIONARIO = " + pessoa.getCd_funcionario() + " AND CD_ANDAR = " + pessoa.getCd_andar() + " AND CD_SALAO = " + pessoa.getCd_salao());
        pessoa.setRetorno(conecta_oracle.resultset);
    }

    public void excluir(Guarda pessoa) {
        conecta_oracle.deleteSQL("DELETE FROM SALAO WHERE CD_FUNCIONARIO = " + pessoa.getCd_funcionario() + "AND CD_SALAO = " + pessoa.getCd_salao() + "AND CD_ANDAR = " + pessoa.getCd_andar());
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

    public void consultaGeral(Guarda pessoa) {
        conecta_oracle.executeSQL("SELECT * FROM SALAO");
        pessoa.setRetorno(conecta_oracle.resultset);
    }
//

    public void consultaCodigo(Guarda pessoa) {
        conecta_oracle.executeSQL("SELECT * FROM SALAO WHERE CD_SALAO = " + pessoa.getCd_salao());
        pessoa.setRetorno(conecta_oracle.resultset);
    }
//
//    public void consultaPessoa(Pessoa pessoa) {
//        conecta_oracle.executeSQL("SELECT * FROM CAD_PESSOA WHERE DS_PESSOA LIKE '%" + pessoa.getDs_pessoa()+ "%'");
//        pessoa.setRetorno(conecta_oracle.resultset);
//    }
}
