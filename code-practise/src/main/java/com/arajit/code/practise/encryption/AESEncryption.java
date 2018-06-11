package com.arajit.code.practise.encryption;

import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;


public class AESEncryption {
  
  private static final String ALGO = "AES";
  
  private byte[] keyValue;

  /**
   * Encrypt a string with AES algorithm.
   *
   * @param data is a string
   * @return the encrypted string
   */
  public String encrypt(String data) throws Exception {
      Key key = generateKey();
      Cipher c = Cipher.getInstance(ALGO);
      c.init(Cipher.ENCRYPT_MODE, key);
      byte[] encVal = c.doFinal(data.getBytes());
      return Base64.getEncoder().encodeToString(encVal);
  }

  /**
   * Decrypt a string with AES algorithm.
   *
   * @param encryptedData is a string
   * @return the decrypted string
   */
  public  String decrypt(String encryptedData) throws Exception {
      Key key = generateKey();
      Cipher c = Cipher.getInstance(ALGO);
      c.init(Cipher.DECRYPT_MODE, key);
      byte[] decordedValue = Base64.getDecoder().decode(encryptedData);
      byte[] decValue = c.doFinal(decordedValue);
      return new String(decValue);
  }

  /**
   * Generate a new encryption key.
   */
  private Key generateKey() throws Exception {
      return new SecretKeySpec(keyValue, ALGO);
  }
  
  public void setKeyValue(byte[] keyValue) {
    this.keyValue = keyValue;
  }
  
}
