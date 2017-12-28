package Exercises.Strings;

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
         * Stop and print as soon as we found the permutations for the whole string.
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

    public static void main(String args[]) {

        findAllPermutations("1234567");
    }
}
