package br.newtonpaiva.dominio;

import java.util.List;
import java.util.ArrayList;
import br.newtonpaiva.dominio.frete.*;

public class PedidoBuilder{
  private List<ItemPedido> itens = new ArrayList<>();
  private Cliente cliente;
  private Endereco enderecoEntrega;
  private Frete calculoFrete;

  public PedidoBuilder addProduto(Produto p, Integer qtd){
    ItemPedido i = new ItemPedido();
    i.setProduto(p);
    i.setQuantidade(qtd);
    i.setPreco(p.getPreco());

    itens.add(i);
    return this;

  }

  public PedidoBuilder setCliente(Cliente c){
    this.cliente = c;
    return this;
  }

  public PedidoBuilder setEnderecoEntrega(Endereco e){
    this.enderecoEntrega = e;

    switch(e.getUf()) {
      case "MG":
        setFrete(new FreteMG());
        break;
      case "RJ":
        setFrete(new FreteRJ());
        break;
      case "ES":
        setFrete(new FreteES());
        break;
      default:
        throw new UnsupportedOperationException("UF não permitida");
    }
    return this;
  }

  private PedidoBuilder setFrete(Frete f){
    this.calculoFrete = f;
    return this;
  }

  public Pedido getResultado(){
    
    Pedido p = new Pedido(99999);
    p.setEnderecoEntrega(enderecoEntrega);
    p.setCliente(cliente);
    p.setItens(itens);
    p.setCalculoFrete(calculoFrete);

    return p;
  }
}

