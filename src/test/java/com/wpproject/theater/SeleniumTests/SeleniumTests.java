package com.wpproject.theater.SeleniumTests;

import com.wpproject.theater.repositories.SeatReservationRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class SeleniumTests {
    private WebDriver driver;
    @BeforeEach
    public void setup() {
        driver = getDriver();
    }

    @AfterEach
    public void tearDown(){
        driver.close();
    }

    private WebDriver getDriver() {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Pavel\\Documents\\Programming projects\\Spring projects\\theater\\src\\main\\resources\\chromedriver\\chromedriver.exe");
        return new ChromeDriver();
    }

    @Test
    void plusClicked() throws InterruptedException {
        CreateScenePage page = new CreateScenePage(driver);
        page.open();
        assertTrue(page.createScene("Pavel", 10, 5));
    }

}
