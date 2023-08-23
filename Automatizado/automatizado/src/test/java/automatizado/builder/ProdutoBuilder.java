package automatizado.builder;

import automatizado.page.ControleDeProdutoPO;

/**
 *  Classe que sabe construir ou adicionar um produto na tela.
 */
public class ProdutoBuilder {
    
    private String codigo = "00001";
    private String nome = "Produto padrão";
    private Integer quantidade = 1;
    private Double valor = 1.0;
    private String data = "22/08/2023";

    private ControleDeProdutoPO controleDeProdutoPO;

    //** Construtor do ProdutoBuilder que recebe a página de controle de produtos. */
    public ProdutoBuilder(ControleDeProdutoPO controleDeProdutoPO){
        this.controleDeProdutoPO = controleDeProdutoPO;
    }
    
    /**
     *  Método que sabe adicionar um código ao builder.
     * @param codigo Código que será adicionado.
     * @return Retorna a própria classe ProdutoBuilder.
     */
    public ProdutoBuilder adicionarCodigo(String codigo){
        this.codigo = codigo;
        return this;
    }

    /**
     *  Método que sabe adicionar um nome ao builder.
     * @param nome Nome que será adicionado.
     * @return Retorna a própria classe ProdutoBuilder.
     */
    public ProdutoBuilder adicionarNome(String nome){
        this.nome = nome;
        return this;
    }

    /**
     *  Método que sabe adicionar uma quantidade ao builder.
     * @param quantidade Quantidade que será adicionada.
     * @return Retorna a própria classe ProdutoBuilder.
     */
    public ProdutoBuilder adicionarQuantidade(Integer quantidade){
        this.quantidade = quantidade;
        return this;
    }

    /**
     *  Método que sabe adicionar um valor ao builder.
     * @param valor Valor que será adicionado.
     * @return Retorna a própria classe ProdutoBuilder.
     */
    public ProdutoBuilder adicionarValor(Double valor){
        this.valor = valor;
        return this;
    }

    /**
     *  Método que sabe adicionar uma data ao builder.
     * @param data Data que será adicionada.
     * @return Retorna a própria classe ProdutoBuilder.
     */
    public ProdutoBuilder adicionarData(String data){
        this.data = data;
        return this;
    }

    /**
     * Método que constrói o produto, ou seja, adiciona o produto pela tela de cadastro de produto.
     */
    public void builder(){

        controleDeProdutoPO.escrever(controleDeProdutoPO.inputCodigo, codigo);
        controleDeProdutoPO.escrever(controleDeProdutoPO.inputNome, nome);
        controleDeProdutoPO.escrever(controleDeProdutoPO.inputQuantidade, (quantidade != null) ? quantidade.toString() : "");
        controleDeProdutoPO.escrever(controleDeProdutoPO.inputValor, (valor != null) ? valor.toString() : "");
        controleDeProdutoPO.escrever(controleDeProdutoPO.inputData, data);

        controleDeProdutoPO.buttonSalvar.click();
    }
}
