package no.swag.nsa.crypto;

public class Blowfish extends Crypto {

  public Blowfish(String password){
    super(password, "Blowfish");    
  }

  public static void main(String[] args) {  
    Blowfish b = new Blowfish("password");  
    String textToEncrypt = "Blowfish Algorithm";  
    System.out.println("Text before Encryption: " + textToEncrypt);  
    String cipherText = b.encrypt(textToEncrypt);
    System.out.println("Cipher Text: " + cipherText);  
    System.out.println("Text after Decryption: " + b.decrypt(cipherText)); 
    // Blowfish c = new Blowfish("password");
    // System.out.println("Text after Decryption2: " + c.decrypt(cipherText)); 
  }
}
