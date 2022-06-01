package Definitions;

import PageObjects.Telecom.AddCustomerPage;
import PageObjects.Telecom.MenuDemoGuruPage;
import PageObjects.Telecom.MenuTelecomPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

import java.util.List;
import java.util.Map;

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




    @And("ingreso datos del cliente")
    public void ingresoDatosDelCliente(DataTable clientes) {
        List<Map<String,String>> lista=clientes.asMaps(String.class,String.class);
        for (int i = 0; i < lista.size(); i++) {
            customer.clickDone(lista.get(i).get("check"));
            customer.RellenarCampos(lista.get(i).get("nombre"),lista.get(i).get("apellido"),
                    lista.get(i).get("email"),lista.get(i).get("direccion"),lista.get(i).get("telefono"));
        }

    }
}
