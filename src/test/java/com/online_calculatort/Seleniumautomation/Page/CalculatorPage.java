package com.online_calculatort.Seleniumautomation.Page;

import com.online_calculatort.Seleniumautomation.annotation.Page;
import com.asprise.ocr.Ocr;
import io.cucumber.datatable.DataTable;
import lombok.val;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import javax.annotation.PostConstruct;
import java.io.File;
import java.util.Map;
import java.util.stream.Collectors;

@Page
public class CalculatorPage extends CommonPage {

    @FindBy(tagName = "iframe")
    WebElement iframe;
    @FindBy(id = "canvas")
    private WebElement calculator;



    int buttonSquareLength;
    int buttonMiddle;
    boolean alreadyInframe=false;

Map<String,Runnable> commands=Map.ofEntries(
        Map.entry("0",()->clickZero()),
        Map.entry("1",()->clickOne()),
        Map.entry("2",()->clickTwo()),

        Map.entry("3",()->clickThree()),
        Map.entry("4",()->clickFour()),
        Map.entry("5",()->clickFive()),
        Map.entry("6",()->clickSix()),
        Map.entry("7",()->clickSeven()),
        Map.entry("8",()->clickEight()),
        Map.entry("9",()->clickNine()),
        Map.entry(".",()->clickDot()),
        Map.entry("+",()->clickplus()),
        Map.entry("-",()->clickMinus()),
        Map.entry("x",()->clickMultiply()),
        Map.entry("/",()->clickDivision()),

        Map.entry("%",()->clickPercentage()),
        Map.entry("=",()->equals()),
        Map.entry("square root",()->clickSquareRoot()),
        Map.entry("1/x",()-> clickInverse()),
        Map.entry("MC",()-> clickMC()),
        Map.entry("MR",()-> clickMR()),
        Map.entry("M+",()-> clickMPlus()),
        Map.entry("M-",()-> clickMsubstract()),
        Map.entry("C",()-> clear())

        );
    JavascriptExecutor js = (JavascriptExecutor) driver;


    Actions actions;
@PostConstruct
    public void initialize(){
       actions=new Actions(driver);

       try{

           driver.switchTo().frame(iframe);
       }
       catch (NoSuchElementException e){

       }

       alreadyInframe=true;
        actions.moveToElement(calculator).click().perform();
        Dimension canvas_dimession=calculator.getSize();
        buttonSquareLength=canvas_dimession.getWidth()/5;
        buttonMiddle=buttonSquareLength/2;
    }

    public void click(String operation){
        if(operation.matches("[0-9\\.]+")){
            val time=  operation.chars().mapToObj(Character::toString).collect(Collectors.toList());
            time.forEach(op->commands.get(op).run());
        }
       else
           commands.get(operation).run();

    }
    public Double getResults() throws Exception {
    Thread.sleep(3000);
        val resultsScreen=   getScreenShot(calculator,6);
        Ocr.setUp();
        Ocr ocr = new Ocr(); // create a new OCR engine
        ocr.startEngine("eng", Ocr.SPEED_SLOW); // English

        String s = ocr.recognize(new File[] {resultsScreen },
                Ocr.RECOGNIZE_TYPE_TEXT, Ocr.OUTPUT_FORMAT_PLAINTEXT).replace("*","0");// it thinks zero is a star
        val results=Double.parseDouble(s.replaceAll("[^0-9\\.]",""));
        if (resultsScreen.exists()){
            resultsScreen.delete();
        }
        ocr.stopEngine();
       return results;
    }
public void performOperations(DataTable dataTable) throws Exception {

dataTable.asMaps().stream().map(operation->operation.get("operation")).collect(Collectors.toList())
                .forEach(operation->click(operation));

Thread.sleep(3000);

}
private void clear(){
    actions.moveToElement(calculator,buttonSquareLength*2,buttonMiddle-(buttonSquareLength*2)).click().perform();
}
private void clickInverse(){
    actions.moveToElement(calculator,buttonSquareLength*2,buttonMiddle+(buttonSquareLength)).click().perform();
}
private void clickMsubstract(){
    actions.moveToElement(calculator,buttonSquareLength,buttonMiddle-(buttonSquareLength*2)).click().perform();
}
private void clickMPlus(){
    actions.moveToElement(calculator,0,buttonMiddle-(buttonSquareLength*2)).click().perform();
}
private void clickMR(){
    actions.moveToElement(calculator,-(buttonSquareLength),buttonMiddle-(buttonSquareLength*2)).click().perform();
}
private void  clickMC(){
    actions.moveToElement(calculator,-(buttonSquareLength*2),buttonMiddle-(buttonSquareLength*2)).click().perform();
}
private void clickSquareRoot(){
    actions.moveToElement(calculator,buttonSquareLength*2,buttonMiddle-buttonSquareLength).click().perform();
}
private void clickDivision(){
    actions.moveToElement(calculator,buttonSquareLength,buttonMiddle-buttonSquareLength).click().perform();
}
private void clickNine(){
    actions.moveToElement(calculator,0,buttonMiddle-buttonSquareLength).click().perform();
}
private void clickEight(){
    actions.moveToElement(calculator,-(buttonSquareLength),buttonMiddle-buttonSquareLength).click().perform();
}

private void clickSeven(){
    actions.moveToElement(calculator,-(buttonSquareLength*2),buttonMiddle-buttonSquareLength).click().perform();//7
}
private void clickPercentage(){
    actions.moveToElement(calculator,buttonSquareLength*2,buttonMiddle).click().perform();
}
private void clickMultiply(){
    actions.moveToElement(calculator,buttonSquareLength,buttonMiddle).click().perform();
}
private void clickMinus(){
    actions.moveToElement(calculator,buttonSquareLength,buttonMiddle+(buttonSquareLength)).click().perform();

}
private void clickSix(){
    actions.moveToElement(calculator,0,buttonMiddle).click().perform();
}
private void clickFive(){
    actions.moveToElement(calculator,-(buttonSquareLength),buttonMiddle).click().perform();
}
private void clickFour(){
    actions.moveToElement(calculator,-(buttonSquareLength*2),buttonMiddle).click().perform();
}
private void clickThree(){
    actions.moveToElement(calculator,0,buttonMiddle+(buttonSquareLength)).click().perform();
}
private void clickplus(){
    actions.moveToElement(calculator,buttonSquareLength,buttonMiddle+(buttonSquareLength*2)).click().perform();
}
    private void equals(){
        actions.moveToElement(calculator,buttonSquareLength*2,buttonMiddle+(buttonSquareLength*2)).click().perform();
    }
private void changeSign(){
    actions.moveToElement(calculator,0,buttonMiddle+(buttonSquareLength*2)).click().perform();
}
private void clickTwo(){
    actions.moveToElement(calculator,-(buttonSquareLength),buttonMiddle+(buttonSquareLength)).click().perform();
}
private void clickOne(){
    actions.moveToElement(calculator,-(buttonSquareLength*2),buttonMiddle+(buttonSquareLength)).click().perform();
}
private void clickZero(){
    actions.moveToElement(calculator,-(buttonSquareLength*2),buttonMiddle+(buttonSquareLength*2)).click().perform();
}
private void clickDot(){
    actions.moveToElement(calculator,-(buttonSquareLength),buttonMiddle+(buttonSquareLength*2)).click().perform();
}


}
