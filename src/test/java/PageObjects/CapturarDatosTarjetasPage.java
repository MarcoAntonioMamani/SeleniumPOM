package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

public class CapturarDatosTarjetasPage {

    //private  --> solo se puede usar dentro de la misma clase
    //public   --> pueden ser usadas dentro del proyecto
    //protected static --> pueden ser usadas dentro del mismo paquete en este caso "Page Objects"



    private WebDriver driver;
    private WebDriverWait wait;
    protected static String tarjeta,cvv,mes,anio,monto;




    @FindBy(xpath = "//h4[1]") private WebElement lbl_tarjeta;
    @FindBy(xpath = "//h4[2]") private WebElement lbl_cvv;
    @FindBy(xpath = "//h4[3]") private WebElement lbl_fecha;
    @FindBy(xpath = "//h4[4]") private WebElement lbl_montoDisponible;
    public CapturarDatosTarjetasPage(WebDriver d) {
        this.driver=d;
        wait=new WebDriverWait(driver, Duration.ofSeconds(20));
        PageFactory.initElements(driver,this);

    }
    public void CambiarVentana(){
        Set<String> indetificadores=driver.getWindowHandles();
       int ventana=0;
        for(String identificador: indetificadores){

           driver.switchTo().window(identificador);
            ventana++;
            System.out.println(ventana+":"+identificador+"   ");
         //   System.out.println("Lenght = "+indetificadores.size());


        }
    }

    public void CerrarVentana(){
        driver.close();
        driver.switchTo().window("");
    }
    public void CapturarTarjeta(){
        wait.until(ExpectedConditions.visibilityOf(lbl_tarjeta));
      /*  Actions builder = new Actions(driver);
        builder.moveToElement(lbl_tarjeta);*/
        tarjeta=lbl_tarjeta.getText().replace("Card Number:- ","");
       // System.out.println(lbl_tarjeta.getText());
       // System.out.println(tarjeta);

    }

    public void CapturarCvv(){
        cvv=lbl_cvv.getText().replace("CVV:- ","");
      //  System.out.println(lbl_cvv.getText());
      //  System.out.println(cvv);
    }
    public void CapturarFecha(){
        String fecha=lbl_fecha.getText().replace("Exp:- ","").trim();
        mes=fecha.substring(0,fecha.indexOf("/"));
        anio=fecha.substring(fecha.indexOf("/")+1,fecha.length());
       // System.out.println(lbl_fecha.getText());
       // System.out.println(mes);
       // System.out.println(anio);
    }
    public void CapturarMontoDisponible(){

        monto=lbl_montoDisponible.getText().replace("Credit Limit $","");
      //  System.out.println(lbl_montoDisponible.getText());
      //  System.out.println(monto);
        CerrarVentana();
    }



}
