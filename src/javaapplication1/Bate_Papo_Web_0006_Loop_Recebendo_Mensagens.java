/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author JMarySystems
 */
public class Bate_Papo_Web_0006_Loop_Recebendo_Mensagens {
    
    Bate_Papo_Web_0005_Separando_por_Linha_as_Mensagens B = null;
    
    public List<String> recebendo_Mensagens(int posicao){                        
        List<String> retorno = new ArrayList<>();
        String mensagem = null;
        StringBuilder sb = new StringBuilder();            
        
        try{
            
            B = new Bate_Papo_Web_0005_Separando_por_Linha_as_Mensagens();
            mensagem = B.tratando_Mensagem( 0 );
            
            if( mensagem != null ){
                                                
                String[] str_mensagem_completa_codificada = mensagem.split("\n");
                                        
                for( int i = 0; i < str_mensagem_completa_codificada.length; i++ ) {
                    
                    //System.out.println( str[i] + "\n" );
                    
                    retorno.add( str_mensagem_completa_codificada[i] );
                }                    
            }
            
            //retorno = mensagem;        
                    
        } catch( Exception e ){ 
            retorno = null;
            e.printStackTrace(); 
        }
        
        return retorno;
    }
    
    public static void main(String[] args) {
        
        try{
            
            while(true){                
                // Opções do formulário
                String Operador_SERVIDOR_CLIENTE = "";
                String Usuario_DESTINATARIO = "";
                String Usuario_REMETENTE = "";
                String Senha = "";
                String Mensagem = "";
                String Funcao_CADASTRAR_ALTERAR_EXCLUIR_CONSULTAR_RESPOSTA = "";
                String Funcao_Opcoes_Da_Função = "";
                String Data_interna = "";
                String Mac_interno = "";
                String Mac_externo = "";
                String Ip_interno = "";
                String Ip_externo = "";
                // Opções do formulário
                
                // exportar_Para_Alfabeto_JM 
                Bate_Papo_Web_0001_Alfabeto Alfabeto = new Bate_Papo_Web_0001_Alfabeto();
                    
                Bate_Papo_Web_0006_Loop_Recebendo_Mensagens B = new Bate_Papo_Web_0006_Loop_Recebendo_Mensagens();
            
                List<String> lista_De_Linhas = B.recebendo_Mensagens( 0 );
                            
                for( int i = 0; i < lista_De_Linhas.size(); i++ ) {
                    System.out.println( "\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\" + " - Linha - " + i ); 
                
                    String[] lista = lista_De_Linhas.get(i).split("j");
                    try{ 
                        Operador_SERVIDOR_CLIENTE = Alfabeto.importar_Para_Alfabeto_JM( lista[0] ) ;
                        System.out.println( Operador_SERVIDOR_CLIENTE ); 
                    }catch( Exception e ){}
                    try{ 
                        Usuario_DESTINATARIO = Alfabeto.importar_Para_Alfabeto_JM( lista[1] ) ;
                        System.out.println( Usuario_DESTINATARIO ); 
                    }catch( Exception e ){}
                    try{ 
                        Usuario_REMETENTE = Alfabeto.importar_Para_Alfabeto_JM( lista[2] ) ;
                        System.out.println( Usuario_REMETENTE ); 
                    }catch( Exception e ){}
                    try{ 
                        Senha = Alfabeto.importar_Para_Alfabeto_JM( lista[3] ) ;
                        System.out.println( Senha ); 
                    }catch( Exception e ){}
                    try{ 
                        Mensagem = Alfabeto.importar_Para_Alfabeto_JM( lista[4] ) ;
                        System.out.println( Mensagem ); 
                    }catch( Exception e ){}
                    try{ 
                        Funcao_CADASTRAR_ALTERAR_EXCLUIR_CONSULTAR_RESPOSTA = Alfabeto.importar_Para_Alfabeto_JM( lista[5] ) ;
                        System.out.println( Funcao_CADASTRAR_ALTERAR_EXCLUIR_CONSULTAR_RESPOSTA ); 
                    }catch( Exception e ){}
                    try{ 
                        Funcao_Opcoes_Da_Função = Alfabeto.importar_Para_Alfabeto_JM( lista[6] ) ;
                        System.out.println( Funcao_Opcoes_Da_Função ); 
                    }catch( Exception e ){}
                    try{ 
                        Data_interna = Alfabeto.importar_Para_Alfabeto_JM( lista[7] ) ;
                        System.out.println( Data_interna ); 
                    }catch( Exception e ){}
                    try{ 
                        Mac_interno = Alfabeto.importar_Para_Alfabeto_JM( lista[8] ) ;
                        System.out.println( Mac_interno ); 
                    }catch( Exception e ){}
                    try{ 
                        Mac_externo = Alfabeto.importar_Para_Alfabeto_JM( lista[9] ) ;
                        System.out.println( Mac_externo ); 
                    }catch( Exception e ){}
                    try{ 
                        Ip_interno = Alfabeto.importar_Para_Alfabeto_JM( lista[10] ) ;
                        System.out.println( Ip_interno ); 
                    }catch( Exception e ){}
                    try{ 
                        Ip_externo = Alfabeto.importar_Para_Alfabeto_JM( lista[11] ) ;
                        System.out.println( Ip_externo ); 
                    }catch( Exception e ){}
                    
                    System.out.println( "\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\" + " - Linha - " + i ); 
                    System.out.println( "\n" );   
                }                             
            
                Thread.sleep( 5000 );
            }
                                    
        }catch( Exception e ){}
    }
    
}