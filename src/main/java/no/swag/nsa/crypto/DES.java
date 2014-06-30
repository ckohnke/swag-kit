package no.swag.nsa.crypto;


public class DES extends Crypto {
  
  public DES(String password){
    super(password, "DES");
  }

  public static void main(String[] args) {  
    DES b = new DES("password");  
    String textToEncrypt = "DES Algorithm";  
    System.out.println("Text before Encryption: " + textToEncrypt);  
    String cipherText = b.encrypt(textToEncrypt);  
    System.out.println("Cipher Text: " + cipherText);  
    System.out.println("Text after Decryption: " + b.decrypt(cipherText)); 
    // DES c = new DES("password");
    // System.out.println("Text after Decryption2: " + c.decrypt(cipherText)); 
  }


  
}
