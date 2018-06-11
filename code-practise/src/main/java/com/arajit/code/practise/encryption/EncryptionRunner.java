package com.arajit.code.practise.encryption;


import java.util.Scanner;


public class EncryptionRunner {

  private static final String PRICING_SECRET_KEY = "Pr1c$ng#Serv1ces";

  public static void main(String[] args) throws Exception {

    // Read pasphrase from console
    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter passowrd");
    String passphrase = scanner.nextLine();
    scanner.close();

    // Run encryption program
    AESEncryption aesEnc = new AESEncryption();
    aesEnc.setKeyValue(PRICING_SECRET_KEY.getBytes());
    System.out.println("Encrypted value: " + aesEnc.encrypt(passphrase));

  }

}
