class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;
        var map = new HashMap<Integer, Integer>();
        int maxFreq = 0;
        for(int a : nums) {
            map.put(a, map.getOrDefault(a, 0) + 1);
        }
        // top k with min heap of k size
        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>(k, (a, b) -> a.getValue() - b.getValue());

        for(var entry : map.entrySet()) {
            minHeap.offer(entry);
            if(minHeap.size() > k) {
                minHeap.poll();
            }
        }

        int[] ans = new int[k];
        int i=k-1;
        while(!minHeap.isEmpty() && i >= 0) {
            ans[i--] = minHeap.poll().getKey();
        }
        return ans;   
    }
}
