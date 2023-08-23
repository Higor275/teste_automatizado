package automatizado.teste;

import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import automatizado.page.GooglePO;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class GoogleTest extends BaseTest {
    

    private static GooglePO googlePage;

    @BeforeClass
    public static void prepararTestes(){
        driver.get("https://www.google.com/");
        googlePage = new GooglePO(driver);
    }

    @Test
    public void TC001_deveSerPossivelPesquisarNoGoogleOTextoAbaixo(){

        googlePage.pesquisar("Junit");

        String resultado = googlePage.obterResultadoDaPesquisa();

        assertTrue(resultado, resultado.contains("Aproximadamente"));

    }

    @Test
    public void TC002_deveSerPossivelPesquisarNoGoogleOTextoAbaixo(){
    
       googlePage.pesquisar("Selenium");

        String resultado = googlePage.obterResultadoDaPesquisa();

        assertTrue(resultado, resultado.contains("resultado"));

    }

}