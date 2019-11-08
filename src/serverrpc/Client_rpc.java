package serverrpc;

import static java.lang.Thread.sleep;
import java.util.Scanner;
import java.util.Vector;
import org.apache.xmlrpc.*;

public class Client_rpc {
    
    public static void main(String[] args) {
        try{
            XmlRpcClient rpcClient = new XmlRpcClient("http://localhost:8080/");
            Vector<Integer> params = new Vector<Integer>();
            Scanner sc = new Scanner(System.in);
            System.out.println("Conexion exitosa");
            int x1 = sc.nextInt();
            int x2 = sc.nextInt();
            params.add(new Integer(x1));
            params.add(new Integer(x2));
            
            Object resS = rpcClient.execute("myServer.suma", params);
            int suma = ((Integer)resS).intValue();
            System.out.println("La suma es: " + suma);            
            
            sleep(10000);
        }catch(Exception ex){
            System.err.println("Client: " + ex);
        }        
    }    
}
