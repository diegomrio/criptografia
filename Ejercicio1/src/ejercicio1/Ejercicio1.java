package ejercicio1;

public class Ejercicio1 {

    public static void main(String[] args) {
        
        int a, b, bAux, m, x;
        bAux = b;
        
        while(bAux > 0){
            if((bAux % 2) == 1)
                x = x * a;
            
            a = a * a;
            b = b / 2;
        }
    }
}
