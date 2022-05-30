package Definitions;

import PageObjects.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CarritoDefinitions {

    MenuPage menu;
    CapturarDatosTarjetasPage captura;
    VerCreditoTarjeta visualizar;
    BalanceTarjetaPage saldoCredito;
    ComprarPage compra;
    public CarritoDefinitions() {

        menu=new MenuPage(Hooks.driver);
        captura=new CapturarDatosTarjetasPage(Hooks.driver);
        visualizar=new VerCreditoTarjeta(Hooks.driver);
        saldoCredito=new BalanceTarjetaPage(Hooks.driver);
        compra=new ComprarPage(Hooks.driver);
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

    @And("Capturo monto del producto")
    public void capturoMontoDelProducto() {
        compra.montoProducto();

    }

    @And("Ingreso la cantidad {string} a comprar")
    public void ingresoLaCantidadAComprar(String cantidad) {
        compra.IngresoCantidad(cantidad);
    }

    @And("Doy click en Agregar")
    public void doyClickEnAgregar() {
        compra.ClickAgregarCarrito();
    }
}
