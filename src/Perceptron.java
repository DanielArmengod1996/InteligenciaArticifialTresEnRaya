import java.util.Random;

public class Perceptron {

    public static void main(String ... args){
        //INPUT
        double x1, x2;
        x1 = 1.4;
        x2 = -0.33;
        for (int i = 0; i < 100; i++) {
            calcular(x1, x2);
        }

    }

    static void calcular(double x1, double x2){
        //PESOS SOBRE LAS ENTRADAS
        double w1, w2;
        w1 = new Random().nextDouble();
        w2 = new Random().nextDouble();

        Neurona oNeurona = new Neurona(x1, x2, w1, w2);

        System.out.println("INPUT 1 == " + x1);
        System.out.println("INPUT 2 == " + x2);
        System.out.println("OUTPUT == " + oNeurona.getY1());
    }



}
