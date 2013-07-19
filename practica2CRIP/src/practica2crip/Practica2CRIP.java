
package practica2crip;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 *
 * @author javier
 */

public class Practica2CRIP {

    
   /**
    * Metodo que dada una sucesion de bits, detetrmina si es o no periodica, y en caso afirmativo,
    * determina la longitud del periodo (para que sea periodica, el periodo debe
    * aparecer en la sucesion al menos dos veces).
    * @param suc Sucesion de bits que se va a comprobar.
    * @return La longitud del periodo si es periodica o -1 si no lo es.
    * @throws ArrayIndexOutOfBoundsException 
    */
    public static int is_periodic(String suc) throws ArrayIndexOutOfBoundsException{ 
        int i, begin, end, beginAux, endAux, repetitions;
        
        begin=0;
        for (i = 1; i < suc.length(); i++) {
            repetitions=1;
            if (suc.charAt(0) == suc.charAt(i)){
                end=i; 
                beginAux=i;
                endAux=i*2;
                //Solamente se entra para comprobar las subsecuencias que contienen el periodo completo
                while(endAux <= suc.length() && (equal(suc.substring(begin, end),suc.substring(beginAux, endAux)))){
                    repetitions++;
                    beginAux+=i;
                    endAux+=i;
                }
                //Solamente se entra si las dos ultimas subsecuencias coincidieron
                if ((endAux > suc.length()) || (equal(suc.substring(begin, end),suc.substring(beginAux, endAux)))){  
                    /*Comparar la ultima subsecuencia  aunque no contenga el periodo entero (tambien seria valido).
                      Si esta coincide y anteriormente hubo un minimo de 2 repeticiones del periodo se devuelve la 
                      longitud del periodo, en caso contrario se devuelve -1*/
                    if(suc.substring(begin, suc.substring(beginAux).length()).compareTo(suc.substring(beginAux))==0){ 
                        if(repetitions>=2){
                            System.out.println("El periodo se repite: "+repetitions+" veces");
                            String aux="El periodo obtenido es: ";
                            String concat = aux.concat(suc.substring(begin, end));
                            System.out.println(concat);
                        
                            return i;
                        }
                        else
                            return -1;
                    }
                }
            }
        }   
        return -1; 
    }
    
    
    
   /**
    * Metodo que dadas dos sucesiones de bits determina si son iguales
    * es llamado desde 'is_periodic(String suc)'
    * @param suc1 Sucesion de bits que se va a comprobar.
    * @param suc2 La otra sucesion de bits que se va a comprobar.
    * @return True si las dos sucesiones son iguales o False si son distintas.
    * @throws ArrayIndexOutOfBoundsException 
    */
    public static boolean equal(String suc1,String suc2) throws ArrayIndexOutOfBoundsException{ 
        
        if (suc1.compareTo(suc2)==0)
            return true;
        else     
            return false;
    }
   
    
 
   /**
    * Metodo que construye la sucesion pseudo-aleatoria que generarıa un LFSR,
    * con polinomio de conexion p(x), y semilla la sucesion de n bits dada. La salida
    * debe ser guardada en un fichero de texto, y debe contener, al menos, dos veces el
    * periodo.
    * @param semSuc Semilla, la sucesion de n bits dada
    * @param polConex Polinomio p(x) perteneciente a Z2[x] de grado n, y tal que p(0) = 1
    * c(D) = D⁴ + D¹ + 1 -> 1001 y s0 = 1, s1 = 0, s2 = 0, s3 = 1 -> 1001
    * 100100011110101 100100011110101 100100011110101.....
    */
    public static String LFSR(String semSuc, String pol, int sizeOutput) { 
        int output = 0;
        StringBuffer sucAux = new StringBuffer();
        int[] vec = new int[sizeOutput]; //Se crea el vector que hace de buffer  de tamaño pasado desde la interfaz o  igual (2^n-1)*2 por defecto
        //Copia la semilla inicial en el buffer
        for (int i = 0; i < semSuc.length(); i++){ 
            if(semSuc.charAt(i) == '1')
                vec[i] = 1; 
            else
                vec[i] = 0;
        }
        //Se crea el vector que hace de polinomio de conexion
        int[] polCon = new int[pol.length()]; 
        for (int i = 0; i < pol.length(); i++){ 
           if(pol.charAt(i) == '1')
                polCon[i] = 1; 
            else
                polCon[i] = 0;
        }
        
        //Mientras no se rellene el vector a partir de la semilla ya introducida  
        for (int i = semSuc.length(); i < vec.length; i++){  
            //c(D) = D⁴ + D¹ + 1 --> 11001000......
            output = 0;
            for (int j = 0; j < polCon.length; j++){ 
                 output ^= polCon[j]*vec[j];
            }
            //Va insertando en el vector que contendra el (periodo dos veces) 
            //Desplaza los elementos anteriores a la derecha e inserta la salida al principio del buffer
            for (int k = i; k > 0; k--)
                vec[k] = vec[k-1];
            vec[0] = output;
        }
        
        //Pasar el vector a un string para imprimir, pasandolo en orden invertido
        for (int i = vec.length-1; i >= 0 ; i--){ 
            if(vec[i] == 1)
                sucAux.append('1'); 
            else
                sucAux.append('0');
        }
        
        return sucAux.toString();
   }
     
    
      
   /**
    * Algoritmo de Berlekamp-Massey que dada una sucesion de bits periodica, determina la complejidad lineal 
    * de dicha sucesion, y el polinomio de conexion que la genera.
    * @param suc sucesion de bits periodica.
    * @return un string con la la complejidad lineal y el polinomio de conexion que la genera.
    * c(D) = D⁴ + D¹ + 1  y s0 = 1, s1 = 0, s2 = 0, s3 = 1
    * 100100011110101 100100011110101 100100011110101.....
    * c(D) = D³ + D¹ + 1 y s0 = 1, s1 = 0, s2 = 1  
    * 1010011 1010011 1010011....
    */ 
    @SuppressWarnings("empty-statement")
    public static String berlekamp_massey(int[] array) {
        String s = new String();
        String suc = new String();
        final int N = array.length;
        int[] b = new int[N];
        int[] c = new int[N];
        int[] t = new int[N];
        int cont = 0;
        
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
                for (int j = 0; j< (N-(n-m)); j++) {
                    c[((n-m)+j)] ^= b[j];
                }
                if (l <= n / 2) {
                    l = n + 1 - l;
                    m = n;
                    System.arraycopy(t, 0, b, 0, N);
                }
            }
        }
        suc+="La complejidad lineal es: ";
        suc+=Integer.toString(l);
        suc+= ", y el polinomio de conexion es: ";
        //Eliminar ceros a la derecha
        for (cont = c.length-1; c[cont] != 1; cont--)
             ;
            
        for (int i = 0; i <= cont; i++){
             if (c[i]==1) 
                 s+= '1';
             else 
                 s+= '0';
        }
        suc+=s;
        
        return suc;
    }

  
    
    
   /**
    * Metodo que a partir de dos o mas sucesiones genera una sucesion por medio de la operacion AND de las sucesiones dadas.
    * @param listSuc lista con las sucesiones dadas, tiene que haber dos o mas.
    * @return la nueva sucesion
    */
    public static String mixing_function_AND(List<String> listSuc){
        
        StringBuffer sucNew = new StringBuffer(listSuc.get(0));
        
        for (int i = 1; i < listSuc.size(); i++){
            StringBuffer sucAux = new StringBuffer(listSuc.get(i));
            
            for (int j = 0; j < sucNew.length(); j++){
                if (sucNew.charAt(j)=='1' && sucAux.charAt(j)=='1') 
                    sucNew.setCharAt(j,'1');
                else 
                    sucNew.setCharAt(j,'0');
            } 
        }
        return sucNew.toString();
    }
    
    
    
    /**
     * Metodo que a partir de dos o mas sucesiones genera una sucesion por medio de la operacion XOR de las sucesiones dadas.
     * @param listSuc lista con las sucesiones dadas, teienes que haber dos o mas.
     * @return la nueva sucesion
     */
     public static String mixing_function_XOR(List<String> listSuc){
        
       StringBuffer sucNew = new StringBuffer(listSuc.get(0));
        
        for (int i = 1; i < listSuc.size(); i++){
            StringBuffer sucAux = new StringBuffer(listSuc.get(i));
            
            for (int j = 0; j < sucNew.length(); j++){
                if ((sucNew.charAt(j)=='0' && sucAux.charAt(j)=='1') || (sucNew.charAt(j)=='1' && sucAux.charAt(j)=='0')) 
                    sucNew.setCharAt(j,'1');
                else
                    sucNew.setCharAt(j,'0');
            } 
        }
        return sucNew.toString();
    }
     
     
     
   /**
    * Metodo usado para las entradas desde ficheros de texto 
    * @return un objeto BufferedReader el cual sera leido desde el metodo que llame a este o null si el fichero esta vacio
    * @throws IOException 
    */
    public static BufferedReader reader() throws IOException { 
        try {
            FileReader fr = new FileReader("/home/javier/NetBeansProjects/practica2CRIP/src/practica2crip/entrada.txt");
            BufferedReader entrada = new BufferedReader(fr);
            
            return entrada;
        }
        catch(java.io.FileNotFoundException fnfex) {
        System.out.println("Archivo de texto no encontrado: " + fnfex);}
        catch(java.io.IOException ioex) {}
        
        return null;
     }  
 
 
    
    /**
     * Metodo usado para las salidas a ficheros de texto
     * @param sucesion la secuencia de unos y ceros que se escribe en el fichero
     * @throws IOException 
     */
     public static void writer(String sucesion) throws IOException {   
        try {
            FileWriter fw = new FileWriter("/home/javier/NetBeansProjects/practica2CRIP/src/practica2crip/salida.txt");
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter salida = new PrintWriter(bw);
            salida.println(sucesion);
            salida.close();

            /*Modo append
            FileWriter fw = new FileWriter("/home/javier/NetBeansProjects/practica2CRIP/src/practica2crip/salida.txt");
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter salida = new PrintWriter(bw);
            salida.println(sucesion);
            salida.close();
            **/
        }
        catch(java.io.IOException ioex) {}
     } 
     
     
     
     /**
      * Metodo usado para realizar potencias
      * @param base base de la potencia
      * @param exponente esponente de la potencia
      * @return la potencia
      */
     public static int pow(int base, int exponente){ 
        int pow=1; 
         
        for(int i=1;i<=exponente;i++)
             pow*=base;
      
        return pow;
     }
     
     
       
     /**
      * @param args the command line arguments
      */
      public static void main(String[] args) {
        new interfazOperaciones().setVisible(true);
    }
}
