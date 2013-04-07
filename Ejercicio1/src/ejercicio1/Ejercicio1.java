package ejercicio1;

import java.math.BigInteger;
import java.util.Date;

public class Ejercicio1 {

    public static void main(String[] args) {
        
        long   inicio;
	long   fin;
	long   tiempo;
        
        BigInteger a = new BigInteger("664587548476");
        BigInteger b = new BigInteger("654");
        BigInteger m = new BigInteger("3");
        BigInteger bAux = new BigInteger("0");
        BigInteger x = new BigInteger("1");
        bAux = b;
        
        System.out.println("baux vale: "+bAux);
        
        inicio = (new Date()).getTime();
        
        while(bAux.signum() == 1){
            if( bAux.remainder(new BigInteger("2")).equals(1))
                x = x.multiply(a);
            
            a = a.multiply(a);
            bAux = bAux.divide(new BigInteger("2"));
        }
        
        fin = (new Date()).getTime();	
	tiempo = fin - inicio;
        
        System.out.println("Tiempo: "+tiempo/1000+" segundos");
        System.out.println("Resultado: "+x);
    }
}
