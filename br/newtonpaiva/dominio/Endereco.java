package br.newtonpaiva.dominio;

public class Endereco {
  private String uf;
  private String cidade;
  private String bairro;
  private String cep;
  private String logradouro;
  private String numero;
  private String complemento;

  public Endereco(String uf, String cidade, String bairro, String cep, String logradouro, String numero, String complemento) {
    this.uf = uf;
    this.cidade = cidade;
    this.bairro = bairro;
    this.cep = cep;
    this.logradouro = logradouro;
    this.numero = numero;
    this.complemento = complemento;
  }
  
  public Endereco(String uf, String cidade, String bairro, String cep, String logradouro, String numero) {
    this(uf, cidade, bairro, cep, logradouro, numero, null);
  }

  public String getUf(){
    return uf;
  }

  public String getCidade(){
    return cidade;
  }

  public String getBairro(){
    return bairro;
  }

  public String getCep(){
    return cep;
  }

  public String getLogradouro(){
    return logradouro;
  }

  public String getNumero(){
    return numero;
  }

  public String getComplemento(){
    return complemento;
  }
}