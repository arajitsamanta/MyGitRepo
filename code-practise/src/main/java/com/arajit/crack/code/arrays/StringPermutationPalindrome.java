package com.arajit.crack.code.arrays;

import static org.junit.Assert.assertTrue;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.junit.Test;

import com.arajit.crack.code.helper.HelperUtils;

/**
 * @author as47775
 * 
 * Given a string, write a function to check if it is a permutation of a palindrome. A palindrome is a word or phrase that is the same forwards and backwards. 
 * A permutation is a rearrangement of letters. The palindrome does not need to be limited to just dictionary words.
 * 
 * e.g
 * Input: Tact Coa
 * Output: True (permutations: "taco cat'; "atc o eta·; etc.)
 */

public class StringPermutationPalindrome {

	/**
	 * To be more precise, strings with even length (after removing all
	 * non-letter characters) must have all even counts of characters. Strings
	 * of an odd length must have exactly one character with an odd count. Of
	 * course, an "even" string can't have an odd number of exactly one
	 * character, otherwise it wouldn't be an even-length string (an odd number+
	 * many even numbers= an odd number). Likewise, a string with odd length
	 * can't have all characters with even counts (sum of evens is even). It's
	 * therefore sufficient to say that, to be a permutation of a palindrome, a
	 * string can have no more than one character that is odd. This will cover
	 * both the odd and the even cases.
	 */

	boolean isPermutationOfPalindrome(String str) {
		Map<Character, Integer> charMap = new ConcurrentHashMap<Character, Integer>();
		for (int idx = 0; idx < str.length(); idx++) {
			Character charAt = str.charAt(idx);
			if (isValidCharacter(charAt)) {
				if (charMap.containsKey(charAt)) {
					charMap.put(charAt,
							Integer.valueOf(charMap.get(charAt) + 1));
				} else {
					charMap.put(charAt, 1);
				}
			}

		}
		HelperUtils.getInstance().displayMap(charMap);
		return checkMaxOneOdd(charMap.values());
	}

	boolean checkMaxOneOdd(Collection<Integer> table) {
		boolean foundOdd = false;
		for (int count : table) {
			if (count % 2 == 1) {
				if (foundOdd)
					return false;
				foundOdd = true;
			}
		}
		return true;
	}

	boolean isValidCharacter(char ch) {
		int ascii = (int) ch;
		if (ascii >= 97 && ascii <= 122)
			return true;
		return false;

	}

	boolean isPermutationOfPalindromeNoAPI(String phrase) {
		int[] table = new int[Character.getNumericValue('z')
				- Character.getNumericValue('a') + 1];
		// HelperUtils.getInstance().displayIntArray(table);
		int countOdd = 0;
		for (char c : phrase.toCharArray()) {
			int x = getCharNumber(c);
			if (x != -1) {
				table[x]++;
				if (table[x] % 2 == 1) {
					countOdd++;
				} else {
					countOdd--;
				}
			}
		}
		return countOdd <= 1;
	}

	/* Count how many times each character appears. */
	int[] buildCharFrequencyTable(String phrase) {

		int[] table = new int[Character.getNumericValue('z')
				- Character.getNumericValue('a') + 1];
		for (char c : phrase.toCharArray()) {
			int x = getCharNumber(c);

			if (x != -1) {
				table[x]++;
			}
		}

		return table;
	}

	/*
	 * Map each character to a number. a -> 0, b -> 1, c -> 2, etc. This is case
	 * insensitive. Non-letter characters map to -1.
	 */
	int getCharNumber(Character c) {
		int a = Character.getNumericValue('a');
		// System.out.println("a= " + Character.getNumericValue(a));

		int z = Character.getNumericValue('z');
		// System.out.println("z= " + z);
		int val = Character.getNumericValue(c);
		// System.out.println("val= " + val);
		if (a <= val && val <= z) {
			return val - a;
		}
		return -1;
	}

	/*
	 * Create a bit vector for the string. For each letter with value i, toggle
	 * the ith bit.
	 */
	int createBitVector(String phrase) {
		int bitVector = 0;
		for (char c : phrase.toCharArray()) {
			int x = getCharNumber(c);
			System.out.println("x:" + x);
			bitVector = toggle(bitVector, x);
			System.out.println("bit vector:" + bitVector);
		}
		return bitVector;
	}

	/* Toggle the ith bit in the integer. */
	int toggle(int bitVector, int index) {
		if (index < 0)
			return bitVector;
		int mask = 1 << index;
		System.out.println("mask::" + mask);
		System.out.println("bitVector & mask::" + (bitVector & mask));
		if ((bitVector & mask) == 0) {
			bitVector |= mask;
		} else {
			bitVector &= ~mask;
		}
		return bitVector;
	}

	/**
	 * Check that exactly one bit is set by subtracting one from the integer and
	 * ANDing it with the original integer.
	 * */
	boolean checkExactlyOneBitSet(int bitVector) {
		return (bitVector & (bitVector - 1)) == 0;
	}

	boolean isPermutationOfPalindromeBitVector(String phrase) {
		int bitVector = createBitVector(phrase);
		return bitVector == 0 || checkExactlyOneBitSet(bitVector);
	}

	@Test
	public void isPermutationOfPalindromeTest() {

		String str = "tact coa";
		assertTrue(isPermutationOfPalindrome(str));

		str = "madai is adam";
		assertTrue(isPermutationOfPalindromeNoAPI(str));

		str = "aabbcadad";
		assertTrue(isPermutationOfPalindrome(str));

		str = "aabbcadad";
		assertTrue(isPermutationOfPalindromeBitVector(str));
	}
}
