package br.newtonpaiva.dominio;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;

public class Pedido{

  private Integer numero;
  private Date dataCriacao;
  private Endereco enderecoEntrega;
  private Cliente cliente;
  private List<ItemPedido> itens = new ArrayList();
  private Frete calculoFrete;
  private Imposto calculoImposto; // EXERCICIO 1

 public Pedido(Integer numero){
   this.numero = numero;
   this.dataCriacao = new Date();
 }

 public Integer getNumero(){
   return numero;
 }

 public Date getDataCriacao(){
   return dataCriacao;
 }

 public Double obterTotal(){
   Double total = 0.0;

   for (ItemPedido item : itens){
     total += item.obterTotal();
   }

   total = total * calculoImposto.getImposto() + total + calculoFrete.getFrete();
   return total;
 }

 public void setCalculoFrete(Frete calculoFrete){
   this.calculoFrete = calculoFrete;
 }

 public void setCalculoImposto(Imposto calculoImposto){
   this.calculoImposto = calculoImposto;
 }

 public List<ItemPedido> getItens(){
   return itens;
 }

 public void setItens(List<ItemPedido> itens){
   this.itens = itens;
 }

 public Endereco getEnderecoEntrega(){
   return enderecoEntrega;
 }

 public void setEnderecoEntrega(Endereco enderecoEntraga){
   this.enderecoEntrega = enderecoEntrega;
 }

 public Cliente getCliente(){
   return cliente;
 }

 public void setCliente (Cliente cliente){
   this.cliente = cliente;
 }

 public String toString(){
   return getNumero() + " - " 
        + getCliente().getNome() + " - "
        + getItens().toString();
   }
}