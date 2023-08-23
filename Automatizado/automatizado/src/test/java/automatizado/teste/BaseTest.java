package automatizado.teste;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Classe base que serve como herança para todas as classes de teste.
 */
public abstract class BaseTest {
    
    /**Driver do navegador da página atual.. */
    protected static WebDriver driver;
    /** Caminho base da URL do sistema a ser testado. */
    private final static String URL_BASE = "file:///C:/Users/higor/Downloads/sistema/login.html";
    /** Caminho relativo do driver ao projeto referente ao path. */
    private final static String CAMINHO_DRIVER = "src/test/java/automatizado/resource/chromedriver.V-116.0.5845.96.exe";

    /**
     * Método para iniciar o driver do navegador antes de qualquer classe de teste. 
    */
    @BeforeClass
    public static void iniciar (){
        System.setProperty("webdriver.chrome.driver", CAMINHO_DRIVER);
        driver = new ChromeDriver ();
        driver.manage().window().maximize();
        driver.get(URL_BASE);
}

/**
 * Método para iniciar o driver do navegador antes de qualquer classe de teste. 
*/
@AfterClass
public static void finalizar (){
    driver.quit();
    }

}