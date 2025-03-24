import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestButtons {
    WebDriver driver;

    @BeforeMethod
    public void OpenChromeBrowser() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.leafground.com/button.xhtml");
        Thread.sleep(3000);
    }
    @Test
    public void TestButtonsEx(){
    //click and confirm title
        driver.findElement(By.id("j_idt88:j_idt90")).click();
        String expectTitle = "Dashboard";
        String actualTitle = driver.getTitle();
       //Assert.assertEquals(expectTitle, actualTitle);
        if (actualTitle.equals(expectTitle)) {
            System.out.println("Test Passed");
        }else
            System.out.println("Test Failed");
        driver.navigate().back();

        //Find position of submit button
        WebElement ButtonPossition =  driver.findElement(By.id("j_idt88:j_idt94"));
        Point Xypoint = ButtonPossition.getLocation();
        int X = Xypoint.getX();
        int Y = Xypoint.getY();
        System.out.println("X: " + X);
        System.out.println("Y: " + Y);

        //Find button color
        WebElement ButtonColor = driver.findElement(By.id("j_idt88:j_idt96"));
        String color = ButtonColor.getCssValue("background-color");
        System.out.println("Background Color: " + color);

        //Find the height and width
        WebElement HightWidth= driver.findElement(By.id("j_idt88:j_idt98"));
        int Hight = HightWidth.getSize().getHeight();
        int Width = HightWidth.getSize().getWidth();
        System.out.println("Hight: " + Hight);
        System.out.println("Width: " + Width);

    }

}
