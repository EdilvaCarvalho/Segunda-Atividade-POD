
package br.edu.ifpb.quest1_shared;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Edilva
 */
public interface Op1 extends Remote {
    
    int operacao1(int x, int y) throws RemoteException;
}
