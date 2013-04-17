package ejercicio3;

import java.math.BigInteger;
import java.util.Date;

public class Ejercicio3 {
    
    public static void main(String[] args) {
        long   inicio;
	long   fin;
	long   tiempo;
        
        /*BigInteger[] a = new BigInteger[3];
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
        
        System.out.println("La congruencia resultado es: x="+resA+"(mod "+resM+")");*/
        
        BigInteger [] a = new BigInteger[3];
        BigInteger [] b = new BigInteger[3];
        BigInteger [] m = new BigInteger[3];
        BigInteger auxMCD = new BigInteger("0");
        BigInteger auxInv = new BigInteger("0");
        BigInteger auxAbs = new BigInteger("0");
        BigInteger auxA = new BigInteger("0");
        BigInteger auxB = new BigInteger("0");
        
        a[0] = new BigInteger("1"); 
        a[1] = new BigInteger("1"); 
        a[2] = new BigInteger("1"); 
        b[0] = new BigInteger("1"); 
        b[1] = new BigInteger("2"); 
        b[2] = new BigInteger("3"); 
        m[0] = new BigInteger("2"); 
        m[1] = new BigInteger("5"); 
        m[2] = new BigInteger("7");
        
        if(a[0].gcd(m[0]).mod(b[0]).equals(new BigInteger("0"))){
            auxMCD = a[0].gcd(m[0]);
            a[0] = a[0].divide(auxMCD);
            b[0] = b[0].divide(auxMCD);
            m[0] = m[0].divide(auxMCD);
                
            auxInv = a[0].modInverse(m[0]);
            a[0] = a[0].multiply(auxInv).mod(m[0]);
            b[0] = b[0].multiply(auxInv).mod(m[0]);
        }
        
        System.out.println(a[0]+" = "+b[0]+"(mod "+m[0]+")");
        
            
        for(int i = 1; i < 3; i++){    
            auxA = (a[i].multiply(m[i-1])).mod(m[i]);
            
            auxB = ((b[i].subtract(b[i-1].multiply(a[i]))).abs()).mod(m[i]);
            System.out.println("b[i]: "+b[i]);
            System.out.println("b[i-1]: "+b[i-1]);
            System.out.println("a[i]: "+a[i]);
            System.out.println(b[i].subtract(b[i-1].multiply(a[i])));
            //auxAbs = (b[i].subtract(b[i-1].multiply(a[i]))).abs();  
            //b[i] = auxAbs.mod(m[i]);
            System.out.println(b[i]+"-"+b[i-1]+"*"+a[i]);
            a[i] = auxA;
            b[i] = auxB;
            
            //if(a[i].gcd(m[i]).mod(b[i]).equals(new BigInteger("0"))){
            if(a[i].gcd(m[i]).remainder(b[i]).equals(new BigInteger("0"))){
                auxMCD = a[i].gcd(m[i]);
                a[i] = a[i].divide(auxMCD);
                b[i] = b[i].divide(auxMCD);
                m[i] = m[i].divide(auxMCD);
                
                auxInv = a[i].modInverse(m[i]);
                a[i] = a[i].multiply(auxInv).mod(m[i]);
                b[i] = b[i].multiply(auxInv).mod(m[i]);
            }
        }
        
        System.out.println("La congruencia resultado es: x="+b[2]+"(mod "+m[2]+")");
    }

    
}
