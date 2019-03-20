package com.wrike.pages;

import com.wrike.links.Links;
import com.wrike.util.IWaitnigForElements;
import com.wrike.util.WaitnigForElements;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Random;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class ResendPage {
    private WebDriver driver;
    private IWaitnigForElements waitnigUtil = new WaitnigForElements();

    public ResendPage(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(css = "div[data-code = 'interest_in_solution'] > label > button")
    private List<WebElement> interestInASolutionButtons;

    @FindBy(css = "div[data-code = 'team_members'] > label > button")
    private List<WebElement> teamMembersButtons;

    @FindBy(css = "div[data-code = 'primary_business'] > label > button")
    private List<WebElement> primaryBusinessButtons;

    @FindBy(css = ".switch__input")
    private WebElement otherButtonField;

    @FindBy(css = ".survey-form > button")
    private WebElement submitResultsButton;

    @FindBy(css = ".survey-success")
    private WebElement surveySuccessWindow;

    @FindBy(css = ".wg-cell--order-1 > p > button")
    private WebElement resentEmailButton;

    @FindBy(css = "li[class = 'wg-footer__social-item']:nth-child(1) > a")
    private WebElement twitterButton;

    @FindBy(css = ".wg-footer__social-block > div > ul > li:nth-child(1) > a > svg > use")
    private WebElement twitterIcon;

    @Step("Set random answers in the Q&A section and assertion data filling")
    public void fillingSurveyForm() {
        Random random = new Random();
        interestInASolutionButtons.get(random.nextInt(interestInASolutionButtons.size())).click();
        teamMembersButtons.get(random.nextInt(teamMembersButtons.size())).click();

        WebElement otherButton = primaryBusinessButtons.get(random.nextInt(primaryBusinessButtons.size()));
        if (otherButton.getAttribute("innerHTML").contains("Other")) {
            otherButton.click();
            otherButtonField.sendKeys("Data");
        } else {
            otherButton.click();
        }

        if (submitResultsButton.isEnabled()) {
            submitResultsButton.click();
            waitnigUtil.wait(driver, ".survey-success", true);
        }

        assertTrue("Form results wasn't sent!", surveySuccessWindow.isDisplayed());
    }

    @Step("6.Click 'Resend email'")
    public void clickResendEmailBtn() {
        resentEmailButton.click();
        waitnigUtil.wait(driver, ".wg-cell--order-1 > p > button", false);
        assertFalse("Email wasn't resended!", resentEmailButton.isDisplayed());
    }

    @Step("7. section 'Follow us' at the site footer contains the 'Twitter' button and icon")
    public void checkTwitterIconAndLink() {
        assertEquals("Incorrect link of Wrike Twitter site!", Links.TWITTER_WRIKE_LINK.getLink(), twitterButton.getAttribute("href"));
        assertEquals("Incorrect link of icon", Links.TWITTER_ICON_TEXT.getLink(), twitterIcon.getAttribute("xlink:href"));
    }
}