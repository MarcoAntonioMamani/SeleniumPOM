package Definitions;

import PageObjects.Telecom.*;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;


import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

public class TelecomDefinition {

    MenuDemoGuruPage menu;
    MenuTelecomPage telecom;
    AddCustomerPage customer;
    CustomerPage customerPage;
    ValidarTarifaPage validar;
    String csv_file_path="src/test/resources/data/test.csv";
    IngresarCustomerPage ingreso;
    FelicitacionPage felicitacion;
    public TelecomDefinition() {
        menu=new MenuDemoGuruPage(Hooks.driver);
        telecom=new MenuTelecomPage(Hooks.driver);
        customer=new AddCustomerPage(Hooks.driver);
        customerPage=new CustomerPage(Hooks.driver);
        validar=new ValidarTarifaPage(Hooks.driver);
        ingreso=new IngresarCustomerPage(Hooks.driver);
        felicitacion=new FelicitacionPage(Hooks.driver);
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

    @And("ingreso datos del cliente desde un csv")
    public void ingresoDatosDelClienteDesdeUnCsv() throws IOException {
         Reader reader= Files.newBufferedReader(Paths.get(csv_file_path));
        CSVParser csvParser=new CSVParser(reader, CSVFormat.DEFAULT
                .withHeader("Check","Nombre","Apellido","Email","Direccion","Telefono")
                .withSkipHeaderRecord()  //aqui ignora para no lea las cabeceras
                .withTrim());   //para eliminar los espacios que hay en los valores de los datos
        for (CSVRecord csvRecord:csvParser) {
            customer.clickDone(csvRecord.get("Check"));
            customer.RellenarCampos(csvRecord.get("Nombre"),csvRecord.get("Apellido"),
                    csvRecord.get("Email"),csvRecord.get("Direccion"),csvRecord.get("Telefono"));
        }

        }


    @And("capturo el customer del cliente")
    public void capturoElCustomerDelCliente() {
        customerPage.CapturarCustomer();
        customerPage.ClickEnviar();

    }

    @And("Doy clic en Agregar tarifa de customer")
    public void doyClicEnAgregarTarifaDeCustomer() {

        telecom.ClickConsultarTarifa();
    }

    @And("doy click Agregar Cliente")
    public void doyClickAgregarCliente() {
        customer.clickConfirmarDatos();
    }

    @Then("obtengo el mensaje de alerta")
    public void obtengoElMensajeDeAlerta() {
        customer.ObtenerMensajeAlerta();
    }

    @And("ingreso el customer")
    public void ingresoElCustomer() {
    ingreso.IngresarCustomerID();
    ingreso.ClickSumbit();
    }

    @And("doy click en tarifa")
    public void doyClickEnTarifa() {
        validar.ClickTarifa();

        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @And("doy clic en boton tarifa")
    public void doyClicEnBotonTarifa() {

        validar.ClickBtnTarrifa();

    }

    @Then("Valido mensaje de felicitacion {string}")
    public void validoMensajeDeFelicitacion(String arg0) {

        felicitacion.ValidarCongrats(arg0);
    }

    @And("Regreso al Home")
    public void regresoAlHome() {
    felicitacion.ClickHome();
    }

    @Then("visualizo el nombre del cliente y el estado")
    public void visualizoElNombreDelClienteYElEstado(DataTable clientes) {

        List<Map<String,String>> lista=clientes.asMaps(String.class,String.class);
        for (int i = 0; i < lista.size(); i++) {
            validar.ValidarNombre(lista.get(i).get("nombre"));
            validar.ValidarEstado(lista.get(i).get("estado"));

        }


    }
}
