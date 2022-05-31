package Definitions;

import PageObjects.Telecom.AddCustomerPage;
import PageObjects.Telecom.MenuDemoGuruPage;
import PageObjects.Telecom.MenuTelecomPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class TelecomDefinition {

    MenuDemoGuruPage menu;
    MenuTelecomPage telecom;
    AddCustomerPage customer;
    public TelecomDefinition() {
        menu=new MenuDemoGuruPage(Hooks.driver);
        telecom=new MenuTelecomPage(Hooks.driver);
        customer=new AddCustomerPage(Hooks.driver);
    }

    @Given("la web esta disponible")
    public void laWebEstaDisponible() {
        Hooks.driver.get("https://demo.guru99.com/payment-gateway/index.php");

    }

    @When("doy clic en telecom project")
    public void doyClicEnTelecomProject() {
    menu.ClickTelecomProject();

    }

    @And("aregamos un nuevo cliente")
    public void aregamosUnNuevoCliente() {
        telecom.ClickAgregarcliente();
    }

    @And("rellenamos los campos del formulario")
    public void rellenamosLosCamposDelFormulario() {
        customer.RellenarCampos();
    }
}
