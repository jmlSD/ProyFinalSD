package serversockets;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ServidorHilos {
 
    //public static void main(String[] args) {
        public void executeSCK(){
    try {
        int id = 1;
        ServerSocket ssk = new ServerSocket(8080);        
        while(true){
            Socket sk = ssk.accept();
            System.out.println("Servidor Sockets arriba, conexion de: " + sk.getInetAddress().getHostName());  
            Runnable r = new ManejadorHilos(sk, id);
            Thread t = new Thread(r);
            t.start();
            id++;
        }
    } catch (IOException ex) {
        Logger.getLogger(ServidorHilos.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
  
}
