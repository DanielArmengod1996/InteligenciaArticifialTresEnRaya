import java.util.Random;

public class MotorAI {
    static int[]matrix;
    static final double E = 0.6;
    public static int[] learn(int[][] tb){
        //entrada
        //int[][] tb = {{1, 1, 1},{1, -1, 1}, {-1, -1, -1}, {-1, 1, 1}};
        double[][] xRes = new double[9999][9999];

        double w, θ, y;

        for (int i = 0; i < tb.length; i++) {
            for (int j = 0; j < tb[i].length; j++) {
                w = new Random().nextDouble() / 2.5;
                xRes[i][j] = w;
            }
        }
        θ = -0.4;

        y = 0;

        System.out.println("θ: " + θ);

        int i, cont;
        i = 0;
        cont = 1;

        while(i < tb.length && cont < 100){
            for (int j = 0; j < tb[i].length; j++) {
                y = Math.tanh((tb[i][j] * xRes[i][j]) + (tb[i][j] * xRes[i][j]) + (-1 * 0));
                y = (y >= 0) ? 1 : -1;

                System.out.println("Entrada[" + tb[i][j] + "," + tb[i][j]
                        + "]) Valor esperado[" + tb[i][j]
                        + "] Salida[" + (int) y + "]");
                if (y == tb[i][j]) {
                    i++;
                } else {
                    System.out.println("Valor esperado diferente de la salida. Hay que reajustar pesos...");
                    //Ajuste de pesos
                    xRes[i][j] = xRes[i][j] + 2 * E * tb[i][j] * tb[i][j];
                    θ = θ + 2 * E * tb[i][j] * (-1);

                    System.out.println("\nAjuste de pesos (" + cont + "):");
                    System.out.println("w1: " + xRes[i][j]);
                    System.out.println("θ: " + θ + "\n");
                    cont++;
                    i = 0;
                }
            }
        }

        if (cont <= 99999) {
            //x1, x2 lo que se introduce por teclado
            matrix = new int[tb.length];
            //lo generado
            for (int j = 0; j < xRes.length; j++) {
                for (int k = 0; k < xRes[i].length; k++) {
                    matrix[j] =(int) Math.tanh((tb[0][i] * xRes[j][k]) + (-1 * θ));
                }
            }

            System.out.println("\nSalida: " + (int)y);
        } else {
            System.out.println("\nFase de aprendizaje ha fallado\n");
        }

        return matrix;
        
    }
    
}
