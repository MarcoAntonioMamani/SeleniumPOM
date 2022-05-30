package Definitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Hooks {

    public static WebDriver driver;  //Variable para conectar con los drivers "ChromeDriver"

    @Before
    public static void setUp(){  //Metodo antes de que inicie
        System.setProperty("webdriver.chrome.driver","src/test/resources/drivers/chromedriver.exe");// Metodo para configurar el driver
        driver=new ChromeDriver();
       // driver=new FirefoxDriver();   Si fuera Firefox cambiariamos de esa forma
        driver.manage().window().maximize();   //Con esta linea de codigo estamos maximizando la ventana del navegador

    }

     // el trabajo del robot automatizado



    @After  //Despues de ejecutar todas las pruebas se ejecuta este metodo
    public static void tearDown(){

        driver.manage().deleteAllCookies();

       driver.close();

    }


}
