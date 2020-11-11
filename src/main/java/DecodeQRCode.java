import com.google.zxing.*;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DecodeQRCode {

    private static final Logger logger = Logger.getLogger(GenerateQRCode.class.getName());

    public void readQRCode(String qrCodeImagePath) {
        try {
            BufferedImage bufferedImage = ImageIO.read(new URL("file:\\"+System.getProperty("user.dir")+"\\"+qrCodeImagePath));
            LuminanceSource source = new BufferedImageLuminanceSource(bufferedImage);
            BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));

            Result result = new MultiFormatReader().decode(bitmap);
            logger.info(result.getText());
        } catch (IOException | NotFoundException exp) {
            exp.printStackTrace();
            logger.log(Level.ALL, exp.toString());
        }
    }
}
