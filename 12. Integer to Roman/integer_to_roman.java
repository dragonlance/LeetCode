/**
 * Created by pli on 6/11/16.
 */
public class integer_to_roman {
    public String intToRoman(int num) {
        //9,5,4,1是独立的   8,7,6可以由5和1组合而成 3,2可以由1组合而成
        int[] values = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] strs = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        String result = "";
        for (int i = 0; num > 0; i++) {
            int count = num / values[i];//例如800,除500,等于1,就加上一个代表500的D,然后一模取,还剩300,再加上3个代表100的C
            for (int k = 0; k < count; k++) {
                result += strs[i];
            }
            num %= values[i];
        }
        return result;
    }
}
