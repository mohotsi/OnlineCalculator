package ae.proctected.covenant.Seleniumautomation.Page;

import ae.proctected.covenant.Seleniumautomation.annotation.Page;
import lombok.val;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;


@Page
public class Button extends CommonPage {
    @FindBy(tagName = "iframe")
    private WebElement iframe;
    @FindBy(id = "canvas")
    private WebElement calculator;

    @Autowired
    private Actions actions;
    private int canVas_x;
    private CalculatorLayout layout;


    public Button(CalculatorLayout calculatorLayout) {
       // waitForElement.until(ExpectedConditions.elementToBeClickable(iframe));
       // driver.switchTo().frame(iframe);

        actions.moveToElement(calculator).click().perform();
        val canvas_dimession=calculator.getSize();
        canVas_x=canvas_dimession.getWidth()/5;
        layout=calculatorLayout;
    }
    public void click(){
        actions.moveToElement(calculator, layout.getCanVas_x(), layout.getCanVas_y()).click().perform();
    }
}
