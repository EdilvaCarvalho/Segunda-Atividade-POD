
package br.edu.ifpb.quest2_node1;

import br.edu.ifpb.quest2_shared.entidade.Customer;
import br.edu.ifpb.quest2_shared.interfaces.CustomerDAO;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Edilva
 */
public class Cliente {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        CustomerDAO customerDAO = null;
        
        long ti = System.currentTimeMillis();
        
        for (int i = 0; i < 1000; i++) {
            try {
                customerDAO = (CustomerDAO) Naming.lookup("//localhost:1099/Servidor");
                Customer customer = new Customer("Edilva");
                customerDAO.saveCustomer(customer);
            } catch (NotBoundException | MalformedURLException | RemoteException ex) {
                Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        System.out.println("Tempo: " + ((System.currentTimeMillis() - ti) / 1000) + " segundos");
    }
    
}
