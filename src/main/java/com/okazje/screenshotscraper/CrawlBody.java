/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.okazje.screenshotscraper;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;


        /**
 *
 * @author Krzysztof Jakubcewicz
 */
public class CrawlBody {
    public void crawling(String[] x, String wdPath, String fPath){
    DesiredCapabilities caps = new DesiredCapabilities();
    caps.setCapability("takesScreenshot", true);
    caps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, wdPath);

    PhantomJSDriver driver = new PhantomJSDriver(caps);
    for (int i=0; i < x.length; i++){
    driver.get(x[i]);
    driver.manage().window().setSize(new Dimension(1240,1240));
    JavascriptExecutor js = ((JavascriptExecutor) driver);

js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        try {
           
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            Logger.getLogger(CrawlBody.class.getName()).log(Level.SEVERE, null, ex);
        }
    System.out.println("Taking screenshot now");
    File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
    System.out.println("File:" + srcFile);
    try{
    FileUtils.copyFile(srcFile, new File(fPath+"/screenshot"+i+".png"));
    }
    catch(IOException e){
        e.printStackTrace();
    
    }
    
    System.out.println("Done");
    } 
    }
}
