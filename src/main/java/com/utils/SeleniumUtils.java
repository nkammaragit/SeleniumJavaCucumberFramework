package com.utils;
import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class SeleniumUtils{
		 
	// Method to capture a screenshot   
     public static void captureScreenshot(WebDriver driver, String screenshotName) {
         try {
             String targetPath  = "target/screenshots/";
             TakesScreenshot ts = (TakesScreenshot) driver;
             File source = ts.getScreenshotAs(OutputType.FILE);
//             FileUtils.copyFile(source, new File("./Screenshots/" + screenshotName + ".png"));
             FileUtils.copyFile(source, new File(targetPath + screenshotName + ".png"));
             System.out.println("Screenshot captured");
         } catch (Exception e) {
             System.out.println("Exception while taking screenshot: " + e.getMessage());
         }
     }
}
