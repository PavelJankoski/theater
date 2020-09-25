package com.wpproject.theater.SeleniumTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumConfig {
    public final WebDriverWait wait;
    public static WebDriver driver;

    public SeleniumConfig(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver,10);
    }
}
