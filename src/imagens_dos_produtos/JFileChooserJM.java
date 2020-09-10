/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imagens_dos_produtos;

import java.io.File;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.filechooser.FileFilter;

public class JFileChooserJM extends JPanel {
  private String[] strArray;
  
  private String strProp = "  imagens    -   jmarysystems.blogspot.com.br";
  
  public JFileChooserJM(String strProp2, String[] strArray2) {
    initComponents();
    this.strArray = strArray2;
    this.strProp = strProp2;
  }
  
  public String getString(int x) {
    String retorno = "";
    try {
      JFileChooser jFileChooser = new JFileChooser();
      FileFilter filter = new ExtensionFileFilter(this.strProp, this.strArray);
      jFileChooser.setFileFilter(filter);
      int status = jFileChooser.showOpenDialog(this);
      if (status == 0) {
        switch (x) {
          case 1:
            retorno = jFileChooser.getSelectedFile().getName();
            break;
          case 2:
            retorno = jFileChooser.getSelectedFile().getCanonicalPath().replace("\\", "/");
            break;
          case 3:
            retorno = (new File(jFileChooser.getSelectedFile().getPath())).toURI().toURL().toString();
            break;
        } 
      } else if (status == 1) {
        Class<Imagens_Internas_Utilidades> clazzHome = Imagens_Internas_Utilidades.class;
        JOPM jOPM = new JOPM(1, "MgetString( int x )\n\nStatus Da Sele\nNenhum documento HTML Selecionado\n\nOK Para Prosseguir", "Class: " + getClass().getName(), new ImageIcon(clazzHome.getResource("logocangaco2.png")));
      } 
    } catch (Exception exception) {}
    return retorno;
  }
  
  public static void main(String[] args) {
    JFileChooserJM jFileChooserJM = new JFileChooserJM("  png  jpeg    -   jmarysystems.blogspot.com.br", new String[] { "PNG", "JPEG" });
    System.out.println(jFileChooserJM.getString(3));
  }
  
  private void initComponents() {
    GroupLayout layout = new GroupLayout(this);
    setLayout(layout);
    layout.setHorizontalGroup(layout
        .createParallelGroup(GroupLayout.Alignment.LEADING)
        .addGap(0, 400, 32767));
    layout.setVerticalGroup(layout
        .createParallelGroup(GroupLayout.Alignment.LEADING)
        .addGap(0, 300, 32767));
  }
}
