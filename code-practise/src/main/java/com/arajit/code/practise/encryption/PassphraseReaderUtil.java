package com.arajit.code.practise.encryption;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PassphraseReaderUtil {

  private final String APPTAB_FILE_PREFIX = "apptab";
  private final String PATH_SEPARATOR = "/";
  private final String REPLACE_SOURCE = "replaceit";


  public static void main(String[] args) {

    System.out.println("PassphraseReaderUtil invoked..." + args.length);
    
    Arrays.stream(args).forEach(System.out::println);
    
    if (null != args && args.length == 2) {
      
      // Read passphrase from classpath encrypted.properties file and decrypt it with the secret key.
      PassphraseReaderUtil pru = new PassphraseReaderUtil();
      String passphrase = pru.readPassphrase(args[0]);
      System.out.println("pp is:" + passphrase);
  
      // Update apptab files with decrypted value.
      if (null != passphrase)
        pru.updateApptab(args[1], passphrase);
    }else {
      System.err.println("Please pass secret key and apptab target directory properly!!");
    }
    
  }

  private String readPassphrase(String key) {

    Properties prop = new Properties();
    InputStream inputStream = null;

    try {
      inputStream = this.getClass().getResourceAsStream("/encrypted.properties");

      // load a properties file
      prop.load(inputStream);
      String encryptedValue = prop.getProperty("encrypted-passphrase");

      // Run AES encryption program to decrypt it.
      AESEncryption encryptionUtil = new AESEncryption();
      encryptionUtil.setKeyValue(key.getBytes());
      return encryptionUtil.decrypt(encryptedValue);
    } catch (Exception ex) {
      ex.printStackTrace();
    } finally {
      // close input stream
      if (inputStream != null) {
        try {
          inputStream.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }
    return null;
  }

  void updateApptab(String targetDir, String passPhrase) {

    File dir = new File(targetDir);
    if (dir.exists()) {
      String[] files = dir.list(new FilenameFilter() {
        @Override
        public boolean accept(File dir, String name) {
          System.out.println("dir::" + dir.getPath());
          if (name.startsWith(APPTAB_FILE_PREFIX)) {
            Path path = Paths.get(dir.getPath() + PATH_SEPARATOR + name);
            try {
              Stream<String> lines = Files.lines(path);
              List<String> replaced = lines.map(line -> line.replaceAll(REPLACE_SOURCE, passPhrase))
                  .collect(Collectors.toList());
              lines.close();
            } catch (IOException e) {
              e.printStackTrace();
            }
            return true;
          }

          else
            return false;
        }
      });
      System.out.println("replaced " + files.length);
    }
  }

}
