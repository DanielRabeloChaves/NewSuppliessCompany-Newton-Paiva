//SP- São Paulo -18%
package br.newtonpaiva.dominio.imposto;

import br.newtonpaiva.dominio.Imposto;

public class ImpostoSP implements Imposto{
  public Double getImposto(){
    return 0.18;
  }
}