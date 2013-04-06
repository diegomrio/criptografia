package ejercicio1;

import java.util.Date;

public class Ejercicio1 {

    public static void main(String[] args) {
        
        long   inicio;
	long   fin;
	long   tiempo;
        
        int a=543, b=34, bAux, m=5, x=1;
        bAux = b;
        
        inicio = (new Date()).getTime();
        
        while(bAux > 0){
            if((bAux % 2) == 1)
                x = x * a;
            
            a = a * a;
            bAux = bAux / 2;
        }
        
        fin = (new Date()).getTime();	
	tiempo = fin - inicio;
        
        System.out.println("Tiempo: "+tiempo+" milisegundos");
        System.out.println("Resultado: "+x);
    }
}
