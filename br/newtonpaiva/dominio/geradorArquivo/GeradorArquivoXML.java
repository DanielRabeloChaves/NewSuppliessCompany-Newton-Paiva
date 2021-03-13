package br.newtonpaiva.dominio.geradorArquivo;

import br.newtonpaiva.dominio.*;

public class GeradorArquivoXML extends GeradorArquivo{
  protected String getConteudo(Pedido pedido){
    StringBuilder conteudo = new StringBuilder();

    conteudo.append("<Pedido>");
    conteudo.append(String.format("<numero>%d</numero>", pedido.getNumero()));

    conteudo.append("<itens>");
    for(ItemPedido i : pedido.getItens()){
      conteudo.append("<item>");
      conteudo.append(String.format("<nome>%s</nome>",i.getProduto().getNome()));
      conteudo.append(String.format("<qtd>%d</qtd>", i.getQuantidade()));
      conteudo.append(String.format("<preco>%f</preco>", i.getPreco()));
      conteudo.append("</item>");
    }
    conteudo.append("/itens");

    conteudo.append("</Pedido>");

    return conteudo.toString();
  }
}