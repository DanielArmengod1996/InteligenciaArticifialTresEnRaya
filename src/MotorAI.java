import java.util.Random;
import java.util.Scanner;

public class MotorAI {
    static final double E = 0.6;
    public static void main(String ...args){
        //entrada
        int[][] tb = {{1, 1, 1},{1, -1, 1}, {-1, -1, -1}, {-1, 1, 1}};

        double w1, w2, θ, y;
        w1 = new Random().nextDouble() / 2.5;
        w2 = new Random().nextDouble() / 2.5;
        θ = -0.4;

        y = 0;
        System.out.println("w1: " + w1);
        System.out.println("w2: " + w2);
        System.out.println("θ: " + θ);

        //INICIACION DEL APRENDIZAJE MEDIANTE LA PUERTA LÓGICA OR

        int i, cont;
        i = 0;
        cont = 1;

        while(i < tb.length && cont < 100){
            y = Math.tanh((tb[i][0] * w1) + (tb[i][1] * w2) + (-1 * 0));
            y = (y >= 0) ? 1 : -1;

            System.out.println("Entrada[" + tb[i][0] + "," + tb[i][1]
                    + "]) Valor esperado[" + tb[i][2]
                    + "] Salida[" + (int) y + "]");
            if (y == tb[i][2]) {
                i++;
            } else {
                System.out.println("Valor esperado diferente de la salida. Hay que reajustar pesos...");
                //Ajuste de pesos
                w1 = w1 + 2 * E * tb[i][2] * tb[i][0];
                w2 = w2 + 2 * E * tb[i][2] * tb[i][1];
                θ = θ + 2 * E * tb[i][2] * (-1);

                System.out.println("\nAjuste de pesos (" + cont + "):");
                System.out.println("w1: " + w1);
                System.out.println("w2: " + w2);
                System.out.println("θ: " + θ + "\n");
                cont++;
                i = 0;
            }
        }

        if (cont <= 99999) {
            System.out.println("\nFase de aprendizaje terminado con exito ");
            System.out.println("\nResultados:");
            System.out.println("w1: " + w1);
            System.out.println("w2: " + w2);
            System.out.println("θ: " + θ);
            System.out.println("\nIniciando fase de testeo...");
            System.out.println("Introduce Entrada 1 (X1): ");
            Scanner leerX1 = new Scanner(System.in);
            double x1 = Double.parseDouble(leerX1.next());

            System.out.println("Introduce Entrada 2 (X2): ");
            Scanner leerX2 = new Scanner(System.in);
            double x2 = Double.parseDouble(leerX2.next());

            y = Math.tanh((x1 * w1) + (x2 * w2) + (-1 * θ));
            y = (y >= θ) ? 1 : -1;

            System.out.println("\nSalida: " + (int)y);
        } else {
            System.out.println("\nFase de aprendizaje ha fallado\n");
        }
        
    }
    
}
