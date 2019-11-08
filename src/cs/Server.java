package cs;

import org.apache.xmlrpc.*;

public class Server {        
    public static void main(String[] args){
        try{
            System.out.println("Iniciando el servidor");
            
            WebServer wbServer = new WebServer(8080);
            Funcionalidad fun = new Funcionalidad();
            wbServer.addHandler("myServer", fun);
        
            wbServer.start();
            
            System.out.println("Inicio exitoso del server\nSe conecto");
        }catch(Exception ex){
            System.err.println("Server: " + ex);
        }
        
    }
}
