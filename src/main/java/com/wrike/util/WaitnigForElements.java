package com.wrike.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Waiting for element appearance or disappearance
 */
public class WaitnigForElements implements IWaitnigForElements {

    public void wait(WebDriver driver, String selector, boolean elementVisibility) {
        By locator = new By.ByCssSelector(selector);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        if (elementVisibility) {
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        } else {
            wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
        }
    }
}