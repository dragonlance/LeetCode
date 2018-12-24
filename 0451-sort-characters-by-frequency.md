### Approach 1
```java
class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> frequency = new HashMap<>();
        for (char c : s.toCharArray()) {
            frequency.put(c, frequency.getOrDefault(c, 0) + 1);
        }
        
        List<Character>[] buckets = new List[s.length() + 1];
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new LinkedList<Character>();
        }
        
        for (Character c : frequency.keySet()) {
            buckets[frequency.get(c)].add(c);
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = buckets.length - 1; i >= 0; i--) {
            for (Character c : buckets[i]) {
                for (int j = 0; j < i; j++) {
                    sb.append(c);
                }
            }
        }
        return sb.toString();
    }
}
```
Time Complexity:O(n), n is the length of the string.

Space Compelxity:O(n), as need a n length array to hold the characters indexed by frequency.

### Approach 2
```java
class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> frequency = new HashMap<>();
        for (char c : s.toCharArray()) {
            frequency.put(c, frequency.getOrDefault(c, 0) + 1);
        }

        Queue<Character> heap = new PriorityQueue<>(
            (Character c1, Character c2) -> frequency.get(c2) - frequency.get(c1)
        );
        for (Character c : frequency.keySet()) {
            heap.add(c);
        }

        StringBuilder sb = new StringBuilder();
        while (!heap.isEmpty()) {
            Character c = heap.poll();
            for (int i = 0; i < frequency.get(c); i++) {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
```
Time Complexity:O(nlogk), k is the distinguish character, as max k is 26, so time complexity can be O(n)

Space Complexity:O(k), as max k is 26, so space complexity can be O(1)
