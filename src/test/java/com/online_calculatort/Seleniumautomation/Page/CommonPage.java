package com.online_calculatort.Seleniumautomation.Page;


import com.online_calculatort.Seleniumautomation.annotation.Page;
import lombok.val;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Lazy;

import javax.annotation.PostConstruct;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.concurrent.TimeUnit;

@Page
public class CommonPage {
    @Autowired
    protected WebDriver driver;
    @Autowired
    protected WebDriverWait waitForElement;
    @Value("${default.timeout}")
    protected int timeout;
    @FindBy(tagName = "a")
    WebElement downloadItemURL;

    @Autowired
    @Lazy
    ApplicationContext applicationContext;

    @PostConstruct
    private void initilize() {
        PageFactory.initElements(this.driver, this);

    }

    public void quit() {
        driver.quit();
    }


    public void select(WebElement menu, String itemText) {
        val select = new Select(menu);
        select.selectByVisibleText(itemText);
    }

    public void clickRetry(final WebElement webElement) {

        waitForElement.until(ExpectedConditions.elementToBeClickable(webElement));
        webElement.click();
    }

    public WebElement scrollTo(final WebElement webElement) {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);

        js.executeScript("arguments[0].scrollIntoView(true);", webElement);
        waitForElement.ignoring(ElementNotInteractableException.class).until((e) -> webElement.isDisplayed());
        Actions action1 = new Actions(driver);
        action1.moveToElement(webElement).perform();
        return webElement;
    }

    public WebElement waitUntilItIsDisplayed(WebElement webElement) {
        waitForElement.until((e) -> webElement.isDisplayed());
        return webElement;
    }
    public File getScreenShot(WebElement webElement,int horizontalDevision) throws IOException {
        val screenShot = applicationContext.getBean(TakesScreenshot.class).getScreenshotAs(OutputType.FILE);
        val fullImg = ImageIO.read(screenShot);
        val point = webElement.getLocation();

        val eleWidth = webElement.getSize().getWidth();
        val eleHeight = webElement.getSize().getHeight();

      val img= fullImg.getSubimage(point.getX(), point.getY(), eleWidth, eleHeight/horizontalDevision);
        byte[] array = new byte[1000]; // length is bounded by 7
        new Random().nextBytes(array);
        String fileName = getSaltString();
       val file= new File(System.getProperty("user.dir")+"/src/main/resources/images/"+fileName+".png");
        ImageIO.write(img, "png", file);
       return file;
    }
    protected String getSaltString() {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 18) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;

    }
    public File getScreenShot(WebElement webElement) throws IOException{
       return getScreenShot(webElement,1);
    }

    protected WebElement waitForloadingOfWebElement(final WebElement webElement) throws InterruptedException {
        int count = timeout;
        return waitForElementNotToBeStale(webElement, count);
    }

    private WebElement waitForElementNotToBeStale(final WebElement webElement, int count) {
        try {
            return webElement;
        } catch (StaleElementReferenceException e) {
            if (count > 0) {
                driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
                return waitForElementNotToBeStale(webElement, count - 1);
            } else
                return webElement;

        }
    }



    public WebElement highlight(WebElement webElement) {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttribute('style', 'background: GreenYellow; border: GreenYellow;color:black;');", webElement);
        return webElement;
    }


}
