package br.newtonpaiva.dominio.geradorArquivo;

import br.newtonpaiva.dominio.*;
import java.io.*;
import java.util.zip.*;

public class GeradorArquivoXMLCompactado extends GeradorArquivoXML {
  protected byte[] posProcessamento(byte[] b) {
    try {
      ByteArrayOutputStream out = new ByteArrayOutputStream();      
      ZipOutputStream zout = new ZipOutputStream(out);
      zout.putNextEntry(new ZipEntry("text.xml"));
      zout.write(b);
      zout.closeEntry();
      zout.close();

      return out.toByteArray();
    }catch(IOException e) {
      return null;
    }
  }
}