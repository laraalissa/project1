import java.util.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.awt.*;
import java.time.Duration;
import java.util.List;

public class Main {



            public static void main(String[] args) throws InterruptedException {
                int random=(int)(Math.random()*99);
                String userName="Larakraft"+random;
                String firstName="Lara"+random;
                String lastName="kraft"+random;


                System.setProperty("webdriver.chrome.driver","/Users/laraalissa/Downloads/chromedriver");
                WebDriver driver =new ChromeDriver();
                driver.manage().window().maximize();
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4000));
                driver.get(" http://qa-duotify.us-east-2.elasticbeanstalk.com/register.php");
                Assert.assertEquals(driver.getTitle (),("Welcome to Duotify!"));
                driver.findElement(By. id ( "hideLogin")).click();
                driver.findElement(By. id ( "username")).sendKeys(userName);
                driver.findElement(By. id ( "firstName")).sendKeys(firstName);
                driver.findElement(By. id ( "lastName")).sendKeys(lastName);
                driver.findElement(By. id ( "email")).sendKeys(userName+random+"@yahoo.com");
                driver.findElement(By. id ( "email2")).sendKeys(userName+random+"@yahoo.com");
                driver.findElement(By. id ( "password")).sendKeys("yahoo123");
                driver.findElement(By. id ( "password2")).sendKeys("yahoo123");
                driver.findElement(By. name ("registerButton")).click();
                Assert.assertEquals(driver.getCurrentUrl(), "http://qa-duotify.us-east-2.elasticbeanstalk.com/browse.php?");

                String verifyLeftSide=driver.findElement(By.id ("nameFirstAndLast")).getText();
                if (verifyLeftSide.equalsIgnoreCase(userName));
                System.out.println("true");

                driver.findElement(By.id ("nameFirstAndLast")).click();
                String verifyMain=driver.findElement(By.id ("mainContent")).getText();
                if(verifyMain.equalsIgnoreCase(userName));
                System.out.println("true");

               driver.findElement(By.id("rafael")).click();
                //Assert.assertEquals(driver.getCurrentUrl(),"http://duotifyapp.us-east-2.elasticbeanstalk.com/register.php");
                Thread.sleep(1000);

                driver.findElement(By. id ( "loginUsername")).sendKeys(userName);
                driver.findElement(By. id ( "loginPassword")).sendKeys("yahoo123");

                driver.findElement(By. name ("loginButton")).click();
                Thread.sleep(1000);

                String pageSource=driver.getPageSource();
                System.out.println(pageSource);
                String expectedText="You Might Also Like";
                Assert.assertTrue(pageSource.contains(expectedText));
                Thread.sleep(1000);


                driver.findElement(By.id ("nameFirstAndLast")).click();
                driver.findElement(By.id("rafael")).click();
                Thread.sleep(1000);

                driver.close();



    }
}
