//RJ- Rio de Janeiro -20%
package br.newtonpaiva.dominio.imposto;

import br.newtonpaiva.dominio.Imposto;

public class ImpostoRJ implements Imposto{
  public Double getImposto(){
    return 0.20;
  }
}