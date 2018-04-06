package br.edu.ifpb.quest2_node2.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Edilva
 */
public class ConexaoPostgresql {

    private final String url = "jdbc:postgresql://localhost:5432/pod_db";
    private final String user = "postgres";
    private final String password = "postgres";
    private final String driver = "org.postgresql.Driver";
    public Connection con;

    public ConexaoPostgresql() {
    }

    public void conecta() {
        try {
            System.setProperty("jdbc.Drivers", driver);
            Class.forName(driver);
            con = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            System.out.println("Erro ao se comunicar com o banco de dados:\n" + e);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConexaoPostgresql.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void desconecta() {
        try {
            this.con.close();
        } catch (SQLException ex) {
            System.out.println("Erro ao se comunicar com o banco de dados:\n" + ex);
        }
    }
}
