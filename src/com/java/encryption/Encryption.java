package com.java.encryption;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import jakarta.xml.bind.DatatypeConverter;

public class Encryption {

	private static final String AES_CIPHER_ALGORITHM = "AES/CBC/PKCS5PADDING";

	private SecretKey symmetricKey;
	private static final byte[] FIXED_IV = DatatypeConverter.parseHexBinary("00112233445566778899AABBCCDDEEFF");

	public Encryption() throws Exception {
		this.symmetricKey = createAESKey();
	}

	public String encrypt(String plainText) throws Exception {
		byte[] cipherText = performEncryption(plainText);
		return DatatypeConverter.printHexBinary(cipherText);
	}

	public String decrypt(String cipherTextHex) throws Exception {
		byte[] cipherText = DatatypeConverter.parseHexBinary(cipherTextHex);
		return performDecryption(cipherText);
	}

	private SecretKey createAESKey() throws Exception {
		byte[] keyBytes = DatatypeConverter.parseHexBinary("00112233445566778899AABBCCDDEEFF");
		return new SecretKeySpec(keyBytes, "AES");
	}

	private byte[] performEncryption(String plainText) throws Exception {
		Cipher cipher = Cipher.getInstance(AES_CIPHER_ALGORITHM);
		IvParameterSpec ivParameterSpec = new IvParameterSpec(FIXED_IV);
		cipher.init(Cipher.ENCRYPT_MODE, symmetricKey, ivParameterSpec);
		return cipher.doFinal(plainText.getBytes());
	}

	private String performDecryption(byte[] cipherText) throws Exception {
		Cipher cipher = Cipher.getInstance(AES_CIPHER_ALGORITHM);
		IvParameterSpec ivParameterSpec = new IvParameterSpec(FIXED_IV);
		cipher.init(Cipher.DECRYPT_MODE, symmetricKey, ivParameterSpec);
		byte[] result = cipher.doFinal(cipherText);
		return new String(result);
	}
}
