package PageObjects.Telecom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class IngresarCustomerPage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(name = "customer_id") private WebElement txt_customerId;
    @FindBy(name = "submit") private WebElement btn_addSubmit;

    public IngresarCustomerPage(WebDriver d) {
        this.driver=d;
        wait=new WebDriverWait(driver, Duration.ofSeconds(20));
        PageFactory.initElements(driver,this);
    }
public void IngresarCustomerID(){
        wait.until(ExpectedConditions.visibilityOf(txt_customerId));
        txt_customerId.sendKeys(CustomerPage.idCustomer);
    try {
        Thread.sleep(2000);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
}
public void ClickSumbit(){
        btn_addSubmit.click();
    try {
        Thread.sleep(2000);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
}

}
