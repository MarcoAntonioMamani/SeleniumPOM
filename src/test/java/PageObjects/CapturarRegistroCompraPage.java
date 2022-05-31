package PageObjects;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CapturarRegistroCompraPage {

    private WebDriver driver;
    private WebDriverWait wait;
    @FindBy(tagName = "h2") private WebElement lbl_validar;
    @FindBy(xpath = "//td[2]/h3/strong") private WebElement lbl_orden;
    @FindBy(xpath = "//*[@class='button special']") private WebElement btn_Home;

protected static String nroOrden;


    public CapturarRegistroCompraPage(WebDriver d) {

        this.driver=d;
        wait=new WebDriverWait(driver, Duration.ofSeconds(20));
        PageFactory.initElements(driver,this);
    }

    public void ValidarMensajePayment(String mensaje){
        wait.until(ExpectedConditions.visibilityOf(lbl_validar));
        Assert.assertEquals(mensaje,lbl_validar.getText());
    }
    public void capturarOrden(){
        System.out.println("text result = "+lbl_orden.getText());
        nroOrden=lbl_orden.getText();

    }
    public void ClickHome(){
        btn_Home.click();
    }

}
