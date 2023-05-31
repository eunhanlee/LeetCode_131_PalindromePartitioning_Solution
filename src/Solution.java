import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<String>> partition(String s) {
        return findSubstringsBacktracking(s);
    }

    /**
     * Finds all possible substrings of the given input string using backtracking.
     *
     * @param input the input string
     * @return a list of lists containing all possible substrings
     */
    public List<List<String>> findSubstringsBacktracking(String input) {
        List<List<String>> result = new ArrayList<>();
        findSubstringsBacktrackingRecur(input, 0, new ArrayList<>(), result);
        return result;
    }

    /**
     * Recursive helper method to find substrings using backtracking.
     *
     * @param input   the input string
     * @param start   the start index for substring extraction
     * @param current the current combination of substrings
     * @param result  the list to store all valid substring combinations
     */
    private void findSubstringsBacktrackingRecur(String input, int start, List<String> current, List<List<String>> result) {
        // Base case: If the start index reaches the length of the input string,
        // it means we have processed all characters and found a valid substring combination.
        // Add the current combination to the result list.
        if (start == input.length()) {
            result.add(new ArrayList<>(current));
        }

        // Explore all possible substrings starting from the current start index.
        for (int i = start; i < input.length(); i++) {
            // Extract the substring from the start index to the current i index.
            String substring = input.substring(start, i + 1);
            // Add the substring to the current combination if palindrome
            if (isPalindrome(substring)) {
                current.add(substring);
                // Recursively call the function to explore the remaining part of the string
                // starting from the next index (i + 1) and with the updated current combination.
                findSubstringsBacktrackingRecur(input, i + 1, current, result);
                // Backtrack: Remove the last added substring from the current combination
                // to try other possibilities in the next iteration.
                current.remove(current.size() - 1);
            }
        }
    }


    /**
     * Checks if a given string is a palindrome.
     *
     * @param input the input string to check
     * @return true if the input string is a palindrome, false otherwise
     */
    private boolean isPalindrome(String input) {
        // Check for null or empty input
        if (input == null || input.length() == 0) {
            return false;
        }

        // Initialize two pointers: left and right
        int left = 0;
        int right = input.length() - 1;

        // Compare characters at the left and right pointers
        while (left < right) {
            // If characters are not equal, it's not a palindrome
            if (input.charAt(left) != input.charAt(right)) {
                return false;
            }
            // Move the pointers towards the center
            left++;
            right--;
        }

        // If the loop completes without returning false, it's a palindrome
        return true;
    }

}
