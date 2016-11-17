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
    
    static String textopuro = "teste";
    
    public static void main(String [] args) throws Exception{
            System.out.println("Texto Puro: " + textopuro);
            
            AES aes = new AES();
            RSA rsa = new RSA();
            
            byte[] textoencriptado = aes.encriptar(textopuro, aes.chaveencriptacao);
            System.out.print("Texto Encriptado usando AES: ");
   
            for (int i=0; i<textoencriptado.length; i++){
                System.out.print(new Integer(textoencriptado[i])+" ");
            }
                      
                System.out.println("");
                
                String textodecriptado = AES.decriptar(textoencriptado, AES.chaveencriptacao);
                       
                System.out.println("Texto Decriptado usando AES: " + textodecriptado);
                
                
                System.out.println("Texto Encriptado usando RSA: ");
                String textoencriptadoRSA = rsa.encriptar(textopuro);
                
                String textodecripitadoRSA = rsa.decriptar(textoencriptadoRSA);
                
                System.out.println("Texto Decriptado usando RSA: " + textodecripitadoRSA);
                
    }        
}
