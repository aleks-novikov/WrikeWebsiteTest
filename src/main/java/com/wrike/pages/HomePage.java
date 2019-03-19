package com.wrike.pages;

import com.wrike.links.Links;
import io.qameta.allure.Step;
import lombok.extern.java.Log;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Log
public class HomePage {
    private WebDriver driver;

    public HomePage(WebDriver driver) {
        if (!driver.getCurrentUrl().contains(Links.HOMEPAGE_URL.getContent())) {
            throw new IllegalStateException("This isn't expected page!");
        }

        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(css = "wg-header__free-trial-button")
    private WebElement getStartedBtn;

    @FindBy(css = "wg-form modal-form-trial__form js-signup-modal")
    private WebElement emailFilingForm;

    @FindBy(css = "wg-input modal-form-trial__input")
    private WebElement inputEmailTextBox;

    @FindBy(css = "wg-btn wg-btn--blue modal-form-trial__submit")
    private WebElement createWrikeAccountBtn;

    @Step("Open url: wrike.com")
    public void openHomePage() {
        log.info("openHomePage");
        driver.navigate().to(Links.HOMEPAGE_URL.getContent());
    }

    @Step("Click 'Get started for free' button near 'Login' button")
    public void clickGetStartedBtn() {
        getStartedBtn.click();
    }

    @Step("Fill in the email field with random generated value of email with mask ")
    public void fillUserEmailAddress() {
        inputEmailTextBox.sendKeys(Links.USER_EMAIL_MASK.getContent());
    }

    @Step("Click on 'Create my Wrike account' button")
    public void createWrikeAccountBtnClick() {
        createWrikeAccountBtn.click();
    }
}