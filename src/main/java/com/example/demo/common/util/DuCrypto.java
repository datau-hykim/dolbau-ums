package com.example.demo.common.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;

import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

@Slf4j
@Component
public class DuCrypto {
    /**
     * Encrypt / Decrypt
     */
    private static final String CRYPT_ALGO = "AES";
    private static final String CRYPT_MODE = "CBC";
    private static final String CRYPT_PADDING = "PKCS5Padding";

    @Value("${crypto.secret}")
    private String secret;
    @Value("${crypto.iv}")
    private String iv;

    public String encrypt(String plainText) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidAlgorithmParameterException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        SecretKeySpec secretKeySpec = new SecretKeySpec(secret.getBytes(), CRYPT_ALGO);
        IvParameterSpec ivSpec = new IvParameterSpec(iv.getBytes());

        Cipher cipher = Cipher.getInstance(CRYPT_ALGO + "/" + CRYPT_MODE + "/" + CRYPT_PADDING);
        cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, ivSpec);

        byte[] cipherText = cipher.doFinal(plainText.getBytes());

        return encodeBase64(cipherText);
    }

    public String decrypt(String cipherText) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidAlgorithmParameterException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        SecretKeySpec secretKeySpec = new SecretKeySpec(secret.getBytes(), CRYPT_ALGO);
        IvParameterSpec ivSpec = new IvParameterSpec(iv.getBytes());

        Cipher cipher = Cipher.getInstance(CRYPT_ALGO + "/" + CRYPT_MODE + "/" + CRYPT_PADDING);
        cipher.init(Cipher.DECRYPT_MODE, secretKeySpec, ivSpec);

        byte[] decoded = decodeBase64(cipherText);
        byte[] plainText = cipher.doFinal(decoded);

        return new String(plainText);
    }

    /**
     * Hashing
     */
    private static final String HASH_ALGO = "SHA-256";
    private static final Integer HASH_ROUND = 3;

    public String hash(String plainText, String salt) throws NoSuchAlgorithmException {
        return hash(plainText + salt, HASH_ROUND);
    }

    private String hash(String hashText, Integer rounds) throws NoSuchAlgorithmException {
        if (rounds == 0) return hashText;

        MessageDigest md = MessageDigest.getInstance(HASH_ALGO);
        md.update((hashText).getBytes());

        return hash(bytesToHex(md.digest()), --rounds);
    }

    private String bytesToHex(byte[] bytes) {
        StringBuilder builder = new StringBuilder();
        for (byte b : bytes) {
            builder.append(String.format("%02x", b));
        }
        return builder.toString();
    }

    /**
     * encode / decode
     */
    private String encodeBase64(byte[] bytes) {
        return Base64.getEncoder().encodeToString(bytes);
    }

    private byte[] decodeBase64(String encodedStr) {
        return Base64.getDecoder().decode(encodedStr.getBytes());
    }
}
