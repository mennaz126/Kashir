import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.*;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.annotations.AfterTest;





public class TestingInterview {
    WebDriver driver = new ChromeDriver();

public void setup(){
    WebDriver driver = new ChromeDriver();
    driver.manage().window().maximize();

    driver.get("https://merchant.kashier.io/signup");

}


    //Verifying elements on Registration page
    @Test
    public void verifyElemntsOnPageTest()
    {
        WebElement signUpTitle = driver.findElement(By.xpath("//h2[contains(text(),'Sign Up')]"));
        signUpTitle.isDisplayed();

        WebElement termsText = driver.findElement(By.xpath("//span[contains(text(),'All fields are required.')]"));
        termsText.isDisplayed();

        WebElement commercialregister = driver.findElement(By.xpath("//p[contains(text(),'have a commercial register and tax card')]"));
        commercialregister.isDisplayed();

        WebElement loginLinkText = driver.findElement(By.xpath("//span[contains(text(),'Already have an account?')]"));
        loginLinkText.isDisplayed();

    }

    // Registration with all valid data
    @Test
    public void validRegistrationTest(){

        WebElement Fullname = driver.findElement(By.xpath("//body/div[1]/div[1]/div[1]/div[1]/div[2]/form[1]/div[1]/div[1]/input[1]"));
        Fullname.sendKeys("MennaTest");

        WebElement StoreName = driver.findElement(By.xpath("//body/div[1]/div[1]/div[1]/div[1]/div[2]/form[1]/div[2]/div[1]/input[1]"));
        StoreName.sendKeys("TestName");

        WebElement phone = driver.findElement(By.xpath("//body/div[1]/div[1]/div[1]/div[1]/div[2]/form[1]/div[4]/div[1]/input[1]"));
        phone.sendKeys("01099981397");

        WebElement email = driver.findElement(By.xpath("//body/div[1]/div[1]/div[1]/div[1]/div[2]/form[1]/div[5]/div[1]/input[1]"));
        email.sendKeys("menna.12eid@gmail.com");

        WebElement password = driver.findElement(By.xpath("//input[@id='register-password']"));
        password.sendKeys("Test@12345");

        WebElement Repassword = driver.findElement(By.xpath("//input[@id='r-register-password']"));
        Repassword.sendKeys("Test@12345");

        WebElement signUp = driver.findElement(By.xpath("//span[@id='signup-span']"));
        signUp.click();

        String expectedURL = "https://merchant.kashier.io/en/dashboard";
        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals(actualURL, expectedURL);

        String expectedTitle = "Verify Your Email Address ";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);


    }

    // Registration without providing user email field
    @Test

    public void NonvalidRegistrationTest(){

        WebElement Fullname = driver.findElement(By.xpath("//body/div[1]/div[1]/div[1]/div[1]/div[2]/form[1]/div[1]/div[1]/input[1]"));
        Fullname.sendKeys("MennaTest");

        WebElement StoreName = driver.findElement(By.xpath("//body/div[1]/div[1]/div[1]/div[1]/div[2]/form[1]/div[2]/div[1]/input[1]"));
        StoreName.sendKeys("TestName");

        WebElement phone = driver.findElement(By.xpath("//body/div[1]/div[1]/div[1]/div[1]/div[2]/form[1]/div[4]/div[1]/input[1]"));
        phone.sendKeys("01099981397");

        WebElement email = driver.findElement(By.xpath("//body/div[1]/div[1]/div[1]/div[1]/div[2]/form[1]/div[5]/div[1]/input[1]"));
        email.sendKeys("");

        WebElement password = driver.findElement(By.xpath("//input[@id='register-password']"));
        password.sendKeys("Test@12345");

        WebElement Repassword = driver.findElement(By.xpath("//input[@id='r-register-password']"));
        Repassword.sendKeys("Test@12345");

        WebElement signUp = driver.findElement(By.xpath("//span[@id='signup-span']"));
        signUp.click();

        String expectedErrorMsg = " Oops! There were some missing data!";

        WebElement exp = driver.findElement(By.xpath("//body/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/h6[1]"));
        String actualErrorMsg = exp.getText();

        Assert.assertEquals(actualErrorMsg, expectedErrorMsg);


    }


     @AfterTest
    public void Close() {
        driver.quit();
    }
}


















