/**
 * Created by pli on 6/9/16.
 */
public class string_to_integer_atoi {

    public static void main(String[] args) {
        string_to_integer_atoi test = new string_to_integer_atoi();
        int result = test.myAtoi("-2147483648");
        System.out.print(result);
    }

    public int myAtoi(String str) {

        if (str.length() == 0) return 0;

        int j = 0;

        //这里不能用str.replaceAll(" ", ""),因为一旦把空格全去掉了,就把后边的原本被空格分割开的合为一体了
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != ' ') {
                break;
            }
            j++;
        }

        boolean isMinus = false;

        if (str.charAt(j) == '+') {
            j++;
        } else if (str.charAt(j) == '-') {
            j++;
            isMinus = true;
        }

        int result = 0;//这里不可以通过用long来先接受计算,最后再判断有没有int溢出,因为输入的string有可能连long也溢出

        for (int i = j; i < str.length(); i++) {
            if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                //-2xxxxxxxx8 ~ 2xxxxxxxx7
                //if (result < 0) {//这里不能通过result < 0判断是不是溢出,因为有可能乘法计算,多次溢出造成结果是正数
                if (result > Integer.MAX_VALUE / 10 // int最大值是10位数21亿,这种情况说明前9位已经溢出
                        || (result == Integer.MAX_VALUE / 10) //前9位与int最大值相等
                        && (str.charAt(i) - '0' > Integer.MAX_VALUE % 10)) {//最低位大于7,也就是8,9两种情况,不论正负,都可以用最大值赋值
                    if (isMinus) {
                        result = Integer.MIN_VALUE;
                    } else {
                        result = Integer.MAX_VALUE;
                    }
                    break;
                } else {
                    result = result * 10 + (str.charAt(i) - '0');
                }
            } else {
                break;
            }
        }

        if (isMinus && result > 0) {
            result = -result;
        }

        return result;
    }

}
