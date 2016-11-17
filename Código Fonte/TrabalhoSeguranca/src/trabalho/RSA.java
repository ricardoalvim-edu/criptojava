/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho;

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
    private PublicKey publicKey;
    private PrivateKey privateKey;

    public RSA(PublicKey publicKey, PrivateKey privateKey) {
        this.publicKey = publicKey;
        this.privateKey = privateKey;
    }
    public RSA(){
        
    }

    public static KeyPair genKeyPair() throws Exception {
        KeyPairGenerator generator = KeyPairGenerator.getInstance("RSA");
        generator.initialize(512);
        //o tamanho em bits da chave
        KeyPair keyPair = generator.generateKeyPair();

        return keyPair;
    }

    public String encriptar(String string) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        return new String(cipher.doFinal(string.getBytes()));
    }

    public String decriptar(String string) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        return new String(cipher.doFinal(string.getBytes()));
    }
}
