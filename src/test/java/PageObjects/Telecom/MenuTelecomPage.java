package PageObjects.Telecom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MenuTelecomPage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(linkText = "Add Customer")
    WebElement lnk_agregarCliente;


    @FindBy(linkText = "Add Tariff Plan")
    WebElement lnk_agregarTarrifa;


    public MenuTelecomPage(WebDriver d) {
        this.driver=d;
        wait=new WebDriverWait(driver, Duration.ofSeconds(20));
        PageFactory.initElements(driver,this);

    }

    public void ClickAgregarcliente(){
        wait.until(ExpectedConditions.elementToBeClickable(lnk_agregarCliente));
        lnk_agregarCliente.click();

        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public void ClickConsultarTarifa(){
        wait.until(ExpectedConditions.elementToBeClickable(lnk_agregarTarrifa));
        lnk_agregarTarrifa.click();

        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
