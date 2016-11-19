package br.edu.utfpr.auditoria.cripto;

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

public class RSA {
	private SecureRandom random;
	private KeyPairGenerator generator;
	private PublicKey publicKey;
	private PrivateKey privateKey;
	private Cipher cipher;

	public RSA(Integer size) {
		random = new SecureRandom();
		try {
			generator = KeyPairGenerator.getInstance("RSA");
			generator.initialize(size, random);
			KeyPair pair = generator.generateKeyPair();
			publicKey = pair.getPublic();
			privateKey = pair.getPrivate();
			cipher = Cipher.getInstance("RSA");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			e.printStackTrace();
		}
	}

	public byte[] encriptPublic(String text) {
		try {
			cipher.init(Cipher.ENCRYPT_MODE, publicKey, random);
			byte[] textoClaro = text.getBytes("ISO-8859-1");
			byte[] cipherText = cipher.doFinal(textoClaro);

			return cipherText;
		} catch (InvalidKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalBlockSizeException | BadPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public byte[] encriptPrivate(String text) {
		try {
			cipher.init(Cipher.ENCRYPT_MODE, privateKey, random);
			byte[] textoClaro = text.getBytes("ISO-8859-1");
			byte[] cipherText = cipher.doFinal(textoClaro);

			return cipherText;
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IllegalBlockSizeException | BadPaddingException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public String descriptPrivate(byte[] text){
		byte[] plainText;
		String mensagem = null;
		try {
			cipher.init(Cipher.DECRYPT_MODE, privateKey);
			plainText = cipher.doFinal(text);
			mensagem = new String(plainText, "UTF-8");
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			e.printStackTrace();
		} catch (BadPaddingException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return mensagem;		        
	}
	
	public String descriptPublic(byte[] text){
		byte[] plainText;
		String mensagem = null;
		try {
			cipher.init(Cipher.DECRYPT_MODE, publicKey);
			plainText = cipher.doFinal(text);
			mensagem = new String(plainText, "UTF-8");
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			e.printStackTrace();
		} catch (BadPaddingException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return mensagem;		        
	}
}
