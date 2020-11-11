import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GenerateQRCode {
    private static final Logger logger = Logger.getLogger(GenerateQRCode.class.getName());

    public void generateQRCode(String data, String path) {

        try {
        BitMatrix matrix = new MultiFormatWriter()
                    .encode(data, BarcodeFormat.QR_CODE, 500, 500);

        MatrixToImageWriter.writeToPath(matrix, "jpg", Paths.get(path));
        } catch (WriterException | IOException exp) {
            exp.printStackTrace();
            logger.log(Level.ALL, exp.toString());
        }
    }
}
