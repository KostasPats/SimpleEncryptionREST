package test

import org.bouncycastle.jce.provider.BouncyCastleProvider

import javax.crypto.Cipher
import java.security.KeyFactory
import java.security.KeyPair
import java.security.KeyPairGenerator
import java.security.NoSuchAlgorithmException
import java.security.PrivateKey
import java.security.PublicKey
import java.security.Security
import java.security.spec.EncodedKeySpec
import java.security.spec.PKCS8EncodedKeySpec
import java.security.spec.X509EncodedKeySpec

/**
 * Created by user on 4/23/2017.
 */
class Crypto {
    PrivateKey privKey
    PublicKey pubKey
    Crypto()
    {
        Security.addProvider(new BouncyCastleProvider())
        generateKey()
    }

    Crypto(String encodedKey)
    {
        Security.addProvider(new BouncyCastleProvider())
        privKey = setPrivateKey(encodedKey)
    }

    String getKey() {
        byte[] keyBytes = privKey.getEncoded()
        return new String(Base64.getEncoder().encodeToString(keyBytes))
    }

    PrivateKey setPrivateKey(String encodedKey) {
        byte[] key = Base64.getDecoder().
                decode(encodedKey.getBytes())
        KeyFactory keyFactory = KeyFactory.getInstance("RSA")
        EncodedKeySpec privateKeySpec = new PKCS8EncodedKeySpec(key)
        PrivateKey privateKey = keyFactory.generatePrivate(privateKeySpec)
        return privateKey
    }



    void generateKey() throws NoSuchAlgorithmException
    {
        KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA")
        keyGen.initialize(1024)
        KeyPair key = keyGen.generateKeyPair()
        pubKey = key.public
        privKey = key.private
    }

    byte[] encrypt(byte[] text) throws Exception
    {
        byte[] cipherText = null
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding")

        cipher.init(Cipher.ENCRYPT_MODE, pubKey)
        cipherText = cipher.doFinal(text)
        return cipherText
    }

    byte[] decrypt(byte[] text) throws Exception
    {
        byte[] dectyptedText = null
        // decrypt the text using the private key
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding")
        cipher.init(Cipher.DECRYPT_MODE, privKey)
        dectyptedText = cipher.doFinal(text)
        return dectyptedText
    }

}
