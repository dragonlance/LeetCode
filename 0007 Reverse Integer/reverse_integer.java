/**
 * Created by pli on 6/9/16.
 */
public class reverse_integer {

    public static void main(String[] args) {

        reverse_integer test = new reverse_integer();
        System.out.println(test.reverse(-1563847412));

    }

    public int reverse(int x) {

        boolean isMinus = x < 0;
        if (isMinus) x = -x;
        long r = 0;//这里用long型

        for (; x > 0; x /= 10) {//每一步除10,去掉最低位
            r = r * 10 + (x % 10);//每一步模取10,取出最低位,与之前的结果乘10升1位,再相加
        }
        //如果r不用long型,这里的r经过溢出,早已经不是想要的结果

        if (isMinus) r = -r;
        if (r > Math.pow(2, 31) - 1 || r < -Math.pow(2, 31)) return 0;

        return (int) r;
    }

}
