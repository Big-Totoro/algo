package Exercises.Strings;

public class Permutations {

    /**
     * Method to print all permutation for the string.
     * Example:
     *  Input: abc
     *  Output abc acb bac bca cab cba
     *
     *  O(N) = N!
     *
     * @param input
     */
    public static void findAllPermutations(String input) {

        allPermutations(input, input.substring(0, 1), 1);
    }

    private static void allPermutations(String original, String input, int index) {

        if (index >= original.length()) {

            System.out.println(input);

            return;
        }

        Character ch = original.charAt(index);

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

        findAllPermutations("1234");
    }
}
