import java.util.*;

/**
 * Created by pli on 6/2/16.
 */
public class longest_substring_without_repeating_characters {



    public static void main(String[] args) {

        longest_substring_without_repeating_characters test = new longest_substring_without_repeating_characters();
        int l = test.lengthOfLongestSubstring("abcabcbb");
        System.out.println(l);
    }

    public int lengthOfLongestSubstring(String s) {

        int maxLen = 0;
        int i = 0;

        int[] index = new int[128]; // current index of character

        for (int j = 0; j < s.length(); j++) {

            char c = s.charAt(j);

            i = Math.max(index[c], i);
            maxLen = Math.max(j - i + 1, maxLen);
            index[c] = j + 1;

        }

        return maxLen;
    }
}
