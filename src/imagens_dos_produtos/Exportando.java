/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imagens_dos_produtos;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Rectangle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.LayoutStyle;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Exportando extends JFrame {
  private boolean cadastrarBoo;
  
  private JLabel jLabel1;
  
  private JLabel jLabel2;
  
  private JLabel jLabel4;
  
  private JLabel lbAcao;
  
  public JProgressBar pbg;
  
  public Exportando(String acao) {
    this.cadastrarBoo = false;
    initComponents();
    this.lbAcao.setText(acao + "...");
    centralizeFrame();
    tempoDeEspera();
  }
  
  private void centralizeFrame() {
    Rectangle scr = getGraphicsConfiguration().getBounds();
    Rectangle form = getBounds();
    int x = (int)(scr.getWidth() - form.getWidth()) / 2;
    int y = (int)(scr.getHeight() - form.getHeight()) / 2;
    setLocation(x, y);
  }
  
  private void tempoDeEspera() {
    (new Thread() {
        public void run() {
          while (!Exportando.this.cadastrarBoo) {
            Exportando.this.cadastrarBoo = true;
            try {
              Thread.sleep(1000L);
            } catch (Exception exception) {}
          } 
        }
      }).start();
  }
  
  public void fechar() {
    dispose();
  }
  
  private void initComponents() {
    this.jLabel1 = new JLabel();
    this.jLabel2 = new JLabel();
    this.lbAcao = new JLabel();
    this.jLabel4 = new JLabel();
    this.pbg = new JProgressBar();
    setDefaultCloseOperation(2);
    this.jLabel1.setIcon(new ImageIcon(getClass().getResource("/imagens_dos_produtos/carregando.gif")));
    this.jLabel2.setIcon(new ImageIcon(getClass().getResource("/imagens_dos_produtos/disquete.png")));
    this.lbAcao.setFont(new Font("Tahoma", 0, 14));
    this.lbAcao.setHorizontalAlignment(0);
    this.lbAcao.setText("ABRINDO...");
    this.jLabel4.setFont(new Font("Tahoma", 0, 14));
    this.jLabel4.setHorizontalAlignment(0);
    this.jLabel4.setText("AGUARDE");
    GroupLayout layout = new GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(layout
        .createParallelGroup(GroupLayout.Alignment.LEADING)
        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
          .addComponent(this.jLabel2)
          .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
          .addComponent(this.lbAcao, -1, -1, 32767)
          .addGap(53, 53, 53))
        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
          .addContainerGap(-1, 32767)
          .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
              .addComponent(this.jLabel4)
              .addGap(68, 68, 68))
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
              .addComponent(this.pbg, -2, 202, -2)
              .addGap(1, 1, 1)))
          .addComponent(this.jLabel1)));
    layout.setVerticalGroup(layout
        .createParallelGroup(GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
          .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
              .addContainerGap()
              .addComponent(this.lbAcao))
            .addComponent(this.jLabel2))
          .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767)
          .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
              .addComponent(this.pbg, -2, 27, -2)
              .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
              .addComponent(this.jLabel4, -2, 19, -2)
              .addGap(34, 34, 34))
            .addComponent(this.jLabel1, GroupLayout.Alignment.TRAILING))));
    pack();
  }
  
  public static void main(String[] args) {
    try {
      for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
        if ("Nimbus".equals(info.getName())) {
          UIManager.setLookAndFeel(info.getClassName());
          break;
        } 
      } 
    } catch (ClassNotFoundException ex) {
      Logger.getLogger(Exportando.class.getName()).log(Level.SEVERE, (String)null, ex);
    } catch (InstantiationException ex) {
      Logger.getLogger(Exportando.class.getName()).log(Level.SEVERE, (String)null, ex);
    } catch (IllegalAccessException ex) {
      Logger.getLogger(Exportando.class.getName()).log(Level.SEVERE, (String)null, ex);
    } catch (UnsupportedLookAndFeelException ex) {
      Logger.getLogger(Exportando.class.getName()).log(Level.SEVERE, (String)null, ex);
    } 
    EventQueue.invokeLater(new Runnable() {
          public void run() {
            new Exportando("A").setVisible(true);
          }
        });
  }
}
