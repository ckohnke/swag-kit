package no.swag.nsa.crypto;

import java.security.*;
import javax.crypto.*;
import javax.crypto.spec.*;

public class Blowfish extends Crypto {
  KeyGenerator keygen;
  SecretKey key;
  Cipher cipher;

  public Blowfish(String password){
    try{
      keygen = KeyGenerator.getInstance("Blowfish");
      key = new SecretKeySpec(password.getBytes(), "Blowfish");
      cipher = Cipher.getInstance("Blowfish");
    } catch(NoSuchPaddingException e){
      System.out.println(e);
    } catch(NoSuchAlgorithmException e){
      System.out.println(e);
    }
  }

 /** 
  * 
  * @param plainText 
  * @return cipherBytes 
  */  
  public byte[] encryptText(String plainText) {  
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
    public String decryptText(byte[] cipherBytes) {  
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

  public static void main(String[] args) {  
    Blowfish b = new Blowfish("password");  
    String textToEncrypt = "Blowfish Algorithm";  
    System.out.println("Text before Encryption: " + textToEncrypt);  
    String cipherText = b.encrypt(textToEncrypt);  
    System.out.println("Cipher Text: " + cipherText);  
    System.out.println("Text after Decryption: " + b.decrypt(cipherText));  
  }
}
