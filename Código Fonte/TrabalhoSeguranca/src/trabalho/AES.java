/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho;


import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/**
 *
 * @author USUARIO
 */
public class AES {
    static String IV = "AAAAAAAAAAAAAAAA";
    static String chaveencriptacao = "0123456789abcdef";
   
    
        public static byte[] encriptar(String textopuro, String chaveencriptacao) throws Exception {
               Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding", "SunJCE");
               //KeyGenerator kg = KeyGenerator.getInstance ("AES");
                //kg.init (128);
               SecretKeySpec chave = new SecretKeySpec(chaveencriptacao.getBytes("UTF-8"), "AES");
               cipher.init(Cipher.ENCRYPT_MODE, chave,new IvParameterSpec(IV.getBytes("UTF-8")));
               return cipher.doFinal(textopuro.getBytes("UTF-8"));
         }
   
         public static String decriptar(byte[] textoencriptado, String chaveencriptacao) throws Exception{
               Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding", "SunJCE");
               SecretKeySpec chave = new SecretKeySpec(chaveencriptacao.getBytes("UTF-8"), "AES");
               cipher.init(Cipher.DECRYPT_MODE, chave,new IvParameterSpec(IV.getBytes("UTF-8")));
               return new String(cipher.doFinal(textoencriptado),"UTF-8");
         }
}
