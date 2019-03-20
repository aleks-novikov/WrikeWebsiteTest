package com.wrike;

import com.wrike.links.Links;
import com.wrike.pages.HomePage;
import com.wrike.pages.ResendPage;
import lombok.extern.java.Log;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

@Log
public class WebPagesTest {
    private static HomePage homePage;
    private static ResendPage resendPage;
    private static WebDriver driver;

    @BeforeClass
    public static void beforeClass() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().window().maximize();

        homePage = PageFactory.initElements(driver, HomePage.class);
        resendPage = PageFactory.initElements(driver, ResendPage.class);
    }

    @AfterClass
    public static void afterClass() {
        driver.quit();
    }

    @Test
    public void PagesTest() {
        log.info("1.Open url: wrike.com");
        homePage.open(Links.HOMEPAGE_URL.getLink());

        log.info("2.Click 'Get started for free' button");
        homePage.clickGetStartedBtn();

        log.info("3.Fill the email address");
        homePage.fillUserEmailAddress("aleks.novikov");

        log.info("4.Click 'Create my Wrike account' button and redirect to the Resend page");
        homePage.createWrikeAccountBtnClick();

        log.info("5.Set random answers in the Q&A section and assertion data filling");
        resendPage.fillingSurveyForm();

        log.info("6.Click 'Resend email' and check it's hiding");
        resendPage.clickResendEmailBtn();

        log.info("7.Checking that section 'Follow us' contains the 'Twitter' button and" +
                "that it leads to the correct url/has the correct icon");
        resendPage.checkTwitterIconAndLink();
    }
}