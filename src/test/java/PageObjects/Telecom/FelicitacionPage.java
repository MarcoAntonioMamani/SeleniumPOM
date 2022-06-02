package PageObjects.Telecom;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FelicitacionPage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(tagName = "h2") private WebElement lbl_congrats;
    @FindBy(xpath = "//a[@class='button']") private WebElement btn_home;


    public FelicitacionPage(WebDriver d) {
        this.driver=d;
        wait=new WebDriverWait(driver, Duration.ofSeconds(20));
        PageFactory.initElements(driver,this);
    }

    public void ValidarCongrats(String Felicitacion){
        wait.until(ExpectedConditions.visibilityOf(lbl_congrats));
        Assert.assertEquals(Felicitacion,lbl_congrats.getText());

        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
    public void ClickHome(){
        btn_home.click();
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
