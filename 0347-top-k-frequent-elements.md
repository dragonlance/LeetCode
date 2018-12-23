[347. Top K Frequent Elements (Medium)](https://leetcode.com/problems/top-k-frequent-elements/description/)

### Approach 1:Heap
```java
class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> frequency = new HashMap<>();
        for (int i : nums) {
            frequency.put(i, frequency.getOrDefault(i, 0) + 1);
        }
        Queue<Integer> heap = new PriorityQueue<>((i1, i2) -> frequency.get(i1) - frequency.get(i2));
        for (int key : frequency.keySet()) {
            heap.add(key);
            if (heap.size() > k) {
                heap.remove();
            }
        }
        List<Integer> topK = new LinkedList<>();
        while (!heap.isEmpty()) {
            topK.add(heap.remove());
        }
        return topK;
    }
}
```
Time Complexity:O(nlogk)

Space Complexity:O(k)

### Approach 2:Bucket Sort
```java
class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> frequency = new HashMap<>();
        for (int n : nums) {
            frequency.put(n, frequency.getOrDefault(n, 0) + 1);
        }
        List<Integer>[] buckets = new List[nums.length + 1];
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new LinkedList();
        }
        for (int key : frequency.keySet()) {
            buckets[frequency.get(key)].add(key);
        }
        List<Integer> topK = new LinkedList<>();
        for (int i = buckets.length - 1; i >= 0; i--) {
            topK.addAll(buckets[i]);
            if (topK.size() >= k) break;
        }
        return topK;
    }
}
```
Time Complexity:O(n)

Space Complexity:O(n)
