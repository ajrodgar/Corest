package CyclomaticComplexity;


public class Ejemplo2 {
    
    private void calculate(int x) {

       if (x % 4 == 0) {
            if (x % 100 == 0) {
                if (x % 400 == 0) {
                    System.out.println("Es bisiesto");
                } else {
                    System.out.println("No es bisiesto");
                }
            } else {
                System.out.println("Es bisiesto");                
                if (x % 100 == 0) {
                    if (x % 400 == 0) {
                        System.out.println("Es bisiesto");
                    } else {
                        System.out.println("No es bisiesto");
                    }
                } else {
                    System.out.println("Es bisiesto");
                }
            }
        } else {
            System.out.println("No es bisiesto");

            if (x % 4 == 0) {
                if (x % 100 == 0) {
                    if (x % 400 == 0) {
                        System.out.println("Es bisiesto");
                    } else {
                        System.out.println("No es bisiesto");
                    }
                } else {
                    System.out.println("Es bisiesto");
                }
            } else {
                System.out.println("No es bisiesto");
            }
        }
    }

}
