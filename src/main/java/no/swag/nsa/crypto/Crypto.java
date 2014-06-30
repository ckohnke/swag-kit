package no.swag.nsa.crypto;

import org.apache.commons.codec.binary.Base64;
import java.security.*;
import javax.crypto.*;
import javax.crypto.spec.*;

public class Crypto {
  private KeyGenerator keygen;
  private SecretKey key;
  private Cipher cipher;

  public Crypto(String password, String type){
    try {
      keygen = KeyGenerator.getInstance(type);
      key = new SecretKeySpec(password.getBytes(), type);
      cipher = Cipher.getInstance(type);
    } catch(NoSuchAlgorithmException e){
      System.out.println(e);
    } catch(NoSuchPaddingException e){
      System.out.println(e);
    }

  }

 /** 
  * 
  * @param plainText 
  * @return cipherBytes 
  */  
  private byte[] encryptText(String plainText) {  
    byte[] cipherBytes = null;  
    try {    
      cipher.init(Cipher.ENCRYPT_MODE, key);  
      byte[] plainBytes = plainText.getBytes();  
      cipherBytes = cipher.doFinal(plainBytes);  
    } catch (IllegalBlockSizeException ex) {  
      System.out.println(ex);  
    } catch (BadPaddingException ex) {  
      System.out.println(ex);  
    } catch (InvalidKeyException ex) {  
      System.out.println(ex);  
    }  
    return cipherBytes;  
  }  
  
   /** 
    * 
    * @param cipherBytes 
    * @return plainText 
    */  
    private String decryptText(byte[] cipherBytes) {  
      String plainText = null;  
      try {  
        cipher.init(Cipher.DECRYPT_MODE, key);  
        byte[] plainBytes = cipher.doFinal(cipherBytes);  
        plainText = new String(plainBytes);  
      } catch (IllegalBlockSizeException ex) {  
        System.out.println(ex);  
      } catch (BadPaddingException ex) {  
        System.out.println(ex);  
      } catch (InvalidKeyException ex) { 
        System.out.println(ex); 
      }  
      return plainText;  
    }  


    /** 
     * 
     * @param plainText 
     * @return cipherText 
     */  
    public String encrypt(String plainText) {  
      String cipherText = null;  
      byte[] cipherBytes = encryptText(plainText);  
      cipherText = bytesToString(cipherBytes);  
      return cipherText;  
    }  
  
    /** 
     *  
     * @param cipherText 
     * @return plainText 
     */  
    public String decrypt(String cipherText) {  
      String plainText = null;  
      byte[] cipherBytes = stringToBytes(cipherText);  
      plainText = decryptText(cipherBytes);  
      return plainText;  
    } 

  /** 
  *  
  * @param rawText 
  * @return plainText 
  * 
  * Perform Base64 encoding 
  */  
  public String bytesToString(byte[] rawText) {  
    String plainText = null;  
    plainText = Base64.encodeBase64String(rawText);  
    return plainText;  
  }  
  
  /** 
  *  
  * @param plainText 
  * @return rawText 
  * 
  * Perform Base64 decoding 
  */  
  public byte[] stringToBytes(String plainText) {  
    byte[] rawText = null;  
    rawText = Base64.decodeBase64(plainText);  
    return rawText;  
  } 
}
