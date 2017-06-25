import java.util.Arrays;
import java.util.Collections;

/**
 * Created by pli on 6/3/16.
 */
public class median_of_two_sorted_arrays {

    public static void main(String[] args) {

        AAA test = new AAA();
        double d = test.findMedianSortedArrays(new int[] {1,2,3,4,5}, new int[] {2,4,6,8,10});
        System.out.print(d);


    }
}

class AAA {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int k = nums1.length + nums2.length;
        if (k % 2 == 0) return (findKth(nums1, nums2, k / 2) + findKth(nums1, nums2, k / 2 + 1)) / 2.0;
        else return findKth(nums1, nums2, k / 2 + 1);

    }

    public int findKth(int[] a, int[] b, int k) {

        if (b.length > a.length) return findKth(b, a, k);
        if (a.length == 0) return b[k - 1];
        if (k == 1) return Math.min(a[0], b[0]);

        //把k分成k1,k2两个部分,正常情况下,k1, k2都是k的一半
        int k1 = Math.min(a.length, k / 2);//但是如果数组A连k的一半都不到,那就全上,剩下的都由数组2出
        int k2 = k - k1;

        //以上的k1,k2是指的第几个元素,下面注意角标要k-1
        if (a[k1 - 1] < b[k2 - 1]) return findKth(Arrays.copyOfRange(a, k1, a.length), b, k - k1);
        else if (a[k - 1] > b[k2 - 1]) return findKth(a, Arrays.copyOfRange(b, k2, b.length), k - k2);
        else return a[k1 - 1];

    }

}