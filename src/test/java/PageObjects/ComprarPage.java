package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ComprarPage {
  private WebDriver driver;
  private WebDriverWait wait;

  protected String montoProducto;

  @FindBy(name = "quantity") private WebElement cbx_cantidad;
  @FindBy(xpath = "//input") private  WebElement btn_comprar;
  @FindBy(tagName = "h3") private WebElement lbl_monto;

  public ComprarPage(WebDriver d) {

    this.driver=d;
    wait=new WebDriverWait(driver, Duration.ofSeconds(20));
    PageFactory.initElements(driver,this);
  }

  public void montoProducto(){

    wait.until(ExpectedConditions.visibilityOf(lbl_monto));
    montoProducto=lbl_monto.getText().replace("Price: $","");
    System.out.println("Monto Del Producto= "+montoProducto);


  }

  public void IngresoCantidad(String Cantidad){
    Select combo=new Select(cbx_cantidad);
    combo.selectByValue(Cantidad);

  /*  combo.selectByValue("2");
    combo.selectByIndex(1);
    combo.selectByVisibleText("2");*/

  }

  public void ClickAgregarCarrito(){
    btn_comprar.click();

    try {
      Thread.sleep(2000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
