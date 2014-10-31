package br.edu.mymuseum.dao;

import br.edu.mymuseum.classe.Escultura;
import br.edu.mymuseum.classe.Obra;
import br.edu.mymuseum.classe.Pintura;

import br.edu.mymuseum.conexao.ConexaoOracle;
import br.edu.mymuseum.validacao.UltimaSequencia;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
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
                    + ", '" + escultura.getTt_peso()
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
                + " AND TP_OBRA = " + pessoa.getTp_obra()
        );
    }

    public void alterar(Pintura pintura) {
        conecta_oracle.atualizarSQL("UPDATE PINTURA SET "
                + "DS_ESTILO = '" + pintura.getDs_estilo()
                + "' WHERE CD_OBRA = " + pintura.getCd_obra()
                + " AND TP_OBRA = " + pintura.getTp_obra()
        );
    }

    public void alterar(Escultura escultura) {
        conecta_oracle.atualizarSQL("UPDATE ESCULTURA SET "
                + "TT_PESO = '" + escultura.getTt_peso()
                + "' WHERE CD_OBRA = " + escultura.getCd_obra()
                + " AND TP_OBRA = " + escultura.getTp_obra()
        );
    }

    public void excluir(Obra pessoa) {
        conecta_oracle.deleteSQL("DELETE FROM OBRAS WHERE CD_OBRA = " + pessoa.getCd_obra());
    }

    public void retornardados(Obra pessoa) {
        conecta_oracle.executeSQL("SELECT * FROM OBRAS WHERE CD_OBRA = " + pessoa.getCd_obra());
        try {
            conecta_oracle.resultset.first();
            pessoa.setCd_obra(conecta_oracle.resultset.getInt("CD_OBRA"));
            pessoa.setTp_obra(conecta_oracle.resultset.getInt("TP_OBRA"));
            pessoa.setCd_autor(conecta_oracle.resultset.getInt("CD_AUTOR"));
            pessoa.setCd_andar(conecta_oracle.resultset.getInt("CD_ANDAR"));
            pessoa.setCd_salao(conecta_oracle.resultset.getInt("CD_SALAO"));
            pessoa.setTi_obra(conecta_oracle.resultset.getString("TI_OBRA"));
            pessoa.setAno_obra(conecta_oracle.resultset.getInt("ANO_OBRA"));

        } catch (Exception e) {
        }
    }

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

    public void consultaCd(Obra pessoa) {
        conecta_oracle.executeSQL("SELECT TP_OBRA FROM OBRAS WHERE CD_OBRA = " + pessoa.getCd_obra());
        pessoa.setRetorno(conecta_oracle.resultset);
    }

    public void consultaCodigo(Obra pessoa) {
        conecta_oracle.executeSQL("SELECT * FROM OBRAS WHERE CD_ANDAR = " + pessoa.getCd_andar() + " AND CD_SALAO = " + pessoa.getCd_salao());
        pessoa.setRetorno(conecta_oracle.resultset);
    }

    public void consultaCodigo(Pintura pessoa) {
        conecta_oracle.executeSQL("SELECT * FROM PINTURA WHERE CD_OBRA = " + pessoa.getCd_obra() + "AND TP_OBRA = " + pessoa.getTp_obra());
        pessoa.setRetorno(conecta_oracle.resultset);
        try {
            pessoa.getRetorno().first();
            pessoa.setDs_estilo(pessoa.getRetorno().getString("DS_ESTILO"));
        } catch (SQLException ex) {
            Logger.getLogger(DaoObra.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void consultaCodigo(Escultura pessoa) {
        conecta_oracle.executeSQL("SELECT * FROM ESCULTURA WHERE CD_OBRA = " + pessoa.getCd_obra() + "AND TP_OBRA = " + pessoa.getTp_obra());
        pessoa.setRetorno(conecta_oracle.resultset);
        try {
            pessoa.getRetorno().first();
            pessoa.setTt_peso(pessoa.getRetorno().getInt("TT_PESO"));
        } catch (SQLException ex) {
            Logger.getLogger(DaoObra.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void consultaCodigoTpAtor(Obra pessoa) {
        conecta_oracle.executeSQL("SELECT * FROM OBRAS WHERE CD_ANDAR =  " + pessoa.getCd_andar() + " AND CD_SALAO = " + pessoa.getCd_salao() + " AND TP_OBRA = " + pessoa.getTp_obra() + " AND CD_AUTOR = " + pessoa.getCd_autor());
        pessoa.setRetorno(conecta_oracle.resultset);
    }

    public void consultaCodigoAtor(Obra pessoa) {
        conecta_oracle.executeSQL("SELECT * FROM OBRAS WHERE CD_ANDAR =  " + pessoa.getCd_andar() + " AND CD_SALAO = " + pessoa.getCd_salao() + " AND CD_AUTOR = " + pessoa.getCd_autor());
        pessoa.setRetorno(conecta_oracle.resultset);
    }

    public void consultaTpObra(Obra pessoa) {
        conecta_oracle.executeSQL("SELECT * FROM OBRAS WHERE CD_ANDAR =  " + pessoa.getCd_andar() + " AND CD_SALAO = " + pessoa.getCd_salao() + " AND TP_OBRA = " + pessoa.getTp_obra());
        pessoa.setRetorno(conecta_oracle.resultset);
    }

    public void consultaGeral(Obra pessoa) {
        conecta_oracle.executeSQL("SELECT * FROM OBRAS");
        pessoa.setRetorno(conecta_oracle.resultset);
    }

    public void consultaEscultura(Obra pessoa) {
        conecta_oracle.executeSQL("SELECT * FROM OBRAS WHERE TP_OBRA = 2");
        pessoa.setRetorno(conecta_oracle.resultset);
    }

    public void consultaObra(Obra obra) {
        conecta_oracle.executeSQL("SELECT * FROM OBRAS WHERE TI_OBRA LIKE '%" + obra.getTi_obra() + "%'");
        obra.setRetorno(conecta_oracle.resultset);
    }

}
