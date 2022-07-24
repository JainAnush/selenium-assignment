package assignment;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
//comment the above line and uncomment below line to use Chrome
//import org.openqa.selenium.chrome.ChromeDriver;

public class MyTest {

    public static void main(String[] args) {
        // declaration and instantiation of objects/variables
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\Hp\\Downloads\\geckodriver-v0.31.0-win64\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
		//comment the above 2 lines and uncomment below 2 lines to use Chrome
        //System.setProperty("webdriver.chrome.driver","G:\\chromedriver.exe");
        //WebDriver driver = new ChromeDriver();

        //String baseUrl = "http://demo.guru99.com/test/newtours/";
        String baseUrl = "https://www.saucedemo.com";
        //String expectedTitle = "Welcome: Mercury Tours";
        String expectedTitle = "Swag Labs";
        String actualTitle = "";

        // launch Fire fox and direct it to the Base URL
        driver.get(baseUrl);

        // get the actual value of the title
        actualTitle = driver.getTitle();
        WebElement username = driver.findElement(By.id("user-name"));
        WebElement password = driver.findElement(By.id("password"));
        username.sendKeys("standard_user");
        password.sendKeys("secret_sauce");
        WebElement login = driver.findElement(By.id("login-button"));
        login.click();
        String actualUrl = "https://www.saucedemo.com/inventory.html";
        String expectedUrl = driver.getCurrentUrl();
//        DesiredCapabilities cap=new DesiredCapabilities();
//        cap.setCapability("firefox_binary","C:\\ProgramData\\Microsoft\\Windows\\Start Menu\\Programs\firefox.exe");
//        FirefoxOptions options = new FirefoxOptions(cap);
//        driver = new FirefoxDriver(options);
//        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        /*
         * compare the actual title of the page with the expected one and print
         * the result as "Passed" or "Failed"
         */
        if (actualTitle.contentEquals(expectedTitle)) {
            System.out.println("Test Passed!");
        } else {
            System.out.println("Test Failed");
        }
        if (actualUrl.equals(expectedUrl)) {
            System.out.println("LOGIN SUCCESSFUL");
        } else {
            System.out.println("LOGIN FAILED");
        }
        System.out.println("current url:" + expectedUrl);
        WebElement item1 = driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
        item1.click();
        WebElement item2 = driver.findElement(By.id("add-to-cart-sauce-labs-bike-light"));
        item2.click();
        WebElement item3 = driver.findElement(By.id("add-to-cart-sauce-labs-bolt-t-shirt"));
        item3.click();
        WebElement item3_remove = driver.findElement(By.id("remove-sauce-labs-bolt-t-shirt"));
        item3_remove.click();
        WebElement cartLink = driver.findElement(By.className("shopping_cart_link"));
        String inventoryUrl = driver.getCurrentUrl();
        cartLink.click();
        String cartUrl = driver.getCurrentUrl();
        if (inventoryUrl.equals(cartUrl)) {
            System.out.println("CANNOT GO TO CHECKOUT PAGE : TEST FAILED");
        } else {
            System.out.println("TEST PASSED : ON THE CHECKOUT PAGE");
            System.out.println(cartUrl);
            

        }
        WebElement checkoutButton=driver.findElement(By.id("checkout"));
        String checkoutUrl=driver.getCurrentUrl();
        checkoutButton.click();
        String afterCheckOutUrl=driver.getCurrentUrl();
        if(checkoutUrl.equals(afterCheckOutUrl)){
            System.out.println("CHECKOUT FAILED");
        }else{
            System.out.println("CHECKOUT SUCCESSFUL");
        }
        WebElement firstname=driver.findElement(By.id("first-name"));
        WebElement lastname=driver.findElement(By.id("last-name"));
        WebElement postalcode=driver.findElement(By.id("postal-code"));
        firstname.sendKeys("abc");
        lastname.sendKeys("xyz");
        postalcode.sendKeys("1234");
        WebElement continueButton=driver.findElement(By.id("continue"));
        String currUrl=driver.getCurrentUrl();
        continueButton.click();
        String nextUrl=driver.getCurrentUrl();
        if(currUrl.equals(nextUrl)){
            System.out.println("TEST FAILED :");
        }else{
            System.out.println("TEST PASSED");
        }
        WebElement finish=driver.findElement(By.id("finish"));
        finish.click();
        WebElement home=driver.findElement(By.id("back-to-products"));
        home.click();
        //driver.close();
    }
}
