/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 *
 * @author JMarySystems
 */
public class Bate_Papo_Web_0002_Formulario {
    
    //Link do Formulário
    //https://docs.google.com/forms/d/1hnhYTGgrJaUz5aUBJDLJXF6K40UHD0iD9kDAfBbDkgw/edit?usp=sharing
    
    public String id_formulario_id = "1FAIpQLSefOZQKDyggUc78UrCSe5c5Lx6uupzPJR8UYh6wxOgDKTf4Sg";
    
    public String id_txt = "833181104";
    
    // Opções do formulário
    public String id_formulario_Operador_SERVIDOR_CLIENTE = "833181104";
    public String id_formulario_Usuario_DESTINATARIO = "74489834";
    public String id_formulario_Usuario_REMETENTE = "2094333563";
    public String id_formulario_Senha = "1778552999";
    public String id_formulario_Mensagem = "1923695513";
    public String id_formulario_Funcao_CADASTRAR_ALTERAR_EXCLUIR_CONSULTAR_RESPOSTA = "825356406";
    public String id_formulario_Funcao_Opcoes_Da_Função = "1483903803";
    public String id_formulario_Data_interna = "249790319";
    public String id_formulario_Mac_interno = "1449157727";
    public String id_formulario_Mac_externo = "140917528";
    public String id_formulario_Ip_interno = "1481016639";
    public String id_formulario_Ip_externo = "1821447749";
    
    public Bate_Papo_Web_0002_Formulario() {

    }
    
    public Bate_Papo_Web_0002_Formulario(String id_txt2) {
    
        enviar_Mensagem( id_txt2 );
    }
    
    private void enviar_Mensagem( String id_txt2 ){
        
        InputStream is = null;
        URL url = null;
        try{
            
            String GET_URL = "https://docs.google.com/forms/d/e/" + id_formulario_id + "/formResponse?"
                    + "entry." + id_txt + "=" + id_txt2;
                    //+ "&entry." + id_formulario_Usuario_DESTINATARIO + "=" + id_formulario_Usuario_DESTINATARIO2;
            
            //System.out.println("GET_URL: " + GET_URL);
                    
            url = new URL(GET_URL);
            URLConnection conn = url.openConnection();
            
        } catch( Exception e ){ }
        
        //Enviando mensagem
        try{
            
            is = url.openStream();
            
        } catch( Exception e ){ e.printStackTrace(); }
    }
    
    public static void main(String[] args) {
        
        try{
            
            String txt = "Hoje é um lindo dia";
            Bate_Papo_Web_0001_Alfabeto V = new Bate_Papo_Web_0001_Alfabeto();
            String str_jm = V.exportar_Para_Alfabeto_JM_Sem_Arroba(txt);
            
            String linha_A_Enviar = "@" + str_jm + "@";
                    
            Bate_Papo_Web_0002_Formulario B = new Bate_Papo_Web_0002_Formulario( linha_A_Enviar );
                    
        }catch( Exception e ){}
    }
    
}