package test.com.jcin.cms.utils;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.Binarizer;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.EncodeHintType;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.Result;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;
import com.jcin.cms.utils.BufferedImageLuminanceSource;
import com.jcin.cms.utils.MatrixToImageWriter;

public class TestMatrixToImageWriter {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//二维码生成。
		try {

			String content = "http://www.baidu.com";
			String path = "C:/Users/Administrator/Desktop/";

			MultiFormatWriter multiFormatWritder = new MultiFormatWriter();

			Map hints = new HashMap();
			hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
			BitMatrix bitMatrix = multiFormatWritder.encode(content,
					BarcodeFormat.QR_CODE, 400, 400, hints);
			File file1 = new File(path, "餐巾纸.jpg");
			MatrixToImageWriter.writeToFile(bitMatrix, "jpg", file1);

		} catch (Exception e) {
			e.printStackTrace();
		}

		//解析二维码
//		try {
//			MultiFormatReader formatReader = new MultiFormatReader();
//			String filePath = "C:/Users/Administrator/Desktop/餐巾纸.jpg";
//			File file = new File(filePath);
//			BufferedImage image = ImageIO.read(file);
//			;
//			LuminanceSource source = new BufferedImageLuminanceSource(image);
//			Binarizer binarizer = new HybridBinarizer(source);
//			BinaryBitmap binaryBitmap = new BinaryBitmap(binarizer);
//			Map hints = new HashMap();
//			hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
//			Result result = formatReader.decode(binaryBitmap, hints);
//
//			System.out.println("result = " + result.toString());
//			System.out.println("resultFormat = " + result.getBarcodeFormat());
//			System.out.println("resultText = " + result.getText());
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
	}

}
