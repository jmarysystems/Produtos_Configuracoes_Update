/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imagens_dos_produtos;

import java.io.File;
import javax.swing.filechooser.FileFilter;

public class ExtensionFileFilter extends FileFilter {
  String description;
  
  String[] extensions;
  
  public ExtensionFileFilter(String description, String extension) {
    this(description, new String[] { extension });
  }
  
  public ExtensionFileFilter(String description, String[] extensions) {
    if (description == null) {
      this.description = extensions[0];
    } else {
      this.description = description;
    } 
    this.extensions = (String[])extensions.clone();
    toLower(this.extensions);
  }
  
  private void toLower(String[] array) {
    for (int i = 0, n = array.length; i < n; i++)
      array[i] = array[i].toLowerCase(); 
  }
  
  public String getDescription() {
    return this.description;
  }
  
  public boolean accept(File file) {
    if (file.isDirectory())
      return true; 
    String path = file.getAbsolutePath().toLowerCase();
    for (int i = 0, n = this.extensions.length; i < n; i++) {
      String extension = this.extensions[i];
      if (path.endsWith(extension) && path.charAt(path.length() - extension.length() - 1) == '.')
        return true; 
    } 
    return false;
  }
}
