/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imagens_dos_produtos;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ImportarExportarExcel {
  Workbook wb;
  
  File f;
  
  public boolean Importar(File file) { // , JTable tbPesquisa
    Exportando Exportando = new Exportando("Importando");
    Exportando.setVisible(true);
    boolean retorno = false;
    //DefaultTableModel modeloT = new DefaultTableModel();
    //tbPesquisa.setModel(modeloT);
    try {
      HSSFWorkbook hSSFWorkbook = null;
      String name = file.toString();
      int pos = name.lastIndexOf('.');
      String ext = name.substring(pos + 1);
      FileInputStream ExcelFileToRead = new FileInputStream(file);
      Workbook obj = null;
      if (ext.equals("xlsx")) {
        try {
          XSSFWorkbook xSSFWorkbook = new XSSFWorkbook(ExcelFileToRead);
          System.out.println("Arquivo Recebido: xlsx");
        } catch (IOException ex) {
          System.out.println("Arquivo Recebido: xlsx");
          ex.printStackTrace();
        } 
      } else if (ext.equals("xls")) {
        try {
          hSSFWorkbook = new HSSFWorkbook(ExcelFileToRead);
          System.out.println("Arquivo Recebido: xls");
        } catch (IOException ex) {
          System.out.println("Arquivo Recebido: xls");
          ex.printStackTrace();
        } 
      } else {
        System.out.println("Arquivo Recebido, ncompat");
      } 
      Sheet aba = hSSFWorkbook.getSheetAt(0);
      Exportando.pbg.setMinimum(0);
      Exportando.pbg.setMaximum(aba.getLastRowNum());
      Row linha = null;
      Object[] listaCelulasdaLinha = null;
      for (int L_i = 0; L_i <= aba.getLastRowNum(); ) { // aba.getLastRowNum();
        Exportando.pbg.setValue(L_i);
        try {
          linha = aba.getRow(L_i);
          listaCelulasdaLinha = new Object[linha.getLastCellNum()];
        } catch (Exception exception) {}
        if (listaCelulasdaLinha != null && linha != null) {
          String strLinha = "";
          for (int C_i = 0; C_i < linha.getLastCellNum(); C_i++) {
            Cell celula = linha.getCell(C_i);
            if (L_i == 0) {
              //System.out.println("Linha - " + L_i + " - Coluna - " + C_i + " - " + celula.getStringCellValue());
              //modeloT.addColumn(celula.getStringCellValue());
            } else if (celula != null) {
              switch (celula.getCellType()) {
                case 0:
                  try {
                    if (DateUtil.isCellDateFormatted(celula)) {
                      SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                      Date dataY = celula.getDateCellValue();
                      String dataX = formatter.format(dataY);
                      listaCelulasdaLinha[C_i] = dataX;
                      break;
                    } 
                    String numeroX = String.valueOf(celula.getNumericCellValue());
                    String numeroX2 = numeroX.replace(".", "#");
                    String[] array = numeroX2.split("#");
                    String v1 = "";
                    try {
                      v1 = array[0].trim();
                    } catch (Exception exception) {}
                    String v2 = "";
                    try {
                      v2 = array[1].trim();
                    } catch (Exception exception) {}
                    if (v2.trim().equals("0")) {
                      listaCelulasdaLinha[C_i] = v1.trim();
                      break;
                    } 
                    listaCelulasdaLinha[C_i] = Double.valueOf(celula.getNumericCellValue());
                  } catch (Exception exception) {}
                  break;
                case 1:
                  try {
                    listaCelulasdaLinha[C_i] = celula.getStringCellValue();
                  } catch (Exception exception) {}
                  break;
                case 4:
                  try {
                    listaCelulasdaLinha[C_i] = Boolean.valueOf(celula.getBooleanCellValue());
                  } catch (Exception exception) {}
                  break;
                case 2:
                  try {
                    listaCelulasdaLinha[C_i] = celula.getCellFormula();
                  } catch (Exception exception) {}
                  break;
                default:
                  try {
                    listaCelulasdaLinha[C_i] = celula.getStringCellValue();
                  } catch (Exception exception) {}
                  break;
              } 
            } 
            
            //tbPesquisa.getColumnModel().getColumn(C_i).setPreferredWidth(150);
            
          } 
                      
            
            
            if (L_i != 0)   
                gerar( listaCelulasdaLinha );
            //for( int dd = 0; dd < listaCelulasdaLinha.length; dd++ ){
            //    System.out.println( listaCelulasdaLinha[dd] );
            //}
        } 
        L_i++;
      } 
    } catch (Exception e) {
      e.printStackTrace();
      JOPM jOPM = new JOPM(2, "Importar(File file, JTable tbPesquisa)(), \n" + e.getMessage() + "\n", getClass().getSimpleName());
    } 
    Exportando.fechar();
    return retorno;
  }
  
  
  
  private void gerar( Object[] listaCelulasdaLinha ) {                                      
        /*new Thread() {   @Override public void run() {*/ try { //Thread.sleep( 1 );

            String ean = "";
            String des = "";
            String cat = "";
            String umb = "";
            
            ean = listaCelulasdaLinha[0].toString().trim();
            des = listaCelulasdaLinha[1].toString().trim();
            cat = listaCelulasdaLinha[2].toString().trim();
            umb = listaCelulasdaLinha[3].toString().trim();
            
            
            
            String html = "<!-- INÍCIO DOS DADOS DO PRODUTO - id=\"ean\" +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ -->                        " +
"                        <li " + "id=produto_" + ean + " style=\"\">" +
"                            <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" style=\"width:100%; padding: 0; margin: 0;\">" +
"                                <tr>" +
"                                    <td align=\"center\">" +
"                                        <ul style=\"list-style:none; padding: 0px; margin: 0px; width:100%;\" >" +
"                                            " +
"<!-- id=\"nome_do_produto_consultado\" +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ -->                                             " +
"                                            <li " + "id=nome_" + ean + " style=\"width:100%; background-color: #3A3A3A; color:#fff; font-family:  Arial, Helvetica, sans-serif; font-size: 120%;\">" +
"                                                " + des + 
"                                            </li>" +
"                                            " +
"                                            <li style=\"\">" +
"                                                <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" style=\"padding: 0; margin: 0;\">" +
"                                                    <tr>" +
"                                                        <td>                                                                                                                    " +
"                                                            <ul style=\"list-style:none; padding: 0px; margin: 0px; width:100%;\" >" +
"                                                                " +
"                                                                <li style=\"float: left;\">" +
"                                                                    " +
"<!-- id=\"imagem_do_ean\" +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ -->                                                                      " +
"                                                                    <img " + "id=" + ean + " class=\"prod_ean\"  src=\"http://www.jmarysystems.com.br/Produtos/Imagens/" + ean + ".gif\" alt=" + ean + " onclick=\"aumentar_imagem(" + ean + ");\" width=\"150\" height=\"150\" style=\"cursor: zoom-in\" > " +
"                                                                </li>    " +
"                                                                " +
"                                                                <li style=\"float: left;\"> " +
"                                                                    " +
"                                                                    <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" style=\"padding: 0; margin: 0;\">" +
"                                                                        " +
"                                                                        <tr>" +
"                                                                                        " +
"                                                                            <td style=\"padding-top: 5px; color:#000; font-family:  Arial, Helvetica, sans-serif; font-size: 120%; padding-left: 5px; float: left; \" >" +
"                                                                                Ean:" +
"                                                                            </td> " +
"                                                                            " +
"<!-- id=\"ean_do_produto_consultado\" +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ -->                                                                                         " +
"                                                                            <td " + "id=ean_" + ean + " style=\"margin-top: 5px; background-color: #3A3A3A; color:#fff; font-family:  Arial, Helvetica, sans-serif; font-size: 120%; padding-left: 5px; float: left;\" >" +
"                                                                                            " + ean +
"                                                                            </td>" +
"                                                                        </tr>" +
                    
                                                                         "<tr>" +
"                                                                                        " +
"                                                                            <td style=\"padding-top: 5px; color:#000; font-family:  Arial, Helvetica, sans-serif; font-size: 120%; padding-left: 5px; float: left; \" >" +
"                                                                                Categoria:" +
"                                                                            </td>  " +
                    
"                                                                        </tr>" +
                    
"<!-- id=\"categoria_do_produto_consultado\" +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ -->       " +                    
                                                                         "<tr>" +
"                                                                            <td " + "id=categoria_" + ean + " style=\"margin-top: 5px; background-color: #3A3A3A; color:#fff; font-family:  Arial, Helvetica, sans-serif; font-size: 120%; padding-left: 5px; float: left;\" >" +
"                                                                                            " + cat +
"                                                                            </td>" +
"                                                                        </tr>" +                    
                    
                                                                         "<tr>" +
"                                                                                        " +
"                                                                            <td style=\"padding-top: 5px; color:#000; font-family:  Arial, Helvetica, sans-serif; font-size: 120%; padding-left: 5px; float: left; \" >" +
"                                                                                UMB:" +
"                                                                            </td>  " +
"                                                                            " +
"<!-- id=\"unidade_do_produto_consultado\" +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ -->                                                                                         " +
"                                                                            <td " + "id=umb_" + ean + " style=\"margin-top: 5px; background-color: #3A3A3A; color:#fff; font-family:  Arial, Helvetica, sans-serif; font-size: 120%; padding-left: 5px; float: left;\" >" +
"                                                                                            " + umb +
"                                                                            </td>" +
"                                                                        </tr>" +
                    
"                                                                        " +
"                                                                    </table> " +
"                                                                    " +
                    
"                                                                </li>" +
"                                                            </ul>" +
"                                                        </td>" +
"                                                    </tr>" +
"                                                </table>     " +
"                                            </li>                                            " +
"                                        </ul>                                                                         " +
"                                    </td>" +
"                                </tr>" +
"                            </table> " +
"                        </li> " +
"<!-- FIM DOS DADOS DO PRODUTO - id=\"ean\" +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ --> ";
            
            
            String s = System.getProperty("file.separator");
            String internalStorageDir = System.getProperty("user.dir");
    
            //String end_Arquivo = internalStorageDir + s +"00_Externo"+ s + "Html_dos_produtos_por_ean2"+ s + ean + ".html";                
            //criar_Arquivo_Iso_Boo( end_Arquivo, html);
            
            String x_desc = des.replaceAll("\"", "'");            
            String end_Arquivo2 = internalStorageDir + s +"00_Externo"+ s + "Html_dos_produtos_por_ean_TXT"+ s + "Html_dos_produtos_por_ean_TXT" + ".txt";                
            adicionar_ao_arquivo_txt_Boo( end_Arquivo2, "@" + ean + "&" + x_desc + "&" + cat + "&" + umb + "@" );
                
        } catch( Exception e ){ } //} }.start();
    }  
  
  private boolean criar_Arquivo_Iso_Boo(String end_Arquivo, String letraDig) {
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
  
  private boolean adicionar_ao_arquivo_txt_Boo(String end_Arquivo, String letraDig) {
    boolean retorno = false;
    try {
      boolean nl = true;
      
      BufferedWriter out = new BufferedWriter(new FileWriter(end_Arquivo ,true));
      out.write(letraDig);
      //if(nl) { out.newLine(); }
                
      out.close();
    } catch (IOException e) {
      retorno = false;
    } 
    return retorno;
  }
  
}