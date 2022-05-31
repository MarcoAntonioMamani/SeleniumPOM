package PageObjects.Telecom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MenuDemoGuruPage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(linkText = "Telecom Project")
    WebElement lnk_telecom;


    public MenuDemoGuruPage(WebDriver d) {
        this.driver=d;
        wait=new WebDriverWait(driver, Duration.ofSeconds(20));
        PageFactory.initElements(driver,this);

    }

    public void ClickTelecomProject(){
    wait.until(ExpectedConditions.elementToBeClickable(lnk_telecom));
    lnk_telecom.click();
    }



}
