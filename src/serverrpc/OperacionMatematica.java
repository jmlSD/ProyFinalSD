package serverrpc;

public class OperacionMatematica {
    public int suma(int a, int b){
        return a + b;
    }
    
    public int resta(int a, int b){
        return a - b;
    }
    
    public int mult(int a, int b){
        return a*b;
    }
    
    public float div(int a, int b){
        return (a/b);
    }
    
    public String desplegaMenu(){
        return "1.- Suma\n2.- Resta\n3.-Salir\n\n"
                + "Presiona el numero correspondiente a la opción: ";
    }
}
