import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

    //import javax.swing.*;
import java.util.List;

public class LinkTest {

    WebDriver driver;

    @BeforeMethod
    public void OpenChromeBrowser() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.leafground.com/link.xhtml");
    }

    @Test
    public void LinkTestOne(){

        //take me to the dash board
        WebElement GotoDashboard = driver.findElement(By.linkText("Go to Dashboard"));
        GotoDashboard.click();
        driver.navigate().back();

        //find my destination
        WebElement wheretoNavigate= driver.findElement(By.partialLinkText("Find the URL without"));
        String path = String.valueOf(wheretoNavigate.getAttribute("href"));
        System.out.println("the link is navigate to" +path);

        //broken link or not
        WebElement Brokenlink = driver.findElement(By.linkText("Broken?"));
        Brokenlink.click();
        String Webtitle= driver.getTitle();
        if (Webtitle.contains("404")){
            System.out.println( "This is a Broken link");
        }else{
            System.out.println("This link is working fine");
        }
        driver.navigate().back();

        //duplicate link
        WebElement dashboard1= driver.findElement(By.linkText("Go to Dashboard"));
        dashboard1.click();
        driver.navigate().back();

        //Count page links
       List<WebElement> Countlinks= driver.findElements(By.tagName("a"));
        int Linksonpage= Countlinks.size();
        System.out.println("There are :" +Linksonpage);

        //count layout links
        WebElement LinksonLayout = driver.findElement(By.className("layout-main-content"));
        List<WebElement> pagelink = LinksonLayout.findElements(By.tagName("a"));
        int links = pagelink.size();
        System.out.println("There are :" +links);

    }
}
