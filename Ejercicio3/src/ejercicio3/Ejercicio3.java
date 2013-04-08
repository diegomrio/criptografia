package ejercicio3;

import java.math.BigInteger;

public class Ejercicio3 {
    
    private static BigInteger inversoZn(BigInteger a, BigInteger n) {
        BigInteger res = new BigInteger("0");
        
        
        return res;
    }

    public static void main(String[] args) {
        BigInteger[] a = new BigInteger[3];
        BigInteger[] m = new BigInteger[3];
        BigInteger[] invA = new BigInteger[3];
        BigInteger resM = new BigInteger("1");
        BigInteger resA = new BigInteger("0");
        
        a[0] = new BigInteger("1"); 
        a[1] = new BigInteger("2"); 
        a[2] = new BigInteger("3"); 
        m[0] = new BigInteger("2"); 
        m[1] = new BigInteger("5"); 
        m[2] = new BigInteger("7"); 
        
        
        
        for(int i = 0; i < 3; i++)
            resM = resM.multiply(m[i]);
        
        for(int i = 0; i < 3; i++)
            invA[i] = inversoZn(a[i], m[i]);
        
        for(int i = 0; i < 3; i++){
            System.out.println("Multiplicamos: "+a[i]+"*"+resM.divide(m[i])+"*"+a[i].modInverse(m[i]));
            resA = resA.add(a[i].multiply((resM.divide(m[i]))).multiply(a[i].modInverse(m[i])));
           
            
        }
        
        //resA = resA.mod(resM);
        
        System.out.println("La congruencia resultado es: x="+resA+"(mod "+resM+")");
    }

    
}
