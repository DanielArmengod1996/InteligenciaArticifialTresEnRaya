import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.io.File;
import java.io.IOException;

public class ImgLoader {
    static int imagenes[][] = new int[9999][9999];
    static int cont = 0;

    public static void readImage(BufferedImage source){
        final int[] ib = ((DataBufferInt)source.getRaster().getDataBuffer()).getData();
        int img[] = new int[ib.length];
        switch ( source.getType() ){
            case BufferedImage.TYPE_INT_RGB :
                for (int i=0, b=0 ; i < 9999 ; i++, b+=4){
                    int p = ib[i];
                    imagenes[cont][i] = p;
                    System.out.println(p);

                }
                cont++;
        }

    }

    public static void main(String... args){

        try {
            File fil = new File("img");
            File[] files = fil.listFiles();
            for (File file : files){
                BufferedImage originImg = ImageIO.read(file);
                BufferedImage img1 = new BufferedImage(originImg.getWidth(), originImg.getHeight(), BufferedImage.TYPE_INT_RGB);
                img1.getGraphics().drawImage(originImg, 0, 0, null);
                ImgLoader.readImage(img1);
                MotorAI.learn(imagenes);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
