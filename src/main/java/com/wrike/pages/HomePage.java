package com.wrike.pages;

import com.wrike.links.Links;
import com.wrike.util.IWaitnigForElements;
import com.wrike.util.WaitnigForElements;
import io.qameta.allure.Step;
import lombok.extern.java.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;

@Log
public class HomePage {
    private WebDriver driver;
    private IWaitnigForElements waitnigUtil = new WaitnigForElements();

    @FindBy(css = ".wg-header__cell .wg-btn--green")
    private WebElement getStartedBtn;
    @FindBy(css = ".wg-form.modal-form-trial__form")
    private WebElement emailFilingForm;
    @FindBy(css = ".modal-form-trial__input")
    private WebElement inputEmailTextBox;
    @FindBy(css = ".modal-form-trial__submit")
    private WebElement createWrikeAccountBtn;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("1.Open url: wrike.com")
    public void open(String url) {
        driver.get(url);
        assertEquals("Your online project management software - Wrike", driver.getTitle());
    }

    @Step("2.Click 'Get started for free' button")
    public void clickGetStartedBtn() {
        waitnigUtil.wait(driver, ".wg-header__cell .wg-btn--green", true);
        getStartedBtn.click();
    }

    @Step("3.Fill the email address ")
    public void fillUserEmailAddress(String emailPrefix) {
        inputEmailTextBox.sendKeys(emailPrefix + Links.EMAIL_POSTFIX.getLink());
    }

    @Step("4.Click 'Create my Wrike account' button and redirect to the Resend page")
    public void createWrikeAccountBtnClick() {
        createWrikeAccountBtn.click();
        driver.get(Links.RESEND_PAGE_URL.getLink());
        waitnigUtil.wait(driver, ".modal-form-trial__input", false);

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(new By.ByClassName("survey")));
        assertEquals("Redirecting to Resend page wasn't executed!", Links.RESEND_PAGE_URL.getLink(), driver.getCurrentUrl());
    }
}