package day10;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class RobotClass {
    
    @Test
    public void robotandselenium() throws InterruptedException
    {
        WebDriver driver=new FirefoxDriver();        
        Robot robot=null;        
        driver.get("http://www.makemytrip.com");
        driver.manage().window().maximize();
        driver.findElement(By.xpath(".//*[@id='ssologinlink']")).click();
        driver.findElement(By.xpath(".//*[@id='username']")).sendKeys("username@gmail.com");
        driver.findElement(By.xpath(".//*[@id='password_text']")).sendKeys("password");        
        try {
            robot=new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
        //Keyboard Activity Using Robot Class
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
    }
}