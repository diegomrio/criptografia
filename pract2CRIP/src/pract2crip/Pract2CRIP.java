
package pract2crip;

/**
 *
 * @author Javier
 */

import java.util.*;

public class Pract2CRIP {
    
/*Dada una sucesion de bits, determine si es o no periodica, y en caso afirmativo,
determine la longitud del periodo (para que sea periodica, el periodo debe
aparecer en la sucesion al menos dos veces).
*/   
    public static int is_periodic(int[] arraySuc) {
       
        return 0;           
    }
    
    
/*Dado un polinomio p(x) 2 Z2[x] de grado n, y tal que p(0) = 1, y una
sucesion de n bits, construya la sucesion pseudo-aleatoria que generarıa un LFSR,
con polinomio de conexion p(x), y semilla la sucesion de n bits dada. La salida
debe ser guardada en un fichero de texto, y debe contener, al menos, dos veces el
periodo.
*/     
    public static void LFSR(int[] arraySuc, int[] pol) {
          
    }
    
    
/*Dada una sucesion de bits periodica, determine la complejidad lineal de dicha
sucesion, y el polinomio de conexion que la genera. Para esto, se usara el algoritmo
de Berlekamp-Massey.
*/    
    public static int berlekamp_massey(int[] array) {
        final int N = array.length;
        int[] b = new int[N];
        int[] c = new int[N];
        int[] t = new int[N];
        b[0] = 1;
        c[0] = 1;
        int l = 0;
        int m = -1;
        for (int n = 0; n < N; n++) {
            int d = 0;
            for (int i = 0; i <= l; i++) {
                d ^= c[i] * array[n - i];
            }
            if (d == 1) {
                System.arraycopy(c, 0, t, 0, N); 
                int N_M = n - m;
                for (int j = 0; j < N - N_M; j++) {
                    c[N_M + j] ^= b[j];
                }
                if (l <= n / 2) {
                    l = n + 1 - l;
                    m = n;
                    System.arraycopy(t, 0, b, 0, N);
                }
            }
        }
        return l;
    }
    
    
/*Dadas dos (o mas) sucesiones periodicas, y una funcıon de mezcla, construya
la nueva sucesion que resulta de aplicar la funcion de mezcla a las sucesiones dadas.
*/
    public static void mixing_function(ArrayList arraysSucs, int[] arraySucNew) {
         
    }
    
    
    
    
     public static void main(String[] args) {
     
     }

    
}
