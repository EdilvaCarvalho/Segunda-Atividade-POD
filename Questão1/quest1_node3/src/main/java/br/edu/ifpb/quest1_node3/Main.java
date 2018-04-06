package br.edu.ifpb.quest1_node3;

import br.edu.ifpb.quest1_shared.Op2;
import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Edilva
 */
public class Main {

    /**
     * @param args the command line arguments
     * @throws java.rmi.RemoteException
     * @throws java.rmi.AlreadyBoundException
     */
    public static void main(String[] args) throws RemoteException, AlreadyBoundException {
        try {

            Op2 op2Node3 = new Node3();

            try {
                LocateRegistry.createRegistry(1099);
            } catch (Exception ex) {
            }

            Naming.rebind("//localhost:1099/Node3", op2Node3);

        } catch (MalformedURLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
