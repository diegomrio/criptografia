package ejercicio3;

public class Ejercicio3 {

    public static void main(String[] args) {
        int[] a = new int[3];
        int[] m = new int[3];
        int resM=1, resA=0;
        a[0] = 1; 
        a[1] = 2;
        a[2] = 3;
        m[0] = 2; 
        m[1] = 5;
        m[2] = 7;
        
        for(int i = 0; i < 3; i++){
            resM = resM*m[i];
        }
    }
}
