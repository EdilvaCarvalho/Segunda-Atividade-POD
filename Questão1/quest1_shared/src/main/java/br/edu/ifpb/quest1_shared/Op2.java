
package br.edu.ifpb.quest1_shared;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Edilva
 */
public interface Op2 extends Remote {
    
    double operacao2(int x, int y) throws RemoteException;
    
}
