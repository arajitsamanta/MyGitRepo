package com.arajit.code.google.devguide;

/**
 * http://codingbat.com/prob/p117334
 *
 */
public class StringSplosion {

  public static void main(String[] args) {
    stringSplosion("code");
  }

  static String stringSplosion(String str) {
    int len = str.length();
    int i = 0;
    StringBuilder buf = new StringBuilder();
    while (i < len - 1) {
      String subStr = str.substring(0, i + 1);
      buf.append(subStr);
      i++;
    }
    return buf.append(str).toString();
  }

}
