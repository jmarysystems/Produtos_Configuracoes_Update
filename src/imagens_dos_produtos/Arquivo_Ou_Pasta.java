/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imagens_dos_produtos;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class Arquivo_Ou_Pasta {
  public static boolean deletar(File file_ou_pasta) {
    if (file_ou_pasta.isDirectory()) {
      String[] listaDosArquivos = file_ou_pasta.list();
      for (int i = 0; i < listaDosArquivos.length; i++) {
        boolean success = deletar(new File(file_ou_pasta, listaDosArquivos[i]));
        if (!success)
          return false; 
      } 
    } 
    return file_ou_pasta.delete();
  }
  
  public static boolean deletar_Todos_Arquivos_da_Pasta(File file_ou_pasta) {
    boolean retorno = false;
    if (file_ou_pasta.isDirectory()) {
      String[] listaDosArquivos = file_ou_pasta.list();
      for (int i = 0; i < listaDosArquivos.length; i++) {
        boolean success = deletar(new File(file_ou_pasta, listaDosArquivos[i]));
        if (!success)
          return false; 
      } 
      retorno = true;
    } 
    return retorno;
  }
  
  public static boolean criarPasta(String onde, String nomePasta) {
    boolean retorno = false;
    File criar = new File(onde + System.getProperty("file.separator") + nomePasta);
    if (!criar.exists()) {
      criar.mkdir();
      retorno = true;
    } 
    return retorno;
  }
  
  public static boolean copiarArquivo(File arquivo, String destino) {
    boolean retorno = false;
    try {
      InputStream inputStream = new FileInputStream(arquivo.getPath());
      OutputStream outputStream = new FileOutputStream(new File(destino + System.getProperty("file.separator") + arquivo.getName()));
      int read = 0;
      byte[] bytes = new byte[1024];
      while ((read = inputStream.read(bytes)) != -1)
        outputStream.write(bytes, 0, read); 
      try {
        inputStream.close();
        outputStream.flush();
        outputStream.close();
      } catch (Exception exception) {}
      retorno = true;
    } catch (Exception exception) {}
    return retorno;
  }
  
  public static boolean copiarArquivoNovoNome(File arquivo, String destino, String nome) {
    boolean retorno = false;
    try {
      InputStream inputStream = new FileInputStream(arquivo.getPath());
      OutputStream outputStream = new FileOutputStream(new File(destino + System.getProperty("file.separator") + nome));
      int read = 0;
      byte[] bytes = new byte[1024];
      while ((read = inputStream.read(bytes)) != -1)
        outputStream.write(bytes, 0, read); 
      try {
        inputStream.close();
        outputStream.flush();
        outputStream.close();
      } catch (Exception exception) {}
      retorno = true;
    } catch (Exception exception) {}
    return retorno;
  }
  
  public static boolean copiarArquivoInputStream(InputStream inputStream, String complemento, File arquivo, String destino) {
    boolean retorno = false;
    try {
      OutputStream outputStream = new FileOutputStream(new File(destino + System.getProperty("file.separator") + complemento + arquivo.getName()));
      int read = 0;
      byte[] bytes = new byte[1024];
      while ((read = inputStream.read(bytes)) != -1)
        outputStream.write(bytes, 0, read); 
      try {
        inputStream.close();
        outputStream.flush();
        outputStream.close();
      } catch (Exception exception) {}
      retorno = true;
    } catch (Exception exception) {}
    return retorno;
  }
  
  public static boolean copiarArquivoDoJar(String origem, String destino) {
    boolean retorno = false;
    try {
      File f = new File(origem);
      Class<Imagens_Internas_Utilidades> clazzHome = Imagens_Internas_Utilidades.class;
      InputStream inputStream = clazzHome.getResourceAsStream(origem);
      OutputStream outputStream = new FileOutputStream(new File(destino + "\\" + f.getName()));
      int read = 0;
      byte[] bytes = new byte[1024];
      while ((read = inputStream.read(bytes)) != -1)
        outputStream.write(bytes, 0, read); 
      try {
        inputStream.close();
        outputStream.flush();
        outputStream.close();
      } catch (Exception exception) {}
      retorno = true;
    } catch (Exception exception) {}
    return retorno;
  }
  
  public static void criar_Arquivo_Iso(String end_Arquivo, String letraDig) {
    try {
      File arq = new File(end_Arquivo);
      OutputStream OS = new FileOutputStream(arq);
      OutputStreamWriter OSW = new OutputStreamWriter(OS, "ISO-8859-1");
      PrintWriter Print = new PrintWriter(OSW);
      Print.println(letraDig);
      Print.close();
      OSW.close();
      OS.close();
    } catch (IOException iOException) {}
  }
  
  public static boolean criar_Arquivo_Iso_Boo(String end_Arquivo, String letraDig) {
    boolean retorno = false;
    try {
      File arq = new File(end_Arquivo);
      OutputStream OS = new FileOutputStream(arq);
      OutputStreamWriter OSW = new OutputStreamWriter(OS, "UTF-8");
      PrintWriter Print = new PrintWriter(OSW);
      Print.println(letraDig);
      Print.close();
      OSW.close();
      OS.close();
      retorno = true;
    } catch (IOException e) {
      retorno = false;
    } 
    return retorno;
  }
  
  public static boolean criar_Arquivo_Iso_Boo_Tipo_UTFISO(String end_Arquivo, String letraDig, String tipo_UTFISO) {
    boolean retorno = false;
    try {
      File arq = new File(end_Arquivo);
      OutputStream OS = new FileOutputStream(arq);
      OutputStreamWriter OSW = new OutputStreamWriter(OS, tipo_UTFISO);
      PrintWriter Print = new PrintWriter(OSW);
      Print.println(letraDig);
      Print.close();
      OSW.close();
      OS.close();
      retorno = true;
    } catch (IOException e) {
      retorno = false;
    } 
    return retorno;
  }
  
  public static void copiar(File diretorioOrigem, String destinoR) {
    try {
      if (diretorioOrigem.isDirectory()) {
        String destino = destinoR + System.getProperty("file.separator") + diretorioOrigem.getName();
        criarPasta(destinoR, diretorioOrigem.getName());
        File[] listaDosArquivos = diretorioOrigem.listFiles();
        if (listaDosArquivos != null) {
          for (int j = 0; j < listaDosArquivos.length; j++) {
            File f = new File(listaDosArquivos[j].getName());
            File veriF = new File(diretorioOrigem.getPath() + System.getProperty("file.separator") + f.getPath());
            if (veriF.isDirectory()) {
              copiar(veriF, destino);
            } else {
              copiarArquivo(veriF, destino);
            } 
          } 
        } else {
          System.out.println("listaDosArquivos == null: " + diretorioOrigem.getPath() + "listarPastas( List<String> diretorios )");
        } 
      } else if (diretorioOrigem.isFile()) {
        copiarArquivo(diretorioOrigem, destinoR);
      } 
    } catch (Exception e) {
      System.out.println("Zero - Diret- Home - listarPastas( List<String> diretorios )");
    } 
  }
  
  public static void main(String[] args) {
    String arquivo = System.getProperty("user.home") + System.getProperty("file.separator") + "z.txt";
    criar_Arquivo_Iso(arquivo, "<html>");
  }
}
