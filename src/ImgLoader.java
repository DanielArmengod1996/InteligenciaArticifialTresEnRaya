import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.io.File;
import java.io.IOException;

public class ImgLoader {
    public static void readImage(BufferedImage source){
        final int[] ib = ((DataBufferInt)source.getRaster().getDataBuffer()).getData();

        switch ( source.getType() ){
            case BufferedImage.TYPE_INT_RGB :
                for (int i=0, b=0 ; i < ib.length ; i++, b+=4){
                    int p = ib[i];
                    System.out.println(p);
                }
        }
    }

    public static void main(String... args){
        try {
            BufferedImage im = ImageIO.read(new File("img/testImagen.jpg"));
            BufferedImage img = new BufferedImage(im.getWidth(), im.getHeight(), BufferedImage.TYPE_INT_RGB);
            img.getGraphics().drawImage(im, 0, 0, null);
            ImgLoader.readImage(img);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
