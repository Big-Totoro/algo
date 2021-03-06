package Exercises.Strings;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

public class Permutations {

    /**
     * Method to print all permutation for the string.
     * Example:
     *  Input: abc
     *  Output abc acb bac bca cab cba
     *
     * The algorithm generates the permutations as follows:
     *  Input: abc
     *  Actions:
     *  1) Get "b" and insert it to every position for "a". As result: "ba" "ab"
     *  2) Get "c" and insert it to every position for "ab" and "ba". As result: cab, acb, abc, cba, bca, bac
     *
     *  O(N) = N!
     *
     * @param input
     */
    public static void findAllPermutations(String input) {

        allPermutations(input, input.substring(0, 1), 1);
    }

    /**
     * Find the permutations for the specific substring
     *
     * @param original the original string
     * @param input the substring to generate new combinations
     * @param index of the next symbol to create combinations
     */
    private static void allPermutations(String original, String input, int index) {

        /**
         * Stop and print the string as soon as we found the permutations for the whole string.
         */
        if (index >= original.length()) {

            System.out.println(input);

            return;
        }

        /**
         * Get the symbol we will use to generate new combinations
         */
        Character ch = original.charAt(index);

        /**
         * Generate new combinations with Symbol + Substring
         */
        for (int i = 0; i <= input.length(); ++i) {

            StringBuilder builder = new StringBuilder(input);

            if (i < builder.length()) {

                builder.insert(i, ch);

            } else {

                builder.append(ch);
            }

            allPermutations(original, builder.toString(), index + 1);
        }
    }

    /**
     * Verifies if one string is the permutation of another string
     *
     * The algo sorts the both strings and then compare
     *
     * @param s1 the first string
     * @param s2 the second string
     * @return true in case of the first string is the permutation of the second string
     */
    public static boolean isPermutation1(String s1, String s2) {

        assert(!s1.isEmpty());
        assert(!s2.isEmpty());

        if (s1.length() != s2.length()) {

            return false;
        }

        char[] array1 = s1.toCharArray();
        char[] array2 = s2.toCharArray();

        Arrays.sort(array1);
        Arrays.sort(array2);

        String r1 = new String(array1);
        String r2 = new String(array2);

        return r1.equalsIgnoreCase(r2);
    }

    public static boolean isPermutation2(String s1, String s2) {

        assert(!s1.isEmpty());
        assert(!s2.isEmpty());

        if (s1.length() != s2.length()) {

            return false;
        }

        Set<Character> set1 = new HashSet<Character>(s1.length());

        /**
         * Add the first string symbols to the set
         */
        for (char ch : s1.toCharArray()) {

            set1.add(ch);
        }

        /**
         * Verify all symbols of the first string exist in the second string
         */
        for (char ch : s2.toCharArray()) {

            if (!set1.contains(ch)) {

                return false;
            }
        }

        return true;
    }

    /**
     * Verifies is the input string can be permuted to palindrome
     * @param input string to verify
     * @return true in case of the input string is palindrome
     */
    public static boolean isPermutationPalindrome(String input) {

        assert (!input.isEmpty());

        char[] a = input.toCharArray();
        Character[] array = IntStream.range(0, a.length).mapToObj(n -> a[n]).toArray(Character[]::new);
        HashMap<Character, Integer> symbolsCounter = new HashMap<>(50);

        for (Character ch : array) {

            Integer counter = symbolsCounter.get(ch);
            if (counter == null) {

                symbolsCounter.put(ch, Integer.valueOf(1));

            } else {

                symbolsCounter.put(ch, Integer.valueOf(counter.intValue() + 1));
            }
        }

        /**
         * A odd values counter. We should have only one odd value.
         */
        int odds = 0;

        for (Integer value : symbolsCounter.values()) {

            if (value.intValue() % 2 > 0) {

                ++odds;
            }
        }

        return odds <= 1;
    }

    public static void main(String[] args) {

        findAllPermutations("1234");

        String s1 = "dog";
        String s2 = "god";

        boolean permutation1 = isPermutation1(s1, s2);
        System.out.println(String.format("The '%s' string is permutation of the string '%s' - %s", s1, s2, Boolean.valueOf(permutation1)));

        boolean permutation2 = isPermutation2(s1, s2);
        System.out.println(String.format("The '%s' string is permutation of the string '%s' - %s", s1, s2, Boolean.valueOf(permutation2)));

        String s3 = "dogod";
        boolean permutation3 = isPermutationPalindrome(s3);
        System.out.println(String.format("The '%s' string is permutation of the string '%s'", s3, Boolean.valueOf(permutation3)));
    }
}
