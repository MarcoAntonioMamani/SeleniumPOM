package PageObjects.Telecom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Objects;

public class AddCustomerPage {


    private WebDriver driver;
    private WebDriverWait wait;
    @FindBy(tagName = "Done")
    WebElement rd_done;
    @FindBy(id = "pending")
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




    public AddCustomerPage(WebDriver d) {
        this.driver=d;
        wait=new WebDriverWait(driver, Duration.ofSeconds(20));
        PageFactory.initElements(driver,this);

    }

    public void RellenarCampos(){
      /*  wait.until(ExpectedConditions.visibilityOf(rd_done));



        rd_done.click();
*/
        txt_name.sendKeys("Marco Antonio");
        txtlame.sendKeys("Mamani Chura");
        txt_email .sendKeys("marcoantoniomamanichura@gmail.com");
        rd_addres.sendKeys("Barrio nueva america uv4578");
        txt_number.sendKeys("78140528");

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        btn_submit.click();


    }


}
