import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class TextboxTest {
    WebDriver driver;

    @BeforeMethod
    public void OpenChromeBrowser() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.leafground.com/input.xhtml");
        Thread.sleep(3000);
    }

    @Test
    public void TestFormField(){
        //Type name
        driver.findElement(By.id("j_idt88:name")).sendKeys("Indeevari Perera");

        //append country to the city
        driver.findElement(By.id("j_idt88:j_idt91")).sendKeys("Sri Lanka");

        //Verify if text box is diseabled
        boolean enablebox = driver.findElement(By.id("j_idt88:j_idt93")).isEnabled();
        System.out.println("This text box is" + enablebox);

        //clear the text type
        WebElement Cleartext = driver.findElement(By.xpath("//*[@id=\"j_idt88:j_idt95\"]"));
        Cleartext.click();

        //Retrive the typed text
        WebElement Retrive = driver.findElement(By.id("j_idt88:j_idt97"));
        String Value= Retrive.getAttribute("value");
        System.out.println("This text box is" +Value);

        //Type email and tab confirm control moved to next element
        WebElement Emailtype = driver.findElement(By.id("j_idt88:j_idt99"));
        Emailtype.sendKeys("indeevari.perera333@gmail.com" + Keys.TAB + "Confirm tab");


        }
    }


