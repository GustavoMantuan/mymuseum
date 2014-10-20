package br.edu.mymuseum.dao;

import br.edu.mymuseum.classe.Escultura;
import br.edu.mymuseum.classe.Obra;
import br.edu.mymuseum.classe.Pintura;

import br.edu.mymuseum.conexao.ConexaoOracle;
import br.edu.mymuseum.validacao.UltimaSequencia;
import javax.swing.table.DefaultTableModel;

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
        conecta_oracle.atualizarSQL("UPDATE OBRAS SET "
                + "CD_AUTOR = " + pessoa.getCd_autor()
                + ", CD_ANDAR = " + pessoa.getCd_andar()
                + ", CD_SALAO = " + pessoa.getCd_salao()
                + ", TI_OBRA = '" + pessoa.getTi_obra()
                + "', ANO_OBRA = " + pessoa.getAno_obra()
                + "  WHERE CD_OBRA = " + pessoa.getCd_obra()
                + " AND TP_OBRA = "+pessoa.getTp_obra()
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
public void grava_itens(Obra obra) {
        DefaultTableModel TabelaItem = (DefaultTableModel) obra.getTabela().getModel();
        int totalinha = obra.getTabela().getRowCount();
        for (int i = 0; i < totalinha; i++) {
            obra.setCd_obra(Integer.parseInt(TabelaItem.getValueAt(i, 0).toString()));
            obra.setTp_obra(Integer.parseInt(TabelaItem.getValueAt(i, 1).toString()));
            obra.setAno_obra(Integer.parseInt(TabelaItem.getValueAt(i, 2).toString()));
            obra.setTi_obra(TabelaItem.getValueAt(i, 3).toString());
            obra.setCd_salao(Integer.parseInt(TabelaItem.getValueAt(i, 4).toString()));
            obra.setCd_andar(Integer.parseInt(TabelaItem.getValueAt(i, 5).toString()));
            obra.setCd_autor(Integer.parseInt(TabelaItem.getValueAt(i, 6).toString()));
            alterar(obra);

        }
    }
    
    public void consultaCd(Obra pessoa){
        conecta_oracle.executeSQL("SELECT TP_OBRA FROM OBRAS WHERE CD_OBRA = "+pessoa.getCd_obra());
        pessoa.setRetorno(conecta_oracle.resultset);
    }
    public void consultaCodigo(Obra pessoa) {
        conecta_oracle.executeSQL("SELECT * FROM OBRAS WHERE CD_ANDAR = "+pessoa.getCd_andar()+" AND CD_SALAO = "+pessoa.getCd_salao());
        pessoa.setRetorno(conecta_oracle.resultset);
    }
    public void consultaCodigoTpAtor(Obra pessoa) {
        conecta_oracle.executeSQL("SELECT * FROM OBRAS WHERE CD_ANDAR =  "+pessoa.getCd_andar()+" AND CD_SALAO = "+pessoa.getCd_salao()+" AND TP_OBRA = " + pessoa.getTp_obra()+ " AND CD_AUTOR = "+pessoa.getCd_autor());
        pessoa.setRetorno(conecta_oracle.resultset);
    }
    public void consultaCodigoAtor(Obra pessoa) {
        conecta_oracle.executeSQL("SELECT * FROM OBRAS WHERE CD_ANDAR =  "+pessoa.getCd_andar()+" AND CD_SALAO = "+pessoa.getCd_salao()+" AND CD_AUTOR = "+pessoa.getCd_autor());
        pessoa.setRetorno(conecta_oracle.resultset);
    }
    public void consultaTpObra(Obra pessoa) {
        conecta_oracle.executeSQL("SELECT * FROM OBRAS WHERE CD_ANDAR =  "+pessoa.getCd_andar()+" AND CD_SALAO = "+pessoa.getCd_salao()+" AND TP_OBRA = "+pessoa.getTp_obra());
        pessoa.setRetorno(conecta_oracle.resultset);
    }

    public void consultaGeral(Obra pessoa) {
        conecta_oracle.executeSQL("SELECT * FROM OBRAS");
        pessoa.setRetorno(conecta_oracle.resultset);
    }
    public void consultaObra(Obra obra){
        conecta_oracle.executeSQL("SELECT * FROM OBRAS WHERE TI_OBRA LIKE '%" + obra.getTi_obra() + "%'");
        obra.setRetorno(conecta_oracle.resultset);
    }
    
    
}
