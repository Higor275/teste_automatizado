package automatizado.teste;


import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import automatizado.builder.ProdutoBuilder;
import automatizado.page.ControleDeProdutoPO;
import automatizado.page.LoginPO;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ControleDeProdutoTest extends BaseTest {
    
private static LoginPO loginPage;
private static ControleDeProdutoPO controleDeProdutoPage;

    @BeforeClass
    public static void prepararTestes(){
        loginPage = new LoginPO(driver);
        loginPage.executarAcaoDeLogar("admin@admin.com", "admin@123");
    
        controleDeProdutoPage = new ControleDeProdutoPO(driver);
        assertEquals(controleDeProdutoPage.obterTituloPagina(), "Controle de Produtos");
    }

    @Test
    public void TC001_deveAbrirModalParaCadastroAoClicarNoBotaoCriar(){
        controleDeProdutoPage.buttonAdicionar.click();
        // TODO: Remover esse clique assim que o sistema for corrigido
        controleDeProdutoPage.buttonAdicionar.click();

       String titulo = controleDeProdutoPage.tituloModal.getText();
       assertEquals("Produto", titulo);
       controleDeProdutoPage.buttonSair.click();
       controleDeProdutoPage.buttonSair.click();
    }

    // @Test
    // public void TC002_naoDeveSerPossivelCadastrarUmProdutoSemPreencherTodosOsCampos(){
       
    //     controleDeProdutoPage.buttonAdicionar.click();

    //     controleDeProdutoPage.cadastrarProduto("00001", "Martelo", 10, 59.9, "");
        
    //     // Aqui vamos capturar a mensagem de erro.
    //     String mensagem = controleDeProdutoPage.spanMensagem.getText();

    //     assertEquals("Todos os campos são obrigatórios para o cadastro!", mensagem);
    // }

    @Test
    public void TC003_naoDeveSerPossivelCadastrarUmProdutoSemPreencherTodosOsCampos(){
       
        String mensagem = "Todos os campos são obrigatórios para o cadastro!";
        controleDeProdutoPage.buttonAdicionar.click();

        // Aqui cria o objeto para adicionar na tela.
        ProdutoBuilder produtoBuilder = new ProdutoBuilder(controleDeProdutoPage);
        
        // Aqui estamos testando se o produto é adicionado sem código.
        produtoBuilder
        .adicionarCodigo("")
        .builder();

        assertEquals(mensagem, controleDeProdutoPage.spanMensagem.getText());

        // Aqui estamos testando se o produto é adicionado sem quantidade.
        produtoBuilder
        .adicionarCodigo("00005")
        .adicionarQuantidade(null)
        .builder();

        assertEquals(mensagem, controleDeProdutoPage.spanMensagem.getText());

        // Aqui estamos testando se o produto é adicionado sem nome.
        produtoBuilder
        .adicionarQuantidade(15)
        .adicionarNome("")
        .builder();

        assertEquals(mensagem, controleDeProdutoPage.spanMensagem.getText());

        // Aqui estamos testando se o produto é adicionado sem valor.
        produtoBuilder
        .adicionarNome("Cimento")
        .adicionarValor(null)
        .builder();

        assertEquals(mensagem, controleDeProdutoPage.spanMensagem.getText());

        // Aqui estamos testando se o produto é adicionado sem data.
        produtoBuilder
        .adicionarNome("Cimento")
        .adicionarValor(null)
        .adicionarData("")
        .builder();

        assertEquals(mensagem, controleDeProdutoPage.spanMensagem.getText());

       controleDeProdutoPage.buttonSair.click();
    }
}
