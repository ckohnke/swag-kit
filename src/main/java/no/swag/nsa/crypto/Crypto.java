package no.swag.nsa.crypto;

import org.apache.commons.codec.binary.Base64;

public class Crypto {
  public String encrypt(String plain){
    return null;
  }

  String decrypt(String cryptext){
    return null;
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
