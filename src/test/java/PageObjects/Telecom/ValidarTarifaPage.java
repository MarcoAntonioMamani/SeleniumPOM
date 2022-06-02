package PageObjects.Telecom;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Locale;

public class ValidarTarifaPage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(tagName = "h3") private WebElement lbl_nameCustomer;
    @FindBy(xpath = "//p//font") private WebElement lbl_active;
    @FindBy(xpath = "//label[@for='sele']") private WebElement rdn_tarifa;
    @FindBy(name = "submit") private WebElement btn_addTarifa;


    public ValidarTarifaPage(WebDriver d) {
        this.driver=d;
        wait=new WebDriverWait(driver, Duration.ofSeconds(20));
        PageFactory.initElements(driver,this);
    }

    public void ValidarNombre(String nombre){
        wait.until(ExpectedConditions.visibilityOf(lbl_nameCustomer));
        String name=lbl_nameCustomer.getText().replace("Welcome to add customer tariff plan ","");
        Assert.assertEquals(nombre.toLowerCase(),name.toLowerCase());
        System.out.println(name);
    }
public void ValidarEstado(String estado){

        wait.until(ExpectedConditions.visibilityOf(lbl_active));
        lbl_active.getText();
        Assert.assertEquals(estado.toLowerCase(),lbl_active.getText().toLowerCase());
    System.out.println(lbl_active.getText());
}
    public void ClickTarifa(){
        JavascriptExecutor executor=(JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();",rdn_tarifa);
    }

    public void ClickBtnTarrifa(){
    btn_addTarifa.click();

    }

}
