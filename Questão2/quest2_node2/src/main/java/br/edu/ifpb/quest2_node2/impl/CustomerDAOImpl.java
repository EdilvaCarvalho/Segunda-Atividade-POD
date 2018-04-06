package br.edu.ifpb.quest2_node2.impl;

import br.edu.ifpb.quest2_node2.conexao.ConexaoMysql;
import br.edu.ifpb.quest2_node2.conexao.ConexaoPostgresql;
import br.edu.ifpb.quest2_shared.entidade.Customer;
import br.edu.ifpb.quest2_shared.interfaces.CustomerDAO;
import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Edilva
 */
public class CustomerDAOImpl extends UnicastRemoteObject implements CustomerDAO, Serializable {

    private ConexaoMysql mysql;
    private ConexaoPostgresql postgresql;

    public CustomerDAOImpl() throws RemoteException {
        super();
    }

    @Override
    public void saveCustomer(Customer customer) {

        PreparedStatement ps = null;
        String sql = "INSERT INTO Customer(name) VALUES(?)";

        mysql = new ConexaoMysql();
        mysql.conecta();

        try {
            ps = mysql.con.prepareStatement(sql);
            ps.setString(1, customer.getName());
            ps.executeUpdate();

            mysql.desconecta();
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        postgresql = new ConexaoPostgresql();
        postgresql.conecta();

        try {
            ps = postgresql.con.prepareStatement(sql);
            ps.setString(1, customer.getName());
            ps.executeUpdate();
            ps.close();

            postgresql.desconecta();
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}

