/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.okazje.screenshotscraper;
//import java.awt.Dimension;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
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
    public void crawling(){
    DesiredCapabilities caps = new DesiredCapabilities();
    caps.setCapability("takesScreenshot", true);
    caps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, "C:\\Users\\Krzysztof\\Documents\\NetBeansProjects\\ScreenShotScraper\\phantomjs-2.1.1-windows\\bin\\phantomjs.exe");
    PhantomJSDriver driver = new PhantomJSDriver(caps);
    driver.get("http://www.youhome.pl/komoda.html");
    driver.manage().window().setSize(new Dimension(1240,1240));
 //SeleniumWaiter _waiter = new SeleniumWaiter(driver);
        try {
            //   _waiter.waitForMe(By.cssSelector("#offer356782255_682 > div > a > img"),5000);
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            Logger.getLogger(CrawlBody.class.getName()).log(Level.SEVERE, null, ex);
        }
    System.out.println("Taking screenshot now");
    File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
    System.out.println("File:" + srcFile);
    try{
    FileUtils.copyFile(srcFile, new File("C:/Java/screenshot_.png"));
    }
    catch(IOException e){
        e.printStackTrace();
    
    }
    
    System.out.println("Done");
    }   
}
