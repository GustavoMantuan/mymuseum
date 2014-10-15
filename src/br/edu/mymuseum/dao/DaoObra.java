package br.edu.mymuseum.dao;

import br.edu.mymuseum.classe.Escultura;
import br.edu.mymuseum.classe.Obra;
import br.edu.mymuseum.classe.Pintura;

import br.edu.mymuseum.conexao.ConexaoOracle;
import br.edu.mymuseum.validacao.UltimaSequencia;

/**
 *
 * @author Dorga
 */
public class DaoObra {

    ConexaoOracle conecta_oracle;
    UltimaSequencia ultima;

    public DaoObra() {
        conecta_oracle = new ConexaoOracle();
    }

    public void incluir(Obra pessoa) {

        try {
            conecta_oracle.incluirSQL("INSERT INTO OBRAS (CD_OBRA,TP_OBRA,CD_AUTOR,CD_ANDAR,CD_SALAO,TI_OBRA,ANO_OBRA) VALUES ("
                    + pessoa.getCd_obra()
                    + ", " + pessoa.getTp_obra()
                    + ", " + pessoa.getCd_autor()
                    + ", " + pessoa.getCd_andar()
                    + ", " + pessoa.getCd_salao()
                    + ", '" + pessoa.getTi_obra()
                    + "' ," + pessoa.getAno_obra()
                    + ")"
            );
        } catch (Exception e) {
        }
    }

    public void incluir(Pintura pintura) {
        try {
            conecta_oracle.incluirSQL("INSERT INTO PINTURA (CD_OBRA,TP_OBRA,DS_ESTILO) VALUES ("
                    + pintura.getCd_obra()
                    + ", " + pintura.getTp_obra()
                    + " ,'" + pintura.getDs_estilo()
                    + "')"
            );
        } catch (Exception e) {
        }

    }
    
    public void incluir(Escultura escultura) {
        try {
            conecta_oracle.incluirSQL("INSERT INTO ESCULTURA (CD_OBRA,TP_OBRA,TT_PESO) VALUES ("
                    + escultura.getCd_obra()
                    + ", " + escultura.getTp_obra()
                    +", '" +escultura.getTt_peso()
                    + "')"
            );
        } catch (Exception e) {
        }

    }

    public void alterar(Obra pessoa) {
        conecta_oracle.atualizarSQL("UPDATE OBRAS SET TP_OBRA = '" + pessoa.getTp_obra()
                + ", CD_AUTOR = " + pessoa.getCd_autor()
                + ", CD_ANDAR = " + pessoa.getCd_andar()
                + ", CD_SALAO = " + pessoa.getCd_salao()
                + ", TI_OBRA = '" + pessoa.getTi_obra()
                + "', ANO_OBRA = " + pessoa.getAno_obra()
                + "'  WHERE CD_OBRA = " + pessoa.getCd_obra()
        );
    }

    public void excluir(Obra pessoa) {
        conecta_oracle.deleteSQL("DELETE FROM OBRAS WHERE CD_OBRA = " + pessoa.getCd_obra());
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
