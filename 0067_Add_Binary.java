public class Solution {
    public String addBinary(String a, String b) {

        int index_a = a.length() - 1;
        int index_b = b.length() - 1;

        int carry = 0;
        StringBuilder result = new StringBuilder(); //

        while (index_a >= 0 || index_b >= 0) {

            int bit_a = index_a >= 0 ? a.charAt(index_a) - '0' : 0; // string 单bit转 int
            int bit_b = index_b >= 0 ? b.charAt(index_b) - '0' : 0;

            int sum = (bit_a + bit_b + carry) % 2;
            carry = (bit_a + bit_b + carry) / 2;

            index_a--;
            index_b--;

            result.append(sum);
        }

        if (carry > 0) result.append(carry);

        return result.reverse().toString(); // 熟悉StringBuilder 的用法 reverse() / toString()

    }
}
