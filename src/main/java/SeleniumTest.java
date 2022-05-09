import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Scanner;

public class SeleniumTest {

    //WebDriver
    private WebDriver driver;
    private WebElement element;
    private String url;

    //Properties
    public static String WEB_DRIVER_ID = "webdriver.chrome.driver";
    public static String WEB_DRIVER_PATH = "C:/webdriver/chromedriver.exe";

    public static void main(String[] args) {

        SeleniumTest test = new SeleniumTest();
        test.login();

        //test.mailOpen();
        Scanner sc = new Scanner(System.in);
        test.searchName(sc.next());
        sc.close();
    }

    public SeleniumTest() {
        System.setProperty(WEB_DRIVER_ID, WEB_DRIVER_PATH);

        ChromeOptions options = new ChromeOptions();
        options.setCapability("ignoreProtectedModeSettings", true);
        driver = new ChromeDriver(options);
        url = "https://cj.cj.net/PT/login.aspx";
    }

    public void login(){

        try{
            driver.get(url);

            element = driver.findElement(By.name("txtID"));
            Thread.sleep(500);
            element.sendKeys("아이디");

            element = driver.findElement(By.name("txtPWD"));
            Thread.sleep(500);
            element.sendKeys("패스워드");
            element = driver.findElement(By.className("btn_login"));
            element.click();
            Thread.sleep(5000);
        } catch (Exception e){
            e.printStackTrace();
        } finally {
        }
    }
    public void mailOpen(){
        url = "https://cj.cj.net/PT/PortalBuilder/main_frame.aspx";

        driver.get(url);
        element = driver.findElement(By.className("qn_mail"));
        element.click();
    }

    public void searchName(String userName){
        try {
            url = "https://cj.cj.net/PT/PortalBuilder/main_frame.aspx";
            driver.navigate().to(url);
            element = driver.findElement(By.id("liSearchUser"));
            Thread.sleep(1000);
            element.click();

            driver.navigate().to("https://cj.cj.net/CM/PhoneBookV3/phoneManage.aspx");
            Thread.sleep(1000);


            element = driver.findElement(By.id("txtSearch"));
            Thread.sleep(1000);

            element.sendKeys(userName);

            element = driver.findElement(By.className("btn_search"));
            Thread.sleep(1000);

            element.click();
        } catch (Exception e){

        } finally {

        }
    }
}