package br.newtonpaiva.dominio;

import java.util.List;
import java.util.ArrayList;

public class Cliente {
    private String nome;
    private String telefone;
    private String email;
    private List<Endereco> enderecos = new ArrayList<>();
    private List<Pedido> pedidos = new ArrayList<>();

    public String getNome() {
      return nome;
    }

    public void setNome(String nome) {
      this.nome=nome;
    }

    public String getTelefone() {
      return telefone;
    }

    public void setTelefone(String telefone) {
      this.telefone=telefone;
    }

    public String getEmail() {
      return email;
    }

    public void setEmail(String email) {
      this.email=email;
    }

    public List<Endereco> getEnderecos(){
      return enderecos;
    }

    public void setEnderecos(List<Endereco> enderecos){
      this.enderecos = enderecos;
    }

    public List<Pedido> getPedidos(){
      return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos){
      this.pedidos=pedidos;
    }
}