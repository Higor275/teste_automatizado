package automatizado.teste;

import static org.junit.Assert.assertEquals;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import automatizado.page.LoginPO;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LoginTest extends BaseTest {

      private static LoginPO loginPage;

    //  private void executarAcaoDeLogar(String email, String senha){
      //  loginPage.escrever(loginPage.inputEmail, email);
      //  loginPage.escrever(loginPage.inputSenha, senha);

     //  loginPage.buttonEntrar.click();
   // }

        @BeforeClass
    public static void prepararTestes(){
        loginPage = new LoginPO(driver);
    }

    @Test
    public void TC001_naoDeveLogarNosistemaComEmailESenhaVazios(){

        loginPage.executarAcaoDeLogar("", "");
        String mensagem = loginPage.obterMensagem();

        assertEquals(mensagem, "Informe usuário e senha, os campos não podem ser brancos.");

    }

        @Test
    public void TC002_naoDeveLogarNosistemaComEmailIncorretoESenhaVazia(){

        loginPage.executarAcaoDeLogar("teste", "");
        String mensagem = loginPage.obterMensagem();

        assertEquals(mensagem, "Informe usuário e senha, os campos não podem ser brancos.");

    }

            @Test
    public void TC003_naoDeveLogarNosistemaComEmailVazioESenhaIncorreta(){

        loginPage.executarAcaoDeLogar("", "");
        String mensagem = loginPage.obterMensagem();

        assertEquals(mensagem, "Informe usuário e senha, os campos não podem ser brancos.");

    }

             @Test
    public void TC004_naoDeveLogarNosistemaComEmailESenhaIncorretos(){

        loginPage.executarAcaoDeLogar("teste", "teste");
        String mensagem = loginPage.obterMensagem();

        assertEquals(mensagem, "E-mail ou senha inválidos");

    }

             @Test
    public void TC005_naoDeveLogarNosistemaComEmailCorretoESenhaIncorreta(){

        loginPage.executarAcaoDeLogar("admin@admin.com", "teste");
        String mensagem = loginPage.obterMensagem();

        assertEquals(mensagem, "E-mail ou senha inválidos");

    }

             @Test
    public void TC006_naoDeveLogarNosistemaComEmailIncorretoESenhaCorreta(){

        loginPage.executarAcaoDeLogar("Aadmin@admin.com", "admin@123");
        String mensagem = loginPage.obterMensagem();

        assertEquals(mensagem, "E-mail ou senha inválidos");

    }

         @Test
    public void TC007_deveLogarNosistemaComEmailEESenhaCorretos(){

        loginPage.executarAcaoDeLogar("admin@admin.com", "admin@123");
        
        assertEquals(loginPage.obterTituloPagina(), "Controle de Produtos");

    }

}
