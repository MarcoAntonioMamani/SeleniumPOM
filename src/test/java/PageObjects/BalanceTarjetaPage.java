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

}
