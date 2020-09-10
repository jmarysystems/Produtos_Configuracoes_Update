/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

/**
 *
 * @author JMarySystems
 */
public class Bate_Papo_Web_0004_Recebendo_Mensagem {
    
    public String key = "AIzaSyBwiMCywJRFQHuuksWdhqwjOrR5mDaWJYs";
    public String intervalo = "A:B";
    public String id = "10n3TYa4DlEbwduXiXU94yY5tHeStfoFeeod6EO-ST_o";
    public String pre = "https://sheets.googleapis.com/v4/spreadsheets/";
    public String GET_URL = null;    
    
    public String recebendo_Mensagem(int posicao){
        String retorno = null;
                
        InputStream is = null;
        URL url = null;
        try{
            
            GET_URL = pre + id + "/values/" + intervalo + "?key=" + key;
            
            url = new URL(GET_URL);
            URLConnection conn = url.openConnection();
            
        } catch( Exception e ){ }
        
        //Recebendo mensagem
        try{
            
            is = url.openStream();
            
            ////////////////////////////////////////////////////////////////////
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);

            StringBuilder sb = new StringBuilder();

            String linha = br.readLine();
            
            while (linha != null) {
                //System.out.println(linha);
                sb.append(linha);
                sb.append("\n");
                linha = br.readLine();
            }

            try{
                //System.out.println("*******************************************************************\n");
                //System.out.println( "GET_URL: " + GET_URL + "\n");
                //System.out.println( sb.toString());
                //System.out.println("*******************************************************************\n");
            } catch( Exception e ){ e.printStackTrace(); }
            ////////////////////////////////////////////////////////////////////
            
            retorno = sb.toString();
            
        } catch( Exception e ){ 
            retorno = null;
            e.printStackTrace(); 
        }
        
        return retorno;
    }
    
    public static void main(String[] args) {
        
        try{
                    
            Bate_Papo_Web_0004_Recebendo_Mensagem B = new Bate_Papo_Web_0004_Recebendo_Mensagem();
            B.recebendo_Mensagem( 0 );
            
            System.out.println( B.recebendo_Mensagem( 0 ) );
            
        }catch( Exception e ){}
    }
    
}