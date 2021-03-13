package br.newtonpaiva.dominio.geradorArquivo;

import br.newtonpaiva.dominio.*;
import javax.crypto.Cipher;
import javax.crypto.spec.*;

public class GeradorArquivoXMLCripto extends GeradorArquivoXML{
  protected byte[] posProcessamento(byte[] b){
    String chaveCripto = "0123456789abcdef";
    String IV = "AAAAAAAAAAAAAAAA";

    try {
      Cipher encript = Cipher.getInstance("AES/CBC/PKCS5Padding", "SunJCE");
      SecretKeySpec key = new SecretKeySpec(chaveCripto.getBytes("UTF-8"), "AES");
      encript.init(Cipher.ENCRYPT_MODE, key, new IvParameterSpec(IV.getBytes("UTF-8")));

      return encript.doFinal(b);
    }catch(Exception e) {
      return null;
    }
  }
}