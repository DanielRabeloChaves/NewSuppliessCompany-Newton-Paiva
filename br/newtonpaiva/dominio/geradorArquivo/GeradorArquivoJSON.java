package br.newtonpaiva.dominio.geradorArquivo;

import br.newtonpaiva.dominio.*;

public class GeradorArquivoJSON extends GeradorArquivo {
  protected String getConteudo(Pedido pedido) {
    StringBuilder conteudo = new StringBuilder();

    conteudo.append("{");
    conteudo.append(String.format("\"numero\":%d,", pedido.getNumero()));
    
    conteudo.append("itens: [");

    for(ItemPedido i : pedido.getItens()){
      conteudo.append("{");
      conteudo.append(String.format("\"nome\": \"%s\",",i.getProduto().getNome()));
      conteudo.append(String.format("\"qtd\": %d,", i.getQuantidade()));
      conteudo.append(String.format("\"preco\": %f,", i.getPreco()));
      conteudo.append("},");
    }

    conteudo.append("]");
    conteudo.append("}");

    return conteudo.toString();
  }
}