package com.wrike.util;

import org.openqa.selenium.WebDriver;

public interface IWaitnigForElements {
    void wait(WebDriver driver, String selector, boolean elementVisibility);
}
