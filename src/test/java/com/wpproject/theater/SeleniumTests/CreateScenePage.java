package com.wpproject.theater.SeleniumTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class CreateScenePage extends SeleniumConfig{


    public CreateScenePage(WebDriver driver) {
        super(driver);
    }

    void open(){
        driver.get("http://localhost:3000");
    }

    boolean createScene(String sceneName, int sceneCapacity, int seatsInRow) throws InterruptedException {
        driver.findElement(By.id("showsNavItem")).click();
        driver.findElement(By.id("createShowButton")).click();
        driver.findElement(By.id("createSceneButton")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"sceneName\"]")).sendKeys(sceneName);
        driver.findElement(By.name("sceneCapacity")).sendKeys(String.valueOf(sceneCapacity));
        driver.findElement(By.name("seatsInRow")).sendKeys(String.valueOf(seatsInRow));
        driver.findElement(By.id("sceneSubmit")).click();
        WebElement selectElement = driver.findElement(By.id("showScene"));
        Select select = new Select(selectElement);
        Thread.sleep(3000);
        List<WebElement> allOptions = select.getOptions();
        for(WebElement el : allOptions){
            if(el.getText().equals(sceneName + " (" + sceneCapacity + ")")){
                return true;
            }
        }
        return false;
    }
}
