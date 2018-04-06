package br.edu.ifpb.quest1_cliete;

import br.edu.ifpb.quest1_shared.Op1;
import br.edu.ifpb.quest1_shared.Op2;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

/**
 *
 * @author Edilva
 */
public class Main {

    public static void executeOperacao2(int x, int y) {

        boolean connected = false;

        Op2 op2Supporter = null;

        while (!connected) {

            try {

                op2Supporter = (Op2) Naming.lookup("//localhost:1099/Node3");

                connected = true;

            } catch (MalformedURLException | NotBoundException | RemoteException ex) {

            }

            if (op2Supporter == null) {

                try {

                    op2Supporter = (Op2) Naming.lookup("//localhost:1097/Node1");

                    connected = true;

                } catch (MalformedURLException | NotBoundException | RemoteException ex) {

                }
            }

            if (op2Supporter == null) {

                System.err.println("Tentando novamente...");
            } else {

                try {
                    System.out.println("The sum result is: " + op2Supporter.operacao2(x, y));
                } catch (RemoteException ex) {
                }
            }

        }

    }

    public static void executeOperacao1(int x, int y) {

        boolean connected = false;

        Op1 op1 = null;

        while (!connected) {

            try {

                op1 = (Op1) Naming.lookup("//localhost:1098/Node2");

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

                try {

                    op1 = (Op1) Naming.lookup("//localhost:1099/Node3");

                    connected = true;

                } catch (MalformedURLException | NotBoundException | RemoteException ex) {

                }
            }

            if (op1 == null) {

                System.err.println("Tentando novamente...");
            } else {

                try {
                    System.out.println("The sum result is: " + op1.operacao1(x, y));
                } catch (RemoteException ex) {
                }
            }

        }

    }

    public static void main(String[] args) throws InterruptedException {
        executeOperacao1(3, 2);
        executeOperacao2(3, 2);
    }

}
