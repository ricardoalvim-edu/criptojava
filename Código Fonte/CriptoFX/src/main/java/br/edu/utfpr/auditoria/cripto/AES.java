package br.edu.utfpr.auditoria.cripto;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class AES {
    public static String IV = "AAAAAAAAAAAAAAAA";
    public static String chaveencriptacao = "0123456789abcdef";   
    
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
        
        cipher.init(Cipher.DECRYPT_MODE, chave ,new IvParameterSpec(IV.getBytes("UTF-8")));
        return new String(cipher.doFinal(textoencriptado),"UTF-8");
    }
}
