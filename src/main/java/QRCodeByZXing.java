import java.util.logging.Logger;

public class QRCodeByZXing {
    private static final Logger logger = Logger.getLogger(QRCodeByZXing.class.getName());

    public static void main(String[] args) {
        String data = "https://github.com/rahimkhanabdul";
        String path = "QR-Code\\rahimkhanabdul.jpg";
        logger.info("Generating QR code");

        GenerateQRCode generateQRCode = new GenerateQRCode();
        generateQRCode.generateQRCode(data, path);

        logger.info("Reading data from QR code");
        DecodeQRCode decodeQRCode = new DecodeQRCode();
        decodeQRCode.readQRCode(path);
    }
}
