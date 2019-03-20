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

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

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
        driver.close();
    }

    @Test
    public void PagesTest() {
        log.info("1.Open url: wrike.com");
        homePage.open(Links.HOMEPAGE_URL.getLink());
        assertEquals("Your online project management software - Wrike", driver.getTitle());

        log.info("2.Click 'Get started for free' button");
        homePage.clickGetStartedBtn();

        log.info("3.Fill the email address");
        homePage.fillUserEmailAddress("alexshram");

        log.info("4.Click 'Create my Wrike account' button and redirect to the Resend page");
        homePage.createWrikeAccountBtnClick();
        assertEquals("Redirecting to Resend page wasn't executed!", Links.RESEND_PAGE_URL.getLink(), driver.getCurrentUrl());

        log.info("5.Set random answers in the Q&A section and assertion data filling");
        resendPage.fillingSurveyForm();
        assertTrue("Form results wasn't sent!", resendPage.getSurveySuccessWindow().isDisplayed());

        log.info("6.Click 'Resend email' and check it's hiding");
        resendPage.clickResendEmailBtn();
        assertFalse("Email wasn't resended!", resendPage.getResentEmailButton().isDisplayed());

        log.info("7.Checking that section 'Follow us' contains the 'Twitter' button and" +
                "that it leads to the correct url/has the correct icon");
        String[] twitterIconData = resendPage.getTwitterIconAndLink();
        assertEquals("Incorrect link of Wrike Twitter site!", Links.TWITTER_WRIKE_LINK.getLink(), twitterIconData[0]);
        assertEquals("Incorrect link of icon", Links.TWITTER_ICON_TEXT.getLink(), twitterIconData[1]);
    }
}