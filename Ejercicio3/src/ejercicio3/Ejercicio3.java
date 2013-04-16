package ejercicio3;

import java.math.BigInteger;
import java.util.Date;

public class Ejercicio3 {
    
    public static void main(String[] args) {
        long   inicio;
	long   fin;
	long   tiempo;
        
        BigInteger[] a = new BigInteger[3];
        BigInteger[] m = new BigInteger[3];
        BigInteger resM = new BigInteger("1");
        BigInteger resA = new BigInteger("0");
        
        a[0] = new BigInteger("4"); 
        a[1] = new BigInteger("1"); 
        a[2] = new BigInteger("6"); 
        m[0] = new BigInteger("6"); 
        m[1] = new BigInteger("9"); 
        m[2] = new BigInteger("10"); 
            
        inicio = (new Date()).getTime();
        
        for(int i = 0; i < 3; i++)
            resM = resM.multiply(m[i]);
        
        for(int i = 0; i < 3; i++)
            resA = resA.add(a[i].multiply((resM.divide(m[i]))).multiply(resM.divide(m[i]).modInverse(m[i])));
        
        resA = resA.mod(resM);
        
        fin = (new Date()).getTime();	
	tiempo = fin - inicio;
        
        System.out.println("Tiempo: "+tiempo+" segundos");
        
        System.out.println("La congruencia resultado es: x="+resA+"(mod "+resM+")");
    }

    
}
