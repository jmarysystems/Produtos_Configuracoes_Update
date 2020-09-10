/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

/**
 *
 * @author JMarySystems
 */
public class Bate_Papo_Web_0005_Separando_por_Linha_as_Mensagens {
    
    Bate_Papo_Web_0004_Recebendo_Mensagem Bate_Papo_Web_Recebendo_Mensagem;    
    String mensagem = null;
    
    public String tratando_Mensagem(int posicao){
        String retorno = null;
        mensagem = null;
        StringBuilder sb = new StringBuilder();
              
        Bate_Papo_Web_Recebendo_Mensagem = new Bate_Papo_Web_0004_Recebendo_Mensagem();
        mensagem = Bate_Papo_Web_Recebendo_Mensagem.recebendo_Mensagem( 0 );

        try{
            
            if( mensagem != null ){
                                                
                if( mensagem.contains("@") ){
                    
                    //System.out.println( "////////// MENSAGEM //////////" );
                    //System.out.println( mensagem );
                    //System.out.println( "////////// MENSAGEM //////////\n\n\n" );
                                                            
                    String[] str = mensagem.split("@");
                                        
                    for( int i = 0; i < str.length; i++ ) {
                        
                        //System.out.println( i + " - ////////////////////////////" );
                        //System.out.println( str[i] );
                        //System.out.println( i + " - ////////////////////////////\n" );
                        
                        if( str[i].contains("-") ){
                            
                            //System.out.println( str[i] + "\n" );
                            
                            sb.append( str[i] );
                            sb.append( "\n" );
                        }
                    }
                    
                    try{ retorno = sb.toString(); } catch( Exception e ){}
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
                    
            Bate_Papo_Web_0005_Separando_por_Linha_as_Mensagens B = new Bate_Papo_Web_0005_Separando_por_Linha_as_Mensagens();
            String x = B.tratando_Mensagem( 0 );
            
            System.out.println( x );
            
        }catch( Exception e ){}
    }
    
}