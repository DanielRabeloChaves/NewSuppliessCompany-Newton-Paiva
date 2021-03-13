package br.newtonpaiva.dominio;

public class ItemPedido{

  private Integer quantidade;
  private Double preco;
  private Pedido pedido;
  private Produto produto;

  public Integer getQuantidade(){
    return quantidade;
  }

  public void setQuantidade(Integer quantidade){
    this.quantidade=quantidade;
  }

  public Double getPreco(){
    return preco;
  }

  public void setPreco (Double preco){
    this.preco=preco;
  }

  public Double obterTotal(){
    return quantidade * preco;
  }

  public Pedido getPedido(){
    return pedido;
  }

  public void setPedido(Pedido pedido){
    this.pedido = pedido;
  }

  public Produto getProduto(){
    return produto;
  }

  public void setProduto(Produto produto){
    this.produto= produto;
  }

  public String toString(){
    return getProduto().getNome() + " - " + getQuantidade() + " R$ " + getPreco();
  }
}