import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.util.List;

public class OpenPage {

    WebDriver driver;


    public OpenPage() {
        System.setProperty("webdriver.gecko.driver", "/Users/oleg/Desktop/TESTING/PROGI-Testing/geckodriver");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
    }

    public void openPage(String url) {
        if (!url.contains("http://") && !url.contains("https://")) {
            url = "http://" + url;
        }
        driver.get(url);
    }

    public List<WebElement> getElements(By locator) {

        return driver.findElements(locator);
    }

    public WebElement getElement(By locator) {
        waitForElement(locator);

        return driver.findElement(locator);
    }

    public boolean isElementPresent(By locator) {
        return getElements(locator).isEmpty();
    }

    private void waitForElement(By locator) {
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    public void close(){
        driver.quit();
    }

}




