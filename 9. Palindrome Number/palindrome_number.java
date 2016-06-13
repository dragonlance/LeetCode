/**
 * Created by pli on 6/10/16.
 */
public class palindrome_number {
    public static void main(String[] args) {
        palindrome_number test = new palindrome_number();
        boolean result = test.isPalindrome2(1000021);
        System.out.print(result);
    }

    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        int digitCount = digitCount(x);
        int left = digitCount / 2;
        int right = (digitCount + 3) / 2; //找出来的规律,奇偶数都适用
        while (left >= 1 && right <= digitCount) {
            if (kthDigit(x, left) != kthDigit(x, right)) {
                return false;
            }
            left--;
            right++;
        }
        return true;
    }
    public int kthDigit(int x, int k) {
        int digits = 1;
        while (k > digits) {
            x /= 10;
            digits++;
        }
        return x % 10;
    }
    public int digitCount(int x) {
        int digits = 1;
        while (x / 10 != 0) {
            x /= 10;
            digits++;
        }
        return digits;
    }

    public boolean isPalindrome2(int x) {
        if (x < 0) return false;
        int d = 1;  //divisor
        while (x / d >= 10) d *= 10;//如果x=9999,让d成为1000
        while (x > 0) { //注意! 这里必须用x>0判断,不可用x>=10,例:1000021,第一次去掉高低位以后,一下子变成了2,这时依然需要用虚拟的0与2做比较判断
            int q = x / d;  //quotient(商),这时q总能代表最高位
            int r = x % 10; //remainder(余),这时r总能代表最低位
            if (q != r) return false;
            x = x % d / 10; //最精妙的一步,x%d去掉最高位,再/10去掉最低位
            d /= 100;
        }
        return true;
    }

}