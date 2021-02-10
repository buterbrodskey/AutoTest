package org.example;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;


public class LoginTest {
    public static WebDriver driver;
    public static LoginPage loginPage;
    public static ProfilePage profilePage;

    @BeforeClass
    public static void setup() {
        System.setProperty("webdriver.chrome.driver",ConfProperties.getProperty("chromedriver"));
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        profilePage = new ProfilePage(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(ConfProperties.getProperty("loginpage"));
    }
    @Test
    public void loginTest() {
        loginPage.inputLogin("zhukov.a.n@edu.mirea.ru");
        loginPage.inputPassword("2237714Zz");
        loginPage.clickPassBtn();

        String user = profilePage.getUserName();

        Assert.assertEquals("Жуков Андрей Николаевич",user);
    }

    @AfterClass
    public static void tearDown() {
        profilePage.userMenuEntry();
        profilePage.userLogout();
        driver.quit();
    }
}

