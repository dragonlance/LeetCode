/**
 * Created by pli on 6/10/16.
 */
public class regular_expression_matching {
    public static void main(String[] args) {
        System.out.print(isMatch("ab", ".*c"));
    }

    public static boolean isMatch(String s, String p) {

        if (p.length() == 0) return s.length() == 0;//p如果是空的,s必须是空的.反过来,s如果为空,p可以有*
        if (p.length() == 1) {//如果p只有1位,不可能是*,因为*必须带前缀,不会单独出现
            return (s.length() == 1 && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.'));
        }
        //以下是p大于2位的情况,分为2种处理,第二位是不是为*
        if (p.charAt(1) != '*') {//如果不为*
            if (s.length() == 0) {
                return false;
            } else {//转换为当第一位匹配的情况下,后面一位彼此是否匹配的子问题,用递归
                return (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.') && (isMatch(s.substring(1), p.substring(1)));
            }
        } else {//如果为*,先用s首位与p首位匹配0次(跳过),直接看看s首位与p*号后面能匹配上不,如果匹配上,就算全部匹配上了
            while (s.length() > 0 && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.')) {
                if (isMatch(s, p.substring(2))) return true;//如果匹配不上,还有其他可能,我们调整前面的*多匹配一些
                s = s.substring(1);//用s更多的一位与*进行匹配,一直到匹配不上或者s用完了
            }//以上while走完,如果还没有完全匹配上,这个*也匹配到极限了,然后拿最后匹配不上的s位继续与*后面的位进行匹配
            return isMatch(s, p.substring(2));
        }
    }
}
