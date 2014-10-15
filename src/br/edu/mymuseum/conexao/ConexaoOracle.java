package br.edu.mymuseum.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Dorga
 */
public class ConexaoOracle {

    public static Connection ConexaoOracle;
    public static Statement statement;
    public static ResultSet resultset;
    public ResultSetMetaData metaData;
    public int retorno = 0;

    public ConexaoOracle() { //Construtor
        conecta();
    }

    public static Connection conecta() {
        if (ConexaoOracle != null) {
            return ConexaoOracle;
        } else {
            try {
                Class.forName("oracle.jdbc.driver.OracleDriver");
                ConexaoOracle = DriverManager.getConnection("jdbc:oracle:thin:"
                        + "@127.0.0.1:1521"
                        + ":XE", "admin", "admin");
                System.out.println("Conectado");
                JOptionPane.showMessageDialog(null, "Conectado com sucesso");
                return ConexaoOracle;
            } catch (ClassNotFoundException ex) {
                JOptionPane.showMessageDialog(null, "Driver não localizado");
                ex.printStackTrace();
                return null;
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro na conexão com a fonte"
                        + "de dados: ");
                ex.printStackTrace();
                return null;
            }
        }
    }

    public void executeSQL(String sql) {
        try {
            statement = ConexaoOracle.createStatement(
                    ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            statement.execute("ALTER SESSION SET NLS_DATE_FORMAT = 'DD-MM-YYYY'");
            resultset = statement.executeQuery(sql);
            retorno = 1;
            
        } catch (SQLException sqlex) {
            JOptionPane.showMessageDialog(null, "Não foi possível localizar o registro \n"
                    + sqlex);
        }
        try {
            metaData = resultset.getMetaData();
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, erro);
        }
    }

    public void incluirSQL(String sql) {
        try {
            statement = ConexaoOracle.createStatement(
                    ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            statement.execute("ALTER SESSION SET NLS_DATE_FORMAT = 'DD-MM-YYYY'");
            resultset = statement.executeQuery(sql);
            retorno = 1;
        } catch (SQLException sqlex) {
            if (sqlex.getErrorCode() == 000001) {
                JOptionPane.showMessageDialog(null, "O Registro não pôde ser incluído pois já está cadastrado");
            } else {
                JOptionPane.showMessageDialog(null, "Não foi possivel executar o comando sql," + sqlex + ",o sql passado foi: " + sql);
            }
            retorno = 0;
        }
    }

    public void atualizarSQL(String sql) {
        try {
            statement = ConexaoOracle.createStatement(
                    ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            retorno = 0;
            retorno = statement.executeUpdate(sql);
            if (retorno == 1) {
                JOptionPane.showMessageDialog(null, "Atualização realizada com sucesso");
            }
        } catch (SQLException sqlex) {
            if (sqlex.getErrorCode() == 2292) {
                JOptionPane.showMessageDialog(null, "O Registro não pôde ser atualizado pois já está sendo utilizado em outro cadastro/movimento");
            } else {
                JOptionPane.showMessageDialog(null, "Não foi possivel executar o comando sql de exclusao," + sqlex + ",o sql passado foi: " + sql);
            }
            retorno = 0;
        }
    }

    public void deleteSQL(String sql) {
        try {
            statement = ConexaoOracle.createStatement(
                    ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            retorno = 0;
            retorno = statement.executeUpdate(sql);
            if (retorno == 1) {
                JOptionPane.showMessageDialog(null, "Exclusão realizada com sucesso");
            }
        } catch (SQLException sqlex) {
            if (sqlex.getErrorCode() == 2292) {
                JOptionPane.showMessageDialog(null, "O Registro não pôde ser atualizado pois já está sendo utilizado em outro cadastro/movimento");
            } else {
                JOptionPane.showMessageDialog(null, "Não foi possivel executar o comando sql de exclusao," + sqlex + ",o sql passado foi: " + sql);
            }
            retorno = 0;
        }
    }

    public void desconecta() {
        boolean result = true;
        try {
            ConexaoOracle.close();
            //JOptionPane.showMessageDialog(null,"Banco Fechado");
        } catch (SQLException fecha) {
            JOptionPane.showMessageDialog(null, "Não foi possível"
                    + "fechar o banco de dados:" + fecha);
            result = false;
        }
    }

    public String retornadescricao(String tabela, String retorno, String condicao, String comparacao) {
        executeSQL("SELECT " + retorno + " FROM " + tabela + " WHERE " + condicao + " = " + comparacao);
        String descricao = "";
        try {
            resultset.first();
            descricao = resultset.getString(retorno);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, descricao);
        }
        return descricao;

    }
    
}
