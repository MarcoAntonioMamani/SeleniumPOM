package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class VerCreditoTarjeta {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(id = "card_nmuber") private WebElement tb_tarjetaCredito;
    @FindBy(name = "submit") private WebElement btn_verificar;

    public VerCreditoTarjeta(WebDriver d) {
        this.driver=d;
        wait=new WebDriverWait(driver, Duration.ofSeconds(20));
        PageFactory.initElements(driver,this);

    }

    public void ConsultarDatos(){
        wait.until(ExpectedConditions.visibilityOf(tb_tarjetaCredito));
        tb_tarjetaCredito.sendKeys(CapturarDatosTarjetasPage.tarjeta);

        try {
            Thread.sleep(5000);
            btn_verificar.click();
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
