package ejercicio1;

import java.math.BigInteger;
import java.util.Date;

public class Ejercicio1 {

    public static void main(String[] args) {
        
        long   inicio;
	long   fin;
	long   tiempo;
        
        BigInteger a = new BigInteger("888888888888888");
        BigInteger b = new BigInteger("123456789");
        BigInteger m = new BigInteger("12345");
        BigInteger bAux = new BigInteger("0");
        BigInteger x = new BigInteger("1");
        bAux = b;
        
        
        inicio = (new Date()).getTime();
        
        while(bAux.signum() == 1){
            if( bAux.remainder(new BigInteger("2")).compareTo(new BigInteger("1")) == 0 )
                x = x.multiply(a).mod(m);
            
            a = a.multiply(a).mod(m);
            bAux = bAux.divide(new BigInteger("2"));
        }
        
        fin = (new Date()).getTime();	
	tiempo = fin - inicio;
        
        System.out.println("Tiempo: "+tiempo/1000+" segundos");
        System.out.println("Resultado: "+x);
    }
}
