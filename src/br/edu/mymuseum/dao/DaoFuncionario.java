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
                + " WHERE CD_FUNCIONARIO = " + pessoa.getCd_funcionario()
        );
    }

    public void alterar(Restaurador pessoa) {
        conecta_oracle.atualizarSQL("UPDATE RESTAURADOR SET ESPECIALIDADE = '" + pessoa.getEspecialidade() + "' WHERE CD_FUNCIONARIO = "
                +pessoa.getCd_funcionario());
    }
    
     public void alterar(Guardinha pessoa) {
        conecta_oracle.atualizarSQL("UPDATE GUARDINHA SET TT_GUARDAS = '" + pessoa.getTt_guardas()+ "' WHERE CD_FUNCIONARIO = "
                +pessoa.getCd_funcionario());
    }

    public void excluir(Funcionario pessoa) {
        try {
            conecta_oracle.deleteSQL("DELETE FROM RESTAURADOR WHERE CD_FUNCIONARIO =" + pessoa.getCd_funcionario());
        } catch (Exception ex) {
            conecta_oracle.deleteSQL("DELETE FROM GUARDINHA WHERE CD_FUNCIONARIO =" + pessoa.getCd_funcionario());
        }
        conecta_oracle.deleteSQL("DELETE FROM FUNCIONARIO WHERE CD_FUNCIONARIO = " + pessoa.getCd_funcionario());
        
    }

    public void retornardados(Funcionario pessoa) {
        conecta_oracle.executeSQL("SELECT * FROM FUNCIONARIO WHERE CD_FUNCIONARIO = " + pessoa.getCd_funcionario());
        try {
            conecta_oracle.resultset.first();
            pessoa.setCd_funcionario(conecta_oracle.resultset.getInt("CD_FUNCIONARIO"));
            pessoa.setCpf(conecta_oracle.resultset.getLong("CPF"));
            pessoa.setNm_funcionario(conecta_oracle.resultset.getString("NM_FUNCIONARIO"));
            pessoa.setSl_funcionario(conecta_oracle.resultset.getDouble("SL_FUNCIONARIO"));
            pessoa.setTp_funcinario(conecta_oracle.resultset.getInt("TP_FUNCIONARIO"));
        } catch (Exception e) {
        }
    }

    public void retornardados(Restaurador pessoa) {
        conecta_oracle.executeSQL("SELECT * FROM RESTAURADOR WHERE CD_FUNCIONARIO = " + pessoa.getCd_funcionario());
        try {
            conecta_oracle.resultset.first();
            pessoa.setCd_funcionario(conecta_oracle.resultset.getInt("CD_FUNCIONARIO"));
            pessoa.setEspecialidade(conecta_oracle.resultset.getString("ESPECIALIDADE"));

        } catch (Exception e) {
        }
    }

    public void retornardados(Guardinha pessoa) {
        conecta_oracle.executeSQL("SELECT * FROM GUARDINHA WHERE CD_FUNCIONARIO = " + pessoa.getCd_funcionario());
        try {
            conecta_oracle.resultset.first();
            pessoa.setCd_funcionario(conecta_oracle.resultset.getInt("CD_FUNCIONARIO"));
            pessoa.setTt_guardas(conecta_oracle.resultset.getDouble("TT_GUARDAS"));

        } catch (Exception e) {
        }
    }

    public void consultaGeral(Funcionario pessoa) {
        conecta_oracle.executeSQL("SELECT * FROM FUNCIONARIO");
        pessoa.setRetorno(conecta_oracle.resultset);
    }

    public void consultaGuardinha(Guardinha pessoa) {
        conecta_oracle.executeSQL("SELECT * FROM FUNCIONARIO WHERE TP_FUNCIONARIO = 2");
        pessoa.setRetorno(conecta_oracle.resultset);
    }

    public void consultaReparador(Restaurador pessoa) {
        conecta_oracle.executeSQL("SELECT * FROM FUNCIONARIO WHERE TP_FUNCIONARIO = 1");
        pessoa.setRetorno(conecta_oracle.resultset);
    }

    public void consultaCodigo(Funcionario pessoa) {
        conecta_oracle.executeSQL("SELECT * FROM FUNCIONARIO WHERE CD_FUNCIONARIO = " + pessoa.getCd_funcionario());
        pessoa.setRetorno(conecta_oracle.resultset);
    }

    public void consultaPessoa(Funcionario pessoa) {
        conecta_oracle.executeSQL("SELECT * FROM FUNCIONARIO WHERE NM_FUNCIONARIO LIKE '%" + pessoa.getNm_funcionario() + "%'");
        pessoa.setRetorno(conecta_oracle.resultset);
    }
}
