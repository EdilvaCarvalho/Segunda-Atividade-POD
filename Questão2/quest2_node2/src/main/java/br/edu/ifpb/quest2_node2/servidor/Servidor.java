
package br.edu.ifpb.quest2_node2.servidor;

import br.edu.ifpb.quest2_node2.impl.CustomerDAOImpl;
import br.edu.ifpb.quest2_shared.interfaces.CustomerDAO;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Edilva
 */
public class Servidor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        try {
            CustomerDAO customerDAO = new CustomerDAOImpl();
            LocateRegistry.createRegistry(1099);
            Naming.rebind("//localhost:1099/Servidor", customerDAO);
        } catch (RemoteException | MalformedURLException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
