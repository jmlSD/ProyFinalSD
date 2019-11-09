package serverrmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface InterfazRMI extends Remote{
    float sumar(float numero1, float numero2) throws RemoteException;
    float restar(float numero1, float numero2) throws RemoteException;    
    String mostrarMenu() throws RemoteException;
}