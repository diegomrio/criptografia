
package pract1crip;

/**
 *
 * @author javier
 */

import java.math.BigInteger;
import java.math.BigDecimal;
import java.util.*;

public class Pract1CRIP {

    public static final BigInteger CERO = BigInteger.ZERO;
    public static final BigInteger UNO = BigInteger.ONE;
       
    // Calcula a elevado a b módulo p
    public static BigInteger Potencia(BigInteger b, BigInteger a, BigInteger p)
    {
        BigInteger r = new BigInteger("1");
        int j = 0, numbits;

        b = b.mod(p);
        numbits = a.bitLength();
        while(j < numbits) {
            if(a.testBit(j))
                r = r.multiply(b).mod(p);
            b = b.multiply(b).mod(p);
            j++;
        }
        
        return r;
    }
    
    // Calcula el logaritmo en base a de b módulo p
    // Devuelve null si no existiera
    public static BigInteger logaritmoDiscreto(BigInteger a, BigInteger b, BigInteger p){
        BigInteger i = new BigInteger("0");
        BigInteger aux = new BigInteger("0");
        BigInteger aux2 = new BigInteger("0");
        Map<BigInteger,BigInteger> S = new TreeMap<BigInteger,BigInteger>();
        
        // Cálculo de la primera aproximación de s
        BigInteger sB = sqrt(p).add(BigInteger.ONE);

        // Generar la tabla S
        while(i.compareTo(sB) <= 0) {
                aux = b.multiply(a.pow(i.intValue())).mod(p);
                S.put(aux,i);
                i = i.add(UNO);
                
        }

        // Generar los valores de la tabla T
        i = BigInteger.ONE;
        while(i.compareTo(sB) <= 0) {
                aux = Potencia(a,sB.multiply(i),p);
                aux2 = S.get(aux);
                if (aux2 != null)
                    return i.multiply(sB).subtract(aux2);
                i = i.add(UNO);
        }

        // Si se llega aquí, no existe el logaritmo
        return null;
    }
    
    // Calcula la raíz cuadrada de un BigInteger
    // Devuelve null si no existiera
    private static BigInteger sqrt(BigInteger m){
      int diff = m.compareTo(CERO);
      if (diff < 0)
          return null; // No existe la raíz cuadrada
      if (diff == 0)
          return BigInteger.valueOf(0);
      BigDecimal n = new BigDecimal(m);
      byte[] barray = new byte[m.bitLength()/16+1];
      barray[0] = (byte)255;
      BigDecimal two = new BigDecimal("2");
      BigDecimal r = new BigDecimal(new BigInteger(1,barray));
      r = r.subtract(r.multiply(r).subtract(n).divide(r.multiply(two),BigDecimal.ROUND_UP));
      while (r.multiply(r).compareTo(n) > 0)
         r = r.subtract(r.multiply(r).subtract(n).divide(r.multiply(two),BigDecimal.ROUND_UP));
      
      return r.toBigInteger();
   }
    


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         
        System.out.println("Parámetros con mismas cifras m (tq p primo), a(tq a<p), b(tq b<p.");
        
        if (args.length != 3){ 
           System.out.println("Número de parámetros incorrecto, introduce m, a y b.");
        }  
        
        long   inicio;
	long   fin;
	long   tiempo;
         
        BigInteger m = new BigInteger(args[0]); 
        BigInteger a = new BigInteger(args[1]);
        BigInteger b = new BigInteger(args[2]);
        BigInteger log = null;
        
        inicio = (new Date()).getTime();
        
    
             log = logaritmoDiscreto(a, b, m);
        
        fin = (new Date()).getTime();	
	tiempo = fin - inicio;
        
        System.out.println("Tiempo: "+(tiempo/1000)+" segundos");
        System.out.println("El logaritmo discreto es: "+log);
       
    }
    
}
