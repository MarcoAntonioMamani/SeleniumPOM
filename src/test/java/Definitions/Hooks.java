package Definitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Hooks {

    public static WebDriver driver;  //Variable para conectar con los drivers "ChromeDriver"

    @Before
    public static void setUp(){  //Metodo antes de que inicie
        //Practica #01
        /*
        System.setProperty("webdriver.chrome.driver","src/test/resources/drivers/chromedriver.exe");// Metodo para configurar el driver
        driver=new ChromeDriver();
        // driver=new FirefoxDriver();   Si fuera Firefox cambiariamos de esa forma
        driver.manage().window().maximize();   //Con esta linea de codigo estamos maximizando la ventana del navegador */
        ///////////////////////////////////////////////////

        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        //ChromeOptions options= new ChromeOptions();

       // options.addArguments("--disable-popup-blocking");


    }

     // el trabajo del robot automatizado



    @After  //Despues de ejecutar todas las pruebas se ejecuta este metodo
    public static void tearDown(){

        driver.manage().deleteAllCookies();

       driver.close();

    }


}
