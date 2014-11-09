package com.dream.utils;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Hashtable;

import javax.imageio.ImageIO;

import com.dream.constants.Constant;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.DecodeHintType;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;

public class QRCodeUtils {

	/**
	 * @param args
	 * @throws Exception
	 * @throws
	 */
	public static void main(String[] args) throws Exception {
		QRCodeUtils t = new QRCodeUtils();
		t.encode("http://www.baidu.com", "D:\\wsg.png");
		t.decode("D:\\wsg.png");

	}

	// 编码
	/**
	 * 传入二维码内容，以及相关的 文件全路径，即可以生成该文件
	 * @param contentURL
	 * @param path
	 * @throws WriterException
	 * @throws IOException
	 */
	@SuppressWarnings("deprecation")
	public void encode(String contentURL, String path) throws WriterException,
			IOException {
		BitMatrix byteMatrix;
		byteMatrix = new MultiFormatWriter().encode(contentURL,
				BarcodeFormat.QR_CODE, Constant.QRCODE_WIDTH,
				Constant.QRCODE_HEIGHT);
		File file = new File(path);
		MatrixToImageWriter.writeToFile(byteMatrix, "png", file);
	}

	// 解码
	public void decode(String imgPath) throws IOException, NotFoundException {
//		Reader reader = new MultiFormatReader();
		File file = new File(imgPath);
		BufferedImage image;
		image = ImageIO.read(file);
		if (image == null) {
			System.out.println("Could not decode image");
		}
		LuminanceSource source = new BufferedImageLuminanceSource(image);
		BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));
		Result result;
		Hashtable<DecodeHintType, String> hints = new Hashtable<DecodeHintType, String>();
		hints.put(DecodeHintType.CHARACTER_SET, "UTF8");
		result = new MultiFormatReader().decode(bitmap, hints);
		String resultStr = result.getText();
		System.out.println(resultStr);

	}

}
