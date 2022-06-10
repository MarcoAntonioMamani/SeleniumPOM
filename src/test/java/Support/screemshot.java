package Support;


import Definitions.Hooks;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class screemshot {


    public static void pantallazo()throws IOException{
        Date date =new Date();
        SimpleDateFormat fecha=new SimpleDateFormat("ddMMyyyy_HHmmss");
        String ruta="target/pantallazo/"+fecha.format(date)+"_pantalla.jpg";
        File file=((TakesScreenshot) Hooks.driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file,new File(ruta));
        

    }

}
