package br.edu.mymuseum.dao;

import br.edu.mymuseum.classe.Funcionario;
import br.edu.mymuseum.classe.Funcionario;
import br.edu.mymuseum.classe.Guardinha;
import br.edu.mymuseum.classe.Restaurador;
import br.edu.mymuseum.conexao.ConexaoOracle;
import br.edu.mymuseum.validacao.UltimaSequencia;

/**
 *
 * @author Dorga
 */
public class DaoFuncionario {

    ConexaoOracle conecta_oracle;
    UltimaSequencia ultima;

    public DaoFuncionario() {
        conecta_oracle = new ConexaoOracle();
    }

    public void incluir(Funcionario pessoa) {

        try {
            conecta_oracle.incluirSQL("INSERT INTO FUNCIONARIO (CD_FUNCIONARIO,NM_FUNCIONARIO,TP_FUNCIONARIO,SL_FUNCIONARIO,CPF) VALUES ("
                    + pessoa.getCd_funcionario()
                    + ", '" + pessoa.getNm_funcionario()
                    + "', " + pessoa.getTp_funcinario()
                    + ", " + pessoa.getSl_funcionario()
                    + ", " + pessoa.getCpf()
                    + ")"
            );
        } catch (Exception e) {
        }
    }

    public void incluir(Restaurador pessoa) {
        try {
            conecta_oracle.incluirSQL("INSERT INTO RESTAURADOR (CD_FUNCIONARIO,ESPECIALIDADE) VALUES ("
                    + pessoa.getCd_funcionario()
                    + ", '" + pessoa.getEspecialidade()
                    + "')"
            );
        } catch (Exception e) {
        }
    }

    public void incluir(Guardinha pessoa) {
        try {
            conecta_oracle.incluirSQL("INSERT INTO GUARDINHA (CD_FUNCIONARIO,TT_GUARDAS) VALUES ("
                    + pessoa.getCd_funcionario()
                    + ", " + pessoa.getTt_guardas()
                    + ")"
            );
        } catch (Exception e) {
        }
    }

    public void alterar(Funcionario pessoa) {
        conecta_oracle.atualizarSQL("UPDATE FUNCIONARIO SET NM_FUNCIONARIO = '" + pessoa.getNm_funcionario()
                + "', TP_FUNCIONARIO = " + pessoa.getTp_funcinario()
                + ", SL_FUNCIONARIO = " + pessoa.getSl_funcionario()
                + ", CPF = " + pessoa.getCpf()
                + "'  WHERE CD_FUNCIONARIO = " + pessoa.getCd_funcionario()
        );
    }

    public void excluir(Funcionario pessoa) {
        conecta_oracle.deleteSQL("DELETE FROM FUNCIONARIO WHERE CD_FUNCIONARIO = " + pessoa.getCd_funcionario());
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
