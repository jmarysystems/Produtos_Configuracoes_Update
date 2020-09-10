/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imagens_dos_produtos;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class JOPM {
  public JOPM(int j, String mensagem) {
    padrao(mensagem);
  }
  
  public JOPM(int j, String mensagem2, String mensagemsemicone21, Icon icon) {
    iconcustomizado(mensagem2, mensagemsemicone21, icon);
  }
  
  public JOPM(int j, String mensagem2, String mensagem21) {
    switch (j) {
      case 1:
        aviso(mensagem2, mensagem21);
        break;
      case 2:
        erroicon(mensagem2, mensagem21);
        break;
      case 3:
        semicon(mensagem2, mensagem21);
        break;
    } 
  }
  
  public JOPM(String metodo, String mensagem, String classe) {
    Class<Imagens_Internas_Utilidades> clazzHome = Imagens_Internas_Utilidades.class;
    JOptionPane.showMessageDialog(null, metodo + "\n\nExcegerada:\n" + mensagem + "\n\nOK Para Prosseguir", "Class: " + classe, 1, new ImageIcon(clazzHome
          
          .getResource("logocangaco2.png")));
  }
  
  public JOPM(String mensagem) {
    Class<Imagens_Internas_Utilidades> clazzHome = Imagens_Internas_Utilidades.class;
    JOptionPane.showMessageDialog(null, mensagem + "Aguarde a Finalização", mensagem + "...", 1, new ImageIcon(clazzHome.getResource("carregando.gif")));
  }
  
  public void fechar() throws Throwable {
    try {
      finalize();
    } catch (Exception exception) {}
  }
  
  private void padrao(String mensagem) {
    JOptionPane.showMessageDialog(null, mensagem);
  }
  
  private void aviso(String mensagem, String aviso) {
    JOptionPane.showMessageDialog(null, mensagem, aviso, 2);
  }
  
  private void erroicon(String mensagem, String erro) {
    JOptionPane.showMessageDialog(null, mensagem, erro, 0);
  }
  
  private void semicon(String mensagem, String mensagemsemicone) {
    JOptionPane.showMessageDialog(null, mensagem, mensagemsemicone, -1);
  }
  
  private void iconcustomizado(String mensagem, String mensagemsemicone, Icon icon) {
    JOptionPane.showMessageDialog(null, mensagem, mensagemsemicone, 1, icon);
  }
}