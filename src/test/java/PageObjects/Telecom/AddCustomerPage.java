package PageObjects.Telecom;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Locale;
import java.util.Objects;

public class AddCustomerPage {


    private WebDriver driver;
    private WebDriverWait wait;
    @FindBy(xpath = "//*[@id='done']//following-sibling::label")
    //@FindBy(xpath = "//div[1]/label")
    WebElement rd_done;
    @FindBy(id = "//div[2]/label")
    WebElement rd_pending;
    @FindBy(id = "fname")
    WebElement txt_name;
    @FindBy(id = "lname")
    WebElement txtlame;
    @FindBy(id = "email")
    WebElement txt_email;
    @FindBy(name = "addr")
    WebElement rd_addres;
    @FindBy(id = "telephoneno")
    WebElement txt_number;
    @FindBy(name = "submit")
    WebElement btn_submit;
    private Alert MensajeAlerta;



    public AddCustomerPage(WebDriver d) {
        this.driver=d;
        wait=new WebDriverWait(driver, Duration.ofSeconds(20));
        PageFactory.initElements(driver,this);

    }

    public void clickDone(String check){
        wait.until(ExpectedConditions.elementToBeClickable(rd_done));

        if (check.toLowerCase().equals("done")){
            rd_done.click();
        }else if(check.toLowerCase().equals("pending"))rd_pending.click();


    }

    public void RellenarCampos(String nombre,String apellido,String email,String direccion,String telefono){

        txt_name.sendKeys(nombre);
        txtlame.sendKeys(apellido);
        txt_email .sendKeys(email);
        rd_addres.sendKeys(direccion);
        txt_number.sendKeys(telefono);

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        btn_submit.click();


    }

    public void clickConfirmarDatos(){
        btn_submit.click();
    }

    public void ObtenerMensajeAlerta(){


        try {
            Thread.sleep(5000);
            MensajeAlerta=driver.switchTo().alert();
            System.out.println("El mensaje de la alerta es: "+MensajeAlerta.getText());
            MensajeAlerta.accept();
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
