// Java code to read the QR code

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.imageio.ImageIO;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

public class QRCode {

	
	// Function to read the QR file
	public static String readQRCode(String path, String charset,
								Map hashMap)
		throws FileNotFoundException, IOException,
			NotFoundException
	{
		BinaryBitmap binaryBitmap
			= new BinaryBitmap(new HybridBinarizer(
				new BufferedImageLuminanceSource(
					ImageIO.read(
						new FileInputStream(path)))));

		Result result
			= new MultiFormatReader().decode(binaryBitmap);

		return result.getText();
	}

	// Driver code
	public static void main(String[] args)
		throws WriterException, IOException,
			NotFoundException
	{

		// Path where the QR code is saved
		String path = "/home/nuzrath/NetBeansProjects/qr_project_with_java_and_maven/";
                String filePath =  path+"demo.png";
		// Encoding charset
		String charset = "UTF-8";

		Map<EncodeHintType, ErrorCorrectionLevel> hintMap
			= new HashMap<EncodeHintType,
						ErrorCorrectionLevel>();

		hintMap.put(EncodeHintType.ERROR_CORRECTION,
					ErrorCorrectionLevel.L);

		System.out.println(
			"QRCode output: "
			+ readQRCode(filePath, charset, hintMap));
	}

}
