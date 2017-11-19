import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.io.File;
import java.io.IOException;

public class ImgLoader {
    public static int[] readImage(BufferedImage source){
        final int[] ib = ((DataBufferInt)source.getRaster().getDataBuffer()).getData();
        int img[] = new int[ib.length];
        switch ( source.getType() ){
            case BufferedImage.TYPE_INT_RGB :
                for (int i=0, b=0 ; i < ib.length ; i++, b+=4){
                    int p = ib[i];
                    ib[i] = p;
                    System.out.println(p);

                }
        }
        return img;
    }

    public static void mainLoadImages(String... args){
        int imagenes[][] = new int[4000][4000];
        try {
            File fil = new File("img");
            File[] files = fil.listFiles();
            int cont = 0;
            for (File file : files){
                BufferedImage originImg = ImageIO.read(file);
                BufferedImage img1 = new BufferedImage(originImg.getWidth(), originImg.getHeight(), BufferedImage.TYPE_INT_RGB);
                img1.getGraphics().drawImage(originImg, 0, 0, null);
                int[] listaImagen = ImgLoader.readImage(img1);
                for(int numero : listaImagen){

                }
                //imagenes[cont][]
                cont++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
