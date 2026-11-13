class Solution {
    public int maxProfit(int[] p) {
        int buy = p[0];
        int profit = 0;

        for(int i=1; i<p.length; i++) {
            if(p[i] < buy) {
                buy = p[i];
            }
            profit = Math.max(profit, p[i] - buy);
        }
        return profit;
    }
}
