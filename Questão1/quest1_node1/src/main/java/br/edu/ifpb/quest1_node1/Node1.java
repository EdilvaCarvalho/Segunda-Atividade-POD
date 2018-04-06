package br.edu.ifpb.quest1_node1;

import br.edu.ifpb.quest1_shared.Op1;
import br.edu.ifpb.quest1_shared.Op2;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author Edilva
 */
public class Node1 extends UnicastRemoteObject implements Op1, Op2 {

    public Node1() throws RemoteException {
        super();
    }

    @Override
    public int operacao1(int x, int y) throws RemoteException {
        System.out.println("Operação 1 do Node1");
        int resultado = 2 * x * y;
        return resultado;
    }

    @Override
    public double operacao2(int x, int y) throws RemoteException {
        System.out.println("Operação 2 do Node1");
        boolean connected = false;

        while (!connected) {

            try {

                Op2 op2 = (Op2) Naming.lookup("//localhost:1099/Node3");

                connected = true;

                return op2.operacao2(x, y);
                
            } catch (NotBoundException | MalformedURLException | RemoteException ex) {
                System.err.println("Tentando novamente...");
            }
        }

        return Long.MAX_VALUE;
    }

}
