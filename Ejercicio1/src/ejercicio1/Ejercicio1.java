package ejercicio1;

import java.math.BigInteger;
import java.util.Date;

public class Ejercicio1 {

    public static void main(String[] args) {
        
        long   inicio;
	long   fin;
	long   tiempo;
        int it = 999999999;
        
        BigInteger a = new BigInteger("1234567654");
        BigInteger b = new BigInteger("5781538327977828897150909166778407659250458379645823062042492461576758526757490910073628008613977550546382774775570888130029763571528699574717583228939535960234464230882573615930384979100379102915657483866755371559811718767760594919456971354184113724");
        
        BigInteger m = new BigInteger("5781538327977828897150909166778407659250458379645823062042492461576758526757490910073628008613977550546382774775570888130029763571528699574717583228939535960234464230882573615930384979100379102915657483866755371559811718767760594919456971354184113725");
        BigInteger bAux = new BigInteger("0");
        BigInteger x = new BigInteger("1");
        bAux = b;
        
        
        inicio = (new Date()).getTime();
        
        for(int i = 0; i < it; i++){
            while(bAux.signum() == 1){
                if( bAux.remainder(new BigInteger("2")).compareTo(new BigInteger("1")) == 0 )
                    x = x.multiply(a).mod(m);
            
                a = a.multiply(a).mod(m);
                bAux = bAux.divide(new BigInteger("2"));
            }
        }
        
        fin = (new Date()).getTime();	
	tiempo = fin - inicio;
        
        System.out.println("Tiempo: "+tiempo/it+" segundos");
        System.out.println("Resultado: "+x);
    }
}
