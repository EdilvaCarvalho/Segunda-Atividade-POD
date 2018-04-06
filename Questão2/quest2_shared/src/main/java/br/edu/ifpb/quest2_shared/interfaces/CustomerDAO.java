
package br.edu.ifpb.quest2_shared.interfaces;

import br.edu.ifpb.quest2_shared.entidade.Customer;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Edilva
 */
public interface CustomerDAO extends Remote {
    
    void saveCustomer(Customer customer) throws RemoteException;
}
