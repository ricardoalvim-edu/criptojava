/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho;


/**
 *
 * @author USUARIO
 */
public class Main {
    
    public static String texto = "teste-";
    public static String texto2M = "teste-teste-";
    public static String texto4M = "teste-teste-teste-teste-";
    public static String texto8M = "teste-teste-teste-teste-teste-teste-teste-teste-";
    
    public static void main(String [] args) throws Exception{
            
            byte[] textoencriptado;
            
            AES aes = new AES();
            RSA rsa = new RSA();
            
            System.out.println("Texto claro: " + texto);
            
            textoencriptado = aes.encriptar(texto, aes.chaveencriptacao);
            System.out.print("Texto Encriptado usando AES: ");
   
            for (int i=0; i<textoencriptado.length; i++){
                System.out.print(new Integer(textoencriptado[i])+" ");
            }
                      
                System.out.println("");
                
                String textodecriptado = AES.decriptar(textoencriptado, AES.chaveencriptacao);
                       
                System.out.println("Texto Decriptado usando AES: " + textodecriptado);
    
                
    }        
}
