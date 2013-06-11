package ejercicio3;

import java.math.BigInteger;
import java.util.Date;

public class Ejercicio3 {
    
    public static int MCD(int a, int b) {
        int r;
        if (a<b) {
            r=a;
            a=b;
            b=r;
        }
        if(b == 0) return a;
            return MCD(b, a % b);
    }
    
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
        
        
        //Uso de BigInteger
        BigInteger [] a = new BigInteger[4];
        BigInteger [] b = new BigInteger[4];
        BigInteger [] m = new BigInteger[4];
        BigInteger auxMCD = new BigInteger("0");
        //BigInteger auxInv = new BigInteger("0");
        BigInteger auxAbs = new BigInteger("0");
        BigInteger auxA = new BigInteger("0");
        BigInteger auxB = new BigInteger("0");
        
        a[0] = new BigInteger("4"); 
        a[1] = new BigInteger("10"); 
        a[2] = new BigInteger("9");
        a[3] = new BigInteger("7");
        b[0] = new BigInteger("1"); 
        b[1] = new BigInteger("4"); 
        b[2] = new BigInteger("13"); 
        b[3] = new BigInteger("4"); 
        m[0] = new BigInteger("9"); 
        m[1] = new BigInteger("21"); 
        m[2] = new BigInteger("16");
        m[3] = new BigInteger("22");
        
        
        
        //Nuevo algoritmo
        
        BigInteger auxInv = new BigInteger("0");
        BigInteger auxA1 = new BigInteger("0");
        BigInteger auxA2 = new BigInteger("0");
        BigInteger auxA3 = new BigInteger("0");
        BigInteger auxDiv = new BigInteger("0");
        
        if(a[0].gcd(m[0]).compareTo(new BigInteger("1"))== 0){
            //Calculamos el inverso
            auxInv = a[0].modInverse(m[0]);
            
            //Multiplicamos todo por el inverso
            a[0] = a[0].multiply(auxInv).mod(m[0]);
            b[0] = b[0].multiply(auxInv).mod(m[0]);
            
            System.out.println("la solucion de la primera ec. es: "
                    + "x = "+b[0]+" + "+m[0]+"k1");
            
            //Guardamos el valor de a[1] antes de obtener el nuevo
            auxA1 = a[1];
            
            //Sustituimos la primera ec en la segunda
            a[1] = a[1].multiply(m[0]).mod(m[1]);
            b[1] = (b[1].subtract(auxA1.multiply(b[0]))).mod(m[1]);
            
            //Calculamos mcd de a[1] y m[1] e intentamos dividir 
            //toda la segunda ecuacion
            auxDiv = a[1].gcd(m[1]);
           
            if(b[1].remainder(auxDiv).compareTo(new BigInteger("0")) == 0){
                a[1] = a[1].divide(auxDiv);
                b[1] = b[1].divide(auxDiv);
                m[1] = m[1].divide(auxDiv);
            }
            
            //Calculamos el inverso de la segunda ecuacion
            //System.out.println(a[1]+" "+b[1]+" "+m[1]);
            auxInv = a[1].modInverse(m[1]);
            
            //Multiplicamos todo por el inverso
            a[1] = a[1].multiply(auxInv).mod(m[1]);
            b[1] = b[1].multiply(auxInv).mod(m[1]);
            
            System.out.println("la solucion de la segunda ec. es: "
                    + "k1 = "+b[1]+" + "+m[1]+"k2");
            
            b[0] = b[0].add(m[0].multiply(b[1]));
            m[0] = m[0].multiply(m[1]);
            
            System.out.println("la primer ec vale ahora: x = "
                    +b[0]+" + "+m[0]+"k2");
            
            //Sustituimos el valor de x en la tercera ec.
            auxA2 = a[2];
            a[2] = a[2].multiply(m[0]).mod(m[2]);
            b[2] = (b[2].subtract(auxA2.multiply(b[0]))).mod(m[2]);
            
            System.out.println("la tercera ec vale ahora:"+
                    a[2]+"k2 = "+b[2]+" (mod "+m[2]+")");
            
            
            //Calculamos el inverso de la tercera ecuacion
            auxInv = a[2].modInverse(m[2]);
            
            //Multiplicamos todo por el inverso
            a[2] = a[2].multiply(auxInv).mod(m[2]);
            b[2] = b[2].multiply(auxInv).mod(m[2]);
            
            System.out.println("la tercera ec vale ahora:"+
                    "k2 = "+b[2]+" + "+m[2]+"k3");
            
            b[0] = b[0].add(m[0].multiply(b[2]));
            m[0] = m[0].multiply(m[2]);
            
            System.out.println("la primera ec vale ahora: x = "
                    +b[0]+" + "+m[0]+"k3");
            
            
            //Sustituimos el valor de x en la cuarta ec.
            auxA3 = a[3];
            a[3] = a[3].multiply(m[0]).mod(m[3]);
            b[3] = (b[3].subtract(auxA3.multiply(b[0]))).mod(m[3]);
            
            System.out.println("la cuarta ec vale ahora:"+
                    a[3]+"k2 = "+b[3]+" (mod "+m[3]+")");
            
            
            
            //Calculamos mcd de a[3] y m[3] e intentamos dividir 
            //toda la segunda ecuacion
            auxDiv = a[3].gcd(m[3]);
           
            if(b[3].remainder(auxDiv).compareTo(new BigInteger("0")) == 0){
                a[3] = a[3].divide(auxDiv);
                b[3] = b[3].divide(auxDiv);
                m[3] = m[3].divide(auxDiv);
            }
            else{
                System.out.println("La ecuacion no tiene solucion");
            }
        }
            
    }

    
}
