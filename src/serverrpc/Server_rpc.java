package serverrpc;

import org.apache.xmlrpc.*;

public class Server_rpc {        
    //public static void main(String[] args){
    public void executeRPC(){
        try{
            System.out.println("Iniciando el servidor RPC");
            
            WebServer wbServer = new WebServer(8081);
            OperacionMatematica opMat = new OperacionMatematica();
            wbServer.addHandler("myServerRPC", opMat);
        
            wbServer.start();
            System.out.println("Inicio exitoso del server RPC \n");
        }catch(Exception ex){
            System.err.println("Server: " + ex);
        }
        
    }
}
