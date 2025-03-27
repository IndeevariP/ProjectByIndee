import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.List;

public class TestDrodown {

    WebDriver driver;

    @BeforeMethod
    public void OpenChromeBrowser() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        Thread.sleep(3000);
    }

    @Test
    public void TestDropDown() throws InterruptedException {
        //Select option from the dropdown
        driver.get("https://www.leafground.com/select.xhtml");
        WebElement dropdownOne = driver.findElement(By.xpath("//select[@class='ui-selectonemenu']"));
        //for select ()
        Select SelectOne = new Select(dropdownOne);
        SelectOne.selectByIndex(1); //first select option 2
        Thread.sleep(3000);
        SelectOne.selectByVisibleText("Puppeteer"); //second select option 3
        Thread.sleep(3000);

        //Get the number of dropdown options
        //generics - accept only webElement
        List<WebElement> ListOptions = SelectOne.getOptions();
        int ListOptionsSize = ListOptions.size();
        System.out.println("List Options" + ListOptionsSize);

        for (WebElement elementOne : ListOptions) {
            System.out.println(elementOne.getText());
        }

        //using send keys select dropdown values
        dropdownOne.sendKeys("Puppeteer");
        Thread.sleep(3000);

        //Google dropdown

        //TestNG
        // Google test script
    }
@Test
    //Google dropdown
    public void GoogledropdownTest() throws InterruptedException {
        driver.get("https://www.google.com");
        driver.findElement(By.name("q")).sendKeys("Cat");
        Thread.sleep(3000);
        List<WebElement> Optionthree =  driver.findElements(By.xpath("//*[@id=\"Zrbbw\"]/div[1]/span"));
        System.out.println(Optionthree.size());
        for(WebElement option : Optionthree){
            System.out.println(option.getText());
        }


    }
}