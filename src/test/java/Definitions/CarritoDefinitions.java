package Definitions;

import PageObjects.CapturarDatosTarjetasPage;
import PageObjects.MenuPage;
import PageObjects.VerCreditoTarjeta;
import PageObjects.BalanceTarjetaPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CarritoDefinitions {

    MenuPage menu;
    CapturarDatosTarjetasPage captura;
    VerCreditoTarjeta visualizar;
    BalanceTarjetaPage saldoCredito;
    public CarritoDefinitions() {

        menu=new MenuPage(Hooks.driver);
        captura=new CapturarDatosTarjetasPage(Hooks.driver);
        visualizar=new VerCreditoTarjeta(Hooks.driver);
        saldoCredito=new BalanceTarjetaPage(Hooks.driver);
    }

    @Given("La pagina esta estable")
    public void laPaginaEstaEstable() {
        Hooks.driver.get("https://demo.guru99.com/payment-gateway/index.php");

    }

    @When("doy click en generar tarjeta")
    public void doyClickEnGenerarTarjeta() {

        menu.clickGenerarTarjeta();

    }

    @And("capturamos datos de la tarjeta")
    public void capturamosDatosDeLaTarjeta() {

        captura.CambiarVentana();

        captura.CapturarTarjeta();
        captura.CapturarCvv();
        captura.CapturarFecha();
        captura.CapturarMontoDisponible();


    }

    @And("doy click en ver limite de la tarjeta")
    public void doyClickEnVerLimiteDeLaTarjeta() {
        menu.clickVerLimiteTarjeta();
    }

    @And("consultamos datos de limite de la tarjeta")
    public void consultamosDatosDeLimiteDeLaTarjeta() {
        visualizar.ConsultarDatos();
    }



    @Then("puedo capturar los mensajes del balance de tarjeta {string}")
    public void puedoCapturarLosMensajesDelBalanceDeTarjeta(String mensajeBalance) {

        saldoCredito.CapturarMensajeBalance(mensajeBalance);



    }

    @And("capturo el mensaje de {string}")
    public void capturoElMensajeDe(String mensaje) {
        saldoCredito.CapturarAnyTransaction(mensaje);
        saldoCredito.CapturarClickBtnCart();
    }
}
