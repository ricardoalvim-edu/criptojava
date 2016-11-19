/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

/**
 *
 * @author USUARIO
 */
public class RSA {
    public static void main(String args[]) throws NoSuchAlgorithmException, NoSuchProviderException, NoSuchPaddingException, InvalidKeyException, UnsupportedEncodingException, IllegalBlockSizeException, BadPaddingException {

        SecureRandom random = new SecureRandom();

        KeyPairGenerator generator = KeyPairGenerator.getInstance("RSA");

        generator.initialize(1024, random);
        KeyPair pair = generator.generateKeyPair();
        PublicKey publicKey = pair.getPublic(); 
        PrivateKey privateKey = pair.getPrivate(); 
        
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, publicKey, random);
        
        byte[] textoClaro = "texte".getBytes("ISO-8859-1");
        byte[] cipherText = cipher.doFinal(textoClaro);     
        
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        byte[] plainText = cipher.doFinal(cipherText);
        String mensagem  = new String(plainText, "UTF-8");
        System.out.println(mensagem);
    }
}



