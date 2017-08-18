/**
 * 
 */
package com.arajit.code.practise.util;

/**
 * @author as47775
 *
 */
public class SymmetricEncryption {
	static String PLAIN_TEXT = "July10";
	static String ENCRYPTION_KEY = "0123456789abcdφ";

	public static void main(String [] args) {
		try {

			System.out.println("Plain text  :" + PLAIN_TEXT);

			byte[] cipherText = AESUtils.encrypt(PLAIN_TEXT, ENCRYPTION_KEY);

			System.out.print("Cipher Text:  ");
			for (int i=0; i<cipherText.length; i++)
				System.out.print( String.format("%02X ",cipherText[i]));

			System.out.println("");

			String decrypted = AESUtils.decrypt(cipherText, ENCRYPTION_KEY);

			System.out.println("Decrypted Text  : " + decrypted);

		} catch (Exception e) {
			e.printStackTrace();
		} 
	}

}
