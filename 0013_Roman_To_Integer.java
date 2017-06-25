import java.util.HashMap;
import java.util.Map;

/**
 * Created by pli on 6/11/16.
 */
public class roman_to_integer {

    public static void main(String[] args) {
        roman_to_integer test = new roman_to_integer();
        test.romanToInt("DCXXI");
    }

    public int romanToInt(String s) {

        //这种用数组代替Map的写法很巧妙,也比Map效率高
        int[] roman = new int[26];//通过'X'-'A'把数组控制在26以内
        roman['I' - 'A'] = 1;
        roman['V' - 'A'] = 5;
        roman['X' - 'A'] = 10;
        roman['L' - 'A'] = 50;
        roman['C' - 'A'] = 100;
        roman['D' - 'A'] = 500;
        roman['M' - 'A'] = 1000;

        int result = 0;

        //这样写,不用考虑i-1或者i+1情况下越界问题和length=1的问题,通过i>0判断length一定>1
        for (int i = 0; i < s.length(); i++) {
            if (i > 0 && (roman[s.charAt(i) - 'A'] > roman[s.charAt(i - 1) - 'A'])) {
                result = result + roman[s.charAt(i) - 'A'] - 2 * roman[s.charAt(i - 1) - 'A'];
            } else {//策略,遇到只管加,发现加错了再减去2个
                result += roman[s.charAt(i) - 'A'];
            }
        }

        return result;
    }
}
