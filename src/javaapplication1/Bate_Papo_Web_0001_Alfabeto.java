/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

/**
 *
 * @author Ariel Arcanjo
 */
public class Bate_Papo_Web_0001_Alfabeto {
    
    public Bate_Papo_Web_0001_Alfabeto() {
    
        
    }
            
    public String exportar_Para_Alfabeto_JM_Sem_Arroba(String txt){
        
        StringBuilder sb = new StringBuilder();
        for( int i = 0; i < txt.length(); i++ ) {
            
            int decimal_unicode = txt.charAt(i);
            
            sb.append(decimal_unicode);
            sb.append("-");
        }

        return sb.toString();
    }
    
    public String importar_Para_Alfabeto_JM(String txt){
        
        String[] texto = txt.split("-");
        
        StringBuilder sb = new StringBuilder();
        
        for( int i = 0; i < texto.length; i++ ) {
            
            int decimal_unicode = Integer.valueOf( texto[i] );
            
            String letra_unicode = String.valueOf( new Character( (char) decimal_unicode) );
            
            sb.append(letra_unicode);
        }

        return sb.toString();
    }
    
    /*
    public String exportar_Para_Alfabeto_JM(String txt){
        
        StringBuilder sb = new StringBuilder();
        for( int i = 0; i < txt.length(); i++ ) {
            
            int decimal_unicode = txt.charAt(i);
            
            sb.append(decimal_unicode);
            sb.append("-");
        }

        return "@" + sb.toString() + "@";
    }
    */
    
    /*
    public String int_Para_String(int x){       
        
        return String.valueOf( new Character( (char) x) );
    }
    
    public int String_Para_int(String x){
        
        return x.charAt(0);
    }
    
    public String importar_Para_Alfabeto_JM_5_DIGITOS(String x){
        
        int numero = x.charAt(0);

        return String.format ("%05d", numero );
    }
    */
            
    public static void main(String[] args) {
        
        try{
            
            // INT PARA STRING No Java
            /*
            System.out.println( "        switch(x){" );   
            for( int i = 0; i < 65000; i++ ) {

                System.out.println( "            case " + i + ": y = " + "\"" + new Character( (char) i) + "\"" + "; break;" );  

            }          
            System.out.println( "            default: y = 'nnn';" );       
            System.out.println( "        }" );
            */
            
            // TEXTO PARA INT_JM
            /*
            Bate_Papo_Web_0001_Alfabeto Bate_Papo_Web_0001_Alfabeto = new Bate_Papo_Web_0001_Alfabeto();
            String texto = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
            for( int i = 0; i < texto.length(); i++ ) { //65000
                
                int numero = texto.charAt(i);
                
                String letra = String.valueOf( new Character( (char) numero) );
                
                // o primeiro argumento é o numero a ser transformado e o segundo é a base
                String binario = Integer.toString( texto.charAt(i), 2);
                
                //Nome da variavel e tipo, 2 = binary. Converte o binario para int
                int bin_para_inteiro = Integer.parseInt(binario, 2);
                
                System.out.println( "Número: " + numero  + " - Letra: " + letra + " - Binário: " + binario + " - bin_para_inteiro: " + bin_para_inteiro + " - Alfa_JM: " +  
                        Bate_Papo_Web_0001_Alfabeto.importar_Para_Alfabeto_JM( String.valueOf( texto.charAt(i) ) ) );  

            } 
            */
            
            // INT PARA INT_JM
            /*
            Bate_Papo_Web_0001_Alfabeto Bate_Papo_Web_0001_Alfabeto = new Bate_Papo_Web_0001_Alfabeto();
            for( int i = 0; i < 65000; i++ ) { //65000
                
                int numero = i;
                
                String letra = String.valueOf( new Character( (char) numero) );
                
                // o primeiro argumento é o numero a ser transformado e o segundo é a base
                String binario = Integer.toString( numero, 2);
                
                //Nome da variavel e tipo, 2 = binary. Converte o binario para int
                int bin_para_inteiro = Integer.parseInt(binario, 2);
                
                System.out.println( "Número: " + numero  + " - Letra: " + letra + " - Binário: " + binario + " - bin_para_inteiro: " + bin_para_inteiro + " - Alfa_JM: " +  
                        Bate_Papo_Web_0001_Alfabeto.importar_Para_Alfabeto_JM( String.valueOf( new Character( (char) numero) ) ) );  

            } 
            */
            
            // importar_Para_Alfabeto_JM 
            /*
            Bate_Papo_Web_0001_Alfabeto Bate_Papo_Web_0001_Alfabeto = new Bate_Papo_Web_0001_Alfabeto();
            String texto = "Hoje é domingo 14/06/2020" + "\nA";
            System.out.println( Bate_Papo_Web_0001_Alfabeto.importar_Para_Alfabeto_JM(texto) );
            */
            
            // exportar_Para_Alfabeto_JM 
            Bate_Papo_Web_0001_Alfabeto Bate_Papo_Alfabeto2 = new Bate_Papo_Web_0001_Alfabeto();
            String textoJM = "72-111-106-101-32-233-32-100-111-109-105-110-103-111-32-49-52-47-48-54-47-50-48-50-48-10-65-";
            System.out.println( Bate_Papo_Alfabeto2.importar_Para_Alfabeto_JM(textoJM) );
            
        }catch( Exception e ){}
    }
}



