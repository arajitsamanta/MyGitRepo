package com.arajit.code.google.devguide;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://techdevguide.withgoogle.com/paths/foundational/find-longest-word-in-dictionary-that-subsequence-of-given-string/#!
 * 
 * Given a string S and a set of words D, find the longest word in D that is a subsequence of S.
 * Word W is a subsequence of S if some number of characters, possibly zero, can be deleted from S to form W, without reordering the remaining characters.
 *
 * Note: D can appear in any format (list, hash table, prefix tree, etc.
 *
 * For example, given the input of S = "abppplee" and D = {"able", "ale", "apple", "bale", "kangaroo"} the correct output would be "apple"
 *
 * The words "able" and "ale" are both subsequences of S, but they are shorter than "apple".
 * The word "bale" is not a subsequence of S because even though S has all the right letters, they are not in the right order.
 * The word "kangaroo" is the longest word in D, but it isn't a subsequence of S.
 *
 * Learning objectives
 * This question gives you the chance to practice with algorithms and data structures. It’s also a good example of why careful analysis for Big-O performance is often worthwhile, as is careful exploration of 
 * common and worst-case input conditions.
 */
public class FindLongestWordInDictionary {

  public static void main(String[] args) {
    String input = "abppplee";

    String[] words = {"able", "ale", "appcle", "bale", "abppkplee", "ple", "ee", "el", "pblee"};

    int maxLengthFountChar = greedyAlgorithmSolution(input, words);
    System.out.println(maxLengthFountChar);

  }

  private static int greedyAlgorithmSolution(String input, String[] words) {
    Map<Character, List<Integer>> freqMap = buildCharFrequecyMap(input);
    boolean found = false;
    int max = -999999999;

    for (String word : words) {
      found = true;
      int len = word.length();
      int i = 0;
      for (i = 0; i < len; i++) {
        List<Integer> currCharIdxList = freqMap.get(word.charAt(i));
        if (null != currCharIdxList && !currCharIdxList.isEmpty()) {
          int currCharIdx = findMinIndexForCurrentChar(currCharIdxList);
          int nextIdx = i + 1;
          if (nextIdx < len) {
            List<Integer> nextCharIdxList = freqMap.get(word.charAt(nextIdx));
            if (null != nextCharIdxList && !nextCharIdxList.isEmpty()) {
              int nextCharIdx = findMinIndexForCurrentChar(nextCharIdxList);
              if (nextCharIdx < currCharIdx) {
                found = false;
                break;
              }
            } else {
              found = false;
              break;
            }
          }
        } else {
          found = false;
          break;
        }

      }
      if (i == len && found && len > max) {
        max = len;
      }
    }
    return max;
  }

  static int findMaximumInFoundArray(int[] arr) {
    int max = -999999999;
    int len = arr.length;
    for (int i = 0; i < len; i++) {
      if (arr[i] > max) {
        max = arr[i];
      }
    }

    return max;
  }


  static int findMinIndexForCurrentChar(List<Integer> indexList) {
    int len = indexList.size();
    int min = 999999999;
    int currentIdx;

    for (int i = 0; i < len; i++) {
      currentIdx = indexList.get(i);
      if (currentIdx < min) {
        min = currentIdx;
      }
    }
    return min;
  }

  static Map<Character, List<Integer>> buildCharFrequecyMap(String s) {
    Map<Character, List<Integer>> freqMap = new HashMap<Character, List<Integer>>();
    int len = s.length();
    for (int i = 0; i < len; i++) {
      char ch = s.charAt(i);
      if (freqMap.containsKey(ch)) {
        freqMap.get(ch).add(i);
      } else {
        List<Integer> idxList = new ArrayList<>();
        idxList.add(i);
        freqMap.put(ch, idxList);
      }
    }
    return freqMap;
  }


}

