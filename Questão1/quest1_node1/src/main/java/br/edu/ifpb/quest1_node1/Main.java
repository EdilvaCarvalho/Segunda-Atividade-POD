package br.edu.ifpb.quest1_node1;

import br.edu.ifpb.quest1_shared.Op1;
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
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        try {
            Op1 op1Node1 = new Node1();
            LocateRegistry.createRegistry(1097);
            Naming.rebind("//localhost:1097/Node1", op1Node1);
        } catch (MalformedURLException | RemoteException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
