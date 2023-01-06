package com.amazon.tests.challenge;

import com.amazon.tests.TestBase;
import com.amazon.utilities.BrowserUtils;
import com.amazon.utilities.Driver;
import com.google.zxing.*;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import org.apache.commons.io.input.ReaderInputStream;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class QRCodeAutomation extends TestBase {

    @Test
    public void testQRCode() throws IOException, NotFoundException {

        BrowserUtils.waitFor(3);
        String qrCodeFileUrl2= driver.findElement(By.xpath("//div[@id='HTML4']//img")).getAttribute("src");
        System.out.println("QR COde Image URL is : = " + qrCodeFileUrl2);

        URL urlOfImage = new URL(qrCodeFileUrl2);
        BufferedImage bufferedImage = ImageIO.read(urlOfImage);

        LuminanceSource luminanceSource = new BufferedImageLuminanceSource(bufferedImage);
        BinaryBitmap binaryBitmap = new BinaryBitmap(new HybridBinarizer(luminanceSource));

        Result result = new MultiFormatReader().decode(binaryBitmap);
        String textInQrCode = result.getText();
        System.out.println("The Text in QR Code is :"+textInQrCode);

    }

    @Test
    public void testQrCode2() throws IOException, NotFoundException {

//        WebDriver driver1 = new ChromeDriver();
//        driver.get("https://testautomationpractice.blogspot.com/");
//        driver.manage().window().maximize();
//        BrowserUtils.waitFor(2);
//
//        String qrCodeUrl = driver.findElement(By.xpath("//div[@id='HTML4']//img")).getAttribute("src");
//
//        URL url = new URL(qrCodeUrl);
//
//       BufferedImage bufferedImage= ImageIO.read(url);
//
//       LuminanceSource luminanceSource = new BufferedImageLuminanceSource(bufferedImage);
//       BinaryBitmap binaryBitmap = new BinaryBitmap(new HybridBinarizer(luminanceSource));
//
//       Result result = new MultiFormatReader().decode(binaryBitmap);
//        String textResult = result.getText();
//
//        System.out.println("textResult = " + textResult);
//
//        driver.close();


    }


}
