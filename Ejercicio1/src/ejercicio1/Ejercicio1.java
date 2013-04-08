package ejercicio1;

import java.math.BigInteger;
import java.util.Date;

public class Ejercicio1 {

    public static void main(String[] args) {
        
        long   inicio;
	long   fin;
	long   tiempo;
        
        BigInteger a = new BigInteger("66548478465654321");
        BigInteger b = new BigInteger("25521");
        BigInteger m = new BigInteger("7");
        BigInteger bAux = new BigInteger("0");
        BigInteger x = new BigInteger("1");
        bAux = b;
        
        
        inicio = (new Date()).getTime();
        
        while(bAux.signum() == 1){
            if( bAux.remainder(new BigInteger("2")).compareTo(new BigInteger("1")) == 0 )
                x = x.multiply(a);
            
            a = a.multiply(a);
            bAux = bAux.divide(new BigInteger("2"));
        }
        
        x = x.mod(m);
        
        fin = (new Date()).getTime();	
	tiempo = fin - inicio;
        
        System.out.println("Tiempo: "+tiempo/1000+" segundos");
        System.out.println("Resultado: "+x);
    }
}
