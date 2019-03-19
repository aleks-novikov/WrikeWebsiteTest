package com.wrike;

import com.wrike.pages.HomePage;
import com.wrike.pages.ResendPage;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

public class WebpageTest {
    private static WebDriver driver;
    private static HomePage homePage;
    private static ResendPage resendPage;

    @BeforeClass
    public static void beforeClass() {
        driver = new ChromeDriver();

        homePage = PageFactory.initElements(driver, HomePage.class);
        resendPage = PageFactory.initElements(driver, ResendPage.class);
    }

    @AfterClass
    public static void afterClass() {
        driver.close();
    }
}
