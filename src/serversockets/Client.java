package serversockets;

import java.io.*;
import java.net.*;
import java.util.*;
import java.util.logging.*;

public class Client {
    public static void main(String[] args) throws InterruptedException {
        
        try{
            Socket sk = new Socket("localhost", 8084);
            Scanner scan = new Scanner(System.in);
            
            DataOutputStream dos  = new DataOutputStream(sk.getOutputStream());
            DataInputStream dis = new DataInputStream(sk.getInputStream());
            Scanner opcion = new Scanner(System.in);
            int opc = -1;
           
            while(opc != 3){
            System.out.println(dis.readUTF());
            System.out.println(dis.readUTF());
            System.out.println(dis.readUTF());
            System.out.println(dis.readUTF());
            
            
            opc = Integer.parseInt(opcion.nextLine());
            dos.writeInt(opc);
            if(opc == 3)
                return;
            System.out.println(dis.readUTF());
            String s = scan.nextLine();
            dos.writeUTF(s);
            System.out.println(dis.readInt());
        }
            opcion.close();
            dos.close();
            sk.close();

        }catch(IOException ex){
             Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);

        }
    }
}
