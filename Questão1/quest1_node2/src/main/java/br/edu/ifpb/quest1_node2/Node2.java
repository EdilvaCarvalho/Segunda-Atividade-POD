package br.edu.ifpb.quest1_node2;

import br.edu.ifpb.quest1_shared.Op1;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author Edilva
 */
public class Node2 extends UnicastRemoteObject implements Op1 {

    public Node2() throws RemoteException {
        super();
    }

    @Override
    public int operacao1(int x, int y) throws RemoteException {
        System.out.println("Operação 1 do Node2");
        int resultado = 2 * x * y;
        return resultado;
    }

}
