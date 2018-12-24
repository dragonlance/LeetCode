```java
class Solution {
    public void sortColors(int[] nums) {
        int a = 0, c = nums.length - 1;
        for (int b = 0; b <= c; b++) {
            if (nums[b] == 0) {
                swap(nums, a++, b);//此处b++，因为从左边换过来的，要么是0，要么是1，不可能是2，不需要再换
            } else if (nums[b] == 2) {
                swap(nums, c--, b--); //此处b--是为了和b++抵消，为了让b原地不动，因为从右边换过来的，可能是0，可能还需要再换
            }
        }
    }
    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
```

### 更直观一些的写法
```java
class Solution {
    public void sortColors(int[] nums) {
        int left = 0, current = 0, right = nums.length - 1;
        while (current <= right) {
            if (nums[current] == 0) {
                swap(nums, current, left);
                left++;
                current++; //此处current+1，因为从左边换过来的，只可能是0或1，如果是0，无所谓；如果是1，current部分相当于尾部增加了一个1
            } else if (nums[current] == 1) {
                current++;
            } else {
                swap(nums, current, right);
                right--; //此处current不变，因为从右边换过来的有可能还是0或1，下次还需要继续判断current是否需要交换
            }
        }
    }
    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
```
