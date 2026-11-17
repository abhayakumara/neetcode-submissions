class Solution {
    public boolean canFinish(int num, int[][] p) {
        // b -> a


        // adjucency matrix
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<num; i++) {
            adj.add(new ArrayList<>());
        }

        int[] inDegree = new int[num];
        for(int[] row : p) {
            adj.get(row[1]).add(row[0]);
            inDegree[row[0]]++;
        }

        Deque<Integer> q = new ArrayDeque<>();

        for(int i=0; i<num; i++) {
            if(inDegree[i] == 0) {
                q.offer(i);
            }
        }
        int ans = 0;
        while(!q.isEmpty()) {
            int polled = q.poll();
            ans++;

            for(int nei : adj.get(polled)) {
                inDegree[nei]--;

                if(inDegree[nei] == 0) {
                    q.offer(nei);
                }
            }

        }

        return ans == num;

        
    }
}
