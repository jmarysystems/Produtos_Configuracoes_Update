/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

/**
 *
 * @author JMarySystems
 */
public class Bate_Papo_Web_0003_Enviando_Mensagem {
    
    Bate_Papo_Web_0002_Formulario Bate_Papo_Web_Formulario;
    
    public boolean enviar_Mensagem( String id_txt2 ){
        boolean retorno = false;
        
        Bate_Papo_Web_Formulario = new Bate_Papo_Web_0002_Formulario();
        
        InputStream is = null;
        URL url = null;
        try{
            
            String GET_URL = "https://docs.google.com/forms/d/e/" + Bate_Papo_Web_Formulario.id_formulario_id + "/formResponse?"
                    + "entry." + Bate_Papo_Web_Formulario.id_txt + "=" + id_txt2;
                    
            url = new URL(GET_URL);
            URLConnection conn = url.openConnection();
            
        } catch( Exception e ){ }
        
        //Enviando mensagem
        try{
            
            is = url.openStream();
            
            retorno = true;
            
        } catch( Exception e ){ 
            retorno = false;
            e.printStackTrace(); 
        }
        
        return retorno;
    }
    
    public static void main(String[] args) {
        
        try{
            
            // Opções do formulário
            String Operador_SERVIDOR_CLIENTE = "CLIENTE";
            String Usuario_DESTINATARIO = "JMARYSYSTEMS@GMAIL.COM";
            String Usuario_REMETENTE = "CLEILSONINFO2@GMAIL.COM";
            String Senha = "23071354";
            String Mensagem = "";
            String Funcao_CADASTRAR_ALTERAR_EXCLUIR_CONSULTAR_RESPOSTA = "";
            String Funcao_Opcoes_Da_Função = "";
            String Data_interna = "";
            String Mac_interno = "";
            String Mac_externo = "";
            String Ip_interno = "";
            String Ip_externo = "";
            // Opções do formulário
            
            // [ A ] declarando e instanciando uma ArrayList<String> listStr
            ArrayList<String> listStr = new ArrayList();
            //Povoando uma ArrayList<String> listStr
            listStr.add(Operador_SERVIDOR_CLIENTE);
            listStr.add(Usuario_DESTINATARIO);
            listStr.add(Usuario_REMETENTE);
            
            StringBuilder sb = new StringBuilder();
            
            //Transformando o texto na codificação JM
            Bate_Papo_Web_0001_Alfabeto V = new Bate_Papo_Web_0001_Alfabeto();
            for(int i = 0; i < listStr.size(); i++ ){
                
                String str_jm = V.exportar_Para_Alfabeto_JM_Sem_Arroba( listStr.get(i) );
                sb.append( str_jm );
                
                int v = listStr.size() - 1;
                if( i != v ){
                    
                    sb.append( "j" );
                }
            }
            
            //Separando comandos/argumentos
            String linha_A_Enviar = "@" + sb.toString() + "@";
    
            //Enviando Mensagem
            Bate_Papo_Web_0003_Enviando_Mensagem B = new Bate_Papo_Web_0003_Enviando_Mensagem();
            B.enviar_Mensagem( linha_A_Enviar );
            
        }catch( Exception e ){}
    }
    
}