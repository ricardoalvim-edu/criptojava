/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho;

import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import javax.crypto.Cipher;


/**
 *
 * @author USUARIO
 */
public class RSA {
    private static PublicKey publicKey;
    private static PrivateKey privateKey;
    private static KeyPairGenerator generator;
    private static KeyPair pair;
    private static Cipher cipher;
    //private static SecureRandom random;
    
   // public RSA(PublicKey publicKey, PrivateKey privateKey) {
     //   this.publicKey = publicKey;
       // this.privateKey = privateKey;
    //}
    public RSA(){
        
    }
    public static void main(String [] args)throws Exception{
            //random = new SecureRandom();
            generator = KeyPairGenerator.getInstance("RSA");
            generator.initialize(1024);
            pair = generator.generateKeyPair();
            publicKey = pair.getPublic();
            privateKey = pair.getPrivate();
    }

    //public static KeyPair genKeyPair() throws Exception {
      //  KeyPairGenerator generator = KeyPairGenerator.getInstance("RSA");
        //generator.initialize(512);
        //o tamanho em bits da chave
        //KeyPair keyPair = generator.generateKeyPair();

        //return keyPair;
    //}

    public byte[] encriptar( String texto) throws Exception {
        byte [] cipherText;
        //try {
            Cipher cipher = Cipher.getInstance("RSA");
            cipher.init(Cipher.ENCRYPT_MODE, publicKey);
            cipherText = cipher.doFinal(texto.getBytes("ISO-8859-1"));
            return (cipherText);
       // } catch (InvalidKeyException e) {
           // System.err.println(e.getMessage());
         // }
       // return null;
    }

    public String decriptar(byte[] cipherText) throws Exception {
       // try{
            Cipher cipher = Cipher.getInstance("RSA");
            cipher.init(Cipher.DECRYPT_MODE, privateKey);
            byte[] plaintext = cipher.doFinal(cipherText);
            String texto = new String(plaintext, "UTF-8");
            return texto;
        // } catch (InvalidKeyException e) {
          //    System.err.println(e.getMessage());
          //}
        //return null;
    }
}
