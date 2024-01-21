package com.java.encryption;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import jakarta.xml.bind.DatatypeConverter;
import java.security.SecureRandom;

public class Encryption {

    private static final String AES = "AES";
    private static final String AES_CIPHER_ALGORITHM = "AES/CBC/PKCS5PADDING";

    private static final String keyString = "00112233445566778899AABBCCDDEEFF";  // Initialized and final

    private SecretKey symmetricKey;
    private byte[] initializationVector;

    public Encryption() throws Exception {
        this.symmetricKey = createAESKey(keyString);
        this.initializationVector = createInitializationVector();
    }

    public String encrypt(String plainText) throws Exception {
        byte[] cipherText = performEncryption(plainText);
        return DatatypeConverter.printHexBinary(cipherText);
    }

    public String decrypt(String cipherTextHex) throws Exception {
        byte[] cipherText = DatatypeConverter.parseHexBinary(cipherTextHex);
        return performDecryption(cipherText);
    }

    private SecretKey createAESKey(String keyString) throws Exception {
        byte[] keyBytes = DatatypeConverter.parseHexBinary(keyString);
        return new SecretKeySpec(keyBytes, AES);
    }

    private byte[] createInitializationVector() {
        byte[] initializationVector = new byte[16];
        SecureRandom secureRandom = new SecureRandom();
        secureRandom.nextBytes(initializationVector);
        return initializationVector;
    }

    private byte[] performEncryption(String plainText) throws Exception {
        Cipher cipher = Cipher.getInstance(AES_CIPHER_ALGORITHM);
        IvParameterSpec ivParameterSpec = new IvParameterSpec(initializationVector);
        cipher.init(Cipher.ENCRYPT_MODE, symmetricKey, ivParameterSpec);
        return cipher.doFinal(plainText.getBytes());
    }

    private String performDecryption(byte[] cipherText) throws Exception {
        Cipher cipher = Cipher.getInstance(AES_CIPHER_ALGORITHM);
        IvParameterSpec ivParameterSpec = new IvParameterSpec(initializationVector);
        cipher.init(Cipher.DECRYPT_MODE, symmetricKey, ivParameterSpec);
        byte[] result = cipher.doFinal(cipherText);
        return new String(result);
    }

    // Driver code
    public static void main(String args[]) throws Exception {
        Encryption encryption = new Encryption();

        System.out.println("The Symmetric Key is :" + keyString);

        String plainText = "This is the message " + "I want To Encrypt.";

        String cipherText = encryption.encrypt(plainText);

        System.out.println("The ciphertext or Encrypted Message is: " + cipherText);

        // Decrypting the encrypted message
        String decryptedText = encryption.decrypt(cipherText);

        System.out.println("Your original message is: " + decryptedText);
    }
}
