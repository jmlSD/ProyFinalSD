package serversockets;

import funciontareas.*;
import java.io.*;
import java.net.Socket;
import java.util.logging.*;

public class ManejadorHilos implements Runnable {
    
    private DataInputStream dis;
    private DataOutputStream dos;
    private FileWriter fileW;
    private Socket sk;
    private int id;
    private int aux, opc;

    public ManejadorHilos(Socket sk, int id,int aux) {
        this.sk = sk;
        this.id = id;
        this.aux = aux;
    }
    
    @Override 
    public void run(){
        System.out.println("conexion SCK " + id + " recibida--->"+ sk.getInetAddress().getHostName());
        try {         
            System.out.println("antes de los flujpos");
            this.dis = new DataInputStream(sk.getInputStream());
            this.dos = new DataOutputStream((sk.getOutputStream()));
            
            System.out.println("estoy en en while");
            System.out.println(aux);
                if(this.aux == 0){
                    dos.writeUTF("Elige una opcion:");
                    dos.writeUTF("1.- Buscar una letra");
                    dos.writeUTF("2.- Buscar una palabra");
                    dos.writeUTF("3.- Salir");  
                }else if(this.aux==1){
            
            
            System.out.println("Espero una opcion");
            //int variable = dis.readInt();
            
            //System.out.println("la opc escogida en aux = 1 " + variable);
            
                }else if(this.aux == 2){
                    //System.out.println("aux =2" + dis.readUTF());
                    opc = dis.readInt();
                    System.out.println("lei opc" + opc);
                    String dato = dis.readUTF();
                
            switch(opc){
                case 1:
                    //dos.writeUTF("Letra a buscar: ");
                    //String dato = dis.readUTF();
                    Tarea3A p = new Tarea3A();
                    dos.writeInt(p.tareaA(dato));
                    //System.out.println(dis.readInt());                    
                break;
                case 2:
                    //dos.writeUTF("Palabra a buscar: ");
                    Tarea3B h = new Tarea3B();
                    h.tareaB(dato);
                    dos.writeInt(h.getApariciones());
                    //System.out.println(dis.readInt());                    
                break;
                case 3:
                    System.exit(0);
                    break;
                default:
                    dos.writeUTF("La opción ingresada no es válida");
                break;
            }
                }else{
                    System.out.println("Estoy en else");
                }
            //aux = 0;
            //return;
                
            } catch (IOException ex) {
            Logger.getLogger(ManejadorHilos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(ManejadorHilos.class.getName()).log(Level.SEVERE, null, ex);
        }

        }
}
    
    
    

