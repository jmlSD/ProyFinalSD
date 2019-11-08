package cs;

import java.io.IOException;
import static java.lang.Thread.sleep;
import java.net.MalformedURLException;
import java.util.Scanner;
import java.util.Vector;
import static jdk.nashorn.internal.objects.NativeError.printStackTrace;
import org.apache.xmlrpc.XmlRpcClient;
import org.apache.xmlrpc.XmlRpcException;
import serverrpc.*;

public class Funcionalidad {
    XmlRpcClient conexionRPC;
    public String desplegaMenu(){
        return "----- Bienvenido al Sistema Jhonys -----\n¿Con qué tipo de servidor desear trabajar?\n1.- Sockets\n2.- RPC\n3.- RMI\n\n"
                + "Presiona el numero correspondiente a la opción: ";
    }
    public String solicitudMenu(int opc){
        String resultado = "";
        if(opc == 1){
            
            return "Llamar a Sockets";
            
        }else if(opc == 2){           
            
            try{
                this.conexionRPC = conectaRPC();
                Vector<Integer> params = new Vector<Integer>();
                System.out.println("Conexion exitosa al servidor RPC");
                Object menu = conexionRPC.execute("myServerRPC.desplegaMenu", params);
                resultado = (String) menu;

            }catch(Exception ex){
                System.err.println("Client: " + ex);
            }
            return resultado;
        }else if(opc == 3){
            return "Llamar a RMI";
        }else{
            return "Opcion no valida";
        }        
    }
    
    public String procesamiento(int opc, int x1, int x2) throws XmlRpcException, IOException{
        int suma = 0;        
      
        Vector<Integer> params = new Vector<Integer>();
        params.add(x1);
        params.add(x2);
        if(opc == 1){
            Object resS = conexionRPC.execute("myServerRPC.suma", params);
            suma = ((Integer)resS).intValue();
            System.out.println("La suma es: " + suma);
            return "La suma es: "+suma;
        }else if(opc == 2){
            Object resS = conexionRPC.execute("myServerRPC.resta", params);
            int resta = ((Integer)resS).intValue();
            System.out.println("La resta es: " + resta);
            return "La resta es: "+resta;
        }else if(opc == 3){
            //Debemos cerrar la conexion con serverRPC
            
        }
        return "Opcion no valida";       
    }
    
    public XmlRpcClient conectaRPC() throws MalformedURLException{
        XmlRpcClient conexioRPC;
        
        Server_rpc srpc = new Server_rpc();
        srpc.executeRPC();        
        conexioRPC = new XmlRpcClient("http://localhost:8081/");
        
        return conexioRPC;
    }
}
