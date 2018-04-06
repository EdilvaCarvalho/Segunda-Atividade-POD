package br.edu.ifpb.quest1_node3;

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
public class Node3 extends UnicastRemoteObject implements Op1, Op2 {

    public Node3() throws RemoteException {
        super();
    }

    @Override
    public int operacao1(int x, int y) throws RemoteException {
        System.out.println("Operação 1 do Node3");
        boolean connected = false;

        Op1 op1 = null;

        while (!connected) {

            try {

                op1 = (Op1) Naming.lookup("//localhost:1097/Node1");

                connected = true;

            } catch (MalformedURLException | NotBoundException | RemoteException ex) {

            }

            if (op1 == null) {

                try {

                    op1 = (Op1) Naming.lookup("//localhost:1097/Node1");

                    connected = true;

                } catch (MalformedURLException | NotBoundException | RemoteException ex) {

                }
            }

            if (op1 == null) {

                System.err.println("Tentando novamente...");
            } else {

                try {
                    return op1.operacao1(x, y);
                } catch (RemoteException ex) {
                }
            }

        }

        return (int) Long.MAX_VALUE;
    }

    @Override
    public double operacao2(int x, int y) throws RemoteException {
        System.out.println("Operação 2 do Node3");
        double resultado = (2 * x) / y;
        return resultado;
    }

}
