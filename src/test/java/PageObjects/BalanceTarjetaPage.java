package PageObjects;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BalanceTarjetaPage {

    private WebDriver driver;
    private WebDriverWait wait;
    //Presionar Control + F para que salga el buscador y crear los xpath
    @FindBy(xpath = "//font[1]") private WebElement lbl_creditBalance;
    @FindBy(xpath = "//font[2]") private WebElement lbl_anyTransaction;

    @FindBy(linkText = "Cart") private WebElement btn_cart;  // el linkText se utiliza cuando un componente contiene un href

    @FindBy(xpath = "//td[1]/b/font") private WebElement lbl_tarjeta;
    @FindBy(xpath = "//tr/td[2]/b/font") private WebElement lbl_montoCompra;
    @FindBy(xpath = "//td[3]/b/font")private WebElement lbl_mes;
    @FindBy(xpath = "//td[4]/b/font")private WebElement lbl_anio;
    @FindBy(xpath = "//td[5]/b/font")private WebElement lbl_cvv;
    @FindBy(xpath = "//td[6]/b/font")private WebElement lbl_orderId
            ;
    @FindBy(xpath = "//h4/span")private WebElement lbl_saldo;

    public BalanceTarjetaPage(WebDriver d) {
        this.driver=d;
        wait=new WebDriverWait(driver, Duration.ofSeconds(20));
        PageFactory.initElements(driver,this);

    }

    public void CapturarMensajeBalance(String MensajeBalance){
        wait.until(ExpectedConditions.visibilityOf(lbl_creditBalance));
        Assert.assertEquals(MensajeBalance,lbl_creditBalance.getText());
        System.out.println(MensajeBalance+"  -  "+lbl_creditBalance.getText());
    }

    public void CapturarAnyTransaction(String mensaje){
        wait.until(ExpectedConditions.visibilityOf(lbl_anyTransaction));
        Assert.assertEquals(mensaje,lbl_anyTransaction.getText());
        System.out.println(mensaje+"  -  "+lbl_anyTransaction.getText());
    }
    public void CapturarClickBtnCart(){
        btn_cart.click();
    }

    public void validarSaldo(){
        double TotalVenta=Double.parseDouble(ComprarPage.montoProducto)*Double.parseDouble(ComprarPage.cantidad);
        double saldo=Double.parseDouble(CapturarDatosTarjetasPage.monto)-TotalVenta;

        double CreditoBalance=Double.parseDouble(lbl_saldo.getText());

        Assert.assertEquals(""+saldo,""+CreditoBalance);

        System.out.println("Validando Saldo = "+saldo+"  Saldo Pantalla = "+CreditoBalance);

    }

    public void validarDatosTarjeta(){
        System.out.println("Comparando Datos "+lbl_tarjeta.getText()+" = "+CapturarDatosTarjetasPage.tarjeta);
        Assert.assertEquals(lbl_tarjeta.getText(),CapturarDatosTarjetasPage.tarjeta);
        System.out.println("Comparando Datos "+lbl_mes.getText()+" = "+CapturarDatosTarjetasPage.mes.replace("0",""));
        Assert.assertEquals(lbl_mes.getText(),CapturarDatosTarjetasPage.mes.replace("0",""));
        System.out.println("Comparando Datos "+lbl_anio.getText()+" = "+CapturarDatosTarjetasPage.anio);
        Assert.assertEquals(lbl_anio.getText(),CapturarDatosTarjetasPage.anio);
        System.out.println("Comparando Datos "+lbl_cvv.getText()+" = "+CapturarDatosTarjetasPage.cvv);
        Assert.assertEquals(lbl_cvv.getText(),CapturarDatosTarjetasPage.cvv);
        System.out.println("Comparando Datos "+lbl_orderId.getText()+" = "+CapturarRegistroCompraPage.nroOrden);
        Assert.assertEquals(lbl_orderId.getText(),CapturarRegistroCompraPage.nroOrden);

        Double Montocompra=Double.parseDouble(lbl_montoCompra.getText().replace("$",""));
        double TotalVenta=Double.parseDouble(ComprarPage.montoProducto)*Double.parseDouble(ComprarPage.cantidad);
        Assert.assertEquals(""+Montocompra,""+TotalVenta);
        System.out.println("Comparando Datos "+Montocompra+" = "+TotalVenta);

    }

}
