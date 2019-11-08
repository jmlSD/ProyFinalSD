package cs;

import static java.lang.Thread.sleep;
import java.util.Scanner;
import java.util.Vector;
import org.apache.xmlrpc.*;

public class Client {
    
    public static void main(String[] args) {
        try{
            XmlRpcClient rpcClient = new XmlRpcClient("http://localhost:8080/");
            Vector<Integer> params = new Vector<Integer>();
            int opc = 0; 
            Object procMenu;
            Scanner sc = new Scanner(System.in);
            System.out.println("Conexion exitosa");            
            
            Object menu = rpcClient.execute("myServer.desplegaMenu", params);
            do{ 
                params.clear();
                System.out.println(menu);

                opc = sc.nextInt();
                params.add(new Integer(opc));

                procMenu = rpcClient.execute("myServer.solicitudMenu", params);
                System.out.println(procMenu);
            }while(procMenu.equals(new String("Opcion no valida")));
            params.clear();
            
            opc = sc.nextInt();// 1 o 2            
            System.out.println("Dame los valores de x1 y x2");
            int x1 = sc.nextInt();
            int x2 = sc.nextInt();
            
            params.add(new Integer(opc));
            params.add(new Integer(x1));
            params.add(new Integer(x2));            
            Object procOper = rpcClient.execute("myServer.procesamiento", params);
            System.out.println(procOper);
            
            
            sleep(10000);
        }catch(Exception ex){
            System.err.println("Client: " + ex);
        }        
    }    
}
