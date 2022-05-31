package PageObjects;

import io.cucumber.java.eo.Se;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ValidarTarjetaPage {

    private WebDriver driver;
    private WebDriverWait wait;
    @FindBy(name = "card_nmuber")
    WebElement txt_numeroTarjeta;
    @FindBy(id = "month") WebElement cbx_mes;
    @FindBy(id = "year") WebElement cbx_Anio;
    @FindBy(id = "cvv_code") WebElement txt_cvvCode;
    @FindBy(name = "submit") WebElement btn_submit;
    @FindBy(xpath = "//font[2]")WebElement txt_monto;
    protected static double montoValidar;

    public ValidarTarjetaPage(WebDriver d) {
        this.driver=d;
        wait=new WebDriverWait(driver, Duration.ofSeconds(20));
        PageFactory.initElements(driver,this);

    }


    public void CapturarMonto(){
        wait.until(ExpectedConditions.visibilityOf(txt_monto));
        montoValidar=Double.parseDouble(txt_monto.getText().replace("$",""));
        System.out.println("Monto a Validar= "+montoValidar);

    }
    public void IngresarDatosTarjeta(){

        double totalMonto=Double.parseDouble(ComprarPage.montoProducto)*Double.parseDouble(ComprarPage.cantidad);
        Assert.assertEquals(""+totalMonto,""+montoValidar);
        txt_numeroTarjeta.sendKeys(CapturarDatosTarjetasPage.tarjeta);
        SeleccionarMes(CapturarDatosTarjetasPage.mes);
        SeleccionarAnio(CapturarDatosTarjetasPage.anio);
        IngresarCvvCode(CapturarDatosTarjetasPage.cvv);

        ClickSubmit();



    }
    public void SeleccionarMes(String mes){
        Select combo=new Select(cbx_mes);

        combo.selectByVisibleText(mes);

    }
    public void SeleccionarAnio(String anio){
        Select combo=new Select(cbx_Anio);
        combo.selectByVisibleText(anio);

    }
    public void IngresarCvvCode(String cvvCode){
        txt_cvvCode .sendKeys(cvvCode);

    }

    public void ClickSubmit(){
        btn_submit.click();
    }

}
