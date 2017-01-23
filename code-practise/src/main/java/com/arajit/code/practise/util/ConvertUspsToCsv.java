/**
 * 
 */
package com.arajit.code.practise.util;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author as47775
 *
 */
public class ConvertUspsToCsv {

	public static void main(String args[]) {
	      
        //reading file line by line in Java using BufferedReader       
        FileInputStream fis = null;
        BufferedReader reader = null;
        int count=0;
        try {
            fis = new FileInputStream("C:/Users/as47775/Desktop/USPS09232016.txt");
            reader = new BufferedReader(new InputStreamReader(fis));
          
            System.out.println("Reading File line by line using BufferedReader");
          
            //String line = reader.readLine();
          
            while(reader.readLine() != null){
            	count++;
               // System.out.println(line);
                String line = reader.readLine();
                String[] splittedLine=line.split(":");
                System.out.println(splittedLine[1]+","+splittedLine[2]+","+splittedLine[3]+","+splittedLine[4]);
            }           
          
        } catch (Exception ex) {
            //Logger.getLogger(BufferedReaderExample.class.getName()).log(Level.SEVERE, null, ex);
        	System.out.println("error in readin file!!"+count);
        	ex.printStackTrace();
        } finally {
            try {
                reader.close();
                fis.close();
            } catch (IOException ex) {
              //  Logger.getLogger(BufferedReaderExample.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
  } 


}
