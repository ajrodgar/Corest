package CyclomaticComplexity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ejemplo1 {

    public static void main(String args[]) throws IOException {
       
        int x, y, z, max;
        System.out.println("Introduce x, y, z: ");
        x = 4;
        y = 5;
        z = 6;
        
        if (x > y && x > z) {
            max = x;
        } else if (z > y) {
            max = z;
        } else {
            max = y;
        }        
        System.out.println("El máximo es " + max);
    }
}
