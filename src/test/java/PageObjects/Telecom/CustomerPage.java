package PageObjects.Telecom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CustomerPage {

    private WebDriver driver;
    private WebDriverWait wait;


    @FindBy(tagName = "h3")
    WebElement lbl_customer;
    @FindBy(xpath = "//a[@class='button']")
    WebElement btn_home;
public  static String idCustomer;
    public CustomerPage(WebDriver d) {
        this.driver=d;
        wait=new WebDriverWait(driver, Duration.ofSeconds(20));
        PageFactory.initElements(driver,this);

    }

    public void CapturarCustomer(){
        wait.until(ExpectedConditions.visibilityOf(lbl_customer));
        idCustomer=lbl_customer.getText();
    }

    public void ClickEnviar(){
        btn_home.click();
    }

}
