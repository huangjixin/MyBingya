package com.jcin.cms.utils;

import java.io.File;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;

/**
 * @author 黄记新
 *
 */
public class ZxingEAN13EncoderHandler {     
    
    /**   
     * 编码   
     * @param contents   
     * @param width   
     * @param height   
     * @param imgPath   
     */    
    public void encode(String contents, int width, int height, String imgPath) {     
        int codeWidth = 3 + // start guard     
                (7 * 6) + // left bars     
                5 + // middle guard     
                (7 * 6) + // right bars     
                3; // end guard     
        codeWidth = Math.max(codeWidth, width);     
        try {     
            BitMatrix bitMatrix = new MultiFormatWriter().encode(contents,     
                    BarcodeFormat.EAN_13, codeWidth, height, null);     
    
            MatrixToImageWriter     
                    .writeToFile(bitMatrix, "png", new File(imgPath));     
    
        } catch (Exception e) {     
            e.printStackTrace();     
        }     
    }     
    
    /**   
     * @param args   
     */    
    public static void main(String[] args) {     
        String imgPath = "C:/Users/Administrator/Desktop/zxing_EAN13.png";     
        // 益达无糖口香糖的条形码     
        String contents = "6923450657713";     
    
        int width = 200, height = 75;     
        ZxingEAN13EncoderHandler handler = new ZxingEAN13EncoderHandler();     
        handler.encode(contents, width, height, imgPath);     
    
        System.out.println("Michael ,you have finished zxing EAN13 encode.");     
    }     
}   