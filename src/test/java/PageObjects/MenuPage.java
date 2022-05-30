package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MenuPage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(linkText = "Generate Card Number") private WebElement lnk_generarTarjeta;
    @FindBy(linkText = "Check Credit Card Limit") private WebElement lnk_verLimiteTarjeta;

    public MenuPage(WebDriver d) {
        this.driver=d;
        wait=new WebDriverWait(driver, Duration.ofSeconds(20));
        PageFactory.initElements(driver,this);

    }

    public void clickGenerarTarjeta(){
        // Espera que cargue la pagina con el wait
        wait.until(ExpectedConditions.elementToBeClickable(lnk_generarTarjeta));
        lnk_generarTarjeta.click();
    }

    public void clickVerLimiteTarjeta(){
        // Espera que cargue la pagina con el wait
        wait.until(ExpectedConditions.elementToBeClickable(lnk_verLimiteTarjeta));
        lnk_verLimiteTarjeta.click();
    }

}
